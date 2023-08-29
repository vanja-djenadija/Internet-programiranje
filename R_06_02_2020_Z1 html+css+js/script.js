const pins = ["1234", "4321", "3241"];
const KEY = "PIN";
const URL = "https://restcountries.com/v3.1/region/europe";
let countries = [];
let success = false;
let pin = "";

function init() {
    localStorage.setItem(KEY, JSON.stringify(pins));
    let buttons = document.getElementsByClassName("key");
    for (let button of buttons) {
        button.onclick = function() {
            enterNumber(button.id);
        };
    }
    let main = document.getElementById("main");
    main.style.display = "none";
}

function enterNumber(number) {
    pin += number;
    document.forms[0].elements[0].value = pin;
}

function login() {
    let form = document.forms[0];
    if (form) {
        let elements = form.elements;
        let entered = elements[0].value;
        for (let pin of pins) {
            if (pin === entered) {
                loadMainPage();
                break;
            }
        }
        if (!success) {
            alert("PIN not correct. Try again.");
        }
    }
}

function deletePin() {
    debugger;
    pin = "";
    document.forms[0].reset();
}

function loadMainPage() {
    success = true;
    console.log("Success!");
    let form = document.getElementById("form");
    form.style.display = "none";
    let main = document.getElementById("main");
    main.style.display = "block";

    $.ajax({
        url: URL,
        type: "GET",
        success: function(data) {
            countries = data.filter(e => e.population > 5000000);
        },
        error: function(error) {
            console.log(`Error ${error}`);
        }
    });

    reload();
}

function reload() {
    let list = document.getElementById("list");
    list.innerHTML = "";
    for (let country of countries) {
        let li = document.createElement("li");
        li.innerHTML = country.name.official;
        list.appendChild(li);
    }
}