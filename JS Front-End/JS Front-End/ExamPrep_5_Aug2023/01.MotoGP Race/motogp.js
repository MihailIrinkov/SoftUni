function motoGp(inputData) {
    const numberOfRiders = Number(inputData.shift());

    let riders = {};

    for (let i = 0; i < numberOfRiders; i++) {
        const [name, fuelCapacity, position] = inputData.shift().split('|');

        riders[name] = {
            fuelCapacity: Number(fuelCapacity),
            position: Number(position)
        };
    }

    let command = inputData.shift();

    while (command !== 'Finish') {
        let action = command.split(' - ')[0];
        let rider = command.split(' - ')[1];

        switch (action) {
            case 'StopForFuel':
                let minimumFuel = Number(command.split(' - ')[2]);
                let changedPosition = Number(command.split(' - ')[3]);
                if (minimumFuel > riders[rider].fuelCapacity) {
                    riders[rider].position = changedPosition;

                    console.log(`${rider} stopped to refuel but lost his position, now he is ${changedPosition}.`);
                } else {
                    console.log(`${rider} does not need to stop for fuel!`);
                }
                break;
            case 'Overtaking':
                let secondRider = command.split(' - ')[2];

                let position1 = Number(riders[rider].position);
                let position2 = Number(riders[secondRider].position);

                if (position2 > position1) {
                    riders[secondRider].position = position1;
                    riders[rider].position = position2;
                    console.log(`${rider} overtook ${secondRider}!`);
                }
                break;
            case 'EngineFail':
                let leftLaps = Number(command.split(' - ')[2]);
                console.log(`${rider} is out of the race because of a technical issue, ${leftLaps} laps before the finish.`);
                delete riders[rider];
                break;
        }

        command = inputData.shift();
    }

    Object.keys(riders).map(k => {
        console.log(k);
        console.log(`  Final position: ${riders[k].position}`);
    });
}

// motoGp((["3",
//     "Valentino Rossi|100|1",
//     "Marc Marquez|90|2",
//     "Jorge Lorenzo|80|3",
//     "StopForFuel - Valentino Rossi - 50 - 1",
//     "Overtaking - Marc Marquez - Jorge Lorenzo",
//     "EngineFail - Marc Marquez - 10",
//     "Finish"])
// );

motoGp((["4",
    "Valentino Rossi|100|1",
    "Marc Marquez|90|3",
    "Jorge Lorenzo|80|4",
    "Johann Zarco|80|2",
    "StopForFuel - Johann Zarco - 90 - 5",
    "Overtaking - Marc Marquez - Jorge Lorenzo",
    "EngineFail - Marc Marquez - 10",
    "Finish"])
);