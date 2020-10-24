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
				<h1>Mince Pie</h1>
                <img src="img/mince-pie.jpg" alt="Mince Pie">
                <div id="ingredients">
                    <h2>Ingredients: </h2>
                    <ul>
                        <li>Butter - 225g</li>
                        <li>Plain Flour - 350g</li>
                        <li>Caster Sugar - 100g</li>                         
                        <li>Mincemeat - 280g</li>                        
                        <li>Egg - 1 small</li> 
                        <li>Icing Sugar - Topping</li> 
                    </ul>
                </div>
                <div id="steps">
                    <h2>Steps: </h2>
                    <ol>
                        <li>To make the pastry, rub 225g cold, diced butter into 350g plain flour, then mix in 100g golden caster sugar and a pinch of salt.</li>
                        <li>Combine the pastry into a ball – don’t add liquid – and knead it briefly.</li>
                        <li>The dough will be fairly firm, like shortbread dough. You can use the dough immediately, or chill for later.</li>
                        <li>Preheat the oven to 200C/gas 6/fan 180C.</li>
                        <li>Line 18 holes of two 12-hole patty tins, by pressing small walnut-sized balls of pastry into each hole.</li>
                        <li>Spoon 280g mincemeat into the pies.</li>
                        <li>Take slightly smaller balls of pastry than before and pat them out between your hands to make round lids, big enough to cover the pies.</li>
                        <li>Top the pies with their lids, pressing the edges gently together to seal – you don’t need to seal them with milk or egg as they will stick on their own (The pies may now be frozen for up to 1 month).</li>
                        <li>Beat 1 small egg and brush the tops of the pies.</li>
                        <li>Bake for 20 mins until golden.</li>
                        <li>Leave to cool in the tin for 5 mins, then remove to a wire rack.</li>
                        <li>To serve, lightly dust with icing sugar.</li>
                    </ol>
                </div>
			</div>
		</main>
		<footer>
			<?php include 'components/footer.php';?>
		</footer>
	</body>
</html>
