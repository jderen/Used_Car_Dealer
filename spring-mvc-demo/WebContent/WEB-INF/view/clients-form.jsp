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
	<!-- Navigation Bar -->
	
	<div class="container" align="center">
		<div class ="row">
			<div class="col-md-8 offset-md-2">
			<input type="text" id="myID" onkeyup="getID()" placeholder="ID">
			<input type="text" id="myName" onkeyup="getName()" placeholder="Imię">
			<input type="text" id="mySurname" onkeyup="getSurname()" placeholder="Nazwisko">
			<input type="text" id="myNumber" onkeyup="getNumber()" placeholder="Numer Telefonu">
			<input type="text" id="myStatus" onkeyup="getStatus()" placeholder="Status">
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class ="row">
			<div class="col-md-8 offset-md-2">
				<div class="table-responsive">
					<table class="table table-bordered table-hover" id="myTable">
					  <thead class="thead-light">
						<thead>
						<tr>
							<th onclick="sortTable(0)">ID</th>
							<th onclick="sortTable(1)">Imię</th>
							<th onclick="sortTable(2)">Nazwisko</th>
							<th onclick="sortTable(3)">Numer Telefonu</th>
							<th onclick="sortTable(4)">Status</th>
						</tr>
					  </thead>
					  <tbody>
						<tr class="item">
						  <td>1</td>
						  <td>Piotr</td>
						  <td>Nowak</td>
						  <td>549203842</td>
						  <td>Sprzedawca</td>
						</tr>
						<tr class="item">
						  <td>2</td>
						  <td>Marek</td>
						  <td>Kowalski</td>
						  <td>430356321</td>
						  <td>Kupiec</td>
						</tr>
						<tr class="item">
						  <td>3</td>
						  <td>Marcin</td>
						  <td>Małysz</td>
						  <td>325523859</td>
						  <td>Sprzedawca</td>
						</tr>
					  </tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class ="row">
			<div class="col-md-2 offset-md-5">
				<div class="btn-group" role="group" aria-label="Basic example">
					<button class="btn btn-success" data-target="#addModal" data-toggle="modal">Dodaj</button>
					<button class="btn btn-warning" data-target="#editModal" data-toggle="modal">Edytuj</button>
					<button class="btn btn-danger" data-target="#deleteModal" data-toggle="modal">Usuń</button>
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
										<label for="inputName">Imię</label>
										<input class="form-control" type="text" id="Name"></input>
									</div>
									<div class="form-group">
										<label for="inputSurname">Nazwisko</label>
										<input class="form-control" type="text" id="Surname"></input>
									</div>
									<div class="form-group">
										<label for="inputNumber">Numer Telefonu</label>
										<input class="form-control" type="text" id="Number"></input>
									</div>
									<div class="form-group">
									</div>
									<div class="form-group">
										<label for="inputSurname">Nazwisko</label>
										<input class="form-control" type="text" id="Surname"></input>
									</div>
									<div class="form-group">
										<label for="inputNumber">Numer Telefonu</label>
										<input class="form-control" type="text" id="Number"></input>
									</div>
									<div class="form-group">
										<label for="inputStatus">Status</label>
										<input class="form-control" type="text" id="Status"></input>
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
										<label for="inputID">ID Klienta</label>
										<input class="form-control" type="text" id="ID"></input>
									</div>
									<div class="form-group">
										<label for="inputName">Imię</label>
										<input class="form-control" type="text" id="Name"></input>
									</div>
									<div class="form-group">
										<label for="inputSurname">Nazwisko</label>
										<input class="form-control" type="text" id="Surname"></input>
									</div>
									<div class="form-group">
										<label for="inputNumber">Numer Telefonu</label>
										<input class="form-control" type="text" id="Number"></input>
									</div>
									<div class="form-group">
										<label for="inputStatus">Status</label>
										<input class="form-control" type="text" id="Status"></input>
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
				<div class="modal" id="deleteModal" tabindex="-1">
						<div class="modal-dialog modal-sm">
							<div class="modal-content">
								<div class="modal-header">
									<button class="close" data-dismiss="modal">&times;</button>
								</div>
								<div class="modal-body">
									<form>
										<div class="form-group">
											<label for="inputID">ID Klienta</label>
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
				</div>
		</div>
	</div>



	<!-- Button "Usuń"-->
	<div class="container">
		<div class ="row">
			<div class="col-md-8 offset-md-5">
				
					
			</div>
		</div>
	</div>





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
	function getName() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myName");
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
	function getSurname() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("mySurname");
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
	function getNumber() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myNumber");
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
	function getStatus() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myStatus");
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











