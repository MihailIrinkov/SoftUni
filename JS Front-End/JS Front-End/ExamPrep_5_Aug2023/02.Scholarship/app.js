window.addEventListener("load", solve);

function solve() {
  const studentEl = document.querySelector('#student');
  const universityEl = document.querySelector('#university');
  const scoreEl = document.querySelector('#score');

  const nextBtn = document.querySelector('#next-btn');
  const previewListUl = document.querySelector('#preview-list');
  const candidatesListUl = document.querySelector('#candidates-list');

  nextBtn.addEventListener('click', e => {
    e.preventDefault();

    if (!studentEl.value || !universityEl.value || !scoreEl.value) return;

    apply(studentEl.value, universityEl.value, scoreEl.value);

    clear();
  });

  function apply(name, uni, score) {
    const liEl = document.createElement('li');
    liEl.classList.add('application');

    const articleEl = document.createElement('article');

    const hName = document.createElement('h4');
    hName.textContent = `${name}`;
    articleEl.appendChild(hName);

    const pUni = document.createElement('p');
    pUni.textContent = `University: ${uni}`;
    articleEl.appendChild(pUni);

    const pScore = document.createElement('p');
    pScore.textContent = `Score: ${score}`;
    articleEl.appendChild(pScore);

    liEl.appendChild(articleEl);

    const editBtn = document.createElement('button');
    editBtn.classList.add('action-btn', 'edit');
    editBtn.textContent = 'edit';
    liEl.appendChild(editBtn);

    const applyBtn = document.createElement('button');
    applyBtn.classList.add('action-btn', 'apply');
    applyBtn.textContent = 'apply';
    liEl.appendChild(applyBtn);

    previewListUl.appendChild(liEl);
    nextBtn.setAttribute('disabled', 'disabled');

    editBtn.addEventListener('click', e => {
      liEl.remove();
      nextBtn.removeAttribute('disabled');

      studentEl.value = name;
      universityEl.value = uni;
      scoreEl.value = score;
    });

    applyBtn.addEventListener('click', e => {
      liEl.remove();
      editBtn.remove();
      applyBtn.remove();

      candidatesListUl.appendChild(liEl);
      nextBtn.removeAttribute('disabled');
    });
  }

  function clear() {
    studentEl.value = '';
    universityEl.value = '';
    scoreEl.value = '';
  }
}
