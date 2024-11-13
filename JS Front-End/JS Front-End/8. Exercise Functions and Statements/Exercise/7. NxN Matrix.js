function matrixNxN(n) {
    const result = ((n + ' ').repeat(n) + '\n').repeat(n);

    return result;
}

console.log(matrixNxN(3));