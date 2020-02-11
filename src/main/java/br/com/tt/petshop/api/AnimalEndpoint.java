package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.AnimalOutDto;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animais")
public class AnimalEndpoint {

    private AnimalService animalService;

    public AnimalEndpoint(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalOutDto> buscarPorId(@PathVariable Long id){

//        if(animalOpt.isPresent()){
//            Animal animal = animalOpt.get();
//        }
//        Animal animal = animalOpt.orElse(new Animal());

        Optional<Animal> animalOpt = animalService.buscarPorId(id);
        AnimalOutDto dto = animalOpt
                .map(a -> new AnimalOutDto(a))
                .orElseThrow(
                    () -> new IllegalArgumentException("Animal não existe")
                );
        return ResponseEntity.ok(dto);
    }

    public ResponseEntity findAll(){
        List<Animal> listaAnimais = animalService.buscarTodos();

        List<AnimalOutDto> listaDto = new ArrayList<AnimalOutDto>();
        for (Animal animal: listaAnimais) {
            new AnimalOutDto(animal);
        }

        return null;
    }
}
