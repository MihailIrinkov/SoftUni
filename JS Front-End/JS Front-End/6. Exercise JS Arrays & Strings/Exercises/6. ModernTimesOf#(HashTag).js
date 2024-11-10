// function solve(text) {
//
//     const words = text.split(' ');
//
//     for (let w of words) {
//         if (w.startsWith('#') && w.length > 1) {
//             const asciiCode = w.charCodeAt(1);
//
//             if ((asciiCode >= 65 && asciiCode <= 90) || (asciiCode >= 97 && asciiCode <= 122)) {
//                 console.log(w.substring(1));
//             }
//         }
//     }
// }

function solve(text) {
    let pattern = /#[A-Za-z]+/g;
    const captures = text.match(pattern);

    captures.forEach(function (element) {
        console.log(element.substring(1));
    });
}

solve('Nowadays everyone uses # to tag a #special word in #socialMedia');