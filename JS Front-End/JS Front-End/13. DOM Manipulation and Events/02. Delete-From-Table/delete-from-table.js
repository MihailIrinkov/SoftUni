function deleteByEmail() {
    
    const inputEl = document.querySelector('input[name="email"]');
    const searchStr = inputEl.value.toLowerCase();
    const persons = document.querySelectorAll('table tbody tr td:nth-child(2)');
    const resultEl = document.querySelector('#result');

    if (searchStr.trim() == '') return;

    const [machedEl] = [...persons]
                        .filter(person => person.textContent.toLowerCase()
                        .includes(searchStr));
                        
    if (machedEl) {
        machedEl.parentElement.remove();
        resultEl.textContent = 'Deleted.';
    } else {
        resultEl.textContent = 'Not found.';
    }                    

    inputEl.value = '';
}
