<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-route"></i>
        </div>
        <div class="sidebar-brand-text mx-2 ">KANCA PLESIR</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider ">

    <!-- Query Menu -->

    <?php
    $level_id = $this->session->userdata('level_user');
    $queryMenu = " SELECT  `user_menu`.`id`, `menu` 
                    FROM `user_menu` JOIN `user_acces_menu` 
                    ON `user_menu`.`id` = `user_acces_menu`.`menu_id` 
                    WHERE `user_acces_menu`.`level_id` = $level_id 
                    ORDER BY `user_acces_menu`.`menu_id` ASC";
    $menu = $this->db->query($queryMenu)->result_array();
    ?>

    <!-- LOOPING MENU -->
    <?php foreach ($menu as $m) : ?>
        <div class="sidebar-heading">
            <?= $m['menu']; ?>
        </div>

        <?php
        $menuId = $m['id'];
        $querySubMenu = " SELECT *
                            FROM `user_sub_menu`  
                            WHERE `menu_id` = $menuId 
                            AND `is_active` = 1";
        $subMenu = $this->db->query($querySubMenu)->result_array();
        ?>
        <?php foreach ($subMenu as $sb) : ?>
            <!-- Nav Item - Dashboard -->
            <?php if ($title == $sb['title']) : ?>
                <li class="nav-item active">
                <?php else : ?>
                <li class="nav-item">
                <?php endif; ?>
                <a class="nav-link pb-0" href="<?= base_url($sb['url']) ?>">
                    <i class="<?= $sb['icon'] ?>"></i>
                    <span><?= $sb['title'] ?></span></a>
                </li>
            <?php endforeach; ?>
            <!-- Divider -->
            <hr class="sidebar-divider mt-3">
        <?php endforeach; ?>

        <li class="nav-item">
            <a class="nav-link" href="<?= base_url('auth/logout') ?>" data-toggle="modal" data-target="#logoutModal">
                <i class="fas fa-fw fa-sign-out-alt"></i>
                <span>Logout</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

</ul>
<!-- End of Sidebar -->