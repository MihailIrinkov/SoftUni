function solve(inputData) {
    const n = Number(inputData.shift());

    let chemicals = {};

    for (let i = 0; i < n; i++) {
        const [name, quantity] = inputData.shift().split(' # ');
        chemicals[name] = {
            quantity: Number(quantity),
            formula: ''
        };
    }

    let command = inputData.shift();

    while (command != 'End') {
        const [action, name, arg1, arg2] = command.split(' # ');

        switch (action) {
            case 'Mix':
                if (chemicals[name].quantity >= Number(arg2)
                    && chemicals[arg1].quantity >= Number(arg2)) {
                    chemicals[name].quantity -= Number(arg2);
                    chemicals[arg1].quantity -= Number(arg2);
                    console.log(`${name} and ${arg1} have been mixed. ${arg2} units of each were used.`);
                } else {
                    console.log(`Insufficient quantity of ${name}/${arg1} to mix.`)
                }
                break;
            case 'Replenish':
                if (!chemicals[name]) {
                    console.log(`The Chemical ${name} is not available in the lab.`);
                } else if ((chemicals[name].quantity + Number(arg1)) > 500) {
                    console.log(`${name} quantity increased by ${500 - chemicals[name].quantity} units, reaching maximum capacity of 500 units!`);
                    chemicals[name].quantity = 500;
                } else {
                    chemicals[name].quantity += Number(arg1);
                    console.log(`${name} quantity increased by ${arg1} units!`);
                }
                break;
            case 'Add Formula':
                if (!chemicals[name]) {
                    console.log(`The Chemical ${name} is not available in the lab.`);
                } else {
                    chemicals[name].formula = arg1;
                    console.log(`${name} has been assigned the formula ${arg1}.`);
                }
                break;
        }

        command = inputData.shift();
    }

    Object.keys(chemicals).map(k => {
        if (chemicals[k].formula !== '') {
            console.log(`Chemical: ${k}, Quantity: ${chemicals[k].quantity}, Formula: ${chemicals[k].formula}`);
        } else {
            console.log(`Chemical: ${k}, Quantity: ${chemicals[k].quantity}`);
        }
    });
}