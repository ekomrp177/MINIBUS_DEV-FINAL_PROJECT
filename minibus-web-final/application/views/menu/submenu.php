        <!-- Begin Page Content -->
        <div class="container-fluid">

            <!-- Page Heading -->
            <h1 class="h3 mb-4 text-gray-800"><?= $title ?></h1>
            <div class="mb-3 mx-auto  ">
                <?php if (validation_errors()) : ?>
                    <div class="alert alert-danger" role="alert">
                        <?= validation_errors(); ?>
                    </div>
                <?php endif; ?>
                <?= $this->session->flashdata('message'); ?>
                <div class=" row no-gutters">
                    <div class="col">

                        <table class="table table-hover table-responsive">
                            <thead class="bg-gradient-primary text-white">
                                <tr>
                                    <th scope="col">No</th>
                                    <th scope="col">Ttle</th>
                                    <th scope="col">Menu</th>
                                    <th scope="col">Url</th>
                                    <th scope="col">Icons</th>
                                    <th scope="col">Active</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <?php $i = 1 ?>
                                <?php foreach ($subMenu as $sm) : ?>
                                    <tr>
                                        <th scope="row"><?= $i ?></th>
                                        <td><?= $sm['title'] ?></td>
                                        <td><?= $sm['menu'] ?></td>
                                        <td><?= $sm['url'] ?></td>
                                        <td><?= $sm['icon'] ?></td>
                                        <td><?= $sm['is_active'] ?></td>

                                        <td>
                                            <a href=" <?= base_url('menu/deleteSubMenu/'), $sm['id'] ?>" class="btn btn-danger mx-auto mb-3 " onclick="return confirm('Sure want To delete ? ')">delete</a>
                                        </td>
                                    </tr>
                                    <?php $i++ ?>
                                <?php endforeach; ?>
                            </tbody>
                        </table>
                    </div>
                </div>
                <hr class="sidebar-divider ">
                <a href="" class="btn btn-primary mx-auto mb-3" data-toggle="modal" data-target="#newSubMenu"> Add New subMenu</a>
            </div>

        </div>
        <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->
        <!-- Modal add -->
        <div class="modal fade" id="newSubMenu" tabindex="-1" role="dialog" aria-labelledby="newSubMenuLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="newSubMenuLabel">Add New SubMenu</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form action="<?= base_url('menu/subMenu') ?>" method="post">

                        <div class="modal-body">
                            <div class="form-group">
                                <input type="text" class="form-control" id="title" name="title" placeholder="title SubMenu . . .">
                            </div>
                            <div class="form-group">
                                <select class="form-control" id="menu_id" name="menu_id" ">
                                    <option value="">select</option>
                                    <?php foreach ($menu as $m) : ?>
                                        <option value=" <?= $m['id'] ?>"><?= $m['menu'] ?></option>
                                <?php endforeach; ?>
                                </select>
                            </div>
                            <div class=" form-group">
                                <input type="text" class="form-control" id="url" name="url" placeholder="subMenu url . . .">
                            </div>
                            <div class=" form-group">
                                <input type="text" class="form-control" id="icon" name="icon" placeholder="subMenu icon . . .">
                            </div>
                            <div class="form-group">
                                <div class="form-check">
                                    <input type="checkbox" aria-label="form-check-input" value="1" id="is_active" name="is_active" checked>
                                    <label class="form-check-label" for="is_active">
                                        active ?
                                    </label>

                                </div>
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