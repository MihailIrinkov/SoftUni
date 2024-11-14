function processMeetings(input) {

    const calender = {};

    input.forEach(entry => {
        const [day, name] = entry.split(' ');

        if (calender.hasOwnProperty(day)) {
            console.log(`Conflict on ${day}!`);
        } else {
            calender[day] = name;
            console.log(`Scheduled for ${day}`);
        }
    });

    for (const key in calender) {
        console.log(`${key} -> ${calender[key]}`);
    }
}

processMeetings(['Monday Peter',
    'Wednesday Bill',
    'Monday Tim',
    'Friday Tim']
);