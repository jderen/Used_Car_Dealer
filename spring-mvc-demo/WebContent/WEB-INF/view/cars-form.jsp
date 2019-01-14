<!DOCTYPE html>
<html lang="pl">
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<title>Komis Samochodowy ELO</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<link href="style.css" rel="stylesheet">
</head>
<body>
	<!-- Navigation Bar -->
	<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active">
						<a class="nav-link" href="carEmployee">Szukaj</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="cars">Samochód</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="clients">Klient</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="transactions">Transakcja</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="accounts">Konto</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="">Wyloguj</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	
	<!-- Table -->
	<div class="container">
		<div class ="row">
			<div class="col-md-10 offset-md-1">
				<input type="text" id="myID" onkeyup="getID()" placeholder="ID">
				<input type="text" id="myBrand" onkeyup="getBrand()" placeholder="Marka">
				<input type="text" id="myModel" onkeyup="getModel()" placeholder="Model">
				<input type="text" id="myMileage" onkeyup="getMileage()" placeholder="Przebieg">
				<input type="text" id="myYear" onkeyup="getYear()" placeholder="Rok Produkcji">
				<input type="text" id="myEngineCapacity" onkeyup="getEngineCapacity()" placeholder="Pojemność Silnika">
				<input type="text" id="myPower" onkeyup="getPower()" placeholder="Moc Silnika">
				<input type="text" id="myFuel" onkeyup="getFuel()" placeholder="Paliwo">
				<input type="text" id="myPrize" onkeyup="getPrize()" placeholder="Cena">
				<input type="text" id="myDate" onkeyup="getDate()" placeholder="Data Wystawienia">
				<input type="text" id="mySeller" onkeyup="getSeller()" placeholder="ID sprzedającego">
				<input type="text" id="myPhoto" onkeyup="getPhoto()" placeholder="Zdjęcie">
				<input type="text" id="myAccident" onkeyup="getAccident()" placeholder="Bezwypadkowy">
			</div>
		</div>
	</div>

<div class="table-responsive">
	<table class="table table-bordered table-hover" id="myTable"">
	  <thead class="thead-light">
	  	<thead>
		<tr>
	<th onclick="sortTable(0)">ID</th>
	<th onclick="sortTable(1)">Marka</th>
	<th onclick="sortTable(2)">Model</th>
	<th onclick="sortTable(3)">Przebieg</th>
	<th onclick="sortTable(4)">Rok Produkcji</th>
	<th onclick="sortTable(5)">Pojemność silnika</th>
	<th onclick="sortTable(6)">Moc Silnika</th>
	<th onclick="sortTable(7)">Rodzaj Paliwa</th>
	<th onclick="sortTable(8)">Cena</th>
	<th onclick="sortTable(9)">Data Wystawienia</th>
	<th onclick="sortTable(10)">ID sprzedającego</th>
	<th onclick="sortTable(11)">Zdjęcie</th>
	<th onclick="sortTable(12)">Bezwypadkowy</th>
		</tr>
	  </thead>
	  <tbody>
		<tr class="item">
		  <td>1</td>
		  <td>Mercedes</td>
		  <td>eCorsa</td>
		  <td>105000</td>
		  <td>1999</td>
		  <td>2100</td>
		  <td>160</td>
		  <td>Benzyna</td>
		  <td>10050</td>
		  <td>10-10-2018</td>
		  <td>1</td>
		  <td>zdjecie</td>
		  <td>Tak</td>
		</tr>
		<tr class="item">
		  <td>2</td>
		  <td>Opel</td>
		  <td>aCorsa</td>
		  <td>205000</td>
		  <td>1995</td>
		  <td>2300</td>
		  <td>150</td>
		  <td>LPG</td>
		  <td>999999</td>
		  <td>10-11-2018</td>
		  <td>2</td>
		  <td>zdjecie</td>
		  <td>Nie</td>
		</tr>
		<tr class="item">
		  <td>3</td>
		  <td>Subaru</td>
		  <td>bCorsa</td>
		  <td>342484</td>
		  <td>2001</td>
		  <td>1400</td>
		  <td>70</td>
		  <td>Diesel</td>
		  <td>109900</td>
		  <td>10-10-2017</td>
		  <td>3</td>
		  <td>zdjecie</td>
		  <td>Tak</td>
		</tr>
	  </tbody>
	</table>
</div>


<div class="container">
	<div class ="row">
		<div class="col-md-2 offset-md-5">
			<div class="btn-group" role="group" aria-label="Basic example">
				
				<button class="btn btn-success" data-target="#addModal" data-toggle="modal">Dodaj</button>
				<button class="btn btn-warning" data-target="#editModal" data-toggle="modal">Edytuj</button>
				<button class="btn btn-danger" data-target="#deleteModal" data-toggle="modal">Usuń</button>
			</div>
			
			<div class="modal" id="deleteModal" tabindex="-1">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<div class="modal-header">
							<button class="close" data-dismiss="modal">&times;</button>
						</div>
						<div class="modal-body">
							<form>
								<div class="form-group">
									<label for="inputID">ID Pojazdu</label>
									<input class="form-control" type="text" id="ID"></input>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button class="btn btn-primary" data-dismiss="modal">Anuluj</button>
							<button class="btn btn-primary">Potwierdz</button>
						</div>
					</div>
				</div>
			</div>	
			<div class="modal" id="addModal" tabindex="-1">
			
			
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<div class="modal-header">
							<button class="close" data-dismiss="modal">&times;</button>
						</div>
						<div class="modal-body">
							<form>
								<div class="form-group">
									<label for="inputBrand">Marka</label>
									<input class="form-control" type="text" id="Brand"></input>
								</div>
								<div class="form-group">
									<label for="inputModel">Model</label>
									<input class="form-control" type="text" id="Model"></input>
								</div>
								<div class="form-group">
									<label for="inputMileage">Przebieg</label>
									<input class="form-control" type="text" id="Mileage"></input>
								</div>
								<div class="form-group">
									<label for="inputYear">Rok Produkcji</label>
									<input class="form-control" type="text" id="Year"></input>
								</div>
								<div class="form-group">
									<label for="inputEngineCapacity">Pojemność Silnika</label>
									<input class="form-control" type="text" id="EngineCapacity"></input>
								</div>
								<div class="form-group">
									<label for="inputPower">Moc Silnika</label>
									<input class="form-control" type="text" id="Power"></input>
								</div>
								<div class="form-group">
									<label for="inputFuel">Rodzaj Paliwa</label>
									<input class="form-control" type="text" id="Fuel"></input>
								</div>
								<div class="form-group">
									<label for="inputPrize">Cena</label>
									<input class="form-control" type="text" id="Prize"></input>
								</div>
								<div class="form-group">
									<label for="inputDate">Data Wystawienia</label>
									<input class="form-control" type="text" id="Date"></input>
								</div>
								<div class="form-group">
									<label for="inputSeller">ID sprzedającego</label>
									<input class="form-control" type="text" id="Seller"></input>
								</div>
								<div class="form-group">
									<label for="inputPhoto">Zdjęcie</label>
									<input class="form-control" type="text" id="Photo"></input>
								</div>
								<div class="form-group">
									<label for="inputAccident">Bezwypadkowy</label>
									<input class="form-control" type="text" id="Accident"></input>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button class="btn btn-primary" data-dismiss="modal">Anuluj</button>
							<button class="btn btn-primary">Potwierdz</button>
						</div>
					</div>
				</div>
			</div>	
			<div class="modal" id="editModal" tabindex="-1">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						<div class="modal-header">
							<button class="close" data-dismiss="modal">&times;</button>
						</div>
						<div class="modal-body">
							<form>
								<div class="form-group">
									<label for="inputID">ID Pojazdu</label>
									<input class="form-control" type="text" id="ID"></input>
								</div>
								<div class="form-group">
									<label for="inputBrand">Marka</label>
									<input class="form-control" type="text" id="Brand"></input>
								</div>
								<div class="form-group">
									<label for="inputModel">Model</label>
									<input class="form-control" type="text" id="Model"></input>
								</div>
								<div class="form-group">
									<label for="inputMileage">Przebieg</label>
									<input class="form-control" type="text" id="Mileage"></input>
								</div>
								<div class="form-group">
									<label for="inputYear">Rok Produkcji</label>
									<input class="form-control" type="text" id="Year"></input>
								</div>
								<div class="form-group">
									<label for="inputEngineCapacity">Pojemność Silnika</label>
									<input class="form-control" type="text" id="EngineCapacity"></input>
								</div>
								<div class="form-group">
									<label for="inputPower">Moc Silnika</label>
									<input class="form-control" type="text" id="Power"></input>
								</div>
								<div class="form-group">
									<label for="inputFuel">Rodzaj Paliwa</label>
									<input class="form-control" type="text" id="Fuel"></input>
								</div>
								<div class="form-group">
									<label for="inputPrize">Cena</label>
									<input class="form-control" type="text" id="Prize"></input>
								</div>
								<div class="form-group">
									<label for="inputDate">Data Wystawienia</label>
									<input class="form-control" type="text" id="Date"></input>
								</div>
								<div class="form-group">
									<label for="inputSeller">ID sprzedającego</label>
									<input class="form-control" type="text" id="Seller"></input>
								</div>
								<div class="form-group">
									<label for="inputPhoto">Zdjęcie</label>
									<input class="form-control" type="text" id="Photo"></input>
								</div>
								<div class="form-group">
									<label for="inputAccident">Bezwypadkowy</label>
									<input class="form-control" type="text" id="Accident"></input>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button class="btn btn-primary" data-dismiss="modal">Anuluj</button>
							<button class="btn btn-primary">Potwierdz</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- Search Function-->
<script type="text/javascript">
	function getID() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myID");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[0];
		if (td) {
		  if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
			tr[i].style.display = "";
		  } else {
			tr[i].style.display = "none";
		  }
		}
	  }
	}
	</script>

	<script type="text/javascript">
	function getBrand() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myBrand");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[1];
		if (td) {
		  if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
			tr[i].style.display = "";
		  } else {
			tr[i].style.display = "none";
		  }
		}
	  }
	}
	</script>


	<script type="text/javascript">
	function getModel() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myModel");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[2];
		if (td) {
		  if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
			tr[i].style.display = "";
		  } else {
			tr[i].style.display = "none";
		  }
		}
	  }
	}
	</script>


	<script type="text/javascript">
	function getMileage() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myMileage");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[3];
		if (td) {
		  if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
			tr[i].style.display = "";
		  } else {
			tr[i].style.display = "none";
		  }
		}
	  }
	}
	</script>

	<script type="text/javascript">
	function getYear() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myYear");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[4];
		if (td) {
		  if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
			tr[i].style.display = "";
		  } else {
			tr[i].style.display = "none";
		  }
		}
	  }
	}
	</script>


	<script type="text/javascript">
	function getEngineCapacity() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myEngineCapacity");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[5];
		if (td) {
		  if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
			tr[i].style.display = "";
		  } else {
			tr[i].style.display = "none";
		  }
		}
	  }
	}
	</script>


<script type="text/javascript">
	function getPower() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myPower");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[6];
		if (td) {
		  if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
			tr[i].style.display = "";
		  } else {
			tr[i].style.display = "none";
		  }
		}
	  }
	}
	</script>




		<script type="text/javascript">
	function getFuel() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myFuel");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[7];
		if (td) {
		  if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
			tr[i].style.display = "";
		  } else {
			tr[i].style.display = "none";
		  }
		}
	  }
	}
	</script>


	<script type="text/javascript">
	function getPrize() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myPrize");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[8];
		if (td) {
		  if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
			tr[i].style.display = "";
		  } else {
			tr[i].style.display = "none";
		  }
		}
	  }
	}
	</script>


	<script type="text/javascript">
	function getDate() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myDate");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[9];
		if (td) {
		  if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
			tr[i].style.display = "";
		  } else {
			tr[i].style.display = "none";
		  }
		}
	  }
	}
	</script>


	<script type="text/javascript">
	function getSeller() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("mySeller");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[10];
		if (td) {
		  if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
			tr[i].style.display = "";
		  } else {
			tr[i].style.display = "none";
		  }
		}
	  }
	}
	</script>


	<script type="text/javascript">
	function getPhoto() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myPhoto");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[11];
		if (td) {
		  if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
			tr[i].style.display = "";
		  } else {
			tr[i].style.display = "none";
		  }
		}
	  }
	}
	</script>


	<script type="text/javascript">
	function getAccident() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myAccident");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[12];
		if (td) {
		  if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
			tr[i].style.display = "";
		  } else {
			tr[i].style.display = "none";
		  }
		}
	  }
	}
	</script>


	<!-- Sort Function-->
	<script type="text/javascript">
	function sortTable(n) {
	  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
	  table = document.getElementById("myTable");
	  switching = true;
	  // Set the sorting direction to ascending:
	  dir = "asc";
	  /* Make a loop that will continue until
	  no switching has been done: */
	  while (switching) {
		// Start by saying: no switching is done:
		switching = false;
		rows = table.rows;
		/* Loop through all table rows (except the
		first, which contains table headers): */
		for (i = 1; i < (rows.length - 1); i++) {
		  // Start by saying there should be no switching:
		  shouldSwitch = false;
		  /* Get the two elements you want to compare,
		  one from current row and one from the next: */
		  x = rows[i].getElementsByTagName("td")[n];
		  y = rows[i + 1].getElementsByTagName("td")[n];
		  /* Check if the two rows should switch place,
		  based on the direction, asc or desc: */
		  if (dir == "asc") {
			if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
			  // If so, mark as a switch and break the loop:
			  shouldSwitch = true;
			  break;
			}
		  } else if (dir == "desc") {
			if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
			  // If so, mark as a switch and break the loop:
			  shouldSwitch = true;
			  break;
			}
		  }
		}
		if (shouldSwitch) {
		  /* If a switch has been marked, make the switch
		  and mark that a switch has been done: */
		  rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
		  switching = true;
		  // Each time a switch is done, increase this count by 1:
		  switchcount ++;
		} else {
		  /* If no switching has been done AND the direction is "asc",
		  set the direction to "desc" and run the while loop again. */
		  if (switchcount == 0 && dir == "asc") {
			dir = "desc";
			switching = true;
		  }
		}
	  }
	}
	</script>
</body>
</html>












