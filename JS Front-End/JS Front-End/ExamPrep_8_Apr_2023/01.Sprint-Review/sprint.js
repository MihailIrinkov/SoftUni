function sprint(inputData) {
    let n = Number(inputData.length) - 1;
    const assigneeNumber = Number(inputData.shift());
    let assignee = {};
    for (let i = 0; i < assigneeNumber; i++) {

        const [name, taskId, title, status, points] = inputData.shift().split(':');
        const task = {};
        task[taskId] = {
            title: title,
            status: status,
            points: points
        }

        let taskArr = [];
        taskArr.push(task);
        assignee[name] = {
            tasks: taskArr
        };
    }

    n -= assigneeNumber;

    for (let i = 0; i < n; i++) {
        const [action, name, arg1, arg2, arg3, arg4] = inputData.shift().split(':');

        switch (action) {
            case 'Add New':
                if (!assignee.hasOwnProperty(name)) {
                    console.log(`Assignee ${name} does not exist on the board!`);
                } else {
                    const newTask = {};
                    newTask[arg1] = {
                        title: arg2,
                        status: arg3,
                        points: arg4
                    }
                    assignee[name].tasks.push(newTask);
                }
                break;
            case 'Change Status':
                if (!assignee.hasOwnProperty(name)) {
                    console.log(`Assignee ${name} does not exist on the board!`);
                } else if (!Object.keys(assignee[name].tasks.hasOwnProperty(arg1))) {
                    // console.log(assignee[name].tasks)
                    console.log(`"Task with ID ${arg1} does not exist for ${name}!`);
                } else {
                    assignee[name].tasks[arg1].status = arg2;
                }
                break;
            case 'Remove Task':
                if (!assignee.hasOwnProperty(name)) {
                    console.log(`Assignee ${name} does not exist on the board!`);
                } else if (assignee[name].tasks.length < arg1) {
                    console.log('Index is out of range!');
                } else {
                    assignee[name].tasks.splice(Number(arg1), 1);
                }
                break;
        }
    }

    // console.log(assignee['Kiril'].tasks);
}

// sprint([
//     '5',
//     'Kiril:BOP-1209:Fix Minor Bug:ToDo:3',
//     'Mariya:BOP-1210:Fix Major Bug:In Progress:3',
//     'Peter:BOP-1211:POC:Code Review:5',
//     'Georgi:BOP-1212:Investigation Task:Done:2',
//     'Mariya:BOP-1213:New Account Page:In Progress:13',
//     'Add New:Kiril:BOP-1217:Add Info Page:In Progress:5',
//     'Change Status:Peter:BOP-1290:ToDo',
//     'Remove Task:Mariya:1',
//     'Remove Task:Joro:1',
// ]);

sprint([
    '4',
    'Kiril:BOP-1213:Fix Typo:Done:1',
    'Peter:BOP-1214:New Products Page:In Progress:2',
    'Mariya:BOP-1215:Setup Routing:ToDo:8',
    'Georgi:BOP-1216:Add Business Card:Code Review:3',
    'Add New:Sam:BOP-1237:Testing Home Page:Done:3',
    'Change Status:Georgi:BOP-1216:Done',
    'Change Status:Will:BOP-1212:In Progress',
    'Remove Task:Georgi:3',
    'Change Status:Mariya:BOP-1215:Done',
]);