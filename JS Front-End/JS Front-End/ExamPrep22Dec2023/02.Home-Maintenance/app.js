window.addEventListener("load", solve);

function solve() {
    const placeEl = document.querySelector('#place');
    const actionEl = document.querySelector('#action');
    const personEl = document.querySelector('#person');
    const addBtnEl = document.querySelector('#add-btn');

    const taskListUl = document.querySelector('#task-list');
    const doneListUl = document.querySelector('#done-list');

    addBtnEl.addEventListener('click', e => {
        e.preventDefault();

        if (!placeEl.value || !actionEl.value || !personEl.value) return;

        createTask(placeEl.value, actionEl.value, personEl.value);

        clear();
    });

    function createTask(place, action, person) {
        const liEl = document.createElement('li');
        liEl.classList.add('clean-task');
        const articleEl = document.createElement('article');

        const pPlace = document.createElement('p');
        pPlace.textContent = `Place:${place}`;
        articleEl.appendChild(pPlace);

        const pAction = document.createElement('p');
        pAction.textContent = `Action:${action}`;
        articleEl.appendChild(pAction);

        const pPerson = document.createElement(`p`);
        pPerson.textContent = `Person:${person}`;
        articleEl.appendChild(pPerson);

        liEl.appendChild(articleEl);

        const divEl = document.createElement('div');
        divEl.classList.add('buttons');

        const editBtn = document.createElement('button');
        editBtn.classList.add('edit');
        editBtn.textContent = 'Edit';
        divEl.appendChild(editBtn);

        const doneBtn = document.createElement('button');
        doneBtn.classList.add('done');
        doneBtn.textContent = 'Done';
        divEl.appendChild(doneBtn);

        liEl.appendChild(divEl);
        taskListUl.appendChild(liEl);

        editBtn.addEventListener('click', e => {
            liEl.remove();

            placeEl.value = place;
            actionEl.value = action;
            personEl.value = person;

        });

        const deleteBtn = document.createElement('button');
        deleteBtn.classList.add('delete');
        deleteBtn.textContent = 'Delete';

        doneBtn.addEventListener('click', e => {
            liEl.remove();
            divEl.remove();

            liEl.appendChild(deleteBtn);
            doneListUl.appendChild(liEl);
        });

        deleteBtn.addEventListener('click', e => {
            liEl.remove();
        });
    }

    function clear() {
        placeEl.value = '';
        actionEl.value = '';
        personEl.value = '';
    }
}