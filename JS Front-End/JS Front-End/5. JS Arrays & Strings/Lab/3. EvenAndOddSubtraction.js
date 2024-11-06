function solve(numbers) {
    let sumOdd = 0;
    let sumEven = 0;

    numbers.forEach(function (number) {
        if (number % 2 === 0) {
            sumEven += number;
        } else {
            sumOdd += number;
        }
    } );

    console.log(sumEven  - sumOdd);
}

solve([1,2,3,4,5,6]);