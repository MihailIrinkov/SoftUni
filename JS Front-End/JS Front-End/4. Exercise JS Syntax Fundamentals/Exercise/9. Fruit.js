function solve(fruit, weight, pricePerKilo) {
    let weightInKilo = weight / 1000;
    let money = weightInKilo * pricePerKilo;

    console.log(`I need $${money.toFixed(2)} to buy ${weightInKilo.toFixed(2)} kilograms ${fruit}.`);
}

solve('orange', 2500, 1.80);