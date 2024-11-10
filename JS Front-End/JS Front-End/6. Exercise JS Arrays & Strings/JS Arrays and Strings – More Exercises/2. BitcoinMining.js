function solve(input){

    const bitcoinPrice = 11949.16;
    const goldPrice = 67.51;

    let bitcoinCount = 0;
    let bitcoinDayIndex = 0;

    const currencyCount = input.reduce(function (earnings, dailyGold, i){
        const currentDay = i + 1;
        let bitcoinDayCount = 0;

        if (currentDay % 3 == 0) dailyGold -= dailyGold * 0.3;

        earnings += dailyGold * goldPrice;

        bitcoinDayCount = Math.floor(earnings / bitcoinPrice);

        if (bitcoinDayCount) {
            if (!bitcoinDayIndex) bitcoinDayIndex = currentDay;
            earnings -= (bitcoinDayCount * bitcoinPrice);
            bitcoinCount += bitcoinDayCount;
        }
        return earnings;
    }, 0);

    console.log(`Bought bitcoins: ${bitcoinCount}`);
    if ( bitcoinDayIndex ) console.log(`Day of the first purchased bitcoin: ${ bitcoinDayIndex }`);
    console.log(`Left money: ${currencyCount.toFixed(2)} lv.`);
}

solve([100, 200, 300]);