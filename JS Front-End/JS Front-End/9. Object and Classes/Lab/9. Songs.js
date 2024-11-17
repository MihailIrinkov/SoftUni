function songs(arr) {

    class Song {
        constructor(typeList, name, time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }
    }

    const songs = [];
    const printData = [];

    let numberOfSongs = arr.shift();
    let typeOfSongs = arr.pop();

    arr.forEach(entity => {
        // const [numberOfSongs, songData, typeList] = entity.split(', ');
        const [typeList, name, time] = entity.split('_');
        songs.push(new Song(typeList, name, time));

    });

    for (const song of songs) {
        if (typeOfSongs === 'all') {
            printData.push(song);
        } else if (song.typeList === typeOfSongs) {
            printData.push(song);
        }
    }

    printData.forEach(song => {
        console.log(song.name);
    })
}

songs([3,
    'favourite_DownTown_3:14',
    'favourite_Kiss_4:16',
    'favourite_Smooth Criminal_4:01',
    'favourite']
);

songs([2,
    'like_Replay_3:15',
    'ban_Photoshop_3:48',
    'all']
);