function addressBook(input) {

    const addressBook = {};

    input.forEach(entry => {
        const [name, place] = entry.split(':');
        addressBook[name] = place;
    });

    const addressBookSortable = Object.entries(addressBook);
    addressBookSortable.sort(([keyA], [keyB]) =>{
        return keyA.localeCompare(keyB);
    });

    for (const [name, place] of addressBookSortable) {
        console.log(`${name} -> ${place}`);
    }
}

addressBook(['Tim:Doe Crossing',
    'Bill:Nelson Place',
    'Peter:Carlyle Ave',
    'Bill:Ornery Rd']
);

// function addressBook(input) {
//
//     const entries = Object.entries(input);
//
//     // entries.sort((a, b) => {
//     //     return a[0].localeCompare(b[0]);
//     // });
//
//     entries.sort(([keyA], [keyB]) => {
//         return keyA.localeCompare(keyB);
//     });
//
//     console.log(entries);
// }

// addressBook({'Tim': '0876566344',
//     'Bill': '0896543112'}
// );