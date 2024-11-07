function solve(input, numberOfRotation) {

    for (let i = 0; i < numberOfRotation; i++) {
        input.push(input.shift());
    }

    console.log(input.join(' '));
}

solve([51, 47, 32, 61, 21], 2);