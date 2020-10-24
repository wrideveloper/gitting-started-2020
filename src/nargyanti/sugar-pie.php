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
				<h1>Sugar Pie</h1>
                <img src="img/sugar-pie.jpg" alt="Sugar Pie">
                <div id="ingredients">
                    <h2>Ingredients: </h2>
                    <ul>
                        <li>Brown Sugar - 2 cups</li>
                        <li>Butter - ¼ cup</li> 
                        <li>Eggs - 2</li>
                        <li>Vanilla Extract - 1 tsp</li>
                        <li>Salt - 1 tsp</li> 
                        <li>Plain Flour - ½ cup</li> 
                        <li>Milk - 1 ½ cups</li> 
                    </ul>
                </div>
                <div id="steps">
                    <h2>Steps: </h2>
                    <ol>
                        <li>Preheat oven to 350 degrees F (175 degrees C).</li>
                        <li>Grease a 9-inch pie dish.</li>
                        <li>Place the brown sugar and butter in a mixing bowl, and beat them together with an electric mixer until creamy and very well combined, without lumps.</li>
                        <li>Beat in eggs, one at a time, incorporating the first egg before adding the next one.</li>
                        <li>Add the vanilla extract and salt; beat the flour in, a little at a time, and then the milk, making a creamy batter.</li>
                        <li>Pour the batter into the prepared pie dish.</li>
                        <li>Bake in the preheated oven for 35 minutes; remove pie, and cover the rim with aluminum foil to prevent burning.</li>
                        <li>Return to oven, and bake until the middle sets and the top forms a crusty layer, about 15 more minutes.</li>
                        <li>Let the pie cool to room temperature, then refrigerate for at least 1 hour before serving.</li>
                    </ol>
                </div>
			</div>
		</main>
		<footer>
			<?php include 'components/footer.php';?>
		</footer>
	</body>
</html>
