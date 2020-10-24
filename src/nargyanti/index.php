<!DOCTYPE html>
<html>
	<head>
		<title>Mama's Recipe</title>
		<link rel="stylesheet" href="style.css">
	</head>
	<body>
		<nav>
			<?php include 'components/nav.php';?>
		</nav>
		<header>
			<div class="header-caption">
			<?php include 'components/header-caption.php';?>
			</div>
		</header>
		<main>
			<div id="content">
				<h1>Recipe List</h1>
				<div class="card">
					<h2>Sugar Pie</h2>
					<img src="img/sugar-pie.jpg" alt="Sugar Pie">
					<form action="sugar-pie.php">
            			<input class="button" type="submit" value="Details">
        			</form>					
				</div>

				<div class="card">
					<h2>Mince Pie</h2>
					<img src="img/mince-pie.jpg" alt="Mince Pie">
					<form action="mince-pie.php">
            			<input class="button" type="submit" value="Details">
        			</form>					
				</div>

				<div class="card">
					<h2>Pumpkin Pie</h2>
					<img src="img/pumpkin-pie.jpg" alt="Pumpkin Pie">
					<form action="pumpkin-pie.php">
            			<input class="button" type="submit" value="Details">
        			</form>					
				</div>

				<div class="card">
					<h2>Three Fish Pie</h2>
					<img src="img/three-fish-pie.jpg" alt="Three Fish Pie">
					<form action="three-fish-pie.php">
            			<input class="button" type="submit" value="Details">
        			</form>					
				</div>				
			</div>
		</main>
		<footer>
			<?php include 'components/footer.php';?>
		</footer>
	</body>
</html>
