function solution() {
    const baseURL = 'http://localhost:3030/jsonstore/advanced/articles/list';
    const contentURL = 'http://localhost:3030/jsonstore/advanced/articles/details/';

    const sectionEl = document.querySelector('#main');

    function getData() {
        fetch(baseURL)
            .then(response => response.json())
            .then(response => {
                Object.values(response).forEach(item => {

                    const title = item.title;
                    const id = item._id;

                    createSection(title, id);
                });

            })
            .catch(error => console.error('Error: ', error));
    }

    getData();

    function createSection(title, id) {
        const divAccordion = document.createElement('div');
        divAccordion.classList.add('accordion');

        const divHead = document.createElement('div');
        divHead.classList.add('head');

        const spanEl = document.createElement('span');
        spanEl.textContent = title;
        divHead.appendChild(spanEl);

        const buttonEl = document.createElement('button');
        buttonEl.classList.add('button');
        buttonEl.id = id;
        buttonEl.textContent = 'MORE';

        divHead.appendChild(buttonEl);

        sectionEl.appendChild(divAccordion);

        divExtra = document.createElement('div');
        divExtra.classList.add('extra');
        divExtra.setAttribute('id', id);
        divExtra.style.display = 'none';

        const pElement = document.createElement('p');
        pElement.setAttribute('id', id);
        divExtra.appendChild(pElement);

        divAccordion.appendChild(divHead);
        divAccordion.appendChild(divExtra);

        buttonEl.addEventListener('click', e => {
            if (buttonEl.textContent === 'LESS') {
                buttonEl.textContent = 'MORE';
                divEl = document.querySelector(`div#${CSS.escape(id)}`);
                divEl.style.display = 'none';

            } else if (buttonEl.textContent === 'MORE') {
                buttonEl.textContent = 'LESS';
                getDescription(id);
            }
        });
    }


    function getDescription(id) {

        fetch(contentURL + id)
            .then(response => response.json())
            .then(response => {
                pEl = document.querySelector(`p#${CSS.escape(id)}`);
                pEl.textContent = response.content;
                divEl = document.querySelector(`div#${CSS.escape(id)}`);

                let buttonEl = document.querySelector(`#${CSS.escape(id)}`);
                //  const divEl = buttonEl.parentElement.querySelector('.extra');
                //  divEl.style.display = (buttonEl.textContent === 'LESS') ? 'block' : 'none';

                divEl.style.display = 'block';

            })
            .catch(error => console.error('Error: ', error));

    }

}


document.addEventListener('DOMContentLoaded', solution);