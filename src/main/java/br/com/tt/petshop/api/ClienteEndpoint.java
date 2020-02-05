package br.com.tt.petshop.api;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteEndpoint {

    private ClienteService clienteService;

    public ClienteEndpoint(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> findAll(){
        return clienteService.listar();
    }

    @GetMapping("{id}")
    public Cliente findById(@PathVariable Long id){
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    public void create(@RequestBody Cliente cliente){
        clienteService.criar(cliente);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        clienteService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
