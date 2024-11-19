// function solve(input) {
//
//     let cars = [];
//
//     input.forEach(car => {
//         let[direction, carNumber] = car.split(', ');
//         if (direction === 'IN' && !cars.hasOwnProperty(carNumber)) {
//             cars.push(carNumber);
//         } else {
//             // delete cars['carNumber'];
//             cars = cars.filter(car => car !== carNumber);
//         }
//     });
//
//     if ( cars.length === 0) {
//         console.log('Parking Lot is Empty');
//     } else {
//         cars.sort().forEach(car => {
//             console.log(car);
//         });
//     }
// }

function solve(input) {

    const parking = {};

    input.forEach(entry => {
        const [direction, carNumber] = entry.split(', ');
        if (direction == 'IN') {
            if (!parking.hasOwnProperty(carNumber)) parking[carNumber] = 1;
        } else {
            if (parking.hasOwnProperty(carNumber)) delete parking[carNumber];
        }
    });

    if (Object.entries(parking).length === 0) {
        console.log('Parking Lot is Empty');
    } else {
        Object.entries(parking).sort().forEach(([carNumber]) => {
            console.log(carNumber);
        });
    }
}


solve(['IN, CA2844AA',
    'IN, CA1234TA',
    'OUT, CA2844AA',
    'IN, CA9999TT',
    'IN, CA2866HI',
    'OUT, CA1234TA',
    'IN, CA2844AA',
    'OUT, CA2866HI',
    'IN, CA9876HH',
    'IN, CA2822UU']
);

solve(['IN, CA2844AA',
    'IN, CA1234TA',
    'OUT, CA2844AA',
    'OUT, CA1234TA']
);