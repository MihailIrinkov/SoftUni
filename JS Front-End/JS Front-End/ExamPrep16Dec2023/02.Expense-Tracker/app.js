window.addEventListener("load", solve);

function solve() {
    const expenseEl = document.querySelector('#expense');
    const amountEl = document.querySelector(`#amount`);
    const dateEl = document.querySelector('#date');

    const addButton = document.querySelector('#add-btn');
    const ulPreviewListEl = document.querySelector('#preview-list');
    const ulExpensesListEl = document.querySelector('#expenses-list');
    const deleteBtn = document.querySelector('.btn.delete');

    addButton.addEventListener('click', e => {
        e.preventDefault();
        
        if (!expenseEl.value || !amountEl.value || !dateEl.value) return;

        createExpense(expenseEl.value, amountEl.value, dateEl.value); 
    });

    function createExpense(expense, amount, date) {

        const liEl = document.createElement('li');
        liEl.classList.add('expense-item');
        const articleEl = document.createElement('article');
        const divEl = document.createElement('div');
        divEl.classList.add('buttons');

        const pType = document.createElement('p');
        pType.textContent = `Type: ${expenseEl.value}`;
        articleEl.appendChild(pType);

        const pAmount = document.createElement('p');
        pAmount.textContent = `Amount: ${amountEl.value}$`;
        articleEl.appendChild(pAmount);

        const pDate = document.createElement('p');
        pDate.textContent = `Date: ${dateEl.value}`;
        articleEl.appendChild(pDate);

        const editBtn = document.createElement('button');
        editBtn.classList.add('btn', 'edit');
        editBtn.textContent = 'edit';
        divEl.appendChild(editBtn);

        const okBtn = document.createElement('button');
        okBtn.classList.add('btn', 'ok');
        okBtn.textContent = 'ok';
        divEl.appendChild(okBtn);

        liEl.appendChild(articleEl);
        liEl.appendChild(divEl);

        ulPreviewListEl.appendChild(liEl);

        editBtn.addEventListener('click', () => {
            expenseEl.value = expense;
            amountEl.value = amount;
            dateEl.value = date;

            // ulPreviewListEl.remove('li');
            liEl.remove();
            addButton.removeAttribute('disabled');
        });

        okBtn.addEventListener('click', () => {
            divEl.remove();
            liEl.remove;

            ulExpensesListEl.appendChild(liEl);
            
            addButton.removeAttribute('disabled');
        });

        addButton.setAttribute('disabled', 'disabled');
        clear();
    }

    deleteBtn.addEventListener('click', () => {
        ulExpensesListEl.innerHTML = '';
    });

    function clear() {
        expenseEl.value ='';
        amountEl.value = '';
        dateEl.value = '';
    }
}