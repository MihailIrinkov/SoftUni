function convertToJSON(name, lastName, hairColor) {
    const object = {
        name,
        lastName,
        hairColor
    }
    console.log(JSON.stringify(object));
}

convertToJSON('George', 'Jones', 'Brown');