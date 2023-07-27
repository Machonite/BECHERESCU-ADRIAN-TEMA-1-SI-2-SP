var tableContainer = document.getElementById('table-container');
var addedProjects = []; 

function createTable(data) {
  var table = document.createElement('table');
  var thead = document.createElement('thead');
  var tbody = document.createElement('tbody');

  
  var headerRow = document.createElement('tr');

  var nameHeader = document.createElement('th');
  nameHeader.textContent = 'Denumire';
  headerRow.appendChild(nameHeader);

  var descriptionHeader = document.createElement('th');
  descriptionHeader.textContent = 'Descriere';
  headerRow.appendChild(descriptionHeader);

  var costHeader = document.createElement('th');
  costHeader.textContent = 'Cost Lunar';
  headerRow.appendChild(costHeader);

  var linkHeader = document.createElement('th');
  linkHeader.textContent = 'Angajati';
  headerRow.appendChild(linkHeader);

  thead.appendChild(headerRow);
  table.appendChild(thead);
  table.appendChild(tbody);
  table.classList.add('table');

  tableContainer.innerHTML = '';

  data.forEach(function (project) {
    
    if (addedProjects.includes(project.idulProiect)) {
      return; 
    }

    var row = document.createElement('tr');

    var nameCell = document.createElement('td');
    nameCell.textContent = project.nume;
    row.appendChild(nameCell);

    var descriptionCell = document.createElement('td');
    descriptionCell.textContent = project.descriere;
    row.appendChild(descriptionCell);

    var costCell = document.createElement('td');
    costCell.textContent = project.costLunar;
    row.appendChild(costCell);

    var linkCell = document.createElement('td');
    var link = document.createElement('a');
    link.href = 'Angajati.html?object=' + encodeURIComponent(JSON.stringify(project));
    link.textContent = 'Angajati';
    linkCell.appendChild(link);
    row.appendChild(linkCell);

    tbody.appendChild(row);

    addedProjects.push(project.idulProiect); 
  });

  table.appendChild(tbody);
  table.classList.add('table');

  tableContainer.innerHTML = '';
  tableContainer.appendChild(table);
}

function fetchData() {
  fetch('http://localhost:8080/proiect')
    .then(function(response) {
      return response.json();
    })
    .then(function(data) {
      createTable(data);
    })
    .catch(function(error) {
      console.log('A apărut o eroare:', error);
    });

}

function filterTable() {
  var input = document.getElementById('filter-input').value.toLowerCase();
  var rows = document.querySelectorAll('#table-container table tbody tr');

  rows.forEach(function(row) {
    var name = row.querySelector('td:nth-child(1)').textContent.toLowerCase();
    var description = row.querySelector('td:nth-child(2)').textContent.toLowerCase();
    var cost = row.querySelector('td:nth-child(3)').textContent.toLowerCase();

    if (name.includes(input) || description.includes(input) || cost.includes(input)) {
      row.style.display = '';
    } else {
      row.style.display = 'none';
    }
  });
}

function addNewEmployee() {
    
    var nume = document.getElementById('nume').value;
    var prenume = document.getElementById('prenume').value;
    var functie = document.getElementById('functie').value;
    var salariu = document.getElementById('salariu').value;
    var project_id = document.getElementById('project-id').value;
    var data_angajare = document.getElementById('data_angajare').value;
    var email = document.getElementById('email').value;
  
    
    var project = {
       idulProiect: project_id
    };

    
    var newAngajat = {
      nume: nume,
      prenume: prenume,
      functie: functie,
      salariu: salariu,
      proiect: project,
      data_angajare: data_angajare,
      email: email
    };

    console.log(project);
  
    
    fetch('http://localhost:8080/angajat', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(newAngajat)
    })
    .then(function(response) {
      if (response.ok) {
        
        fetchData();
        
      } else {
        throw new Error('Eroare la adăugarea angajatului');
      }
    })
    .catch(function(error) {
      console.log('A apărut o eroare:', error);
    });
  }
  
  
  document.getElementById('add-employee-form').addEventListener('submit', function(event) {
    event.preventDefault(); 
    addNewEmployee();
    windows.location.reload();
  });
  
  
  

fetchData();