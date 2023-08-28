const KEY = "ETF";
let user = {};
let data = [];
let sorted = false;

function initFirst() {
    let storage = localStorage.getItem(KEY);
    if (storage) {
        data = JSON.parse(storage);
        initList();
    }
}

function initList() {
    let list = document.getElementById('list1');
    list.innerHTML = "";
    let filtered = data.filter((item) => item.name === document.forms[0].elements[0].value);
    for (let element of filtered) {
        let li = document.createElement('li');
        li.innerHTML = `${element.name} ${element.start} ${element.end} ${element.date}`;
        list.appendChild(li);
    }
}

function discard() {
    document.forms[0].reset();
}

function saveData() {
    let form = document.forms[0];
    if (form) {
        let elements = form.elements;

        let obj = {
            name: elements[0].value,
            start: elements[1].value,
            end: elements[2].value,
            date: elements[3].value
        }
        if (data.filter((e) => e.name === obj.name && e.start === obj.start && e.end === obj.end && e.date === obj.date).length == 0) {
            data.push(obj);
            localStorage.setItem(KEY, JSON.stringify(data));
        }
        initList();
    }
}

function initSecond() {
    let storage = localStorage.getItem(KEY);
    if (storage) {
        data = JSON.parse(storage);
        if (!sorted)
            data = data.sort((a, b) => b.date.localeCompare(a.date)); // sortirano opadajuce
    }
    let table = document.getElementById('tableContent');
    table.innerHTML = "";
    for (let [index, element] of data.entries()) {
        let tr = document.createElement('tr');
        let nameCell = document.createElement('td');
        nameCell.innerHTML = element.name;
        let startCell = document.createElement('td');
        startCell.innerHTML = element.start;
        let endCell = document.createElement('td');
        endCell.innerHTML = element.end;
        let dateCell = document.createElement('td');
        dateCell.innerHTML = element.date;
        let actionsCell = document.createElement('td');
        let acceptButton = document.createElement('button');
        acceptButton.innerHTML = 'Prihvati';
        acceptButton.id = index;
        acceptButton.onclick = function() {
            accept(acceptButton);
        };
        let declineButton = document.createElement('button');
        declineButton.innerHTML = 'Odbij';
        declineButton.id = index;
        declineButton.onclick = function() {
            decline(declineButton);
        };
        actionsCell.appendChild(acceptButton);
        actionsCell.appendChild(declineButton);
        tr.appendChild(nameCell);
        tr.appendChild(startCell);
        tr.appendChild(endCell);
        tr.appendChild(dateCell);
        tr.appendChild(actionsCell);
        table.appendChild(tr);
    }
}

function accept(button) {
    alert('Accepted');
}

function decline(button) {
    let id = button.id;
    data.splice(id, 1);
    localStorage.setItem(KEY, JSON.stringify(data));
    initSecond();
}

function sort() {
    data = data.sort((a, b) => a.name.localeCompare(b.name));
    localStorage.setItem(KEY, JSON.stringify(data));
    sorted = true;
    initSecond();
}