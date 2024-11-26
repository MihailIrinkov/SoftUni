document.addEventListener('DOMContentLoaded', solve);

function solve() {
    
    const emailEl = document.querySelector('#email');
    const pattern = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;

    emailEl.addEventListener('change', e =>{

        if (!pattern.test(e.currentTarget.value)) {
            return e.currentTarget.classList.add('error');
        }

        e.currentTarget.classList.remove('error');
    });
}
