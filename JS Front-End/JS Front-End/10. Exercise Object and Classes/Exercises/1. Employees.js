// function solve(arr) {
//     const employees = {};
//
//     arr.forEach( element => {
//         employees[element] = element.length;
//     });
//
//     for (const name in employees) {
//         console.log(`Name: ${name} -- Personal Number: ${employees[name]}`);
//     }
// }

function solve(arr) {

    function processEmployees(list) {
        return list.reduce((employees, person) => {
            employees[person] = person.length;
            return employees;
        }, {});
    }

    function printEmployees(employees) {
        for (const employee in employees) {
            console.log(`Name: ${employee} -- Personal Number: ${employees[employee]}`);
        }
    }

    const employees = processEmployees(arr);
    printEmployees(employees);
}

solve([
        'Silas Butler',
        'Adnaan Buckley',
        'Juan Peterson',
        'Brendan Villarreal'
    ]
);