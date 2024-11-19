function solve(input) {

    const heroes = [];

    input.forEach(line => {
        let [name, level, item] = line.split(' / ');

        let hero = {
            name: name,
            level: Number(level),
            item: item
        };

        heroes.push(hero);
    });

    heroes
        .sort((a, b) => a.level - b.level)
        .forEach(hero => {
            console.log(`Hero: ${hero.name}`);
            console.log(`level => ${hero.level}`);
            console.log(`items => ${hero.item}`);
        });
}

solve([
        'Isacc / 25 / Apple, GravityGun',
        'Derek / 12 / BarrelVest, DestructionSword',
        'Hes / 1 / Desolator, Sentinel, Antara'
    ]
);