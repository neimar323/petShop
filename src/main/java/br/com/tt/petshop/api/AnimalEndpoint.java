package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.AnimalInDto;
import br.com.tt.petshop.dto.AnimalOutDto;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.service.AnimalService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animais")
public class AnimalEndpoint {

    private AnimalService animalService;
    private ModelMapper modelMapper;

    public AnimalEndpoint(AnimalService animalService, ModelMapper modelMapper) {
        this.animalService = animalService;
        this.modelMapper = modelMapper;
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

    @GetMapping
    public ResponseEntity<List<AnimalOutDto>> findAll(){
//        List<Animal> listaAnimais = animalService.buscarTodos();
//
//        List<AnimalOutDto> listaDto = new ArrayList<AnimalOutDto>();
//
//        for (Animal animal: listaAnimais) {
//            listaDto.add(new AnimalOutDto(animal));
//        }
//
//        return ResponseEntity.ok(listaDto);

        return ResponseEntity.ok(animalService
                .buscarTodos().stream()
                .map(AnimalOutDto::new)
                .collect(Collectors.toList()));
    }

//    concatena valores
////        String nomes = animalService
////                .buscarTodos().stream()
////                .map(animal -> new AnimalOutDto(animal))
////                .map(AnimalOutDto::getNome)
////                .collect(Collectors.joining(","));

//    private void somaValores(){
//        BigDecimal um;
//        BigDecimal dois;
//        BigDecimal tres;
//
//        BigDecimal soma = BigDecimal.ZERO;
//
//        if(um != null){
//            soma = soma.add(um);
//        }
//
//        if(dois != null){
//            soma = soma.add(dois);
//        }
//
//        if(tres != null){
//            soma = soma.add(tres);
//        }
//
//        soma = Stream.of(um, dois, tres)
//        .filter(Objects::nonNull)
//        .reduce(BigDecimal::add)
//        .orElse(BigDecimal.ZERO);
//    }


    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid AnimalInDto animalDto){
        
        Animal animal = modelMapper.map(animalDto, Animal.class);

        Animal animalSalvo = this.animalService.salvar(animal);

        return ResponseEntity
                .created(URI.create("/animais/"+animalSalvo.getId()))
                .build();
    }

}
