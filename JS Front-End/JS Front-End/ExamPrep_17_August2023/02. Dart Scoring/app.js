window.addEventListener("load", solve);

function solve() {
  const nameEl = document.querySelector('#player');
  const scoreEl = document.querySelector('#score');
  const roundEl = document.querySelector('#round');

  const sureListUl = document.querySelector('#sure-list');
  const addBtn = document.querySelector('#add-btn');
  const scoreboardListUl = document.querySelector('#scoreboard-list');
  const clearBtn = document.querySelector('.clear');

  addBtn.addEventListener('click', e => {
    e.preventDefault();

    if (!nameEl.value || !scoreEl.value || !roundEl.value) return;

    tableInfo(nameEl.value, scoreEl.value, roundEl.value);
    clear();
  });

  function tableInfo(name, score, round) {
    const liEl = document.createElement('li');
    liEl.classList.add('dart-item');

    const articleEl = document.createElement('article');

    const pName = document.createElement('p');
    pName.textContent = name;
    articleEl.appendChild(pName);

    const pScore = document.createElement('p');
    pScore.textContent = `Score: ${score}`;
    articleEl.appendChild(pScore);

    const pRound = document.createElement('p');
    pRound.textContent = `Round: ${round}`;
    articleEl.appendChild(pRound);

    const editBtn = document.createElement('button');
    editBtn.textContent = 'edit';
    editBtn.classList.add('btn', 'edit');

    const okBtn = document.createElement('button');
    okBtn.textContent = 'ok';
    okBtn.classList.add('btn', 'ok');

    liEl.appendChild(articleEl);
    liEl.appendChild(editBtn);
    liEl.appendChild(okBtn);
    sureListUl.appendChild(liEl);
    addBtn.setAttribute('disabled', 'disabled');

    editBtn.addEventListener('click', e => {
      liEl.remove();

      nameEl.value = name;
      scoreEl.value = score;
      roundEl.value = round;

      addBtn.removeAttribute('disabled');
    });

    okBtn.addEventListener('click', e => {
      liEl.remove();
      editBtn.remove();
      okBtn.remove();

      scoreboardListUl.appendChild(liEl);
    });

    clearBtn.addEventListener('click', e => {
      scoreboardListUl.innerHTML = '';
      addBtn.removeAttribute('disabled');
    });
  }

  function clear() {
    nameEl.value = '';
    scoreEl.value = '';
    roundEl.value = '';
  }
}
