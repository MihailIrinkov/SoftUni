let a = 5;
let b = 10;

console.log(a, b);

if (a == b) {
    console.log(true);
} else {
    console.log(false);
}

function solve(num1, num2) {
    console.log(num1 + num2);
}

solve(5, 10);

function gradeText(name, grade) {
    console.log(`The name is: ${name}, grade: ${grade.toFixed(2)}`);
}

gradeText(`Misho`, 5.566);

for (let i= 1; i<= 5; i++) {
    console.log(i);
}

let j = 1;
while (j <= 5) {
    console.log(j);
    j++;
}

let car;
console.log(typeof car);