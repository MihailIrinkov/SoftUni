function init() {

    const baseUrl = 'http://localhost:3030/jsonstore/phonebook';

    const loadBtnEl = document.querySelector('#btnLoad');
    const phonebookUlEl = document.querySelector('#phonebook');
    const createBtnEl = document.querySelector('#btnCreate');
    const phoneEl = document.querySelector('#phone');
    const personEl = document.querySelector('#person');

    loadBtnEl.addEventListener('click', e => {
        
        fetch(baseUrl)
            .then(response => response.json())
            .then(contacts => {
                console.log(Object.values(contacts));
                phonebookUlEl.innerHTML = '';

                Object.values(contacts).forEach(c => {
                    const liEl = document.createElement('li');
                    liEl.textContent = `${c.person}: ${c.phone}`;
                    const deleteBtn = document.createElement('button');
                    deleteBtn.textContent = 'Delete';
                    deleteBtn.addEventListener('click', e => {

                        fetch(baseUrl + '/' + c._id, {
                            method: 'DELETE'
                        })
                            .then(response => response.json())
                            .then(c => {
                                liEl.remove();
                            })
                            .catch(error => console.error('Error: ', error));
                            console.log(Object.values(contacts));
                    });
                    liEl.append(deleteBtn);
                    phonebookUlEl.append(liEl);
                });

            })
            .catch(error => console.error('Error: ', error));
    });


    createBtnEl.addEventListener('click', e => {

        const contact = {
            person: personEl.value,
            phone: phoneEl.value
        };
        
        fetch(baseUrl , {
            method:'POST',
            body: JSON.stringify(contact)
        })
            .then(response => response.json())
            .then()
            .catch(error => console.error('Error: ', error));
            personEl.value = '';
            phoneEl.value = '';
            loadBtnEl.click();
    });

    // function dleteContact(baseUrl, btn, contact) {
    //     btn.addEventListener('click', e => {

    //         fetch(baseUrl + '/' + contact.id, {
    //             method: 'DELETE'
    //         }) 
    //         .then(response => response.json())
    //         .then(contact )
    //     });
    // }
}

document.addEventListener('DOMContentLoaded', init);