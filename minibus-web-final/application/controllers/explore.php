<?php
defined('BASEPATH') or exit('No direct script access allowed');

class explore extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        is_logged_in();
    }
    public function index()
    {

        $wisata = file_get_contents('https://thawing-anchorage-78445.herokuapp.com/api/pariwisata/');
        $kuliner = file_get_contents('https://thawing-anchorage-78445.herokuapp.com/api/kuliner/');
        $data['wisata'] = json_decode($wisata, true);
        $data['kuliner'] = json_decode($kuliner, true);
        $data['title'] = 'explore';
        $data['user'] = $this->db->get_where('user', ['email' => $this->session->userdata('email')])->row_array();

        $this->load->view('templates/header', $data);
        $this->load->view('templates/sidebar', $data);
        $this->load->view('templates/topbarexplore', $data);
        $this->load->view('explore/index', $data);
        $this->load->view('templates/footer', $data);
    }
    public function detailwisata($id)
    {
        $data['id'] = $id;
        $wisata = file_get_contents('https://thawing-anchorage-78445.herokuapp.com/api/pariwisata/');
        $data['wisata'] = json_decode($wisata, true);
        $data['title'] = 'explore';
        $data['user'] = $this->db->get_where('user', ['email' => $this->session->userdata('email')])->row_array();

        $this->load->view('templates/header', $data);
        $this->load->view('templates/sidebar', $data);
        $this->load->view('templates/topbarexplore', $data);
        $this->load->view('explore/detailwisata', $data);
        $this->load->view('templates/footer', $data);
    }
    public function detailkuliner($id)
    {
        $data['id'] = $id;
        $kuliner = file_get_contents('https://thawing-anchorage-78445.herokuapp.com/api/kuliner/');
        $data['kuliner'] = json_decode($kuliner, true);
        $data['title'] = 'explore';
        $data['user'] = $this->db->get_where('user', ['email' => $this->session->userdata('email')])->row_array();

        $this->load->view('templates/header', $data);
        $this->load->view('templates/sidebar', $data);
        $this->load->view('templates/topbarexplore', $data);
        $this->load->view('explore/detailkuliner', $data);
        $this->load->view('templates/footer', $data);
    }
}
