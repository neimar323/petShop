package br.com.tt.petshop.api;

import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidades")
public class UnidadeEndpoint {

    //@RequestMapping(value = "/unidades", method = RequestMethod.GET)
    private final UnidadeService unidadeService;

    public UnidadeEndpoint(UnidadeService unidadeService){
        this.unidadeService = unidadeService;
    }

    @GetMapping("")
    public List<Unidade> buscarTodos(){
        return unidadeService.listar();
    }

    @GetMapping("/{id}")
    public Unidade buscaPorId(@PathVariable Long id){
        return unidadeService.buscaPorId(id);
    }


    @PostMapping("")
    public void criar(@RequestBody Unidade unidade){
        unidadeService.criar(unidade);
        return;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        unidadeService.deletar(id);
        return;
    }


}
