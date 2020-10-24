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
				<h1>Three Fish Pie</h1>
                <img src="img/three-fish-pie.jpg" alt="Three Fish Pie">
                <div id="ingredients">
                    <h2>Ingredients: </h2>
                    <ul>
                       <li>Potatoes - 1kg</li> 
                       <li>Butter - Knob</li>
                       <li>Milk - Dash</li>
                       <li>Gruyère - 50g</li>
                       <li>Butter - 75g</li>
                       <li>Leek - 2 sliced</li>
                       <li>Plain Flour - 75g</li>
                       <li>White Wine - 150ml</li>
                       <li>Milk - 568ml</li>
                       <li>Parsley - 2 tbs chopped</li>
                       <li>Salmon - 250g</li>
                       <li>Haddock - 250g</li>
                       <li>Smoked Haddock - 250g</li>
                       <li>Eggs - 6</li>
                    </ul>
                </div>
                <div id="steps">
                    <h2>Steps: </h2>
                    <ol>
                        <li>Preheat the oven to 200C/400F/Gas 6 (180C fan).</li>
                        <li>Put the potatoes into a saucepan of cold salted water.</li>
                        <li>Bring up to the boil and simmer until completely tender.</li>
                        <li>Drain well and then mash with the butter and milk.</li>
                        <li>Add pepper and taste to check the seasoning.</li>
                        <li>Add salt and more pepper if necessary.</li>
                        <li>For the fish filling, melt the butter in a saucepan, add the leeks and stir over the heat.</li>
                        <li>Cover with a lid and simmer gently for 10 minutes, or until soft.</li>
                        <li>Measure the flour into a small bowl.</li>
                        <li>Add the wine and whisk together until smooth.</li>
                        <li>Add the milk to the leeks, bring to the boil and then add the wine mixture.</li>
                        <li>Stir briskly until thickened.</li>
                        <li>Season and add the parsley and fish.</li>
                        <li>tir over the heat for two minutes, then spoon into an ovenproof casserole.</li>
                        <li>Scatter over the eggs.</li>
                        <li>Allow to cool until firm.</li>
                        <li>Spoon the mashed potatoes over the fish mixture and mark with a fork.</li>
                        <li>Sprinkle with cheese.</li>
                        <li>Bake for 30-40 minutes, or until lightly golden-brown on top and bubbling around the edges.</li>
                    </ol>
                </div>
			</div>
		</main>
		<footer>
			<?php include 'components/footer.php';?>
		</footer>
	</body>
</html>
