// function formatGrade(grade) {
//
//     if (grade < 3.00) {
//         console.log(`Fail (2)`);
//     } else if (grade >= 3.00 && grade < 3.50) {
//         console.log(`Poor (${grade.toFixed(2)})`);
//     } else if (grade >= 3.50 && grade < 4.50) {
//         console.log(`Good (${grade.toFixed(2)})`);
//     } else if (grade >= 4.50 && grade < 5.50) {
//         console.log(`Very good (${grade.toFixed(2)})`);
//     } else if (grade >= 5.50) {
//         console.log(`Excellent (${grade.toFixed(2)})`);
//     }
//
// }

function formatGrade(grade) {

    let result = '';

    if (grade < 3.00) {
        result = 'Fail';
    } else if (grade < 3.50) {
        result = 'Poor';
    } else if (grade < 4.50) {
        result = 'Good';
    } else if (grade < 5.50) {
        result = 'Very good';
    } else if (grade >= 5.50) {
        result = 'Excellent';
    }

    console.log(`${result} (${grade < 3 ? 2 : grade.toFixed(2)})`);
}

formatGrade(3.33);
formatGrade(5.80);