<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Admin extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        is_logged_in();
    }
    public function index()
    {
        $data['title'] = 'Dashboard';
        $data['user'] = $this->db->get_where('user', ['email' => $this->session->userdata('email')])->row_array();
        $data['usershow'] = $this->db->get('user')->result_array();

        $this->load->view('templates/header', $data);
        $this->load->view('templates/sidebar', $data);
        $this->load->view('templates/topbar', $data);
        $this->load->view('admin/index', $data);
        $this->load->view('templates/footer', $data);
    }
    public function level()
    {
        $data['title'] = 'level';
        $data['user'] = $this->db->get_where('user', ['email' => $this->session->userdata('email')])->row_array();

        $this->form_validation->set_rules('level', 'level', 'required');
        if ($this->form_validation->run() == false) {
            $data['level'] = $this->db->get('level_user')->result_array();
            $this->load->view('templates/header', $data);
            $this->load->view('templates/sidebar', $data);
            $this->load->view('templates/topbar', $data);
            $this->load->view('admin/level', $data);
            $this->load->view('templates/footer', $data);
        } else {
            $this->db->insert('level_user', ['level' => $this->input->post('level')]);
            $this->session->set_flashdata(
                'message',
                '<div class="alert alert-success" role="alert"> 
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h3>Add level </h3>  
                    <p>Succes</p>
                    
                    </div>'
            );
            redirect('admin/level');
        }
    }
    public function levelAccess($levelId)
    {
        $data['title'] = 'level access';
        $data['user'] = $this->db->get_where('user', ['email' => $this->session->userdata('email')])->row_array();

        $data['level'] = $this->db->get_where('level_user', ['id' => $levelId])->row_array();
        $this->db->where('id !=', 1);
        $data['menu'] = $this->db->get('user_menu')->result_array();

        $this->load->view('templates/header', $data);
        $this->load->view('templates/sidebar', $data);
        $this->load->view('templates/topbar', $data);
        $this->load->view('admin/levelaccess', $data);
        $this->load->view('templates/footer', $data);
    }


    public function changeaccess()
    {
        $menu_id = $this->input->post('menuId');
        $level_Id = $this->input->post('levelId');

        $data = [
            'level_id' => $level_Id,
            'menu_id' => $menu_id
        ];
        $result = $this->db->get_where('user_acces_menu', $data);

        if ($result->num_rows() < 1) {
            $this->db->insert('user_acces_menu', $data);
        } else {
            $this->db->delete('user_acces_menu', $data);
        }
        $this->session->set_flashdata(
            'message',
            '<div class="alert alert-success" role="alert"> 
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>  
                <p>access change</p>
                <h3>Thanks </h3>
                </div>'
        );
    }
    public function delete($id)
    {
        $this->db->where('id', $id);
        $this->db->delete('level_user');
        $this->session->set_flashdata(
            'message',
            '<div class="alert alert-success" role="alert"> 
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h3>level_user </h3>  
                <p>Succes to Delete</p>
                </div>'
        );
        redirect('admin/level');
    }


    public function deleteuser($id)
    {
        $this->db->where('id', $id);
        $this->db->delete('user');
        $this->session->set_flashdata(
            'message',
            '<div class="alert alert-success" role="alert"> 
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h3>user </h3>  
                <p>Succes to Delete</p>
                
                </div>'
        );
        redirect('admin');
    }
}
