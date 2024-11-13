// function loadingBar(num) {
//     const loadNum = num / 10;
//     let loadProgress = '';
//
//     if (loadNum === 10) {
//         for (let i = 0; i < 10; i++) {
//             loadProgress += '%';
//         }
//         console.log('100% Complete!');
//         console.log(loadProgress);
//     } else {
//         for (let i = 0; i < loadNum; i++) {
//             loadProgress += '%';
//         }
//         for (let i = 0; i < 10 - loadNum; i++) {
//             loadProgress += '.';
//         }
//         console.log(`${num}% [${loadProgress}]`);
//         console.log('Still loading...');
//     }
// }

function loadingBar(num) {

    const barsLength = 10;
    const barsFilled = Math.round(num / barsLength);
    const barsEmpty = barsLength - barsFilled;

    const before = (num < 100) ? `${num}%` : `100% Complete!\n`;
    const progressBar = `[${'$'.repeat(barsFilled)}${'.'.repeat(barsEmpty)}]\n`;
    const after = (num < 100) ? 'Still loading...' : '';

    console.log(before + progressBar + after);
}

loadingBar(30);
loadingBar(50);
loadingBar(100);