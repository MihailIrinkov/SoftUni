// function solve(product, qty) {
//     let price = 0;
//
//     switch (product) {
//         case 'coffee':
//             price = qty * 1.5;
//             break;
//         case 'water':
//             price = qty * 1;
//             break;
//         case 'coke':
//             price = qty * 1.4;
//             break;
//         case 'snacks':
//             price = qty * 2;
//             break;
//     }
//
//     return price.toFixed(2);
// }

function solve(product, qty) {
    const drinks = [];

    drinks['coffee'] = (q) => q * 1.50;
    drinks['water'] = (q) => q * 1.00;
    drinks['coke'] = (q) => q * 1.40;
    drinks['snacks'] = (q) => q * 2.00;

    console.log(drinks[product](qty).toFixed(2));
}

solve('water', 5);

// console.log(solve('water', 5));