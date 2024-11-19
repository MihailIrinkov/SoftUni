function solve(input) {

    const movies ={};

    input.forEach((line) => {
        if (line.includes('addMovie')) {

            const [_, name] = line.split('addMovie ');
            movies[name] = {name};
        } else if (line.includes('directedBy')) {

            const [name, director] = line.split(' directedBy ');
            if (!movies.hasOwnProperty(name)) movies[name] ={};
            movies[name].director = director;
        } else if (line.includes('onDate')) {
            const[name, date] = line.split(' onDate ');
            if (!movies.hasOwnProperty(name)) movies[name] = {};
            movies[name].date = date;
        }
    });

    for (const movie in movies) {
        if (Object.keys(movies[movie]).length > 2) console.log(JSON.stringify(movies[movie]));
    }
}

solve([
        'addMovie Fast and Furious',
        'addMovie Godfather',
        'Inception directedBy Christopher Nolan',
        'Godfather directedBy Francis Ford Coppola',
        'Godfather onDate 29.07.2018',
        'Fast and Furious onDate 30.07.2018',
        'Batman onDate 01.08.2018',
        'Fast and Furious directedBy Rob Cohen'
    ]
);
