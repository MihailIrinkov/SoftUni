function solve() {
    
    const outputEl = document.querySelector('#output');

    const tHeadRowCells = document.querySelector('table thead tr');
    const tBodyRows = document.querySelectorAll('table tbody tr');

    const checkedInputElements = [...tHeadRowCells.children]
        .map((th, i) => ({ el: th.children[0], name: th.children[0].getAttribute('name'), index: i}))
        .filter(object => object.el.checked);

    const outPutData = [... tBodyRows]
        .map(row => {
            return checkedInputElements.reduce((acc, input) => {
                acc[input.name] = row.children[input.index].textContent;
                return acc;
            }, {});
        });

        outputEl.value = JSON.stringify(outPutData);
}