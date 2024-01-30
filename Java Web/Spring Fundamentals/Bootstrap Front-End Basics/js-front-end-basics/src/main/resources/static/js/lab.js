//1. Sort array

function sortArray(args, sortingDirection) {
    if (sortingDirection === "asc") {
        return args.sort((a, b) => a -b);
    }
    return args.sort((a, b) => b - a);
}

console.log(sortArray([14, 7, 17, 6, 8], 'asc'));
console.log(sortArray([14, 7, 17, 6, 8], 'desc'));

