// function printCharactersInRange(char1, char2) {
//
//     const start =
//         Math.min(char1.charCodeAt(0), char2.charCodeAt(0)) + 1;
//     const end =
//         Math.max(char1.charCodeAt(0), char2.charCodeAt(0));
//
//     let result = '';
//
//     for (let i = start; i < end; i++) {
//         result += String.fromCharCode(i) + ' ';
//     }
//
//     console.log(result);
// }


function printCharactersInRange(char1, char2) {

    const start =
        Math.min(char1.charCodeAt(0), char2.charCodeAt(0)) + 1;
    const end =
        Math.max(char1.charCodeAt(0), char2.charCodeAt(0));

    const chars =
        Array.from({length: end - start},
            (_, i) => String.fromCharCode(start + i));

    const result = chars.reduce((res, char) => res + char + ' ', '');

    console.log(result);

}
printCharactersInRange('a',
    'd'
);

printCharactersInRange('#',
    ':'
);
