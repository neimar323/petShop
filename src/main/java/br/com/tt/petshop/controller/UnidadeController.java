package br.com.tt.petshop.controller;

import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/admin/unidade/")
public class UnidadeController {

    private UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @RequestMapping("cadastrar")
    public String cadastrar(){
        return "/unidade/cadastrar";
    }

    @RequestMapping("salvar")
    public String salvar(Unidade unidade, Model model){
        unidadeService.criar(unidade);
        return "redirect:/admin";
    }

    @RequestMapping("excluir")
    public String excluir(Model model, @RequestParam String nomeFantasia){
        unidadeService.excluir(nomeFantasia);
        return "redirect:/admin";
    }
    @RequestMapping("listar")
    public String listar(Model model){
        List<Unidade> lista = this.unidadeService.listar();
        model.addAttribute("unidades", lista);

        return "/unidade/listar";
    }

}
