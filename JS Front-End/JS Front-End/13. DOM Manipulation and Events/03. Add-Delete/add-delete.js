function deleteItem(e) {
    e.currentTarget.parentElement.remove();
}

function addItem() {
    
    const inputEl = document.querySelector('#newItemText');
    const listEl = document.querySelector('#items');

    if (inputEl.value == '') return;

    const newListItem = document.createElement('li');
    const deleteButton = document.createElement('a');

    newListItem.textContent = inputEl.value;
    deleteButton.setAttribute('href', '#');
    deleteButton.textContent = '[Delete]';

    deleteButton.addEventListener('click', deleteItem);

    newListItem.appendChild(deleteButton);

    listEl.appendChild(newListItem);

    inputEl.value = '';
}


// function addItem() {
    
//     const inputEl = document.querySelector('#newItemText');
//     const listEl = document.querySelector('#items');

//     if (inputEl.value.trim() == '') return;

//     const newListItem = document.createElement('li');
//     const deleteButton = document.createElement('a');

//     newListItem.textContent = inputEl.value;
//     deleteButton.setAttribute('href', '#');
//     deleteButton.textContent = '[Delete}';

//     deleteButton.addEventListener('click', e => {
//         e.currentTarget.parentElement.remove();
//     });

//     newListItem.appendChild(deleteButton);

//     listEl.appendChild(newListItem);

//     inputEl.value = '';
// }



