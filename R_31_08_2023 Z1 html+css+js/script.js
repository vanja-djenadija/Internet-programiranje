const KEY = "PROIZVODI";
const N = 60;
var products = [];
var page = 0;
const message = 'Kupovina je uspješno realizovana.';


function init() {
    generateProducts();
    generateCards();
}

function generateProducts() {
    if (JSON.parse(localStorage.getItem(KEY)) != null) {
        products = JSON.parse(localStorage.getItem(KEY));
        return;
    }
    for (var i = 0; i < N; i++) {
        let obj = {
            name: "Proizvod " + i,
            description: "Opis " + i,
            price: parseFloat((Math.random() * 100).toFixed(2)),
            selected: false
        }
        products.push(obj);
    }
    localStorage.setItem(KEY, JSON.stringify(products));
}

function generateCards() {
    let content = document.getElementById('content');
    for (let i = 0; i < products.length; i++) {
        let card = document.createElement('div');
        card.className = 'card';
        let name = document.createElement('h4');
        name.innerHTML = products[i].name;
        let description = document.createElement('h6');
        description.innerHTML = products[i].description;
        let price = document.createElement('h3');
        price.innerHTML = products[i].price + ' KM';
        let selected = document.createElement('input');
        selected.id = i;
        selected.type = 'checkbox';
        selected.checked = products[i].selected;
        selected.onchange = function() {
            selectProduct(selected);
        }

        card.appendChild(name);
        card.appendChild(description);
        card.appendChild(price);
        card.appendChild(selected);
        content.appendChild(card);
    }
}

function selectProduct(selected) {
    products[selected.id].selected = selected.checked;
    localStorage.setItem(KEY, JSON.stringify(products));
    console.log('Selected product', selected.id, selected.checked);
}

function next() {

    page++;
    if (page === 1) {
        let form = document.forms[0];
        form.innerHTML = '';
        let select = document.createElement('select');
        select.name = 'payment';
        select.id = 'select';
        select.onchange = function() {
            console.log('Hello ', document.getElementById('select').value);
            let value = document.getElementById('select').value;
            if (value === 'card') {
                let cardNumber = document.getElementById('cardNumber');
                cardNumber.style.display = 'block';
                let address = document.getElementById('address');
                address.style.display = 'none';
            } else if (value === 'personal') {
                let cardNumber = document.getElementById('cardNumber');
                cardNumber.style.display = 'none';
                let address = document.getElementById('address');
                address.style.display = 'block';
            }
        }
        let optionCard = document.createElement('option');
        optionCard.text = 'Karticom';
        optionCard.value = 'card';


        let optionPersonal = document.createElement('option');
        optionPersonal.text = 'Pouzećem';
        optionPersonal.value = 'personal';

        select.appendChild(optionCard);
        select.appendChild(optionPersonal);

        let address = document.createElement('input');
        address.type = 'text';
        address.placeholder = 'Adresa';
        address.id = 'address';
        address.style.display = 'none';
        let cardNumber = document.createElement('input');
        cardNumber.type = 'number';
        cardNumber.placeholder = 'Broj kartice';
        cardNumber.id = 'cardNumber';
        cardNumber.style.display = 'block';

        let nextButton = document.createElement('input');
        nextButton.type = 'submit';
        nextButton.value = 'Dalje';

        form.appendChild(select);
        form.appendChild(document.createElement('hr'));
        form.appendChild(address);
        form.appendChild(cardNumber);
        form.appendChild(document.createElement('hr'));
        form.appendChild(nextButton);
    } else if (page === 2) {
        let title = document.createElement('h3');
        title.innerHTML = message;
        let centre = document.getElementsByClassName('centre')[0];
        centre.innerHTML = '';
        centre.appendChild(title);

        let bought = products.filter(e => e.selected == true).sort((a, b) => b.price - a.price);
        const totalPrice = bought.reduce((total, product) => total + product.price, 0);

        for (let product of bought) {
            let div = document.createElement('div');
            div.innerHTML = `${product.name} - ${product.price}`;
            centre.appendChild(div);
        }
        let total = document.createElement('h3');
        total.innerHTML = `Ukupna cijena ${totalPrice}`;
        centre.appendChild(total);
        console.log('Bought products', bought);

    }
}

function insertAfter(referenceNode, newNode) {
    referenceNode.parentNode.insertBefore(newNode, referenceNode.nextSibling);
}