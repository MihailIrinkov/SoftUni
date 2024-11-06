// function solve(input) {
//     let sum = input[0] + input[input.length - 1];
//
//     console.log(sum);
// }

function solve(input) {
    let sum = input.shift() + input.pop();

    console.log(sum);
}

solve([20, 30, 40]);