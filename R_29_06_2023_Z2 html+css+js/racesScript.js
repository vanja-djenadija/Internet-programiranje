var sessionStorageKey = "key";
var localStorageKey = "key1";
var userName = '';
var userUsername = '';

var myFavourites = [];
var localStorageData = [];
var dataApi = [];

function init() {
    loadUserData();
    loadLocalStorageData();
    loadMyFavourites();
    getDataFromAPI();
}

function loadUserData() {
    const userData = sessionStorage.getItem(sessionStorageKey);
    if(userData) {
        let credentials = JSON.parse(userData);
        userName = credentials.name;
        userUsername = credentials.surname;
    }
}

function loadLocalStorageData() {
    const storageData = localStorage.getItem(localStorageKey);
    localStorageData = storageData? JSON.parse(storageData): [];
}

function loadMyFavourites() {
    for(let i=0;i<localStorageData.length;i++) {
        if(localStorageData[i].user === userName + " " + userUsername) {
            for(let j=0;j<localStorageData[i].favourites.length;j++) {
                myFavourites.push(localStorageData[i].favourites[j]);
            }
        }
    }
}

function getDataFromAPI() {
    let request = new XMLHttpRequest();
    request.onreadystatechange = function() {
        if(request.readyState == 4 && request.status == 200) {
            let result = JSON.parse(request.responseText);
            dataApi = result.MRData.RaceTable.Races;
            drawTable();
        }
    }
    request.open("GET", "https://ergast.com/api/f1/2023.json", true);
    request.send(null);
}

function drawTable() {
    let bodyContent = document.getElementById('body-content');
            for(let i=0;i<dataApi.length;i++) {
                let row = bodyContent.insertRow(0);
                if(isFavourite(dataApi[i])) {
                    row.style.color = "red";
                }
                row.insertCell(0).innerHTML = dataApi[i].raceName;
                row.insertCell(1).innerHTML = dataApi[i].Circuit.circuitName;
                row.insertCell(2).innerHTML = dataApi[i].Circuit.Location.locality;
                row.insertCell(3).innerHTML = dataApi[i].Circuit.Location.country;
                row.insertCell(4).innerHTML = dataApi[i].date;
                row.insertCell(5).innerHTML = dataApi[i].time;

                let linkCell = row.insertCell(6);
                let a = document.createElement('a');
                a.textContent = "Wikipedia"
                a.href = dataApi[i].url;
                a.target = "_blank";
                linkCell.appendChild(a);

                let buttonCell = row.insertCell(7);
                let buttonElement = document.createElement('button');
                buttonElement.classList.add('button-element');
                buttonElement.textContent = isFavourite(dataApi[i])? "Ukloni": "Dodaj";

                buttonCell.appendChild(buttonElement);
            }
            addActionListenerToButtons();
}

function isFavourite(race) {
    for(let i=0;i<myFavourites.length;i++) {
        if(myFavourites[i].round === race.round) {
            return true;
        }
    }
    return false;
}

function addActionListenerToButtons() {
    let buttonElements = document.getElementsByClassName('button-element');
    for(let i=0;i<buttonElements.length;i++) {
        buttonElements[i].addEventListener("click", handleClickEvent);
    }
}

function handleClickEvent() {
    let row = this.parentNode.parentNode;
    if(findRace(row.cells[0].innerHTML, row.cells[1].innerHTML, row.cells[2].innerHTML) != null){
        myFavourites = myFavourites.filter((item) => item.raceName !== row.cells[0].innerHTML || item.Circuit.circuitName !== row.cells[1].innerHTML || item.Circuit.Location.locality !== row.cells[2].innerHTML)
        row.style.color = "black";
        this.textContent = "Dodaj";
    } else {
        row.style.color = 'red';
        this.textContent = "Ukloni";
        myFavourites.push(findRaceFromRaceApi(row.cells[0].innerHTML, row.cells[1].innerHTML, row.cells[2].innerHTML));
    }
    localStorageData = localStorageData.filter((item) => item.user !== userName + " " + userUsername);
    const user = {
        user: userName + " " + userUsername,
        favourites: myFavourites
    }
    localStorageData.push(user);
    localStorage.setItem(localStorageKey, JSON.stringify(localStorageData));
}

function findRace(raceName, circuitName, location) {
    for(let i=0;i<myFavourites.length;i++) {
        if(myFavourites[i].raceName === raceName || myFavourites[i].Circuit.circuitName === circuitName || myFavourites[i].Circuit.Location.locality === location) {
            return myFavourites[i];
        }
    }
    return null;
}

function findRaceFromRaceApi(raceName, circuitName, location){
    for(let i=0;i<dataApi.length;i++) {
        if(dataApi[i].raceName === raceName && dataApi[i].Circuit.circuitName === circuitName && dataApi[i].Circuit.Location.locality === location) {
            return dataApi[i];
        }
    }
    return null;
}

function sortByNazivTrke() {
    dataApi = dataApi.sort((x,y) => {
        if(x.raceName > y.raceName) return -1;
        if(x.raceName < y.raceName) return 1;
        return 0;
    });
    drawTable();
}

function sortByNazivStaze() {
    dataApi = dataApi.sort((x,y) => {
        if(x.Circuit.circuitName > y.Circuit.circuitName) return -1;
        if(x.Circuit.circuitName < y.Circuit.circuitName) return 1;
        return 0;
    });
    drawTable();
}

function deleteMyFavourites() {
    myFavourites = [];
    loadLocalStorageData();
    localStorageData = localStorageData.filter((item) => item.user !== userName + " " + userUsername);
    localStorage.setItem(localStorageKey, JSON.stringify(localStorageData));
    drawTable();
}