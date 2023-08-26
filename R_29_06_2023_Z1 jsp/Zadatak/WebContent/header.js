function init() {
    let interval = setInterval(() => {
        document.getElementById('dateTime').innerHTML = new Date();
    }, 1000);
}