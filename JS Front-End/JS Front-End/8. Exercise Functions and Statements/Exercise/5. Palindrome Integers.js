function palindrome (numbers) {

    const isPalindrome = num => {
        const strNum = num.toString();
        const strNumReverse = strNum.split('').reverse().join('');

        return strNum === strNumReverse;
    }

    numbers.forEach(n => console.log(isPalindrome(n)));
}

palindrome([123,323,421,121]);