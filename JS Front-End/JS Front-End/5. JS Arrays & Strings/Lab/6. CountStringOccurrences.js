// function solve(text, word) {
//     const pattern = new RegExp(`\\b${word}\\b`, 'g');
//     const result = text.match(pattern) || [];
//
//     console.log(result.length);
// }

function solve(text, word) {
    console.log(text.split(' ').filter(w => (w === word)).length);
}

solve('This is a word and it also is a sentence',
    'is'
);