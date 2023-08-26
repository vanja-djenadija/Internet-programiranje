var sessionStorageKey = "key";

function login() {
    const user = {
        name: document.getElementById('name').value,
        surname: document.getElementById('surname').value
    }
    sessionStorage.setItem(sessionStorageKey, JSON.stringify(user));
    location.href = "races.html";
}