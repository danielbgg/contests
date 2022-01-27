//https://www.reddit.com/r/dailyprogrammer/comments/onfehl/20210719_challenge_399_easy_letter_value_sum/

const { load } = require('csv-load-sync');
const csv = load('./challenge-399-full.csv');
const dados = [];

const letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'];
const mapResults = new Map();

readFile();
callList();
//printMapResults();
printMapCountResults();

function readFile() {
    console.log("Reading CVS file...");
    csv.forEach(data => {
        dados.push(data);
    });
    console.log(`${dados.length} words imported!`);
}

function callList() {
    for (const data of dados) {
        log(data.WORD);
    }
}

function printMapResults() {
    console.log("********* RESULTS *********");
    var mapAsc = new Map([...mapResults.entries()].sort((e1, e2) => e1[0] - e2[0]));
    const it = mapAsc.keys();
    for (const itItem of it) {
        console.log(`${itItem} => ${mapAsc.get(itItem)}`);
    }
}

function printMapCountResults() {
    console.log("********* COUNT RESULTS *********");
    var mapAsc = new Map([...mapResults.entries()].sort((e1, e2) => e1[0] - e2[0]));
    const it = mapAsc.keys();
    for (const itItem of it) {
        console.log(`${itItem} => ${mapAsc.get(itItem).length}`);
    }
}

function log(phrase) {
    let value = lettersum(phrase);
    //console.log(`${phrase} => ${value}`);
    if (mapResults.get(value) === undefined) {
        mapResults.set(value, []);
    }
    mapResults.get(value).push(phrase);
}

function lettersum(phrase) {
    let sum = 0;
    for (const char of phrase) {
        sum += (letters.indexOf(char) + 1);
    }
    return sum;
}


