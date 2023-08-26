let n;
let array = [];
const localStorageKey = "k12019Array"

const onLoad = () => {
    try {
        n = parseInt(prompt("Unesite broj:"));
        if (n) {
            const list = document.getElementById("aList");
            for (let i = 0; i < n; i++) {
                const li = document.createElement("li");
                li.appendChild(document.createTextNode("red " + (i + 1)));
                list.appendChild(li);
            }
            if (localStorage.getItem(localStorageKey))
                array = JSON.parse(localStorage.getItem(localStorageKey));
            setInterval(() => {
                document.getElementById("dateTime").innerHTML = new Date().toUTCString();
            }, 1000);
            loadE();
            setTimeout(() => {
                document.getElementById("f").style.backgroundColor = "blue";
            }, 10000);
        } else {
            location.href = "https://www.etf.unibl.org";
        }
    } catch (err) {
        console.log(err);
        //location.href = "https://www.etf.unibl.org";
    }
};

const save = () => {
    const form = document.getElementById("form");
    const elem = {
        name: form["name"].value,
        grade: form["grade"].value
    };
    array.push(elem);
    localStorage.setItem(localStorageKey, JSON.stringify(array));
    loadE();
};

const loadE = () => {
    document.getElementById("noElements").innerHTML = array.length;
    const pStats = document.getElementById("stats");
    let sum = 0;
    for (item of array) 
        sum += parseInt(item.grade);
    pStats.innerHTML = "Prosječna ocjena je: " + (sum / array.length);
    pStats.innerHTML += ", a imena sa najvećom ocjenom su: ";
    const arrTemp = array;
    const first = arrTemp.sort((i1, i2) => i2.grade - i1.grade).find(() => true);
    if (first) {
        const maxGrade = first.grade;
        for (item of array) 
            if (item.grade === maxGrade)
                pStats.innerHTML += item.name + " ";
    }
};