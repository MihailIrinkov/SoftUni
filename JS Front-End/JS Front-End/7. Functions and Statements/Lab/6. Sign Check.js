function checkSign(num1, num2, num3) {

    const array = [num1, num2, num3];

    const check =
        array.filter(num => num < 0).length % 2 !== 0 ? 'Negative' : 'Positive';

    console.log(check);
}

checkSign(5,
    12,
    -15
);

checkSign(-6,
    -12,
    14
);