<!-- Begin Page Content -->

<!-- /.container-fluid -->
<div id="loading" style="display:none;">
    Loading Please Wait....
    <img src="ajax-loader.gif" alt="Loading" />
</div>
<div class="row ml-5">
    <div class="container-fluid">
        <!-- Page Heading -->
        <h1 class="h3 mb-4 text-gray-800 mx-auto"><?= $title ?> wisata</h1>
    </div>
    <?php foreach ($wisata as $row) : ?>
        <div class="card mr-5 mb-5" style="width: 18rem;">
            <img class="card-img-top" src="<?= $row["images"]; ?>" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title"><?= $row["fullname"]; ?></h5>
                <p class="card-text"><?= $row["harga"]; ?></p>

            </div>
            <div class="card-footer text-muted">
                <a href="<?= base_url('explore/detailwisata/'), $row['id'] ?>" class="btn btn-primary">Detail</a>
            </div>
        </div>
    <?php endforeach; ?>
</div>
<div class="row ml-5 mt-5">
    <div class="container-fluid">
        <!-- Page Heading -->
        <h1 class="h3 mb-4 text-gray-800 mx-auto"><?= $title ?> kuliner</h1>
    </div>
    <?php foreach ($kuliner as $row) : ?>
        <div class="card mr-5 mb-5" style="width: 18rem;">
            <img class="card-img-top" src="<?= $row["images"]; ?>" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title"><?= $row["fullname"]; ?></h5>
                <p class="card-text"><?= $row["harga"]; ?></p>
            </div>
            <div class="card-footer text-muted">
                <a href="<?= base_url('explore/detailkuliner/'), $row['id'] ?>" class="btn btn-primary">Detail</a>
            </div>
        </div>
    <?php endforeach; ?>
</div>
</div>
<!-- End of Main Content -->