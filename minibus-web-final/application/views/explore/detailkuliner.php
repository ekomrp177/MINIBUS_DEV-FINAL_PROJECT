<!-- Begin Page Content -->

<!-- /.container-fluid -->
<div class="row ml-5">
    <div class="container-fluid">
        <!-- Page Heading -->
        <h1 class="h3 mb-4 text-gray-800 mx-auto"><?= $title ?> kuliner</h1>
    </div>
</div>
<div class="row ml-5">
    <?php foreach ($kuliner as $row) : ?>
        <?php if ($row['id'] == $id) { ?>
            <div class="card mb-3 ml-2 mr-5">
                <img class="card-img-top img-fluid" src="<?= $row["images"]; ?>" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title"><?= $row["fullname"] ?></h5>
                    <h6 class="card-text"><?= $row["harga"]; ?></h6>
                    <p class="card-text"><?= $row["desc"]; ?></p>
                    <p class="card-text"><small class="text-muted"><?= $row["alamat"]; ?></small></p>
                    <p class="card-text"><small class="text-muted">open : <?= $row["jam_buka"]; ?></small></p>
                    <p class="card-text"><small class="text-muted">close : <?= $row["jam_tutup"]; ?> </small></p>
                    <a href="<?= base_url('explore') ?>" class="btn btn-primary">Back</a>
                </div>
            </div>
        <?php } ?>
    <?php endforeach; ?>
</div>
</div>
<!-- End of Main Content -->