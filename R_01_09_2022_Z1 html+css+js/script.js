const URL = "https://ergast.com/api/f1/2012.json";
const SKEY = "USER";
key = "";
user = {};

key = "";
races = [];
favorites = [];

function initSecond() {
    initKey();
    $.ajax({
        url: URL,
        type: "GET",
        success: function(data) {
            races = data.MRData.RaceTable.Races;
            initTable();
            console.log(races);
        },
        error: function(error) {
            console.log(`Error: ${error}`);
        }
    });
}

function saveUser() {
    let form = document.forms[0];
    if (form) {
        let elements = form.elements;
        var user = {
            firstName: elements[0].value,
            lastName: elements[1].value
        }
        sessionStorage.setItem(SKEY, JSON.stringify(user));
    }
}

function initKey() {
    let storage = sessionStorage.getItem(SKEY);
    if (storage) {
        user = JSON.parse(storage);
        key = `${user.firstName} ${user.lastName}`;
    }
}

function initFavorites() {
    let storage = localStorage.getItem(key);
    if (storage) {
        favorites = JSON.parse(storage);
    } else {
        favorites = [];
    }
}

function initTable() {
    initFavorites();
    let tableContent = document.getElementById('tableContent');
    tableContent.innerHTML = "";
    for (const [index, race] of races.entries()) {
        let tr = document.createElement('tr');
        let raceName = document.createElement('td');
        raceName.innerHTML = race.raceName;
        let circuitName = document.createElement('td');
        circuitName.innerHTML = race.Circuit.circuitName;
        let locality = document.createElement('td');
        locality.innerHTML = race.Circuit.Location.locality;
        let country = document.createElement('td');
        country.innerHTML = race.Circuit.Location.country;
        let date = document.createElement('td');
        date.innerHTML = race.date;
        let time = document.createElement('td');
        time.innerHTML = race.time;
        let url = document.createElement('td');
        let a = document.createElement('a');
        a.innerHTML = 'Link';
        a.href = race.url;
        a.target = '_blank';
        url.appendChild(a);
        let favorite = document.createElement('td');
        let checkbox = document.createElement('input');
        checkbox.type = 'checkbox';
        checkbox.id = index;
        checkbox.onclick = function() {
            setFavorite(checkbox, race.raceName);
        }
        favorite.appendChild(checkbox);

        tr.appendChild(raceName);
        tr.appendChild(circuitName);
        tr.appendChild(locality);
        tr.appendChild(country);
        tr.appendChild(date);
        tr.appendChild(time);
        tr.appendChild(url);
        tr.appendChild(favorite);

        // color favorite races/rows of table
        if (favorites.length > 0 && favorites.includes(race.raceName)) {
            raceName.style.color = 'red';
            checkbox.checked = true;
        }
        tableContent.appendChild(tr);
    }
}

function setFavorite(checkbox, raceName) {
    if (checkbox.checked) {
        console.log('Favorite ', raceName);
        if (!favorites.includes(raceName)) {
            favorites.push(raceName);
        }
        checkbox.checked = true;
    } else {
        const index = favorites.indexOf(raceName);
        if (index !== -1) {
            favorites.splice(index, 1);
            checkbox.checked = false;
            console.log('Removed from favorites: ', raceName);
        }
    }
    console.log('Favorites ', favorites);
    localStorage.setItem(key, JSON.stringify(favorites));
    initTable();
}

function sort() {
    races = races.sort((a, b) => { return a.raceName.localeCompare(b.raceName); });
    console.log('Sorted ', races);
    initTable();
}

function deleteSettings() {
    localStorage.removeItem(key);
    initTable();
}

function openThirdPage() {
    location.href = 'third.html';
}

function initThird() {
    let tableContent = document.getElementById('tableContentThird');
    tableContent.innerHTML = "";
    for (let i = 0; i < localStorage.length; i++) {
        let user = localStorage.key(i);
        let favorites = JSON.parse(localStorage.getItem(user));
        console.log(`${user}: ${favorites}}`);

        let tr = document.createElement("tr");
        let userCell = document.createElement("td");
        userCell.innerHTML = user;
        let favoritesCell = document.createElement("td");
        let ul = document.createElement("ul");
        for (let fav of favorites) {
            let li = document.createElement("li");
            li.innerHTML = fav;
            ul.appendChild(li);
        }
        favoritesCell.appendChild(ul);

        tr.appendChild(userCell);
        tr.appendChild(favoritesCell);
        tableContent.appendChild(tr);
    }
}