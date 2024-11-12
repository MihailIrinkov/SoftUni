function simpleCalculator(x, y, operator) {
    const operations = [];

    operations['multiply'] = (a, b) => x * y;
    operations['divide'] = (a, b) => x / y;
    operations['add'] = (a, b) => x + y;
    operations['subtract'] = (a, b) => x - y;

    console.log(operations[operator](x,y));
}

simpleCalculator(5, 5, 'multiply');