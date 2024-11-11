function simpleCalculator(x, y, operator) {
    const operations = [];

    operations['multiply'] = (x, y) => x * y;
    operations['divide'] = (x, y) => x / y;
    operations['add'] = (x, y) => x + y;
    operations['subtract'] = (x, y) => x - y;

    console.log(operations[operator](x,y));
}

simpleCalculator(5, 5, 'multiply');