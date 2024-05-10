// 1. Sort array

function sortArray(arg, sortingDirection) {
    if(sortingDirection === "asc") {
        return arg.sort((a,b) => a - b);
    }

    return arg.sort((a,b) => b-a);
}

console.log(sortArray([1,2,3,4,5,6], 'asc'));
console.log(sortArray([6,5,4,3,2,1], 'desc'));

