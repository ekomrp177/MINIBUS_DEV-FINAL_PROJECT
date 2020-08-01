        <!-- Begin Page Content -->
        <div class="container-fluid">

            <!-- Page Heading -->
            <h1 class="h3 mb-4 text-gray-800" hidden><?= $title ?></h1>
            <h1 class="h3 mb-4 text-gray-800"><?= $title ?> user table</h1>
            <div class="mb-3 mx-auto  ">
                <?= $this->session->flashdata('message'); ?>
                <div class=" row no-gutters">
                    <div class="col">
                        <table class="table table-hover table-responsive">
                            <thead class="bg-gradient-primary text-white">
                                <tr>
                                    <th scope="col">No</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">email</th>
                                    <th scope="col">level</th>
                                    <th scope="col">statuse</th>
                                    <th scope="col">date created</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <?php $i = 1 ?>
                                <?php foreach ($usershow as $us) : ?>

                                    <?php
                                    $level = $us['level_user'];
                                    $status = $us['statuse_in_active'];
                                    if ($level == '2') {
                                        $level = "member";
                                    } else {
                                        $level = "admin";
                                    }
                                    if ($status == '1') {
                                        $status = "active";
                                    } else {
                                        $status = "not activated";
                                    }

                                    ?>


                                    <tr>
                                        <th scope="row"><?= $i ?></th>
                                        <td><?= $us['name'] ?></td>
                                        <td><?= $us['email'] ?></td>
                                        <td><?= $level ?></td>
                                        <td><?= $status ?></td>
                                        <td><?= $us['date_created'] ?></td>
                                        <td>
                                            <a href=" <?= base_url('admin/deleteuser/'), $us['id'] ?>" class="btn btn-danger mx-auto mb-3 " onclick="return confirm('Sure want To delete ? ')">delete</a>
                                        </td>
                                    </tr>
                                    <?php $i++ ?>
                                <?php endforeach; ?>
                            </tbody>
                        </table>
                    </div>
                </div>
                <hr class="sidebar-divider ">
            </div>

        </div>
        <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->