async function lockedProfile() {
    try {
        let response = await fetch('http://localhost:3030/jsonstore/advanced/profiles');

        if (!response) {
            throw new Error('Faild to fetch profiles');
        }

        let data = await response.json();

        Object.entries(data).forEach(([key, profile], index) => {
            const profileCard = createProfileCard(profile, index + 1);
            document.getElementById('main').appendChild(profileCard);
        });
    } catch (error) {
        console.error('Error: ', error);
    }
}

function createProfileCard(profile, index) {

    const cardElement = document.createElement('div');
    cardElement.classList.add('profile');

    const img = document.createElement('img');
    img.src = './iconProfile2.png';
    img.classList.add('userIcon');
    cardElement.appendChild(img);

    cardElement.appendChild(createLabel('Lock'));
    cardElement.appendChild(createRadioButton(`user${index}Locked`, 'lock', true));

    cardElement.appendChild(createLabel('Unlock'));
    cardElement.appendChild(createRadioButton(`user${index}Locked`, 'unlock', false));

    cardElement.appendChild(document.createElement('br'));
    cardElement.appendChild(document.createElement('hr'));

    cardElement.appendChild(createLabel('Username'));
    cardElement.appendChild(createInput('text', `user${index}Username`, profile.username));

    const hiddenFields = document.createElement('div');
    hiddenFields.id = `user${index}HiddenFields`;
    hiddenFields.classList.add('hiddenInfo');
    
    hiddenFields.appendChild(document.createElement('hr'));
    hiddenFields.appendChild(createLabel('Email:'));
    hiddenFields.appendChild(createInput('email', `user${index}Email`, profile.email));

    hiddenFields.appendChild(createLabel('Age:'));
    hiddenFields.appendChild(createInput('number', `user${index}Age`, profile.age));

    cardElement.appendChild(hiddenFields);

    const button = document.createElement('button');
    button.textContent = 'Show more';
    button.addEventListener('click', showMoreOnClick);
    cardElement.appendChild(button);

    return cardElement;
}

function createLabel(text) {
    const label = document.createElement('label');
    label.textContent = text;

    return label;
}

function createRadioButton(name, value, checked) {

    const radio = document.createElement('input');
    radio.type = 'radio';
    radio.name = name;
    radio.value = value;
    if (checked) {
        radio.checked = true;
    }

    return radio;
}

function createInput(type, name, value) {

    const input = document.createElement('input');
    input.type = type;
    input.name = name;
    input.value = value;
    input.disabled = true;
    input.readOnly = true;

    return input;
}

function showMoreOnClick(e) {

    let profile = e.currentTarget.parentNode;
    let isLocked = profile.querySelector('input[value="lock"]').checked;
    let hiddenInformationElement = profile.querySelector('div.hiddenInfo');

    if (!isLocked) {
        hiddenInformationElement.classList.toggle('hiddenInfo');

        e.currentTarget.textContent = e.currentTarget.textContent === 'Show more' ? 'Hide it' : 'Show more';
    }
}