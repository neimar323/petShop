package br.com.tt.petshop.api;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.service.ClienteService;
import br.com.tt.petshop.service.NomeInvalidoExceptipn;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteEndpoint {

    ClienteService clienteService;

    public ClienteEndpoint(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<List<Cliente>> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("x-situacao","ativo")
                .body(clienteService.listar());
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Cliente>find(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clienteService.find(id));
    }

    @PostMapping("")
    private ResponseEntity inserir(@RequestBody Cliente cliente){
        Cliente clienteSalvo = null;
        try {
            clienteSalvo = clienteService.criar(cliente);
        } catch (NomeInvalidoExceptipn nomeInvalidoExceptipn) {
            return ResponseEntity
                    .status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(nomeInvalidoExceptipn.getMessage());
        }
        URI uri = URI.create("/cliente/"+clienteSalvo.getId());
        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping("{id}")
    private ResponseEntity delete(@PathVariable Long id){

        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
