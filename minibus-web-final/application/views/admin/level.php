        <!-- Begin Page Content -->
        <div class="container-fluid">

            <!-- Page Heading -->
            <h1 class="h3 mb-4 text-gray-800"><?= $title ?></h1>

            <div class="mb-3 mx-auto  ">
                <?= form_error(
                    'level',
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
                                    <th scope="col">Level</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <?php $i = 1 ?>
                                <?php foreach ($level as $r) : ?>
                                    <tr>
                                        <th scope="row"><?= $i ?></th>
                                        <td><?= $r['level'] ?></td>
                                        <td>
                                            <a href=" <?= base_url('admin/delete/'), $r['id'] ?>" class="btn btn-danger mx-auto mb-3 " onclick="return confirm('Sure want To delete ? ')">delete</a>
                                            <a href=" <?= base_url('admin/levelaccess/'), $r['id'] ?>" class="btn btn-warning mx-auto mb-3 " ">acces</a>
                                        </td>
                                    </tr>
                                    <?php $i++ ?>
                                <?php endforeach; ?>
                            </tbody>
                        </table>
                    </div>
                </div>
                <hr class=" sidebar-divider ">
                <a href="" class=" btn btn-primary mx-auto mb-3" data-toggle="modal" data-target="#newlevelModal"> Add New level</a>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
            <!-- Modal add -->
            <div class="modal fade" id="newlevelModal" tabindex="-1" role="dialog" aria-labelledby="newlevelModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="newlevelModalLabel">Add New level</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form action="<?= base_url('admin/level') ?>" method="post">

                            <div class="modal-body">
                                <div class="form-group">
                                    <input type="text" class="form-control" id="level" name="level" placeholder="Level name . . .">
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