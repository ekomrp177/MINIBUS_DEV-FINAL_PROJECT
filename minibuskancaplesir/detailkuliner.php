<?php
  include 'connection.php';
$id = $_GET["id_kuliner"];
$data = mysqli_query($connect,"SELECT * FROM kuliner where id = '$id' ");

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
      <h1>KANCA PLESIR</h1>
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


<div class="card text-center">
  <div class="card-header">
    kuliner
  </div>
 
	<?php foreach($data as $row): ?> 
	<div class="card mb-4 mt-4 mx-auto shadow p-3 mb-5 bg-white rounded" style="max-width: 80%;">
	  <div class="row no-gutters mb-2 mt-2">
	    <div class="col">
	      <img src="img/gambar.png" class="card-img" alt="...">
	    </div>
	    <div class="col-md-8 text-left">
	      <div class="card-body">
	        <h5 class="card-title"><?= $row["Name"];?></h5>
	        <hr>
	        <p class="card-text"><?= $row["description"];?></p>
	         <?php if($row["harga"] == "Free") {?>
			 <h5 class="card-title">Harga/Tiket <b><?= $row["harga"];?></b></h5>
			 <?php } ?>
			 <?php if($row["harga"] != "Free"){ ?>
			     <h5 class="card-title">Harga/Tiket Rp <b> <?= $row["harga"];?></b></h5>
			 <?php }?>
	        <p class="card-text"><small class="text-muted">alamat : <?= $row["alamat"];?></small></p>

	      </div>
	    </div>
	  </div>
	   <div class="card-footer text-muted">
   			 <a href="wisata.php" class="btn btn-dark">Back</a>
  		</div>
	</div>

	<?php endforeach;?>

  <div class="card-footer text-muted">
    enjoy with KANCA PLESIR
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