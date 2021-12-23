/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


const container = document.querySelector('.container');
const seats = document.querySelectorAll('.row .seat:not(.occupied');

const count = document.getElementById('count');
const total = document.getElementById('total');
const movieSelect = document.getElementById('movie');
const selections = {};
const reserveButton = document.getElementById('reserveButton');
const totalElem = document.getElementById("total-container");
const hiddenTotalElem = document.getElementById("hidden-total");
const hiddenSeatElem = document.getElementById("hidden-seats");
const seatsElem = document.getElementById("selected-seats");
let ticketPrice = +movieSelect.value;

// Save selected movie index and price
function setMovieData(movieIndex, moviePrice) {
    localStorage.setItem('selectedMovieIndex', movieIndex);
    localStorage.setItem('selectedMoviePrice', moviePrice);
}

// update total and count
function updateSelectedCount() {
    const selectedSeats = document.querySelectorAll('.row .seat.selected');
    const seatsIndex = [...selectedSeats].map((seat) => [...seats].indexOf(seat));

    localStorage.setItem('selectedSeats', JSON.stringify(seatsIndex));

    //copy selected seats into arr
    // map through array
    //return new array of indexes

    const selectedSeatsCount = selectedSeats.length - 1;

    count.innerText = selectedSeatsCount;
    total.innerText = selectedSeatsCount * ticketPrice;
}

// Movie select event
movieSelect.addEventListener('change', (e) => {
    ticketPrice = +e.target.value;
    setMovieData(e.target.selectedIndex, e.target.value);

    updateSelectedCount();
});

// Seat click event
container.addEventListener('click', (e) => {
    if (e.target.classList.contains('seat') && !e.target.classList.contains('occupied')) {
        let elem = e.target.classList.toString();
        if (elem !== "seat selected" && Object.keys(selections).length < 6) {
            e.target.classList.toggle('selected');
            selections[e.target.id] = {
                id: e.target.id,
                value: e.target.getAttribute('data-value')
            };
        } else if (elem === "seat selected") {
            e.target.classList.toggle('selected');
            delete selections[e.target.id];
        } else {
            e.preventDefault();
            alert('You can only reserve 6 seats at time');
            return;
        }


        console.log(e.target.id);
        const result = [];
        let total = 0;

        for (const key in selections) {
            result.push(selections[key].value);
        }

        result.length ? reserveButton.disabled = false : reserveButton.disabled = true;
        totalElem.innerText = total;
        seatsElem.innerHTML = result.join(",");
        updateSelectedCount();
    }
});


// intial count and total
updateSelectedCount();
