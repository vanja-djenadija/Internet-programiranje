var storageKey = "20211216";
var data = [];

function init() {
  loadData();
  drawTable();
  openPage("studenti");
}

function openPage(pageName) {
  var i, tabcontent;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  document.getElementById(pageName).style.display = "block";
  if (pageName === "studenti") drawTable();
}

function openPageETF() {
  window.open("https://etf.unibl.org/", "_blank");
}

function saveStudentData() {
  var form = document.forms[0];
  if (form) {
    var elements = form.elements;

    var student = {
      firstName: elements.name.value,
      lastName: elements.lname.value,
      index: elements.index.value,
      year: elements.year.value,
      program: elements.program.value,
      status: elements.status.value,
      note: elements.note.value,
    };

    data.push(student);
    drawTable();
    alert("Uspješno dodan student.");
    form.reset();
  }

  if (typeof Storage !== "undefined") {
    sessionStorage.setItem(storageKey, JSON.stringify(data));
    alert("Uspješno sačuvano.");
  }
}

/* na reload page-a učitavamo iz session storage podatke i smiještamo u data */
function loadData() {
  if (typeof Storage !== "undefined") {
    var storage = sessionStorage.getItem(storageKey);

    if (storage) {
      data = JSON.parse(storage);
      if (data.length == 0) {
        document.getElementById("message").innerHTML = "Nema podataka.";
      }
    } else {
      document.getElementById("message").innerHTML = "Podaci nisu sačuvani.";
    }
  }
}

function drawTable() {
  var table = document.getElementById("table-content");
  table.innerHTML = "";

  /* Ako ima manje od 5 studenata u tabeli, kreirati prazne redove */
  for (let i = 0; i < 5 - data.length; i++) {
    var row = table.insertRow(i);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);
    var cell7 = row.insertCell(6);
    cell1.innerHTML = " ";
    cell2.innerHTML = " ";
    cell3.innerHTML = " ";
    cell4.innerHTML = " ";
    cell5.innerHTML = " ";
    cell6.innerHTML = " ";
    cell7.innerHTML = " ";
  }

  /* Podaci */
  for (var element in data) {
    var row = table.insertRow(0);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);
    var cell7 = row.insertCell(6);
    cell1.innerHTML = data[element].firstName;
    cell2.innerHTML = data[element].lastName;
    cell3.innerHTML = data[element].index;
    cell4.innerHTML = data[element].year;
    cell5.innerHTML = data[element].program;
    cell6.innerHTML = data[element].status;
    cell7.innerHTML = data[element].note;
  }
}

function sortName() {
  data.sort(function (a, b) {
    return a.firstName.localeCompare(b.firstName);
  });
  drawTable();
}

function sortLastName() {
  data.sort(function (a, b) {
    return a.lastName.localeCompare(b.lastName);
  });
  drawTable();
}

function deleteData() {
  if (confirm("Želite li obrisati sve podatke?")) {
    data = [];
    sessionStorage.removeItem(storageKey); // DA LI SE PODACI BRIŠU I IZ SESIJE?
    drawTable();
  }
}
