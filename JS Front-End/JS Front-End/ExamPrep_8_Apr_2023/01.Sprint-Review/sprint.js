function sprint(inputData) {
    let n = Number(inputData.length) - 1;
    const assigneeNumber = Number(inputData.shift());
    let assignee = {};
    for (let i = 0; i < assigneeNumber; i++) {

        const [name, taskId, title, status, points] = inputData.shift().split(':');
        // const task = {taskId, title, status, points: Number(points)};

        if (!assignee.hasOwnProperty(name)) {
            assignee[name] = [];
        }
        assignee[name].push({taskId, title, status, points: Number(points)});
    }

    n -= assigneeNumber;

    for (let i = 0; i < n; i++) {
        const [action, name, taskId, arg2, arg3, arg4] = inputData.shift().split(':');

        switch (action) {
            case 'Add New':
                if (!assignee.hasOwnProperty(name)) {
                    console.log(`Assignee ${name} does not exist on the board!`);
                } else {
                    assignee[name].push({taskId: taskId, title: arg2, status: arg3, points: Number(arg4)});
                }
                break;
            case 'Change Status':
                if (!assignee.hasOwnProperty(name)) {
                    console.log(`Assignee ${name} does not exist on the board!`);
                } else if (!assignee[name].taskId === taskId) {
                    console.log(`Task with ID ${taskId} does not exist for ${name}!`);
                } else {
                    const task =  assignee[name].find((t) => t.taskId === taskId);
                    task.status = arg2;
                }
                break;
            case 'Remove Task':
                if (!assignee.hasOwnProperty(name)) {
                    console.log(`Assignee ${name} does not exist on the board!`);
                } else if (assignee[name].length <= taskId || taskId < 0) {
                    console.log('Index is out of range!');
                } else {
                    assignee[name].splice(Number(taskId), 1);
                }
                break;
        }
    }

    let toDo = getTotalPointsPerStatus('ToDo');
    let inProgress = 0;
    let codeReview = 0;
    let donePoints = 0;

    function getTotalPointsPerStatus(status) {
        return Object.values(assignee)
            .reduce((totalPoints, tasks) => {
                return totalPoints + tasks
                    .filter((t) => t.status === status)
                    .map((t) => t.points)
                    .reduce((a, b) => a + b, 0);
            }, 0);
    }

    console.log(`ToDo: ${getTotalPointsPerStatus('ToDo')}pts`);
    console.log(`In Progress: ${getTotalPointsPerStatus('In Progress')}pts`);
    console.log(`Code Review: ${getTotalPointsPerStatus('Code Review')}pts`);
    console.log(`Done Points: ${getTotalPointsPerStatus('Done')}pts`);

    if (getTotalPointsPerStatus('Done') >= (
        getTotalPointsPerStatus('ToDo') +
        getTotalPointsPerStatus('In Progress') +
        getTotalPointsPerStatus('Code Review')
    )) {

        console.log('Sprint was successful!');
    } else {
        console.log('Sprint was unsuccessful...');
    }

}

// sprint(['4',
//     'Kiril:BOP-1213:Fix Typo:Done:1',
// 'Peter:BOP-1214:New Products Page:In Progress:2',
// 'Mariya:BOP-1215:Setup Routing:ToDo:8',
// 'Georgi:BOP-1216:Add Business Card:Code Review:3',
// 'Add New:Sam:BOP-1237:Testing Home Page:Done:3',
// 'Change Status:Georgi:BOP-1216:Done',
// 'Change Status:Will:BOP-1212:In Progress',
// 'Remove Task:Georgi:3',
// 'Change Status:Mariya:BOP-1215:Done']);

sprint([
    '5',
    'Kiril:BOP-1209:Fix Minor Bug:ToDo:3',
    'Mariya:BOP-1210:Fix Major Bug:In Progress:3',
    'Peter:BOP-1211:POC:Code Review:5',
    'Georgi:BOP-1212:Investigation Task:Done:2',
    'Mariya:BOP-1213:New Account Page:In Progress:13',
    'Add New:Kiril:BOP-1217:Add Info Page:In Progress:5',
    'Change Status:Peter:BOP-1290:ToDo',
    'Remove Task:Mariya:1',
    'Remove Task:Joro:1',
]);

// sprint([
//     '4',
//     'Kiril:BOP-1213:Fix Typo:Done:1',
//     'Peter:BOP-1214:New Products Page:In Progress:2',
//     'Mariya:BOP-1215:Setup Routing:ToDo:8',
//     'Georgi:BOP-1216:Add Business Card:Code Review:3',
//     'Add New:Sam:BOP-1237:Testing Home Page:Done:3',
//     'Change Status:Georgi:BOP-1216:Done',
//     'Change Status:Will:BOP-1212:In Progress',
//     'Remove Task:Georgi:3',
//     'Change Status:Mariya:BOP-1215:Done',
// ]);