window.addEventListener("load", solve);

function solve() {
  const nameEl = document.querySelector('#name');
  const phoneNumberEl = document.querySelector('#phone');
  const categoryEl = document.querySelector('#category');

  const ulEl = document.querySelector('#check-list');
  const contactListUl = document.querySelector('#contact-list');

  const addButton = document.querySelector('#add-btn');


  if (nameEl == '' || phoneNumberEl == '' || categoryEl == '') return;

  addButton.addEventListener('click', () => {
    createData(nameEl.value, phoneNumberEl.value, categoryEl.value);

    clear();
  });

  function createData(name, phone, category) {
    const articleEl = document.createElement('article');

    const namePEl = document.createElement('p');
    namePEl.textContent = `name:${name}`;
    articleEl.appendChild(namePEl);

    const phonePEl = document.createElement('p');
    phonePEl.textContent = `phone:${phone}`;
    articleEl.appendChild(phonePEl);

    const categoryPEl = document.createElement('p');
    categoryPEl.textContent = `category:${category}`;
    articleEl.appendChild(categoryPEl);

    const liEl = document.createElement('li');
    liEl.appendChild(articleEl);

    ulEl.appendChild(liEl);

    const divEl = document.createElement('div');
    divEl.classList.add('buttons');

    const editBtn = document.createElement('button');
    editBtn.classList.add('edit-btn');
    divEl.appendChild(editBtn);

    const saveBtn = document.createElement('button');
    saveBtn.classList.add('save-btn');
    divEl.appendChild(saveBtn);

    liEl.appendChild(divEl);

    const editBtnEl = document.querySelector('.edit-btn');
    editBtnEl.addEventListener('click', () => {
      nameEl.value = name;
      phoneNumberEl.value = phone;
      categoryEl.value = category;

      liEl.remove();
    });

    saveBtn.addEventListener('click', () => {
      contactListUl.appendChild(liEl);
      divEl.remove();

      const deleteButton = document.createElement('button');
      deleteButton.classList.add('del-btn');
      liEl.appendChild(deleteButton);

      deleteButton.addEventListener('click', (e) => {
        e.target.parentElement.remove();
      });
    });

  }

  function clear() {
    nameEl.value = '';
    phoneNumberEl.value = '';
    categoryEl.value = '';
  }
}
