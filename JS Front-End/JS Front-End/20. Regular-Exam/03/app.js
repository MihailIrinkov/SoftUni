const baseUrl = `http://localhost:3030/jsonstore/workout/`;
const loadWorkoutBtnEl = document.querySelector('#load-workout');
const listEl = document.querySelector('#list');
// const containerEl = document.querySelector('#container');
const editWorkoutBtnEl = document.querySelector('#edit-workout');

loadWorkoutBtnEl.addEventListener('click', e => {
    getWorkouts();

});

async function getWorkouts() {
    listEl.innerHTML = '';
    const response = await fetch(baseUrl);
    const result = await response.json();
    const workaouts = Object.values(result);

    const workaoutElements =
    workaouts.map(w => createWorkout(w.workout, w.date, w.location));

    listEl.append(...workaoutElements);
    editWorkoutBtnEl.setAttribute('disabled', 'disabled');
}

function createWorkout(workout, date, location) {
    const divContainer = document.createElement('div');
    divContainer.classList.add('container');

    // const divList = document.createElement('div');
    // divList.classList.add('list');

    const hWorkout = document.createElement('h2');
    hWorkout.textContent = workout;
    divContainer.appendChild(hWorkout);

    const hDate = document.createElement('h3');
    hDate.textContent = date;
    divContainer.appendChild(hDate);

    const hLocation = document.createElement('h3');
    hLocation.textContent = location;
    hLocation.id = "location";
    divContainer.appendChild(hLocation);

    const buttonsContainer = document.createElement('div');
    buttonsContainer.classList.add('buttons-container');

    const changeBtn = document.createElement('button');
    changeBtn.classList.add('change-btn');
    changeBtn.textContent = 'Change';
    buttonsContainer.appendChild(changeBtn);

    const doneBtn = document.createElement('button');
    doneBtn.classList.add('delete-btn');
    doneBtn.textContent = "Done";
    buttonsContainer.appendChild(doneBtn);

    divContainer.appendChild(buttonsContainer);

    // divList.appendChild(divContainer);

    return divContainer;
}


{/* <div id="list">
                    <div class="container">
                        <h2>Tabata</h2>
                        <h3>2024-11-19</h3>
                        <h3 id="location">ul. "Dimitar Dospevski" 9, Sofia</h3>
                        <div id="buttons-container">
                            <button class="change-btn">Change</button>
                            <button class="delete-btn">Done</button>
                        </div>
                    </div>
                </div> */}