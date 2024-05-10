function  printStars(count) {
    console.log("*".repeat(count))
}

printStars(10);

separator();

let printStartObject =  function printStars() {
    console.log("*".repeat(20))
};

var testMeHosting;
testMeHosting = "asd123"
console.log(testMeHosting + " " + typeof testMeHosting);

function separator() {
    console.log("---------------------------------")
}

let person = {
    firstName: "Test",
    lastName: "Tester",
    age: 25,
    documentNumbers: {id: 25, cardId: 53},
    functions: {printStartObject}
}

let keys = Object.keys(person);
let values = Object.values(person);

values.forEach(v => console.log(v))

separator();