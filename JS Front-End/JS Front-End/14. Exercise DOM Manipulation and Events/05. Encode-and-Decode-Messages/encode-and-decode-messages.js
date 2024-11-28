document.addEventListener('DOMContentLoaded', solve);

function solve() {
    
    document.querySelector('#encode').addEventListener('submit', e => {
        e.preventDefault();

        const inputEl = e.target.querySelector('textarea');
        const message = inputEl.value;
        const encodeMessage = message.split('')
            .map(ch => String.fromCharCode(ch.charCodeAt() + 1)).join('');

        document.querySelector('#decode textarea').value = encodeMessage;
        inputEl.value = '';    
    });

    document.querySelector('#decode').addEventListener('submit', e => {
        e.preventDefault();

        const outputEl = e.target.querySelector('textarea');
        const message = outputEl.value;

        const decodeMessage = message.split('')
            .map(ch => String.fromCharCode(ch.charCodeAt() - 1)).join('');

        outputEl.value = decodeMessage;    
    });
}