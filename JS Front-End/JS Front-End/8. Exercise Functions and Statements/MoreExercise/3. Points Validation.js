function validPoints(input) {

    function distance(x1, y1, x2, y2) {
        return Math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2);
    }

    function distanceValidity(x1, y1, x2, y2) {
        return Number.isInteger(distance(x1, y1, x2, y2));
    }

    function printDistanceValidity(x1, y1, x2, y2) {
        const isValid = distanceValidity(x1, y1, x2, y2);
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is ${(isValid) ? 'valid' : 'invalid'}`);

    }

    printDistanceValidity(input[0], input[1], 0, 0);
    printDistanceValidity(input[2], input[3], 0, 0);
    printDistanceValidity(input[0], input[1], input[2], input[3]);

}

validPoints([2, 1, 1, 1]);
validPoints([3, 0, 0, 4]);
