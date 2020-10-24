<?php
session_start();

?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" type="text/css"  href="cart.css">
</head>
<body>
<?php
    include 'konek.php'; // konek.php -> file yang berisi koneksi dengan db
    if (!isset($_SESSION["user"])){
        header("location:login.php");
    }
    ?>
<header>
    <div class="container">
        <div id="brand">
            <img src="img/exol-logo (1).png" alt="">
            <h1 class="wlc"> WELCOME TO AERI SHOP</h1>

        </div>
        <nav>
            <ul>
            <li><a href="beranda.html">Home</a></li>
                <li class="active"><a href="belanja.php">Shop</a></li>
                <li><a href="cart.php">Cart</a></li>
                <?php if (isset($_SESSION["user"])): ?>
                <li><a href="logout.php">Logout</a></li>
                <?php else :?>
                <li><a href="login.php">Login</a></li>
                <?php endif ?>
                <li><a href="checkout.php">Check Out</a></li>
            </ul>
        </nav>
    </div>
</header>
<table  class="table">
    <thead>
        <tr>
            <th>No</th>
            <th>NAMA PRODUK</th>
            <th>HARGA PRODUK</th>
            <th>JUMLAH PRODUK</th>
            <th>SUBTOTAL</th>
            <th>EDIT</th>
        </tr>
    </thead>
    <tbody>
        <?php $no=1;?>
        <?php if(isset($_SESSION["keranjang"])) foreach ($_SESSION["keranjang"] as $id_produk => $jumlah): ?>
        <?php
        $ambil =$connect->query("SELECT*FROM produk where id_produk='$id_produk'");
        $pecah = $ambil->fetch_assoc();
        $subtotal= $pecah["harga_produk"]*$jumlah;
        ?>
        <tr class="table">
            <td><?php echo $no ?></td>
            <td><?php echo $pecah["nama_produk"];?></td>
            <td>Rp.<?php echo number_format($pecah["harga_produk"]);?> </td>
            <td><?php echo $jumlah ?></td>
            <td>Rp.<?php echo number_format($subtotal);?></td>
            <td>
                <a href="hapus.php?id=<?php echo $id_produk?>" class="button1">Hapus</a>
            </td>
        </tr>
        <?php $no++;?>
        <?php endforeach ?>
    </tbody>
</table>
        <br>
        <a href="belanja.php" class="button">Lanjutkan Belanja</a>
        <a href="checkout.php" class="cek">Checkout</a>

        </div>

<section id="boxes">
    <div class="container">
        <div class="box">
            <img src="img/ig.png" alt="">
            <h3>Instagram</h3>
            <p>Follow our Instagram acc @aeri_ina</p>
        </div>

        <div class="box">
            <img src="img/line.png" alt="">
            <h3>Line</h3>
            <p>Follow our Line acc @aeri.exo</p>
        </div>

        <div class="box">
            <img src="img/twitter.jpg" alt="">
            <h3>Twitter</h3>
            <p>Follow our Twitter acc @aeri_ina</p>
        </div>

        <div class="box">
            <img src="img/wa.png" alt="">
            <h3>WhatsApp</h3>
            <p>Call our shop in 010-9282-xxx</p>
        </div>
    </div>

</section>
<footer>
    <p>
        Aeri Shop, Copyright @2020
    </p>
</footer>
</body>
</html>