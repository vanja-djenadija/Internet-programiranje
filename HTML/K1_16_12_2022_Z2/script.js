var clicked = 0;
const colors = ["blue", "red", "green"];
const key = "ETF";
let data = [];

function init() {
  let table = document.getElementById("tableContent");
  for (let i = 0; i < 5; i++) {
    let row = document.createElement("tr");
    let name = document.createElement("td");
    let lastName = document.createElement("td");
    let index = document.createElement("td");
    name.innerHTML = "Ime" + i;
    lastName.innerHTML = "Prezime" + i;
    index.innerHTML = i;
    row.appendChild(name);
    row.appendChild(lastName);
    row.appendChild(index);
    table.appendChild(row);
  }

  data = JSON.parse(localStorage.getItem(key));
  let table2 = document.getElementById("requests");
  for (let i = 0; i < data.length; i++) {
    let row = document.createElement("tr");
    let name = document.createElement("td");
    let birth = document.createElement("td");
    let des = document.createElement("td");
    let priority = document.createElement("td");
    name.innerHTML = data[i].name;
    birth.innerHTML = data[i].birth;
    des.innerHTML = data[i].des;
    priority.innerHTML = data[i].priority;
    row.appendChild(name);
    row.appendChild(birth);
    row.appendChild(des);
    row.appendChild(priority);
    table2.appendChild(row);
  }
}

function changeColor() {
  // get all boxes
  let boxes = document.getElementsByClassName("box");
  for (let index = 0; index < boxes.length; index++) {
    boxes[index].style.background = colors[clicked % 3];
  }
  clicked++;
}

function save() {
  // save in local storage
  let form = document.forms[0];

  var obj = {
    name: form["name"].value,
    birth: form["birth"].value,
    des: form["des"].value,
    priority: form["priority"].value,
  };
  
  data.push(obj);
  localStorage.setItem(key, JSON.stringify(data));
}
