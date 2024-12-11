window.addEventListener("load", solve);

function solve() {
  const nemaEl = document.querySelector('#name');
  const timeEl = document.querySelector('#time');
  const descriptionEl = document.querySelector('#description');

  const addBtn = document.querySelector('#add-btn');
  const previewListUl = document.querySelector('#preview-list');
  const archiveListUl = document.querySelector('#archive-list');

  addBtn.addEventListener('click', e => {
    e.preventDefault();

    if (!nemaEl.value || !timeEl.value || !descriptionEl.value) return;

    addEvent(nemaEl.value, timeEl.value, descriptionEl.value);

    clear();
    addBtn.setAttribute('disabled', 'disabled');
  });

  function addEvent(name, time, description) {
    const liEl = document.createElement('li');
    const articleEl = document.createElement('article');

    const pName = document.createElement('p');
    pName.textContent = name;
    articleEl.appendChild(pName);

    const pTime = document.createElement('p');
    pTime.textContent = time;
    articleEl.appendChild(pTime);

    const pDescription = document.createElement('p');
    pDescription.textContent = description;
    articleEl.appendChild(pDescription);

    const divEl = document.createElement('div');
    divEl.classList.add('buttons');

    const editBtn = document.createElement('button');
    editBtn.classList.add('edit-btn');
    editBtn.textContent = 'Edit';
    divEl.appendChild(editBtn);

    const nextBtn = document.createElement('button');
    nextBtn.classList.add('next-btn');
    nextBtn.textContent = 'Next';
    divEl.appendChild(nextBtn);

    liEl.appendChild(articleEl);
    liEl.appendChild(divEl);

    previewListUl.appendChild(liEl);

    editBtn.addEventListener('click', e => {

      liEl.remove();
      nemaEl.value = name;
      timeEl.value = time;
      descriptionEl.value = description;
      addBtn.removeAttribute('disabled');
    });

    const archiveBtn = document.createElement('button');
    archiveBtn.textContent = 'Archive';
    archiveBtn.classList.add('archive-btn');

    nextBtn.addEventListener('click', e => {
      divEl.remove();
      liEl.remove();

      liEl.appendChild(archiveBtn);
      archiveListUl.appendChild(liEl);
    });

    archiveBtn.addEventListener('click', e => {

      liEl.remove();
      addBtn.removeAttribute('disabled');
    });
  }

  function clear() {
    nemaEl.value = '';
    timeEl.value = '';
    descriptionEl.value = '';
  }
}