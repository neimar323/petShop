package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.ProdutoInDto;
import br.com.tt.petshop.dto.ProdutoOutDto;
import br.com.tt.petshop.model.Produto;
import br.com.tt.petshop.service.ProdutoService;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoEndpoint {

    private ModelMapper modelMapper;
    private ProdutoService produtoService;

    public ProdutoEndpoint(ModelMapper modelMapper, ProdutoService produtoService) {
        this.modelMapper = modelMapper;
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid ProdutoInDto produtoDto){
        Produto produto = modelMapper.map(produtoDto, Produto.class);

        Produto produtoSalvo = produtoService.salvar(produto);

        return ResponseEntity
                .created(URI.create("/produtos/"+produtoSalvo.getId()))
                .build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoOutDto>> listar(@Valid
            @RequestParam(required = false) @ApiParam("Valor de referencia") BigDecimal valorMaiorQue){
        //return ResponseEntity.ok(produtoService.listar(valorMaiorQue));
//        return ResponseEntity.ok(produtoService
//                .listar(valorMaiorQue)
//                .stream()
//                .map(ProdutoOutDto::new)
//                .collect(Collectors.toList()));

        List<Produto> listaProdutos = produtoService.listar(valorMaiorQue);
        List<ProdutoOutDto> listaProdutoOutDto = new ArrayList<>();

        for (Produto p:listaProdutos) {
            listaProdutoOutDto.add(new ProdutoOutDto(p));
        }
        return ResponseEntity.ok(listaProdutoOutDto);
    }

}
