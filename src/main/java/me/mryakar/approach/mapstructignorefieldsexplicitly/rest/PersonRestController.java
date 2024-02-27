package me.mryakar.approach.mapstructignorefieldsexplicitly.rest;

import lombok.AllArgsConstructor;
import me.mryakar.approach.mapstructignorefieldsexplicitly.dto.NewPersonDto;
import me.mryakar.approach.mapstructignorefieldsexplicitly.dto.PersonModel;
import me.mryakar.approach.mapstructignorefieldsexplicitly.dto.UpdatedPersonDto;
import me.mryakar.approach.mapstructignorefieldsexplicitly.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonRestController {

    private final PersonService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody NewPersonDto newPersonDto) {
        long createdPersonId = service.create(newPersonDto);

        URI resourceLocation = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{resourceId}")
                .buildAndExpand(createdPersonId)
                .toUri();

        return ResponseEntity.created(resourceLocation).build();
    }

    @GetMapping
    public ResponseEntity<List<PersonModel>> read() {
        return ResponseEntity.ok(service.read());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody UpdatedPersonDto updatedPersonDto) {
        service.update(updatedPersonDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}