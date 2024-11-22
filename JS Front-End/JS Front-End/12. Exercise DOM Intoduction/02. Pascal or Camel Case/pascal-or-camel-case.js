// function solve() {
  
//   const input = document.querySelector('#text').value.toLowerCase().split(' ');
//   const namingConvention = document.querySelector('#naming-convention').value.toLowerCase().trim();

//   const resultEl = document.querySelector('#result');

//   switch(namingConvention) {
//     case 'camel case':
//       resultEl.textContent = input[0] + input.slice(1).map(word => word[0].toUpperCase() + word.slice(1)).join('');
//       break;

//       case 'pascal case':
//         resultEl.textContent = input.map(word => word[0].toUpperCase() + word.slice(1)).join('');
//         break;
//     default:
//       resultEl.textContent = 'Error!';    
//   }
// }


function solve() {
  
  const input = document.querySelector('#text').value.toLowerCase().split(' ');
  const namingConvention = document.querySelector('#naming-convention').value.toLowerCase().trim();

  const resultEl = document.querySelector('#result');

  function capitaliseWord(word) {
    return word[0].toUpperCase() + word.slice(1);
  }

  switch(namingConvention) {
    case 'camel case':
      resultEl.textContent = input[0] + input.slice(1).map(capitaliseWord).join('');
      break;

      case 'pascal case':
        resultEl.textContent = input.map(capitaliseWord).join('');
        break;
    default:
      resultEl.textContent = 'Error!';    
  }
}