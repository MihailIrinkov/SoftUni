function solve(inputdata) {
    const n = Number(inputdata.shift());
    let farmers = {};

    for (let i = 0; i < n; i++) {
        const [name, workArea, tasks] = inputdata.shift().split(' ');
        let splitedTasks = tasks.split(',');
        farmers[name] = {
            workArea: workArea,
            tasks: splitedTasks
        };
    }

    let command = inputdata.shift();

    while (command !== 'End') {
        const [action, name, arg1, arg2] = command.split(' / ');

        switch (action) {
            case 'Execute':
                if (farmers[name].workArea === arg1 && farmers[name].tasks.includes(arg2)) {
                    console.log(`${name} has executed the task: ${arg2}!`);
                } else {
                    console.log(`${name} cannot execute the task: ${arg2}.`);
                }
                break;
            case 'Change Area':
                farmers[name].workArea = arg1;
                console.log(`${name} has changed their work area to: ${arg1}`);
                break;
            case 'Learn Task':
                if (farmers[name].tasks.includes(arg1)) {
                    console.log(`${name} already knows how to perform ${arg1}.`);
                } else {
                    farmers[name].tasks.push(arg1);
                    console.log(`${name} has learned a new task: ${arg1}.`);
                }
                break;
        }

        command = inputdata.shift();
    }

    Object.keys(farmers).map(k => {
        console.log(`Farmer: ${k}, Area: ${farmers[k].workArea}, Tasks: ${farmers[k].tasks.sort().join(', ')}`);
    });
}

// solve([
//         "2",
//         "John garden watering,weeding",
//         "Mary barn feeding,cleaning",
//         "Execute / John / garden / watering",
//         "Execute / Mary / garden / feeding",
//         "Learn Task / John / planting",
//         "Execute / John / garden / planting",
//         "Change Area / Mary / garden",
//         "Execute / Mary / garden / cleaning",
//         "End"
//     ]
// );

solve([
        "3",
        "Alex apiary harvesting,honeycomb",
        "Emma barn milking,cleaning",
        "Chris garden planting,weeding",
        "Execute / Alex / apiary / harvesting",
        "Learn Task / Alex / beeswax",
        "Execute / Alex / apiary / beeswax",
        "Change Area / Emma / apiary",
        "Execute / Emma / apiary / milking",
        "Execute / Chris / garden / watering",
        "Learn Task / Chris / pruning",
        "Execute / Chris / garden / pruning",
        "End"
    ]
);