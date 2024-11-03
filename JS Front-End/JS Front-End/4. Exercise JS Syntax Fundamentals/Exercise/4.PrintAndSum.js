function solve(num1, num2) {
    let sum =0;
    let log ='';

    for (let i = num1; i <= num2; i++) {
        sum += i;
        log += i +' ';
    }
    console.log(log.trim());
    console.log(`Sum: ${sum}`);
}

solve(5, 10);