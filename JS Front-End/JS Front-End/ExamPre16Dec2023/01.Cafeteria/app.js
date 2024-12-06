function cafeteria(inputData) {
    const numberOfBaristas = inputData.shift();

    let baristas = {};

    for (let i = 0; i < numberOfBaristas; i++) {
        const[name, shift, coffeeTypes] = inputData.shift().split(' ');
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
                break;
            case 'Learn':
                break;
        }

        command = inputData.shift();
    }
    // console.log(baristas);
}


cafeteria([
    '3',
    'Alice day Espresso,Cappuccino',
    'Bob night Latte,Mocha',
    'Carol day Americano,Mocha',
    'Prepare / Alice / day / Espresso',
    'Closed']
);