function adventure(input) {
    const numberOfMembers = Number(input.shift());
    let posse = {};

    for (let i = 0; i < numberOfMembers; i++) {
        const[name, hp, bullets] = input.shift().split(' ');

        posse[name] = {
            hp: Number(hp),
            bullets: Number(bullets)
        }
    }

    let command = input.shift();

    while (command != 'Ride Off Into Sunset') {

        let action = command.split(' - ');
        let heroName = action[1];
        switch (action[0]) {

            case 'FireShot':
                let target = action[2];
            if(posse[heroName].bullets >= 1) {
                posse[heroName].bullets -= 1;
                console.log(`${heroName} has successfully hit ${target} and now has ${posse[heroName].bullets} bullets!`); 
            } else {
                console.log(`${heroName} doesn't have enough bullets to shoot at ${target}!`)
            }
            break;

            case 'TakeHit':
                let attacker = action[3];
                let damage = Number(action[2]);
                posse[heroName].hp -= damage;
                if (posse[heroName].hp > 0) {
                    console.log(`${heroName} took a hit for ${damage} HP from ${attacker} and now has ${posse[heroName].hp} HP!`);
                } else {
                    delete(posse[heroName]);
                    console.log(`${heroName} was gunned down by ${attacker}!`);
                }
            break;

            case 'Reload':
                let bulletsCount = posse[heroName].bullets;
                if (bulletsCount < 6) {
                    posse[heroName].bullets = 6;
                    console.log(`${heroName} reloaded ${6 - bulletsCount} bullets!`);
                } else {
                    console.log(`${heroName}'s pistol is fully loaded!`);
                }
            break;

            case 'PatchUp':
                let currentHp = posse[heroName].hp;
                let amount = Number(action[2]);
                if ( currentHp == 100) {
                    console.log(`${heroName} is in full health!`);
                } else {
                    let patchUpHp = currentHp + amount;
                     if (patchUpHp > 100) {
                        console.log(`${heroName} patched up and recovered ${100 - currentHp} HP!`);
                        posse[heroName].hp = 100;
                     } else {
                        console.log(`${heroName} patched up and recovered ${amount} HP!`);
                        posse[heroName].hp += amount; 
                     }
                }
            break;
        }

        command = input.shift();
    }

    Object.keys(posse).forEach(el => {
        console.log(el);
        console.log(`HP: ${posse[el].hp}`);
        console.log(`Bullets: ${posse[el].bullets}`);
    })

}


// adventure(
//     (["2",
//     "Gus 100 0",
//     "Walt 100 6",
//     "FireShot - Gus - Bandit",
//     "TakeHit - Gus - 100 - Bandit",
//     "Reload - Walt",
//     "Ride Off Into Sunset"])
// );

adventure((["2",
    "Jesse 100 4",
    "Walt 100 5",
    "FireShot - Jesse - Bandit",
     "TakeHit - Walt - 30 - Bandit",
     "PatchUp - Walt - 20" ,
     "Reload - Jesse",
     "Ride Off Into Sunset"])
    );

    // adventure((["2",
    //     "Gus 100 4",
    //     "Walt 100 5",
    //     "FireShot - Gus - Bandit",
    //     "TakeHit - Walt - 100 - Bandit",
    //     "Reload - Gus",
    //     "Ride Off Into Sunset"])
    //  );
 