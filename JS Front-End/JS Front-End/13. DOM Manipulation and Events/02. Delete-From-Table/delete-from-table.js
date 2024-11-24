function deleteByEmail() {
    
    const inputEl = document.querySelector('input[name="email"]').value.toLowerCase();
    const persons = document.querySelectorAll('table tbody tr td:nth-child(2)');
    const resultEl = document.querySelector('#result');

    if (inputEl == '') return;

    persons.forEach(person => {

        if (person.textContent.toLowerCase().includes(inputEl)) {
            person.parentElement.remove();
            resultEl.textContent = 'Deleted.'
        } else {
            resultEl.textContent = 'Not found.';
        }
        
    });
}
