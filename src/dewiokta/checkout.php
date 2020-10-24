<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="cart.css">
</head>
<body>
    <?php
    session_start();
    include 'konek.php';

    if (!isset($_SESSION["user"])) {
        echo "<script>alert('Silahkan Login ');</scrip>";
        header("Location: login.php");
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
        </tr>
    </thead>
    <tbody>
        <?php $no=1;?>
        <?php $total=0; ?>
        <?php if(isset($_SESSION["keranjang"])) foreach ($_SESSION['keranjang'] as $id_produk => $jumlah): ?>
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
            
        </tr>
        <?php $no++;?>
        <?php $total+=$subtotal; ?> 
        <?php endforeach ?>
    </tbody>
    <tfoot>
            <tr>
                <th colspan="4" class="y">Total Belanja</th>
                <th>Rp. <?php echo number_format($total)?></th>
            </tr>
    </tfoot>
</table>

<form method="post">
<div class="table-2">
    <div class="col-md-3">
        <div class="form">
            <input type="text" readonly value="<?php echo $_SESSION["user"]["nama"]
            ?>" class="control">
        </div>
    </div>
    <div class="col-md-3">
    <div class="form">
            <input type="text" readonly value="<?php echo $_SESSION["user"]["username"]
            ?>" class="control">
        </div>
    </div>
    <div class="col-md-3">
    <div class="form">
            <input type="text" readonly value="<?php echo $_SESSION["user"]['no_telp']
            ?>" class="control">
        </div>
    </div>
    <div class="col-md-3">
    <div class="form">
            <input type="text" readonly value="<?php echo $_SESSION["user"]['alamat']
            ?>" class="control">
        </div>
    </div>
    <div class="col-md-3">
        <select name="id_ongkir" class="control">
            <option value="">Pilih Alamat</option>
            <?php
            $ambil= $connect->query("SELECT*FROM ongkir");
            while ($ongkir = $ambil->fetch_assoc()) {
                ?>
                <option value="<?php echo $ongkir["id_ongkir"]?>">
                    <?php echo $ongkir['kota']?>
                    Rp.<?php echo number_format ($ongkir['tarif'])?>
                </option>
           <?php } ?>
        </select>
    </div>
</div>
<button class="klik" name="checkout">Checkout</button>
</form>
<?php
    if (isset($_POST["checkout"])) {
        $id_pelanggan =$_SESSION["user"]["id"];
        $id_ongkir=$_POST["id_ongkir"];
        $tgl_beli =date('y-m-d H:i:s');

        $ambil = $connect->query("SELECT*FROM ongkir where 
        id_ongkir = '$id_ongkir'");
        $arrayongkir = $ambil->fetch_assoc();
        $tarif = $arrayongkir['tarif'];

        $total_beli = $total + $tarif;

        $connect->query("INSERT INTO pembelian(id_pelanggan,id_ongkir,tanggal_beli,total) 
        VALUES ('$id_pelanggan','$id_ongkir',Now(),'$total_beli')");

        $id_new=$connect->insert_id;
        foreach($_SESSION["keranjang"] as $id_produk => $jumlah){
            $connect->query("INSERT INTO pembelian_produk (id_pembelian,id_produk,jumlah) 
            VALUES ('$id_new','$id_produk','$jumlah')");
            
        }
        unset($_SESSION["keranjang"]);
        echo "<script>alert('Pembelian sukses!');</script>";
        header("location: nota.php?id=$id_new");
    }
?>

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