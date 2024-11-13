function passwordValidator(password) {

    const patternFullPassword = new RegExp(/^(?=.*\d.*\d)[a-zA-Z\d]{6,10}$/);
    const patternLetterAndDigits = new RegExp(/^[a-zA-Z\d]+$/);
    const patternAtLeast2Digits = new RegExp(/(.*\d){2}/);

    const checkLength = password.length < 6 || password.length > 10;
    const checkContents = !patternLetterAndDigits.test(password);
    const checkNumCount = !patternAtLeast2Digits.test(password);

    if (patternFullPassword.test(password)) {
        console.log('Password is valid');
    } else {
        if (checkLength) console.log('Password must be between 6 and 10 characters');
        if (checkContents) console.log('Password must consist only of letters and digits');
        if (checkNumCount) console.log('Password must have at least 2 digits');
    }
}

passwordValidator('logIn');