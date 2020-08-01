        <!-- Begin Page Content -->
        <div class="container-fluid">

            <!-- Page Heading -->
            <h1 class="h3 mb-4 text-gray-800"><?= $title ?></h1>
        </div>
        <div class="row ml-3">
            <div class="col-lg-8">

                <?= $this->session->flashdata('message'); ?>

                <form action="<?= base_url('user/changepassword') ?>" method="post">
                    <div class="form-group">
                        <label for="curent_password">Current Password</label>
                        <input type="password" class="form-control form-control-user" id="curent_password" name="curent_password">
                        <?= form_error('curent_password', '<small class="text-danger pl-3">', ' </small>') ?>
                    </div>
                    <div class="form-group">
                        <label for="new_password1">New Password</label>
                        <input type="password" class="form-control form-control-user" id="new_password1" name="new_password1">
                        <?= form_error('new_password1', '<small class="text-danger pl-3">', ' </small>') ?>
                    </div>
                    <div class="form-group">
                        <label for="new_password2">repeat Password</label>
                        <input type="password" class="form-control form-control-user" id="new_password2" name="new_password2">
                        <?= form_error('new_password2', '<small class="text-danger pl-3">', ' </small>') ?>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary" type="submit">Change Password</button>
                    </div>
                </form>
            </div>
        </div>
        <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->