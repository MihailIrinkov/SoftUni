function solve(people, type, dayOfWeek) {

    const sFriday = 8.45;
    const sSaturday = 9.80;
    const sSunday = 10.46;

    const bFriday = 10.90;
    const bSaturday = 15.60;
    const bSunday = 16;

    const rFriday = 15;
    const rSaturday = 20;
    const rSunday = 22.50;

    let price;

    switch (dayOfWeek) {
        case 'Friday':
            switch (type) {
                case 'Students':
                    if (people >= 30) {
                        price = people * (sFriday * 0.85);
                    } else {
                        price = people * sFriday;
                    }
                    break;

                case 'Business':
                    if (people >= 100) {
                        price = (people - 10) * bFriday;
                    } else {
                        price = people * bFriday;
                    }
                    break;

                case 'Regular':
                    if (people >= 10 && people <= 20) {
                        price = people * (rFriday * 0.95);
                    } else {
                        price = people * rFriday;
                    }
                    break;
            }
            break;

        case 'Saturday':

            switch (type) {
                case 'Students':
                    if (people >= 30) {
                        price = people * (sSaturday * 0.85);
                    } else {
                        price = people * sSaturday;
                    }
                    break;

                case 'Business':
                    if (people >= 100) {
                        price = (people - 10) * bSaturday;
                    } else {
                        price = people * bSaturday;
                    }
                    break;

                case 'Regular':
                    if (people >= 10 && people <= 20) {
                        price = people * (rSaturday * 0.95);
                    } else {
                        price = people * rSaturday;
                    }
                    break;
            }
            break;

        case 'Sunday':
            switch (type) {
                case 'Students':
                    if (people >= 30) {
                        price = people * (sSunday * 0.85);
                    } else {
                        price = people * sSunday;
                    }
                    break;

                case 'Business':
                    if (people >= 100) {
                        price = (people - 10) * bSunday;
                    } else {
                        price = people * bSunday;
                    }
                    break;

                case 'Regular':
                    if (people >= 10 && people <= 20) {
                        price = people * (rSunday * 0.95);
                    } else {
                        price = people * rSunday;
                    }
                    break;
            }
            break;
    }

    console.log(`Total price: ${price.toFixed(2)}`);
}

solve(40,
    "Regular",
    "Saturday"
);