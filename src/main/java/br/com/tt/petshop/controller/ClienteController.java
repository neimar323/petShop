package br.com.tt.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClienteController {

    @RequestMapping("/admin")
    public String inicial(Model model){
        model.addAttribute("usuarioLogado",
                "Gilberto");
        return "inicial";
    }

    @RequestMapping("/admin/cliente/cadastrar")
    public String cadastrar(){
        return "/cliente/cadastrar";
    }

    @RequestMapping("/admin/cliente/salvar")
    public String salvar(Model model){
//        String nome = (String) model.getAttribute("nome");
//        String cpf = (String) model.getAttribute("CPF");
//        String nascimento = (String) model.getAttribute("nascimento");

        return "inicial";
    }

}
