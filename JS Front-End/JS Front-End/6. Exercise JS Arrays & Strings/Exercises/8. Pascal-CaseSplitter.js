function solve(text) {
    console.log(text.match(/[A-Z][a-z]*/g).join(', '));
}

solve('SplitMeIfYouCanHaHaYouCantOrYouCan');