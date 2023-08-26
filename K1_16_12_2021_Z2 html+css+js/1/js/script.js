const sessionStorageKey = "K1_2022_Z02";
let array = [];

const onLoad = () => {
    array = JSON.parse(sessionStorage.getItem(sessionStorageKey));
    if (!array)
        array = [];
    loadTable();
};

const sortByFirstName = () => {
    array = array.sort((i1, i2) => {
        if (i1.firstName < i2.firstName)
            return 1;
        else 
            return -1;
    });
    loadTable();
};

const sortByLastName = () => {
    array.sort((i1, i2) => i1.lastName.localeCompare(i2.lastName));
    loadTable();
}

const tab1 = () => {
    document.getElementById("tab1").style.display = "block";
    document.getElementById("tab2").style.display = "none";
};

const tab2 = () => {
    document.getElementById("tab1").style.display = "none";
    document.getElementById("tab2").style.display = "block";
};

const deleteAll = () => {
    const result = confirm("Da li ste sigurni?");
    if (result) {
        sessionStorage.setItem(sessionStorageKey, JSON.stringify([]));
        array = [];
        loadTable();
    }
};

const save = () => {
    const form = document.getElementById("form");
    const s = {
        firstName: form["firstName"].value,
        lastName: form["lastName"].value,
        index: form["index"].value,
        year: form["year"].value,
        program: form["program"].value,
        status: form["status"].value,
        note: form["note"].value
    };
    form.reset();
    array.push(s);
    sessionStorage.setItem(sessionStorageKey, JSON.stringify(array));
    loadTable();
};

const loadTable = () => {
    const table = document.getElementById("tableContent");
    table.innerHTML = "";
    let i = 0;
    for (item of array) {
        const row = table.insertRow(i++);
        row.insertCell(0).innerHTML = item.firstName;
        row.insertCell(1).innerHTML = item.lastName;
        row.insertCell(2).innerHTML = item.index;
        row.insertCell(3).innerHTML = item.year;
        row.insertCell(4).innerHTML = item.program;
        row.insertCell(5).innerHTML = item.status;
        row.insertCell(6).innerHTML = item.note;
    }
    if (array.length < 5) {
        for  (let i = array.length; i < 5; i++) {
            const row = table.insertRow(i);
            row.insertCell(0).innerHTML = "x";
            row.insertCell(1).innerHTML = "x";
            row.insertCell(2).innerHTML = "x";
            row.insertCell(3).innerHTML = "x";
            row.insertCell(4).innerHTML = "x";
            row.insertCell(5).innerHTML = "x";
            row.insertCell(6).innerHTML = "x";
        }
    }
}