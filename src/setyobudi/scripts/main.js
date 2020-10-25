import '../scripts/nav.js';
import '../scripts/info.js';

let numeral = require('numeral');
const main = () => {

	const global = 'https://covid19.mathdro.id/api';
	const indo = 'https://covid19.mathdro.id/api/countries/ID';
	const getGlobal = () => {

        fetch(`${global}`)
            .then(response => {
                return response.json();
            })
            .then(responseJson => {
                renderGlobal(responseJson);
            })
            .catch(error => {
                showResponseMessage(error);
            });

    };
	const getindo = () => {

        fetch(`${indo}`)
            .then(response => {
                return response.json();
            })
            .then(responseJson => {
                renderindo(responseJson);
            })
            .catch(error => {
                showResponseMessage(error);
            });

    };

    const renderGlobal = (data) => {
    	const idConfirmed = document.querySelector("#confirmed");
    	const idRecovered = document.querySelector("#recovered");
    	const idDeaths = document.querySelector("#deaths");
    	const idLastUpdate = document.querySelector("#lastUpdate");

    	idConfirmed.innerHTML = numeral(`${data.confirmed.value}`).format('0,0');
    	idRecovered.innerHTML = numeral(`${data.recovered.value}`).format('0,0');
    	idDeaths.innerHTML = numeral(`${data.deaths.value}`).format('0,0');
    	idLastUpdate.innerHTML = `${data.lastUpdate}`;
    };
	
    const renderindo = (data) => {
    	const idConfirmed1 = document.querySelector("#confirmed1");
    	const idRecovered1 = document.querySelector("#recovered1");
    	const idDeaths1 = document.querySelector("#deaths1");
    	

    	idConfirmed1.innerHTML = numeral(`${data.confirmed.value}`).format('0,0');
    	idRecovered1.innerHTML = numeral(`${data.recovered.value}`).format('0,0');
    	idDeaths1.innerHTML = numeral(`${data.deaths.value}`).format('0,0');
    	
    };	

    const showResponseMessage = (message = "Check your internet connection") => {
        alert(message);
    };

    document.addEventListener("DOMContentLoaded", () => {
    	getGlobal();
    	getindo();

    });
	
}

export default main;