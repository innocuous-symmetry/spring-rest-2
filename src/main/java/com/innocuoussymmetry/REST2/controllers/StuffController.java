package com.innocuoussymmetry.REST2.controllers;

import com.innocuoussymmetry.REST2.models.Stuff;
import com.innocuoussymmetry.REST2.repositories.StuffRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/stuff")
public class StuffController {
    private final StuffRepository stuffRepository;

    public StuffController(StuffRepository repo) {
        this.stuffRepository = repo;
    }

    @GetMapping()
    public Iterable<Stuff> getAllStuff() {
        return this.stuffRepository.findAll();
    }

    @GetMapping("/{id}")
    public Stuff getStuffById(@PathVariable Integer id) {
        Optional<Stuff> maybe = this.stuffRepository.findById(id);
        return maybe.orElse(null);
    }

    @PostMapping()
    public Stuff addStuff(@RequestBody Stuff stuff) {
        return this.stuffRepository.save(stuff);
    }

    @PutMapping("/{id}")
    public Stuff updateStuff(@PathVariable Integer id, @RequestParam String newName) {
        Optional<Stuff> maybe = this.stuffRepository.findById(id);

        if (maybe.isEmpty()) {
            return null;
        }

        Stuff updated = maybe.get();
        updated.setName(newName);
        return this.stuffRepository.save(updated);
    }
}
