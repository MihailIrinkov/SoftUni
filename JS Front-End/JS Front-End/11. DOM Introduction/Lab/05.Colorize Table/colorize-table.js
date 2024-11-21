function colorize() {
    
    const rows = document.querySelectorAll('table tbody tr');

    [...rows].forEach((el, i) => {
        if (i % 2 != 0) el.style.backgroundColor = 'teal';
    });

}