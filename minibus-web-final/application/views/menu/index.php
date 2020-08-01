        <!-- Begin Page Content -->
        <div class="container-fluid">

            <!-- Page Heading -->
            <h1 class="h3 mb-4 text-gray-800"><?= $title ?></h1>

            <div class="mb-3 mx-auto  ">
                <?= form_error(
                    'menu',
                    '<div class="alert alert-danger" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h3>Sorry, </h3>  ',
                    '</div>'
                ) ?>
                <?= $this->session->flashdata('message'); ?>
                <div class="row no-gutters">
                    <div class="col">

                        <table class="table table-hover table-responsive">
                            <thead class="bg-gradient-primary text-white">
                                <tr>
                                    <th scope="col">No</th>
                                    <th scope="col">Menu</th>

                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <?php $i = 1 ?>
                                <?php foreach ($menu as $m) : ?>
                                    <tr>
                                        <th scope="row"><?= $i ?></th>
                                        <td><?= $m['menu'] ?></td>
                                        <td>
                                            <a href=" <?= base_url('menu/delete/'), $m['id'] ?>" class="btn btn-danger mx-auto mb-3 " onclick="return confirm('Sure want To delete ? ')">delete</a>
                                        </td>
                                    </tr>
                                    <?php $i++ ?>
                                <?php endforeach; ?>
                            </tbody>
                        </table>
                    </div>
                </div>
                <hr class="sidebar-divider ">
                <a href="" class="btn btn-primary mx-auto mb-3" data-toggle="modal" data-target="#newMenuModal"> Add New Menu</a>
            </div>

        </div>
        <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->
        <!-- Modal add -->
        <div class="modal fade" id="newMenuModal" tabindex="-1" role="dialog" aria-labelledby="newMenuModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="newMenuModalLabel">Add New Menu</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="<?= base_url('menu') ?>" method="post">

                        <div class="modal-body">
                            <div class="form-group">
                                <input type="text" class="form-control" id="menu" name="menu" placeholder="Menu name . . .">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Add</button>
                        </div>
                </div>
                </form>
            </div>
        </div>