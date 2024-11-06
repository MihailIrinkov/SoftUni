// function solve(num, arrayInput) {
//
//     let arrayFromN = arrayInput.slice(0, num);
//
//     let reverseArray = arrayFromN.reverse();
//
//     let result = '';
//
//     // reverseArray.forEach(result + ' ');
//
//     for (let i = 0; i < reverseArray.length; i++) {
//         // result.concat(reverseArray[i]);
//          result = result + ' ' + reverseArray[i];
//     }
//
//     console.log(result.trim());
// }

function solve(n, numbers) {
    console.log(numbers.splice(0, n).reverse().join(' '));
}

solve(3, [10, 20, 30, 40, 50]);