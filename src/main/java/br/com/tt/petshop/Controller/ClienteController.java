package br.com.tt.petshop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClienteController {

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
    public String salvar(Model model){
        String nome = (String) model.getAttribute("nome");
        String cpf = (String) model.getAttribute("cpf");
        String nascimento = (String) model.getAttribute("nascimento");

        return "inicial";
    }



}
