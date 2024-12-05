window.addEventListener("load", solve);

function solve() {
    const typeEl = document.querySelector('#type');
    const ageEl = document.querySelector('#age');
    const genderEl = document.querySelector('#gender');

    const adoptionInfoEl = document.querySelector('#adoption-info');
    const adoptButtonEl = document.querySelector('#adopt-btn');
    const ulAdoptedListEl = document.querySelector('#adopted-list');

    adoptButtonEl.addEventListener('click', (e) => {
      e.preventDefault();
      if (typeEl.value === '' || ageEl.value === '' || genderEl.value === '') return;
        createPet(typeEl.value, ageEl.value, genderEl.value);
      clear();
    });

    function createPet(type, age, gender) {

      const articleEl = document.createElement('article');
      const liEl = document.createElement('li');

      const pTypeEl = document.createElement('p');
      pTypeEl.textContent = `Pet:${type}`;
      articleEl.appendChild(pTypeEl);

      const pGenderEl = document.createElement('p');
      pGenderEl.textContent = `Gender:${gender}`;
      articleEl.appendChild(pGenderEl);

      const pAgeEl = document.createElement('p');
      pAgeEl.textContent = `Age:${age}`;
      articleEl.appendChild(pAgeEl);

      const divEl = document.createElement('div');
      divEl.classList.add('buttons');

      const editBtnEl = document.createElement('button');
      editBtnEl.classList.add('edit-btn');
      editBtnEl.textContent = 'Edit';
      divEl.appendChild(editBtnEl);

      const doneBtnEl = document.createElement('button');
      doneBtnEl.classList.add('done-btn');
      doneBtnEl.textContent = 'Done'; 
      divEl.appendChild(doneBtnEl);

      articleEl.appendChild(divEl);
      liEl.appendChild(articleEl);
      adoptionInfoEl.appendChild(liEl);

      editBtnEl.addEventListener('click', () => {
        typeEl.value = type;
        ageEl.value = age;
        genderEl.value = gender;
        liEl.remove();
      });

      const clearBtn = document.createElement('button');

      doneBtnEl.addEventListener('click', e => {
        clearBtn.classList.add('clear-btn');
        clearBtn.textContent = 'Clear';

        divEl.remove();
        liEl.appendChild(clearBtn);
        ulAdoptedListEl.appendChild(liEl);
        adoptionInfoEl.remove(liEl);

      });

      clearBtn.addEventListener('click', e => {
        ulAdoptedListEl.remove(liEl);
      });
      
    }

    function clear() {
      typeEl.value = '';
      ageEl.value = '';
      genderEl.value = '';
    }
  }
  