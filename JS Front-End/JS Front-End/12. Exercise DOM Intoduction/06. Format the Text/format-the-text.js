function solve() {
  
  const inputEl = document.querySelector('#input');
  const outputEl = document.querySelector('#output');

  const sentences = inputEl.value.split('. ');
  const sentPerPar = 3;

  const numberOfParagraphs = Math.ceil(sentences.length / sentPerPar);

  let output = '';

  for (let i = 0; i < numberOfParagraphs; i++) {
    const p = i * sentPerPar;
    output += '<p>';
    output += sentences.slice(p, (p + numberOfParagraphs)).join('. ');
    output += '</p>'
  }

  outputEl.innerHTML = output;
}