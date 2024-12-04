function solve(commands) {

    let spell = commands.shift();

    let command = commands.shift();

    while (command !== 'End') {

        let action = command.split('!')[0];

        switch (action) {

            case 'RemoveEven':
                spell = spell.split('').filter((char, index) => index % 2 === 0).join('');
                console.log(spell);
                break;

            case 'TakePart':
                let firstIndex = Number(command.split('!')[1]);
                let secondIndex = Number(command.split('!')[2]);

                if (firstIndex > 0 || secondIndex > 0) {
                    spell = spell.slice(firstIndex, secondIndex);
                }
                console.log(spell);
                break;

            case 'Reverse':
                let combination = command.split('!')[1];
                if (spell.includes(combination)) {
                    let reverseString = combination.split('').reverse().join('');

                    spell = spell.replace(combination, '');
                    spell += reverseString;
                    console.log(spell);
                } else {
                    console.log('Error');
                }
                break;
        }
        command = commands.shift();
    }

    console.log(`The concealed spell is: ${spell}`);
}

solve((["asAsl2adkda2mdaczsa",
    "RemoveEven",
    "TakePart!1!9",
    "Reverse!maz",
    "End"])
);

solve((["hZwemtroiui5tfone1haGnanbvcaploL2u2a2n2i2m",
    "TakePart!31!42",
    "RemoveEven",
    "Reverse!anim",
    "Reverse!sad",
    "End"])
);



// function solve(commands) {

//     let spell = commands.shift();
//     let encodedSpell = '';

//     let command = commands.shift();

//     while (command !== 'End') {

//         let action = command.split('!')[0];

//         switch (action) {

//             case 'RemoveEven':
//                 let spellToEncode = spell.split('');
//                 for (let i = 0; i < spellToEncode.length; i++) {
//                     if (i % 2 === 0) {
//                         encodedSpell += spellToEncode[i];
//                         spell = encodedSpell;
        
//                     }
//                 }
//                 encodedSpell = '';
//                 console.log(spell);
//                 break;

//             case 'TakePart':
//                 let firstIndex = Number(command.split('!')[1]);
//                 let secondIndex = Number(command.split('!')[2]);

//                 if (firstIndex > 0 || secondIndex > 0) {
//                     spell = spell.slice(firstIndex, secondIndex);
//                 }
//                 console.log(spell);
//                 break;

//             case 'Reverse':
//                 let combination = command.split('!')[1];
//                 if (spell.includes(combination)) {
//                     let reverseString = combination.split('').reverse().join('');

//                     spell = spell.replace(combination, '');
//                     spell += reverseString;
//                     console.log(spell);
//                 } else {
//                     console.log('Error');
//                 }
//                 break;
//         }
//         command = commands.shift();
//     }

//     console.log(`The concealed spell is: ${spell}`);
// }