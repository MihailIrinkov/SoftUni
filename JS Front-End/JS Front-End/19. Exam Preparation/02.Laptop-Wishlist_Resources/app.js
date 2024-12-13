window.addEventListener("load", solve);

function solve() {
  const modelEl = document.querySelector('#laptop-model');
  const storageEl = document.querySelector('#storage');
  const priceEl = document.querySelector('#price');

  const checkListUl = document.querySelector('#check-list');
  const addBtn = document.querySelector('#add-btn');
  const laptopsListUl = document.querySelector('#laptops-list');
  const clearBtn = document.querySelector('.clear');

  addBtn.addEventListener('click', e => {
    e.preventDefault();

    if (!modelEl.value || !storageEl.value || !priceEl.value) return;

    addLaptop(modelEl.value, storageEl.value, priceEl.value);

    clear();
  });

  clearBtn.addEventListener('click', e => {
    laptopsListUl.innerHTML = '';
    addBtn.removeAttribute('disabled');
  });

  function addLaptop(model, storage, price) {
    const liEl = document.createElement('li');
    liEl.classList.add('laptop-item');

    const articleEl = document.createElement('article');
    liEl.appendChild(articleEl);

    const pModel = document.createElement('p');
    pModel.textContent = model;
    articleEl.appendChild(pModel);

    const pMemory = document.createElement('p');
    pMemory.textContent = `Memory: ${storage} TB`;
    articleEl.appendChild(pMemory);

    const pPrice = document.createElement('p');
    pPrice.textContent = `Price: ${price}$`;
    articleEl.appendChild(pPrice);

    const editBtn = document.createElement('button');
    editBtn.classList.add('btn', 'edit');
    editBtn.textContent = 'edit';
    liEl.appendChild(editBtn);

    const okBtn = document.createElement('button');
    okBtn.classList.add('btn', 'ok');
    okBtn.textContent = 'ok';
    liEl.appendChild(okBtn);

    checkListUl.appendChild(liEl);
    addBtn.setAttribute('disabled', 'disabled');

    editBtn.addEventListener('click', e => {
      liEl.remove();

      modelEl.value = model;
      storageEl.value = storage;
      priceEl.value = price;

      addBtn.removeAttribute('disabled');
    });

    okBtn.addEventListener('click', e => {
      editBtn.remove();
      okBtn.remove();
      liEl.remove();

      laptopsListUl.appendChild(liEl);
      addBtn.removeAttribute('diabled');
    });
  }

  function clear() {
    modelEl.value = '';
    storageEl.value = '';
    priceEl.value = '';
  }
}
