// function solve(input, number) {
//
//     const result = [];
//     for (let i = 0; i < input.length; i++) {
//
//         if (i % number === 0) {
//             result.push(input[i]);
//         }
//     }
//
//     return result;
// }

// function solve(input, number) {
//
//     const result = [];
//
//     input.forEach(function (el, index) {
//         if (index % number === 0) result.push(input[index]);
//     });
//
//     return result;
// }

// function solve(input, number) {
//
//     return input.filter(function (el, index) {
//         return index % number === 0;
//     });
// }

function solve(input, number) {
    return input.filter((e, i) => i % number === 0);
}

console.log(solve(['5',
        '20',
        '31',
        '4',
        '20'],
    2
));
console.log(solve(['dsa',
        'asd',
        'test',
        'tset'],
    2
));