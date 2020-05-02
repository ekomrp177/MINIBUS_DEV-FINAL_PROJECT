<?php
  include 'connection.php';

$data = mysqli_query($connect,"SELECT *FROM wisata");

if( isset($_POST["Search"])){
  $key=$_POST["keyword"];
  $data = mysqli_query($connect,"SELECT * FROM wisata where name like '%$key%'
  or jam_buka like'%$key%' or harga like'%$key%'");
}

?>



<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>KANCAPLESIR</title>
  </head>
  <body>
   
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
    
      <a class="navbar-brand" href="#">
      <h1 >KANCA PLESIR</h1>
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav"> 
           <a class="nav-item nav-link" href="wisata.php">wisata</a> 
           <a class="nav-item nav-link" href="kuliner.php">kuliner</a>  
        </div>
      </div>
    </div>
  </nav>
   <div class="container">
  <form action="" method="POST">
    <div class="row mt-3 justify-content-center">
      <div class="col-md-10">      
        <h1 class="text-center">Search Wisata </h1>
          <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="wisata..." name="keyword" >
            <div class="input-group-append">
           <button class="btn btn-dark" type="submit" text-align="left" name="Search">Search</button>
            </div>
          </div>
      </div>
    </div>
    <hr>
  </form>
  </div>


  <div class="container">
  
    <div class="row">
      <div class="col" style=" font-family: alegreya; ">      
        <h1>Wisata</h1>
      </div>
    </div>
    <div class="row">
      <?php foreach($data as $row): ?>
      <div class="col-md-4 lg-4 d-flex align-items-stretch">      
        <div class="card mb-4 shadow p-3 mb-5 bg-white rounded" style="max-width: 100%;">
        <img src="img/gambar.png" class="card-img-top">
          <div class="card-body">
            <h5 class="card-title"><?= $row["Name"];?></h5>
            <hr>  
            <p class="card-text"><?= $row["jam_buka"];?></p>
            <?php if($row["harga"] == "Free") {?>
                <h5 class="card-title"> <?= $row["harga"];?></h5>
            <?php } ?>
             <?php if($row["harga"] != "Free"){ ?>
                <h5 class="card-title"> Rp <?= $row["harga"];?></h5>
            <?php }?>     
             <p class="card-text"><?= $row["alamat"];?></p>
          </div>
           <div class="card-footer text-muted">
             <a href="detailwisata.php?id_wisata=<?php echo $row["id"]?>" class="btn btn-dark" role="button">detail</a>
          </div>
        </div>
      </div>
      <?php endforeach; ?>
    </div>
  </div>




    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script
    src="https://code.jquery.com/jquery-3.5.0.js"
    integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc="
    crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    

  </body>
</html>