 function request() {
    console.log("Showing All");
    const Http = new XMLHttpRequest();
    const url = 'http://localhost:9002/ShowAll';
    Http.open("GET", url);
    Http.onload = function (e) {
        data = JSON.parse(Http.response);
        resetInformation();
        data.forEach(function (item) {
            renderSingleInformation(item);
        });
    }
    Http.send();
}

function resetInformation() {
    let postcardList = document.getElementById("postcards");
    postcardList.innerHTML = "";
}

function renderSingleInformation(item) {
    let card = document.createElement("div");
    card.className= "card p-3 m-3";
    var country = document.createElement("div");
    var username = document.createElement("div");
    var cardid = document.createElement("div");
    var rating = document.createElement("div");
    var category = document.createElement("div");
    var space = document.createElement("br");
    country.innerHTML = item.country;
    username.innerHTML = item.username;
    cardid.innerHTML = item.cardid;
    rating.innerHTML = item.rating;
    category.innerHTML = item.category;
    card.appendChild(country);
    card.appendChild(username);
    card.appendChild(cardid);
    card.appendChild(rating);
    card.appendChild(category);
    card.appendChild(space);

    document.getElementById("postcards").appendChild(card);
}

function request2(form) {
    
    console.log("Finding By Card-ID");
    const Http = new XMLHttpRequest();
    const url = 'http://localhost:9002/ShowCardid/' + form.cardid.value;
    Http.open("GET", url);
    Http.onload = function (e) {
        data = JSON.parse(Http.responseText);
        resetInformation();
        renderSingleInformation(data);
    }
    Http.send();
    return false;
}
function request3(){
    let country = document.getElementById("country").value;
    let username = document.getElementById("username").value;
    let cardid = document.getElementById("cardid").value;
    let rating = document.getElementById("rating").value;
    let category = document.getElementById("category").value;
    const Http = new XMLHttpRequest();
    const url = 'http://localhost:9002/AddNewPostcard/';
    Http.open("POST", url);
    Http.setRequestHeader("Content-Type", "application/json");
    Http.send(JSON.stringify({"country":country, "username":username, "cardid":cardid, "rating":rating, "category":category}));
}
function request4(form){
    const Http = new XMLHttpRequest();
    const url = 'http://localhost:9002/DeletePostcard/' + form.cardid.value;
    Http.open("DELETE", url);
    Http.send();
    return false;
}
function request5(form){
    const Http = new XMLHttpRequest();
    const url = 'http://localhost:9002/UpdateRating/' + form.cardid.value + "/"+ form.rating.value;
    Http.open("Put", url);
    Http.send();
    return false;
}