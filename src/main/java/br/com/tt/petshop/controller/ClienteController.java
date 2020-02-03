package br.com.tt.petshop.controller;
import br.com.tt.petshop.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.tt.petshop.service.ClienteService;
import java.util.List;

@Controller
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RequestMapping("/admin")
    public String inicial(Model model){
        model.addAttribute("usuarioLogado", "Neimar");
        return "inicial";
    }

    @RequestMapping("/admin/cliente/cadastrar")
    public String cadastrar(){
        return "/cliente/cadastrar";
    }

    @RequestMapping("/admin/cliente/salvar")
    public String salvar(Cliente cliente, Model model){
        clienteService.criar(cliente);
        return inicial(model);
    }

    @RequestMapping("/admin/cliente/listar")
    public String listar(Model model){
        List<Cliente> lista = this.clienteService.listar();
        model.addAttribute("clientes", lista);

        return "/cliente/listar";
    }

    @RequestMapping("/admin/cliente/excluir")
    public String excluir(Cliente cliente, Model model){
        this.clienteService.excluir(cliente);

        return inicial(model);
    }

}
