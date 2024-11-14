function convertTpObject(input) {

    const object = JSON.parse(input);
    const entries = Object.entries(object);

    for (const [property, value] of entries) {
        console.log(`${property}: ${value}`);
    }
}

convertTpObject('{"name": "George", "age": 40, "town": "Sofia"}');