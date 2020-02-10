package br.com.tt.petshop.api;

import br.com.tt.petshop.exception.NomeInvalidoException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteEndpoint {

    private ClienteService clienteService;

    public ClienteEndpoint(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

//    @GetMapping
//    public ResponseEntity<List<Cliente>> findAll(){
//        return ResponseEntity.ok(clienteService.listar());
//    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("X-SITUACAO", "Ativos")
                .body(clienteService.listar());
    }

    @GetMapping("{id}")
    public Cliente findById(@PathVariable Long id){
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Cliente cliente)
            throws NomeInvalidoException {
        Cliente clienteSalvo = clienteService.criar(cliente);
        URI uri = URI.create("/clientes/"+clienteSalvo.getId());
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
