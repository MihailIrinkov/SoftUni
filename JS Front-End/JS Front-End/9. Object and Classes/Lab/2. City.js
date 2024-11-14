function processCity(city) {
    let keys = Object.keys(city);

    for (const key of keys) {
        console.log(`${key} -> ${city[key]}`);
    }
}

processCity({
        name: "Sofia",
        area: 492,
        population: 1238438,
        country: "Bulgaria",
        postCode: "1000"
    }
);