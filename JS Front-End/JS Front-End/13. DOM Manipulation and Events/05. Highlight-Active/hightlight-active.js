document.addEventListener('DOMContentLoaded', solve);

function solve() {
    
    function sectionFocusedEventHandler(event) {
        event.currentTarget.parentElement.classList.add('focused');
    }

    function sectionBluredEventHandler(event) {
        event.currentTarget.parentElement.classList.remove('focused');
    }

    const inputFields = document.querySelectorAll('input[type="text"]');

    [...inputFields].forEach(el => {
        el.addEventListener('focus', sectionFocusedEventHandler);
        el.addEventListener('blur', sectionBluredEventHandler);
    });
}