package br.com.tt.petshop.controller;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RequestMapping("/admin")
    public String inicial(Model model){
        ClienteService clienteService;
        model.addAttribute("usuarioLogado",
                "Gilberto");
        return "inicial";
    }

    @RequestMapping("/admin/cliente/cadastrar")
    public String cadastrar(){
        return "/cliente/cadastrar";
    }

    @RequestMapping("/admin/cliente/salvar")
    public String salvar(Cliente cliente, Model model){
        this.clienteService.criar(cliente);
        return "inicial";
    }

    @RequestMapping("/admin/cliente/listar")
    public String listar(Model model){
        List<Cliente> lista = this.clienteService.listar();
        model.addAttribute("clientes", lista);
        return "/cliente/listar";
    }

}
