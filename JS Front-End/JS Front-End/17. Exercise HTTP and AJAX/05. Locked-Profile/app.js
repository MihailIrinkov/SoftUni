function lockedProfile() {
    const baseUrl = 'http://localhost:3030/jsonstore/advanced/profiles';

    const structuredProfileElement = document.querySelector('.profile');
    const mainContentElement = document.querySelector('#main');

    async function customFetch(url, options) {
        try {
            const data = await fetch(url, options).then((res) => {
                if (!res.ok) {
                    throw new Error(res.message);
                }
                return res.json()
            });
        } catch (error) {
            console.error(error);
            return { data: null, error};
        }
    }

    function showAdditionalData(profileElement, _id) {
        const {checked: isLocked} = profileElement.querySelector(`input[name="${_id}"]`);

        if (isLocked) {
            return;
        }


        const hiddenDataElement = profileElement.querySelector('.profile > div');
        const buttonElement = profileElement.querySelector('button');

        const isHidden = buttonElement.textContent === 'Show more';

        if (!isHidden) {
            profileElement.querySelector('.profile > div').style.display = 'none';
            profileElement.querySelector('button').textContent = 'Show more';
        } else {
            profileElement.querySelector('.profile > div').style.display = 'block';
            profileElement.querySelector('button').textContent = 'Hide it';
        }
    }

    function appendProfiles (profiles) {

        profiles.forEach(({username, email, age, _id}) => {
            const profileClone = structuredProfileElement.cloneNode(true);

            profileClone.querySelector("input[name='user1Username']").value = username;
            profileClone.querySelector("input[name='user1Email']").value = email;
            profileClone.querySelector("input[name='user1Age']").value = age.toString();

            const [lockRadioElement, unlockRadioElement] = profileClone.querySelector("input[name='user1Locked']");

            lockRadioElement.setAttribute("name", _id);
            unlockRadioElement.setAttribute("name", _id);

            profileClone.querySelector('.profile > div').style.display = 'none';

            mainContentElement.appendChild(profileClone);

            profileClone.querySelector('button')
            .addEventListener('click', () => showAdditionalData(profileClone, _id));
        });

        structuredProfileElement.remove();
    }

    async function getAllProfiles() {
        const { data, error } = await customFetch(baseUrl);

        if (error) {
            return;
        }

        appendProfiles(Object.values(data));
    }

    getAllProfiles();
}

// function lockedProfile() {

//     const baseUrl = 'http://localhost:3030/jsonstore/advanced/profiles';
//     const mailEl = document.querySelector('#main');

//     const initialEl = document.querySelector('.profile');
//     initialEl.remove();

//     function loadUsers() {
//         fetch(baseUrl)
//             .then(response => response.json())
//             .then(response => {
//                 Object.values(response).forEach(r => {
//                     createUserCard(r)
//                 })
//             })
//             .catch(error => console.error('Error: ', error));
//     }
//     loadUsers();

//     function createUserCard(person) {
//         const divProfileEl = document.createElement('div');
//         divProfileEl.classList.add('profile');
//         const imgEl = document.createElement('img');
//         imgEl.classList.add('userIcon');
//         imgEl.src = './iconProfile2.png';
//         divProfileEl.appendChild(imgEl);
//         const labelLockEl = document.createElement('label');
//         labelLockEl.textContent = 'Lock';
//         divProfileEl.appendChild(labelLockEl);
//         const inputBtnLockEl = document.createElement('input');
//         inputBtnLockEl.type = 'radio';
//         inputBtnLockEl.name = person._id;
//         inputBtnLockEl.value = 'lock';
//         inputBtnLockEl.checked = true;
//         divProfileEl.appendChild(inputBtnLockEl);

//         const labelUnlockEl = document.createElement('label');
//         labelUnlockEl.textContent = 'Unlock';
//         divProfileEl.appendChild(labelUnlockEl);
//         const inputBtnUnlockEl = document.createElement('input');
//         inputBtnUnlockEl.type = 'radio';
//         inputBtnUnlockEl.name = person._id;
//         inputBtnUnlockEl.value = 'unlock';
//         divProfileEl.appendChild(inputBtnUnlockEl);

//         const brEl = document.createElement('br');
//         divProfileEl.appendChild(brEl);
//         const hrEl = document.createElement('hr');
//         divProfileEl.appendChild(hrEl);
//         const labelUsernameEl = document.createElement('label');
//         labelUsernameEl.textContent = 'Username';
//         divProfileEl.appendChild(labelUsernameEl);
//         const inputUsernameEl = document.createElement('input');
//         inputUsernameEl.type = 'text';
//         inputUsernameEl.name = 'user1Username';
//         inputUsernameEl.value = person.username;
//         inputUsernameEl.disabled = true;
//         inputUsernameEl.readOnly = true;
//         divProfileEl.appendChild(inputUsernameEl);

//         const divHiddenEl = document.createElement('div');
//         divHiddenEl.id = 'user1HiddenFields';
//         const hrEl2 = document.createElement('hr');
//         divHiddenEl.appendChild(hrEl2);
//         divHiddenEl.style.display = 'none';
//         divProfileEl.appendChild(divHiddenEl);

//         const labelEmailEl = document.createElement('label');
//         labelEmailEl.textContent = 'Email:';
//         divHiddenEl.appendChild(labelEmailEl);
//         const inputEmailEl = document.createElement('input');
//         inputEmailEl.type = 'email';
//         inputEmailEl.name = 'user1Username';
//         inputEmailEl.value = person.email;
//         inputEmailEl.disabled = true;
//         inputEmailEl.readOnly = true;
//         divHiddenEl.appendChild(inputEmailEl);

//         const labelAgeEl = document.createElement('label');
//         labelAgeEl.textContent = 'Age:';
//         divHiddenEl.appendChild(labelAgeEl);
//         const inputAgelEl = document.createElement('input');
//         inputAgelEl.type = 'number';
//         inputAgelEl.name = 'user1Age';
//         inputAgelEl.value = person.age;
//         inputAgelEl.disabled = true;
//         inputAgelEl.readOnly = true;
//         divHiddenEl.appendChild(inputAgelEl);

//         const showContentBtn = document.createElement('button');
//         showContentBtn.textContent = 'Show more';
//         showContentBtn.addEventListener('click',
//             showContent(inputBtnUnlockEl, showContentBtn, divHiddenEl));
//         divProfileEl.appendChild(showContentBtn);

//         mailEl.appendChild(divProfileEl);

//         showContent(inputBtnUnlockEl, showContentBtn, divHiddenEl);
//         hideContent(inputBtnUnlockEl, showContentBtn, divHiddenEl);
//         console.log(inputBtnLockEl.checked);

//     }

//     function showContent(inputBtnUnlockEl, button, divHiddenEl) {

//         inputBtnUnlockEl.addEventListener('change', function () {
//             if (inputBtnUnlockEl.checked) {
//                 button.addEventListener('click', function (e) {
//                     divHiddenEl.style.display = 'block';
//                     button.textContent = 'Hide it';
//                 });

//             }
//         });
//     }

//     function hideContent(inputBtnUnlockEl, button, divHiddenEl) {
//         inputBtnUnlockEl.addEventListener('change', function () {
//             if (button.textContent === 'Hide it' && inputBtnUnlockEl.checked) {
//                 button.addEventListener('click', function (e) {
//                     button.textContent = 'Show more';
//                     divHiddenEl.style.display = 'none';
//                 });

//             } else {

//             }
//         });
//     }

// }
