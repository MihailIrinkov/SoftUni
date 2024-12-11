function superheroAlliance(inputData) {
    const n = Number(inputData.shift());
    let heroes = {};

    for (let i = 0; i < n; i++) {
        const [name, power, energy] = inputData.shift().split('-');
        heroes[name] = {
            power: power,
            energy: Number(energy),
        };
    }

    let command = inputData.shift();

    while (command != 'Evil Defeated!') {
        const [action, superheroName, arg1, arg2] = command.split(' * ');

        switch (action) {
            case 'Use Power':
                if (heroes[superheroName].power.includes(arg1)
                    && heroes[superheroName].energy > Number(arg2)) {
                    heroes[superheroName].energy -= Number(arg2);
                    console.log(`${superheroName} has used ${arg1} and now has ${heroes[superheroName].energy} energy!`);
                } else {
                    console.log(`${superheroName} is unable to use ${arg1} or lacks energy!`);
                }
                break;
            case 'Train':
                if (heroes[superheroName].energy === 100) {
                    console.log(`${superheroName} is already at full energy!`);
                } else if (heroes[superheroName].energy + Number(arg1) > 100) {
                    console.log(`${superheroName} has trained and gained ${100 - heroes[superheroName].energy} energy!`);
                    heroes[superheroName].energy = 100;
                } else {
                    heroes[superheroName].energy += Number(arg1);
                    console.log(`${superheroName} has trained and gained ${arg1} energy!`);
                }
                break;
            case 'Learn':
                if (heroes[superheroName].power.includes(arg1)) {
                    console.log(`${superheroName} already knows ${arg1}.`);
                } else {
                    heroes[superheroName].power += (`,${arg1}`);
                    console.log(`${superheroName} has learned ${arg1}!`);
                    // console.log(heroes[superheroName].power);
                }
                break;
        }
        command = inputData.shift();
    }

    Object.keys(heroes).map(k => {
        console.log(`Superhero: ${k}`);
        console.log(`- Superpowers: ${heroes[k].power.split(',').join(', ')}`);
        console.log(`- Energy: ${heroes[k].energy}`);
    });
}

superheroAlliance(([
        "3",
        "Iron Man-Repulsor Beams,Flight-80",
        "Thor-Lightning Strike,Hammer Throw-10",
        "Hulk-Super Strength-60",
        "Use Power * Iron Man * Flight * 30",
        "Train * Thor * 20",
        "Train * Hulk * 50",
        "Learn * Hulk * Thunderclap",
        "Use Power * Hulk * Thunderclap * 70",
        "Evil Defeated!"
    ])
);

// superheroAlliance( ([
//         "2",
//         "Iron Man-Repulsor Beams,Flight-100",
//         "Thor-Lightning Strike,Hammer Throw-50",
//         "Train * Thor * 20",
//         "Learn * Thor * Hammer Throw",
//         "Use Power * Iron Man * Repulsor Beams * 30",
//         "Evil Defeated!"
//     ])
// );

// superheroAlliance( ([
//         "2",
//         "Iron Man-Repulsor Beams,Flight-20",
//         "Thor-Lightning Strike,Hammer Throw-100",
//         "Train * Thor * 20",
//         "Use Power * Iron Man * Repulsor Beams * 30",
//         "Evil Defeated!"
//     ])
// );