function solve(inputData) {
    let encodedMessage = inputData.shift();

    let command = inputData.shift();

    while (command != 'Buy') {
        let action = command.split('?')[0];
        let substring = command.split('?')[1];

        switch (action) {
            case 'TakeEven':
                encodedMessage =
                    encodedMessage.split('')
                        .filter((char, index) => index % 2 == 0).join('');
                console.log(encodedMessage);
                break;
            case 'ChangeAll':
                let replacement = command.split('?')[2];
                // encodedMessage = encodedMessage.replaceAll(substring, replacement);
                while (encodedMessage.includes(substring)) {
                    encodedMessage = encodedMessage.replace(substring, replacement);
                }
                console.log(encodedMessage);
                break;
            case 'Reverse':
                let encode = encodedMessage.split(substring);
                if (encode.length > 1) {
                    encodedMessage = encodedMessage.replace(substring, '');
                    encodedMessage += substring.split('').reverse().join('');
                    console.log(encodedMessage);
                } else {
                    console.log('error');
                }
                break;
        }

        command = inputData.shift();
    }

    console.log(`The cryptocurrency is: ${encodedMessage}`);
}

solve((["z2tdsfndoctsB6z7tjc8ojzdngzhtjsyVjek!snfzsafhscs",
    "TakeEven",
    "Reverse?!nzahc",
    "ChangeAll?m?g",
    "Reverse?adshk",
    "ChangeAll?z?i",
    "Buy"])
);

// solve((["PZDfA2PkAsakhnefZ7aZ",
//     "TakeEven",
//     "TakeEven",
//     "TakeEven",
//     "ChangeAll?Z?X",
//     "ChangeAll?A?R",
//     "Reverse?PRX",
//     "Buy"])
// );