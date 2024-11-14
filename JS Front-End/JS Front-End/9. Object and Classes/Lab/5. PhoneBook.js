function phoneBook(input) {
    const object = {};

    input.forEach(entry => {
        const [name, phone] = entry.split(' ');
        object[name] = phone;
    });

    for (const key in object) {
        console.log(`${key} -> ${object[key]}`)
    }
}

phoneBook(['Tim 0834212554',
    'Peter 0877547887',
    'Bill 0896543112',
    'Tim 0876566344']
);