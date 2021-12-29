/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


const container = document.querySelector('.container');
const seats = document.querySelectorAll('.row .seat:not(.occupied');
const count = document.getElementById('count');
const selections = {};
const reserveButton = document.getElementById('reserveButton');
const totalElem = document.getElementById("total-container");
const hiddenTotalElem = document.getElementById("hidden-total");
const hiddenSeatElem = document.getElementById("hidden-seats");
const seatsElem = document.getElementById("selected-seats");
const results = [];


//update total and count
function updateSelectedCount() {
    const selectedSeats = document.querySelectorAll('.row .seat.selected');
    const seatsIndex = [...selectedSeats].map((seat) => [...seats].indexOf(seat));

    localStorage.setItem('selectedSeats', JSON.stringify(seatsIndex));

    //copy selected seats into arr
    // map through array
    //return new array of indexes

    const selectedSeatsCount = selectedSeats.length - 1;

    count.innerText = selectedSeatsCount;
}




// Seat click event
container.addEventListener('click', (e) => {
    if (e.target.classList.contains('seat') && !e.target.classList.contains('occupied')) {
        let elem = e.target.classList.toString();
        if (elem !== "seat selected" && Object.keys(selections).length < 5) {
            e.target.classList.toggle('selected');
            selections[e.target.id] = {
                id: e.target.id
            };
            results.push(e.target.id);
        } else if (elem === "seat selected") {
            e.target.classList.toggle('selected');
            delete selections[e.target.id];
        } else {
            e.preventDefault();
            alert('Chỉ tối đa 5 vé');
            return;
        }
        console.log(e.target.id);
        const result = [];
        for (const key in selections) {
            result.push(selections[key].id);
        }
        result.length ? reserveButton.disabled = false : reserveButton.disabled = true;
        seatsElem.innerHTML = result.join(",");
        updateSelectedCount();
    }
});

function pay(userId, id, price) {
    fetch("http://localhost:8080/CS82TicketSale/api/pay", {
        method: 'post',
        body: JSON.stringify({
            "userId": userId,
            "seats": results,
            "tripId": id,
            "price": parseInt(price)
        }),
        headers: {
            "Content-type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (code) {
        console.info(code);
        //window.location="http://localhost:8080/CS82TicketSale/";
    });

}

// intial count and total
updateSelectedCount();
