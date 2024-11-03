function solve(num) {
    let numToString = num.toString();
    let sum = 0;

    for (let i = 0; i < numToString.length; i++) {
        sum += Number(numToString[i]);
    }
    console.log(sum);
}

solve(543);