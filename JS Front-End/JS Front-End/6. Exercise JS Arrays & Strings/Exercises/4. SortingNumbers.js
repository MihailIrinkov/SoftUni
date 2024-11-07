function solve(input) {

    const initialArrayLength = input.length;
    const resultArray = [];

    input.sort((a, b) => a - b);

    for (let i = 0; i < initialArrayLength; i++) {
        if (i % 2 === 0) {
            const el = input.shift();
            resultArray.push(el);
        } else {
            const el = input.pop();
            resultArray.push(el);
        }
    }

    return resultArray;
}

console.log(solve([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));