// function solve(input) {
//
//     const initialArrayLength = input.length;
//     const resultArray = [];
//
//     // input.sort((a, b) => a - b);
//     input.sort(function (a, b){
//         return a - b;
//     });
//
//     for (let i = 0; i < initialArrayLength; i++) {
//         if (i % 2 === 0) {
//             const el = input.shift();
//             resultArray.push(el);
//         } else {
//             const el = input.pop();
//             resultArray.push(el);
//         }
//     }
//
//     return resultArray;
// }

function solve(input) {
    input.sort(function (a, b){
        return a - b;
    });

    const counter = [...new Array(input.length).keys()];

    return counter.reduce(function (result, i){
       if (i % 2 == 0) {
           return [...result, input.shift()];
       } else {
           return [...result, input.pop()];
       }
    }, []);
}

console.log(solve([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));