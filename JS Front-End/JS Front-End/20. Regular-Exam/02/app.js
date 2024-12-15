window.addEventListener("load", solve);

function solve() {
  const emailEl = document.querySelector('#email');
  const eventEl = document.querySelector('#event');
  const locationEl = document.querySelector('#location');

  const previewListUl = document.querySelector('#preview-list');
  const nextBtnEl = document.querySelector('#next-btn');
  const eventListUl = document.querySelector('#event-list');

  nextBtnEl.addEventListener('click', e => {
    e.preventDefault();

    if (!emailEl.value || !eventEl.value || !locationEl.value) return;

    register(emailEl.value, eventEl.value, locationEl.value);

    nextBtnEl.setAttribute('disabled', 'disabled');
    clear();
  });

  function register(email, event, location) {
    const liEl = document.createElement('li');
    liEl.classList.add('application');

    const articleEl = document.createElement('article');

    const hEmail = document.createElement('h4');
    hEmail.textContent = email;
    articleEl.appendChild(hEmail);

    const strong = document.createElement('strong');
    const br = document.createElement('br');
    let pEvent = document.createElement('p');
    let strongEvent = document.createElement('strong');
    strongEvent.textContent = 'Event:';
    pEvent.appendChild(strongEvent);
    pEvent.appendChild(document.createElement('br'));
    pEvent.appendChild(document.createTextNode(event));
    articleEl.appendChild(pEvent);

    const pLocation = document.createElement('p');
    const strongLoc = document.createElement('strong');
    strongLoc.textContent = 'Location:';
    pLocation.appendChild(strongLoc);
    pLocation.appendChild(document.createElement('br'));
    pLocation.appendChild(document.createTextNode(location));
    articleEl.appendChild(pLocation);

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

    editBtn.addEventListener('click', e => {
      liEl.remove();

      emailEl.value = email;
      eventEl.value = event;
      locationEl.value = location;
      nextBtnEl.removeAttribute('disabled');
    });

    applyBtn.addEventListener('click', e => {
      liEl.remove();

      editBtn.remove();
      applyBtn.remove();

      eventListUl.appendChild(liEl);
      nextBtnEl.removeAttribute('disabled');
    });

  }

  function clear() {
    emailEl.value = '';
    eventEl.value = '';
    locationEl.value = '';
  }
}
