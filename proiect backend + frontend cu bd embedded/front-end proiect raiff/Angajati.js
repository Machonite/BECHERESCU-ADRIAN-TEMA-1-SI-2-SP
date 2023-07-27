
var detailsContainer = document.getElementById('details-container');


var queryString = window.location.search;
var urlParams = new URLSearchParams(queryString);


var objectParam = urlParams.get('object');
var objectData = JSON.parse(decodeURIComponent(objectParam));


function createDetails(data) {
    
    if (Array.isArray(data.angajat)) {
      var angajatiData = data.angajat;
  
      
      angajatiData.forEach(function(angajat, index) {
        var card = document.createElement('div');
        card.classList.add('card');
  
        var cardBody = document.createElement('div');
        cardBody.classList.add('card-body');


    var labelArray = [ "Nume","Prenume", "Functie", "Salariu", "Data angajarii","Email"];
  
     
     var keys = Object.keys(angajat);
     for (var i = 0; i < keys.length - 2; i++) {
        var key = keys[i];
        var divWrapper = document.createElement('div');
        divWrapper.classList.add('card-item');

        var label = document.createElement('label');
        label.textContent = labelArray[i]+':';
        label.classList.add('card-label');

        var value = document.createElement('div');
        value.textContent = angajat[key];
        value.classList.add('card-value');

        divWrapper.appendChild(label);
        divWrapper.appendChild(value);
        cardBody.appendChild(divWrapper);
     }

  
     var divWrapper = document.createElement('div');

     divWrapper.classList.add('card-item');


     var updateButton = document.createElement('button');

     updateButton.textContent = "Actualizare";

     updateButton.classList.add('card-value');



     updateButton.addEventListener('click', function() {

     var project = {

       idulProiect: document.getElementById('idProjectInput').value

    };



  

    var updatedData = {

     angajatid: angajat.angajatId, 

     nume: document.getElementById('lastNameInput').value,

     prenume: document.getElementById('firstNameInput').value,

     functie: document.getElementById('jobPositionInput').value,

     salariu: document.getElementById('salaryInput').value,

     email: document.getElementById('emailInput').value,

     proiect: project, 

     data_angajare: angajat.data_angajare 

   };

  


    console.log(updatedData);



    fetch('http://localhost:8080/angajat', {

     method: 'PUT',

     headers: {

     'Content-Type': 'application/json'

    },

    body: JSON.stringify(updatedData)

    })

    .then(function(response) {

     if (response.ok) {



     } else {

     throw new Error('Eroare la actualizarea elementului');

     }

   })

    .catch(function(error) {

    console.log('A apărut o eroare:', error);

   });

 });



     divWrapper.appendChild(updateButton);

     cardBody.appendChild(divWrapper);


     var deleteButton = document.createElement('button');

     deleteButton.textContent = "Stergere";

     deleteButton.classList.add('card-value');



     deleteButton.addEventListener('click', function() {

       var id = angajat.angajatId; 

      

       fetch('http://localhost:8080/angajat/' + id, {

         method: 'DELETE',

         headers: {

           'Content-Type': 'application/json'

         }

       })

       .then(function(response) {

         if (response.ok) {

           

           $('#confirmModal').modal('show');

           

          var closeButton = document.querySelector('#confirmModal .modal-footer button');


         } else {

           throw new Error('Eroare la ștergerea elementului');

         }

       })

       .catch(function(error) {

         console.log('A apărut o eroare:', error);

       });

     });


     divWrapper.appendChild(deleteButton);

     cardBody.appendChild(divWrapper);

     card.appendChild(cardBody);

     detailsContainer.appendChild(card);
      });
    }
  }
    


createDetails(objectData);


