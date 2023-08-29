const URL = "http://ergast.com/api/f1/2019/driverStandings.json";
let drivers = [];
let current = 0;

function init() {

    $.ajax({
        url: URL,
        type: "GET",
        success: function(data) {
            drivers = data.MRData.StandingsTable.StandingsLists[0].DriverStandings;
            console.log(drivers);
            loadPlayer();
        }
    });
}

function loadPlayer() {
    let name = document.getElementById('name');
    name.innerHTML = `${drivers[current].Driver.givenName} ${drivers[current].Driver.familyName}`;
    let position = document.getElementById('position');
    position.innerHTML = drivers[current].position;
    let score = document.getElementById('score');
    score.innerHTML = drivers[current].points;
    let team = document.getElementById('team');
    team.innerHTML = drivers[current].Constructors[0].name;

    let leftArrow = document.getElementById("leftArrow");
    let rightArrow = document.getElementById("rightArrow");
    if (current == 0) {
        leftArrow.style.display = 'none';
    } else if (current == drivers.length - 1) {
        rightArrow.style.display = 'none';
    } else {
        leftArrow.style.display = 'block';
        rightArrow.style.display = 'block';
    }
}

function next() {
    current++;
    if (current < drivers.length)
        loadPlayer();

}

function prev() {
    current--;
    if (current >= 0)
        loadPlayer();
}