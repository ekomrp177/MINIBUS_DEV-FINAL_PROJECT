<?php $danau = "danau.jpg"; ?>
<?php $gunung = "gunung.jpg"; ?>
<?php $pantai = "pantai.jpg"; ?>
<?php $sunset = "sunset.jpg"; ?>
<?php $pohon = "hutan.jpg"; ?>

<div class="card text-white">
    <div class="row mr-3 ml-3">
        <img class=" card-img mb-3" src="<?= base_url('assets/img/background/') . $pantai ?>" alt="Card image">
        <div class="col-sm-3">
            <div class="card">
                <img class="card-img-top" src="<?= base_url('assets/img/background/') . $gunung ?>">
            </div>
            <div class="card-img-overlay">
                <div class="card-body text-white mx-auto ">
                    <h4 class="card-title text-right">Mountaint</h4>
                </div>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="card">
                <img class="card-img-top" src="<?= base_url('assets/img/background/') . $pohon ?>">
            </div>
            <div class="card-img-overlay">
                <div class="card-body text-white mx-auto ">
                    <h4 class="card-title text-right">forest</h4>
                </div>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="card">
                <img class="card-img-top" src="<?= base_url('assets/img/background/') . $sunset ?>">
            </div>
            <div class="card-img-overlay">
                <div class="card-body text-white mx-auto ">
                    <h4 class="card-title text-right">sunset</h4>
                </div>
            </div>
        </div>
        <div class=" col-sm-3">
            <div class="card">
                <img class="card-img-top" src="<?= base_url('assets/img/background/') . $danau ?>">
            </div>
            <div class="card-img-overlay">
                <div class="card-body text-white mx-auto ">
                    <h4 class="card-title text-right">lake</h4>
                </div>
            </div>
        </div>
    </div>
    <br>
    <div class="card-img-overlay">
        <div class="card-body text-white mx-auto position-fixed">
            <h1 class="card-title">Kanca Plesir</h1>
            <p class="card-text">Lets go make your holiday more happy with Kanca Plesir</p>
            <a href="<?= base_url('auth') ?>" class="btn btn-primary">Get started</a>
        </div>
    </div>

</div>