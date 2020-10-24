<!DOCTYPE html>
<html>
	<head>
		<title>Mama's Recipe</title>
        <link rel="stylesheet" href="style.css">
        <style>
            #ingredients ul, #steps ol {
                text-align: justify;
                padding: 20px 40px;      
                line-height: 1.5;      
            }
        </style>
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
				<h1>Pumpkin Pie</h1>
                <img src="img/pumpkin-pie.jpg" alt="Pumpkin Pie">
                <div id="ingredients">
                    <h2>Ingredients: </h2>
                    <ul>
                        <li>Pumpkin - 750g</li>
                        <li>Shortcrust Pastry - 350g</li>
                        <li>Plain Flour - Dusting</li>
                        <li>Caster Sugar - 140g</li>
                        <li>Salt - ½ tsp</li>
                        <li>Nutmeg - ½ tsp</li>
                        <li>Cinnamon - 1 tsp</li>
                        <li>Eggs - 2 Beaten</li>
                        <li>Butter - 25g</li>
                        <li>Milk - 175g</li>
                        <li>Icing Sugar - 1 tblsp</li>
                    </ul>
                </div>
                <div id="steps">
                    <h2>Steps: </h2>
                    <ol>
                        <li>Place the pumpkin in a large saucepan, cover with water and bring to the boil.</li>
                        <li>Cover with a lid and simmer for 15 mins or until tender.</li>
                        <li>Drain pumpkin; let cool.</li>
                        <li>Heat oven to 180C/160C fan/gas 4. Roll out the pastry on a lightly floured surface and use it to line a 22cm loose-bottomed tart tin. Chill for 15 mins.</li>
                        <li>Line the pastry with baking parchment and baking beans, then bake for 15 mins.</li>
                        <li>Remove the beans and paper, and cook for a further 10 mins until the base is pale golden and biscuity.</li>
                        <li>Remove from the oven and allow to cool slightly.</li>
                        <li>Increase oven to 220C/200C fan/gas 7.</li>
                        <li>Push the cooled pumpkin through a sieve into a large bowl.</li>
                        <li>In a separate bowl, combine the sugar, salt, nutmeg and half the cinnamon.</li>
                        <li>Mix in the beaten eggs, melted butter and milk, then add to the pumpkin purée and stir to combine.</li>
                        <li>Pour into the tart shell and cook for 10 mins, then reduce the temperature to 180C/160C fan/gas 4.</li>
                        <li>Continue to bake for 35-40 mins until the filling has just set.</li>
                        <li>Leave to cool, then remove the pie from the tin.</li>
                        <li>Mix the remaining cinnamon with the icing sugar and dust over the pie.</li>
                        <li>Serve chilled.</li>
                    </ol>
                </div>
			</div>
		</main>
		<footer>
			<?php include 'components/footer.php';?>
		</footer>
	</body>
</html>
