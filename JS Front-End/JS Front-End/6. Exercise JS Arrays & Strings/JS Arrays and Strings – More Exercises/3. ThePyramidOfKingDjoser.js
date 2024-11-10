function solve(base, increment) {

    const materials = [];

    materials['Stone'] = 0;
    materials['Marble'] = 0;
    materials['Lapis Lazuli'] = 0;
    materials['Gold'] = 0;

    const layers = Array.from({ length: Math.ceil(base / 2) }, function(_, i){ return base - i * 2 });
    const pyramidHeight = layers.reduce(function(height, layerSides, index){

        materials['Stone'] += ( layerSides * layerSides - (4 * layerSides - 4)) * increment;

        if ( index == 4 ) {
            materials['Lapis Lazuli'] += (4 * layerSides - 4) * increment;
        } else {
            materials['Marble'] += (4 * layerSides - 4) * increment;
        }

        return ++height;
    }, 0);

    if ( base % 2 == 0 ) {
        if ( base % 5 == 0 ) {
            materials['Gold'] = 4 * increment;
            materials['Lapis Lazuli'] -= materials['Gold'];
        } else {
            materials['Gold'] = 4 * increment;
            materials['Marble'] -= materials['Gold'];
        }
    } else {
        materials['Gold'] = 1 * increment;
        materials['Stone'] -= materials['Gold'];
    }

    Object.keys(materials).forEach(function(key, index){
        console.log(`${ key } required: ${ Math.ceil(materials[key]) }`);
    });

    console.log(`Final pyramid height: ${ Math.floor(pyramidHeight * increment) }`);
}

solve(11,1);


// function calculatePyramidMaterials(base, increment) {
//
//     let stones = 0, marble = 0, lapisLazuli = 0, gold = 0, layerCount = 1;
//
//     while (base > 2) {
//         base -= 2
//         stones += ((base) ** 2) * increment
//         if (layerCount % 5 == 0) {
//             lapisLazuli += ((base * 4) + 4) * increment
//         } else {
//             marble += ((base * 4) + 4) * increment
//         }
//         layerCount += 1
//     }
//
//     gold += (base ** 2) * increment
//
//     console.log(`Stone required: ${Math.ceil(stones)}`);
//     console.log(`Marble required: ${Math.ceil(marble)}`);
//     console.log(`Lapis Lazuli required: ${Math.ceil(lapisLazuli)}`);
//     console.log(`Gold required: ${Math.ceil(gold)}`);
//     console.log(`Final pyramid height: ${Math.floor(layerCount * increment)}`);
//
// }