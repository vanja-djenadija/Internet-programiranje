let number = 0;
let data = [];
const storageKey = "KEY";

function changeCardColor() {
  let cards = document.querySelectorAll(".card");
  if (number % 3 == 0) {
    cards.forEach((card) => {
      card.style.backgroundColor = "DodgerBlue";
    });
  } else if (number % 3 == 1) {
    cards.forEach((card) => {
      card.style.backgroundColor = "Tomato";
    });
  } else if (number % 3 == 2) {
    cards.forEach((card) => {
      card.style.backgroundColor = "PaleGreen";
    });
  }

  number++;
}

function init() {
  let studentsTable = document.getElementById("table-body");
  for (let i = 0; i < 5; i++) {
    let row = document.createElement("tr");
    for (let j = 0; j < 3; j++) {
      let td = document.createElement("td");
      td.textContent = "X" + i + "" + j;
      row.appendChild(td);
    }
    studentsTable.appendChild(row);
  }

  loadData();
  refreshRequestsTable();
}

function refreshRequestsTable() {
  let requestsTable = document.getElementById("requests-content");
  requestsTable.innerHTML = "";
  for (const element of data) {
    let row = document.createElement("tr");
    let tdName = document.createElement("td");
    let tdBirth = document.createElement("td");
    let tdDesc = document.createElement("td");
    let tdPriority = document.createElement("td");
    tdName.textContent = element.name;
    tdBirth.textContent = element.birth;
    tdDesc.textContent = element.description;
    tdPriority.textContent = element.priority;
    row.appendChild(tdName);
    row.appendChild(tdBirth);
    row.appendChild(tdDesc);
    row.appendChild(tdPriority);
    requestsTable.appendChild(row);
  }
}

function loadData() {
  let item = localStorage.getItem(storageKey);
  if (item) {
    data = JSON.parse(item);
  }
}

function saveData() {
  let form = document.getElementById("form");
  let obj = {
    name: form["name"].value,
    birth: form["birth"].value,
    description: form["description"].value,
    priority: form["priority"].value,
  };

  data.push(obj);
  localStorage.setItem(storageKey, JSON.stringify(data));
  refreshRequestsTable();
}
