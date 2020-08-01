<?php

function is_logged_in()
{
    $bebas = get_instance();

    if (!$bebas->session->userdata('email')) {
        redirect('auth');
    } else {
        $level_id = $bebas->session->userdata('level_user');
        $menu = $bebas->uri->segment(1);

        $queryMenu = $bebas->db->get_where('user_menu', ['menu' => $menu])->row_array();
        $menu_id = $queryMenu['id'];
        $user_acces = $bebas->db->get_where('user_acces_menu', [
            'level_id' => $level_id,
            'menu_id' => $menu_id
        ]);

        if ($user_acces->num_rows() < 1) {
            redirect('auth/block');
        }
    }
}

function check_access($level_id, $menu_id)
{
    $ci = get_instance();

    $ci->db->where('level_id', $level_id);
    $ci->db->where('menu_id', $menu_id);
    $result = $ci->db->get('user_acces_menu');

    if ($result->num_rows() > 0) {
        return "checked='checked'";
    }
}
