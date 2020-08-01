<?php
defined('BASEPATH') or exit('No direct script access allowed');

class contact extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        is_logged_in();
    }
    public function index()
    {
        $data['title'] = 'Developer';
        $data['user'] = $this->db->get_where('user', ['email' => $this->session->userdata('email')])->row_array();

        $this->load->view('templates/header', $data);
        $this->load->view('templates/sidebar', $data);
        $this->load->view('templates/topbarexplore', $data);
        $this->load->view('contact/index', $data);
        $this->load->view('templates/footer', $data);
    }
}
