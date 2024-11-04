function solve(num) {
    let input = num.toString();
    let sum =0;
    let check = true;

    for (let i = 0; i < input.length; i++) {
        if (input[i] !== input[i + 1] && input.length -1 > i) {
            check = false;
        }

        sum += Number(input[i]);
    }
    console.log(check);
    console.log(sum);
}

solve(2222222);
solve(1234);