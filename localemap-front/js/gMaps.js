window.addEventListener('load', initListeners);

// Declaración de variables para GMaps
let marker = null;
let markers = new Array();
let infowindow = null;
let locations = null;
let map = null;

//------------------------------ Listeners --------------------------------------
// Función para inicalizar todos los listener de la página y que será utilizado al cargar la misma
function initListeners() {
    selectListener();
}

// Escuchador del submit del formulario
function selectListener() {
    document.getElementById('selectTipoLocal').addEventListener('change', (e) => {
        let options = document.getElementById('selectTipoLocal').options;
        let categoria;
        // Extrae el valor selecionado en el Select de Locales
        for (let i = 0; i < options.length; i++) {
            if (options[i].selected) {
                categoria = options[i].value;
            }
        }
        getLocales(categoria);
    })
}

//------------------------------ Petición AJAX --------------------------------------
// Permite obtener los locales de la categoría recibida por parámetros lanzando una consulta asíncrona al lado del servidor
function getLocales(categoria) {
    let locales;
    // Objeto de configuración de petición FETCH
    let configFetch = {
        method: 'GET',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    };
    // Lanzamiento de la peticion AJAX con FETCH
    fetch('http://localhost:8080/locales/' + categoria, configFetch).then(function(response) {
        // La propiedad ok retorna true si se ha realizado correctamente
        if (response.ok) { console.log('Respuesta OK'); }
        response.json().then(function(objetoJSON) {
            locations = objetoJSON;
            setLocations(map);
        });
    }).catch(function(error) {
        console.log('Error con la petición:' + error.message);
    });
}


//------------------------------ GMaps --------------------------------------
// https://developers.google.com/maps/documentation/javascript/adding-a-google-map
// Función que permite inciar el mapa al cargar la página
function initMap() {
    // establecemos un punto incial para el centrado del mapa a en su creación
    let chios = { lat: 43.35745296321702, lng: -8.399676003063062 };
    // Creación del mapa centrado en la posición de Chios 
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 13,
        center: chios,
    });
}

// Recibe por parámetros los resultados con los locales de la consulta del Back a la base datos
function setLocations(map) {
    // Elimina los marcadores que haya de la anterior carga (En caso de que haya)
    if (markers.length > 0) { deleteMarkers(); }
    // Recorre el array con el local o locales devuletos por la consulta a la BDD y crea un nuevo marker para cada uno
    // con el nombre extraído de la base de datos y añadiendo una animación a la creación de los mismos
    if (typeof locations !== 'undefined') {
        locations.forEach(local => {
            marker = new google.maps.Marker({
                position: JSON.parse(local.coordenadas),
                title: local.nombre,
                animation: google.maps.Animation.DROP,
            });
            marker.setMap(map); // Establece el punto creado, en la instancia de mapa que tenemos almacenada en map
            markers.push(marker); // Añadimos el punto creado al array 'Temporal' que contiene los puntos devueltos por al consulta
        });
    }
}

// Permite eliminar los marcadores del mapara a traves de la referencia que está guardada en el array de markers
function deleteMarkers() {
    markers.forEach(marker => {
        marker.setMap(null);
    });
}