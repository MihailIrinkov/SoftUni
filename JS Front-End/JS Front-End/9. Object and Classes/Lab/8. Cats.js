function catCrater(arr) {

    class Cat {
        constructor(name, age) {
            this.name = name;
            this.age = age;
        }

        meow() {
            console.log((`${this.name}, age ${this.age} says Meow`));
        }
    }

    const cats = [];

    arr.forEach(entity => {
        const [name, age] = entity.split(' ');
        cats.push(new Cat(name, age));
    });

    for (const cat of cats) {
        cat.meow();
    }

}

catCrater(['Mellow 2', 'Tom 5']);