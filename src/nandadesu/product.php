<?php
session_start();
require_once("connection.php");

$db_handle = new DBController();
?>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>IKIA - Solusi rumah anda</title>

        <!-- CSS / JS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/footer.css">
        <link rel="stylesheet" href="./css/product.css">
    </head>

    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
            <a class="navbar-brand" href="index.php">
                <img src="./assets/img/logo.png" width="80" height="30" alt="">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="index.php">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about.php">About</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="product.php">Product</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav ml-auto">
                    <?php
                    if (isset($_SESSION["loggedin"]) && $_SESSION["loggedin"] === true) {
                        ?>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-user-circle"></i>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="account.php">Account Information</a>
                                <a class="dropdown-item" href="logout.php">Logout</a>
                            </div>
                        </li>
                    <?php
                    } else {
                        ?>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-user-circle"></i>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="login.php">Login</a>
                                <a class="dropdown-item" href="register.php">Register</a>
                            </div>
                        </li>
                    <?php
                    }
                    ?>
                    <li class="nav-item">
                        <button type="button" class="btn btn-link"><a href="cart.php"><i class="fas fa-shopping-cart"></i></a></button>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container-fluid mt-2 mb-4">
            <div id="product-grid">
                <div class="txt-heading">
                    <h1>Products</h1>
                </div>
                <div class="row">
                    <?php
                    $product_array = $db_handle->runQuery("SELECT * FROM products WHERE category = 'interior' AND id > 0 AND id <= 4 ORDER BY id ASC");
                    if (!empty($product_array)) {
                        foreach ($product_array as $key => $value) {
                            ?>
                            <div class="col-3">
                                <div class="card" style="width: 18rem;">
                                    <form method="post" action="cart.php?action=add&code=<?php echo $product_array[$key]["code"]; ?>">
                                        <img src="<?php echo $product_array[$key]["image"]; ?>" class="card-img-top" alt="...">
                                        <div class="card-body">
                                            <h5 class="card-title"><?php echo $product_array[$key]["merk"]; ?></h5>
                                            <p class="card-text">Starting from Rp.<?php echo "" . $product_array[$key]["price"]; ?></p>
                                            <div class="cart-action"><input type="number" class="product-quantity" name="quantity" value="1" size="2" /><button type="submit" value="Add to Cart" class="btn btn-success">Beli</div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                    <?php
                        }
                    }
                    ?>
                </div>
                <br>
                <div class="row">
                    <?php
                    $product_array = $db_handle->runQuery("SELECT * FROM products WHERE category = 'interior' AND id > 4 AND id < 9 ORDER BY id ASC");
                    if (!empty($product_array)) {
                        foreach ($product_array as $key => $value) {
                            ?>
                            <div class="col-3">
                                <div class="card" style="width: 18rem;">
                                    <form method="post" action="cart.php?action=add&code=<?php echo $product_array[$key]["code"]; ?>">
                                        <img src="<?php echo $product_array[$key]["image"]; ?>" class="card-img-top" alt="...">
                                        <div class="card-body">
                                            <h5 class="card-title"><?php echo $product_array[$key]["merk"]; ?></h5>
                                            <p class="card-text">Starting from Rp.<?php echo "" . $product_array[$key]["price"]; ?></p>
                                            <div class="cart-action"><input type="number" class="product-quantity" name="quantity" value="1" size="2" /><button type="submit" value="Add to Cart" class="btn btn-success">Beli</div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                    <?php
                        }
                    }
                    ?>
                </div>
            </div>
        </div>

        <footer id="footer-Section">
            <div class="footer-top-layout">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="footer-col-item">
                                <h4>Address</h4>
                                <address>
                                    Gedung Sipil Lt 5 - 7 <br>
                                    Politeknik Negeri Malang
                                </address>
                            </div>
                        </div>
                        <div class="col">
                            <div class="footer-col-item">
                                <h4>Contact Us</h4>
                                <div class="item-contact">
                                    <a href="tel:630-885-9200"><span class="link-id">Phone</span>:<span>+628-1234-5678-910</span>
                                        <a href="mailto:info@brandcatmedia.com"><span class="link-id">E-Mail</span>:<span>support@ikia.com</span></a>
                                </div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="footer-col-item">
                                <h4>Subscribe</h4>
                                <form class="signUpNewsletter" action="" method="get">
                                    <input name="" class="gt-email form-control" placeholder="You@youremail.com" type="text">
                                    <input name="" class="btn-go" value="Go" type="button">
                                </form>
                            </div>
                        </div>
                    </div>
                </div><br>
                <div class="socialMedia-footer">
                    <a href="#"><i class="fab fa-facebook-square"></i></a>
                    <a href="#"><i class="fab fa-twitter"></i></a>
                    <a href="#"><i class="fab fa-instagram"></i></a>
                    <a href="#"><i class="fab fa-youtube"></i></a>
                </div>

                <div class="copyright-tag">Copyright © 2019. All Rights Reserved.</div>
            </div>
        </footer>

        <!-- JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script defer src="https://kit.fontawesome.com/abee8333cb.js"></script>
    </body>

    </html>