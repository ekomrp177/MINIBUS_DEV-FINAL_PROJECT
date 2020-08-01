        <!-- Begin Page Content -->
        <div class="container-fluid">

            <!-- Page Heading -->
            <h1 class="h3 mb-4 text-gray-800"><?= $title ?></h1>

            <div class="mb-3 mx-auto  ">
                <?= $this->session->flashdata('message'); ?>
                <h5>Level : <?= $level['level'] ?></h5>
                <div class="row no-gutters">
                    <div class="col">

                        <table class="table table-hover table-responsive">
                            <thead class="bg-gradient-primary text-white">
                                <tr>
                                    <th scope="col">No</th>
                                    <th scope="col">menu</th>
                                    <th scope="col">access</th>
                                </tr>
                            </thead>
                            <tbody>
                                <?php $i = 1 ?>
                                <?php foreach ($menu as $m) : ?>
                                    <tr>
                                        <th scope="row"><?= $i ?></th>
                                        <td><?= $m['menu'] ?></td>
                                        <td>
                                            <div class="form-check">
                                                <input type="checkbox" class="form-check-input" <?= check_access($level['id'], $m['id']); ?> data-level="<?= $level['id'] ?>" data-menu="<?= $m['id'] ?>">
                                            </div>
                                        </td>
                                    </tr>
                                    <?php $i++ ?>
                                <?php endforeach; ?>
                            </tbody>
                        </table>
                        <a href="<?= base_url('admin/level/') ?>" class="btn btn-primary">Back</a>
                    </div>
                </div>
                <hr class=" sidebar-divider ">

            </div>

        </div>
        <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->