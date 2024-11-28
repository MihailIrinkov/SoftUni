document.addEventListener('DOMContentLoaded', solve);

function solve() {
    
    const formEl = document.querySelector('#solutionCheck');
    const outpuEl = document.querySelector('#check');

    let status = '';
    let size = 3;

    formEl.addEventListener('submit', e => {
        e.preventDefault();

        const rows = e.target.querySelectorAll('table tbody tr');

        rows.forEach(row => {
            const values = [...row.children].map(el => el.children[0].value);
            const duplicates = values.filter((item, index) => values.indexOf(item) !== index);

            if (duplicates.length > 0) {
                status += '0';
            } else {
                status += '1';
            }
        });

        status += 'x';

        for (let i = 1; i <= size; i++) {
            const colum = [...e.target.querySelectorAll(`table tbody tr td:nth-child(${i})`)]
                    .map(el => el.children[0].value);
            const duplicates = colum.filter((item, index) => colum.indexOf(item) !== index);

            if (duplicates.length > 0) {
                status += '0';
            } else {
                status += '1';
            }
        }

        if (status === '111x111') {
            outpuEl.classList.remove('fail');
            outpuEl.classList.add('success');
            outpuEl.textContent = 'Success!';
        } else {
            outpuEl.classList.add('fail');
            outpuEl.classList.remove('success');
            outpuEl.textContent = 'Keep trying ...';
        }

    });


    // const inputs = document.querySelectorAll('table input');

    // inputs[0].value = 1;
    // inputs[1].value = 2;
    // inputs[2].value = 3;
    // inputs[3].value = 2;
    // inputs[4].value = 3;
    // inputs[5].value = 1;
    // inputs[6].value = 3;
    // inputs[7].value = 1;
    // inputs[8].value = 2;
}