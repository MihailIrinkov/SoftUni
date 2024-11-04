function solve(speed, area) {

    function speedLimitCheck(speed, speedLimit) {
        if ((speedLimit - speed) >= 0) {
            console.log(`Driving ${speed} km/h in a ${speedLimit} zone`)
        } else if ((speed - speedLimit) <= 20) {
            console.log(`The speed is ${speed - speedLimit} km/h faster than the allowed speed of ${speedLimit} - speeding`);
        } else if ((speed - speedLimit) <= 40) {
            console.log(`The speed is ${speed - speedLimit} km/h faster than the allowed speed of ${speedLimit} - excessive speeding`);
        } else {
            console.log(`The speed is ${speed - speedLimit} km/h faster than the allowed speed of ${speedLimit} - reckless driving`);
        }
    }

    switch (area) {
        case 'motorway':
            speedLimitCheck(speed, 130);
            break;
        case 'interstate':
            speedLimitCheck(speed, 90);
            break;
        case 'city':
            speedLimitCheck(speed, 50);
            break;
        case 'residential':
            speedLimitCheck(speed, 20);
    }
}

solve(200, 'motorway');