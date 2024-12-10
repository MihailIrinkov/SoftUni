function astroAdventure(inputData) {

    const n = Number(inputData.shift());
    const astronauts = {};

    for (let i = 0; i < n; i++) {
        const [name, oxygenLevel, energyReserves] = inputData.shift().split(' ');
        astronauts[name] = {
            oxygenLevel: Number(oxygenLevel),
            energyReserves: Number(energyReserves)
        };
    }

    let command = inputData.shift();

    while (command != 'End') {

        const [action, astronautName, arg] = command.split(' - ');

        switch (action) {
            case 'Explore':
                if (astronauts[astronautName].energyReserves > Number(arg)) {
                    astronauts[astronautName].energyReserves -= Number(arg);
                    console.log(`${astronautName} has successfully explored a new area and now has ${astronauts[astronautName].energyReserves} energy!`);
                } else {
                    console.log(`${astronautName} does not have enough energy to explore!`);
                }
                break;
            case 'Refuel':
                if ((astronauts[astronautName].energyReserves + Number(arg)) > Number(200)) {
                    console.log(`${astronautName} refueled their energy by ${200 - astronauts[astronautName].energyReserves}!`);
                    astronauts[astronautName].energyReserves = 200;
                } else {
                    astronauts[astronautName].energyReserves += Number(arg);
                    console.log(`${astronautName} refueled their energy by ${arg}!`);
                }
                break;
            case 'Breathe':
                if ((astronauts[astronautName].oxygenLevel + Number(arg)) > 100) {
                    console.log(`${astronautName} took a breath and recovered ${100 - astronauts[astronautName].oxygenLevel} oxygen!`);
                    astronauts[astronautName].oxygenLevel = 100;
                } else {
                    astronauts[astronautName].oxygenLevel += Number(arg);
                    console.log(`${astronautName} took a breath and recovered ${arg} oxygen!`);
                }
                break;
        }

        command = inputData.shift();
    }

    Object.keys(astronauts).map(k => {
        console.log(`Astronaut: ${k}, Oxygen: ${astronauts[k].oxygenLevel}, Energy: ${astronauts[k].energyReserves}`);
    });
}

// astroAdventure(['3',
//     'John 50 120',
//     'Kate 80 180',
//     'Rob 70 150',
//     'Explore - John - 50',
//     'Refuel - Kate - 30',
//     'Breathe - Rob - 20',
//     'End']
// );

astroAdventure([    '4',
    'Alice 60 100',
    'Bob 40 80',
    'Charlie 70 150',
    'Dave 80 180',
    'Explore - Bob - 60',
    'Refuel - Alice - 30',
    'Breathe - Charlie - 50',
    'Refuel - Dave - 40',
    'Explore - Bob - 40',
    'Breathe - Charlie - 30',
    'Explore - Alice - 40',
    'End']
);