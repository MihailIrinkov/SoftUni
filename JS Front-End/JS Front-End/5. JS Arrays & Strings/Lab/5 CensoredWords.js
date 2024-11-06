function solve(text, word) {

    console.log(text.replaceAll(word, '*'.repeat(word.length)));
}

solve('A small sentence with some words', 'small');