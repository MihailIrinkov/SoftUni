function cafeteria(inputData) {
    const numberOfBaristas = inputData.shift();

    let baristas = {};

    for (let i = 0; i < numberOfBaristas; i++) {
        const [name, shift, coffeeTypes] = inputData.shift().split(' ');
        baristas[name] = {
            shift: shift,
            coffeeTypes: coffeeTypes.split(',')
        }
    }

    let command = inputData.shift();

    while (command != 'Closed') {
        let action = command.split(' / ')[0];
        let baristaName = command.split(' / ')[1];
        let baristaShift = command.split(' / ')[2];
        let coffeeType = command.split(' / ')[3];

        switch (action) {
            case 'Prepare':
                if (baristas[baristaName].shift === baristaShift && baristas[baristaName].coffeeTypes.includes(coffeeType)) {
                    console.log(`${baristaName} has prepared a ${coffeeType} for you!`);
                } else {
                    console.log(`${baristaName} is not available to prepare a ${coffeeType}.`)
                }
                break;
            case 'Change Shift':
                baristas[baristaName].shift = baristaShift;
                console.log(`${baristaName} has updated his shift to: ${baristaShift}`)
                break;
            case 'Learn':
                let newCoffeeType = command.split(' / ')[2];
                if (baristas[baristaName].coffeeTypes.includes(newCoffeeType)) {
                    console.log(`${baristaName} knows how to make ${newCoffeeType}.`);
                } else {
                    baristas[baristaName].coffeeTypes.push(newCoffeeType);
                    console.log(`${baristaName} has learned a new coffee type: ${newCoffeeType}.`);
                }
                break;
        }

        command = inputData.shift();
    }

    Object.keys(baristas).forEach(k => {
        console.log(`Barista: ${k}, Shift: ${baristas[k].shift}, Drinks: ${baristas[k].coffeeTypes.join(', ')}`);
    });
}


// cafeteria(['3',
//     'Alice day Espresso,Cappuccino',
//     'Bob night Latte,Mocha',
//     'Carol day Americano,Mocha',
//     'Prepare / Alice / day / Espresso',
//     'Change Shift / Bob / night',
//     'Learn / Carol / Latte',
//     'Learn / Bob / Latte',
//     'Prepare / Bob / night / Latte',
//     'Closed']
// );

cafeteria(['4',
    'Alice day Espresso,Cappuccino',
    'Bob night Latte,Mocha',
    'Carol day Americano,Mocha',
    'David night Espresso',
    'Prepare / Alice / day / Espresso',
    'Change Shift / Bob / day',
    'Learn / Carol / Latte',
    'Prepare / Bob / night / Latte',
    'Learn / David / Cappuccino',
    'Prepare / Carol / day / Cappuccino',
    'Change Shift / Alice / night',
    'Learn / Bob / Mocha',
    'Prepare / David / night / Espresso',
    'Closed']
);