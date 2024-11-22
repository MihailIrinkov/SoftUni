// function subtract() {
    
//     const inputElFirst = document.querySelector('#firstNumber');
//     const inputElSecond = document.querySelector('#secondNumber');
//     const resultEl = document.querySelector('#result');

//     const result = Number(inputElFirst.value) - Number(inputElSecond.value);

//     resultEl.textContent = result;
// }


function subtract() {
    
    const [num1, num2] = [...document.querySelectorAll('input[type="text"]')]
                        .map(el => Number(el.value));

    document.querySelector('#result').textContent = num1 - num2; 
}


