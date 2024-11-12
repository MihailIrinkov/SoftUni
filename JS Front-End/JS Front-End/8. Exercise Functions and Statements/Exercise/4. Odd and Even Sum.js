// function oddAndEvenSum(num) {
//
//     const digits = Math.abs(num).toString().split('').map(Number);
//
//     const evenSum = digits.filter(number => number % 2 === 0)
//         .reduce((sum, n) => sum + n, 0);
//
//     const oddSum = digits.filter(n => n % 2 !== 0)
//         .reduce((sum, n) => sum + n, 0);
//
//     console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);
// }


function oddAndEvenSum(num) {

    const digits = Math.abs(num).toString().split('').map(Number);

    let oddSum = 0, evenSum = 0;

    digits.forEach(d => (d % 2 === 0) ? evenSum += d : oddSum += d);

    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);
}

oddAndEvenSum(1000435);