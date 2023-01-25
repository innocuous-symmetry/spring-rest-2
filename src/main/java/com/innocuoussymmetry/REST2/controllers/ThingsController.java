package com.innocuoussymmetry.REST2.controllers;

import com.innocuoussymmetry.REST2.models.Thing;
import com.innocuoussymmetry.REST2.repositories.ThingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/things")
public class ThingsController {
    private final ThingsRepository thingsRepository;

    public ThingsController(ThingsRepository thingsRepository) {
        this.thingsRepository = thingsRepository;
    }

    @GetMapping()
    public Iterable<Thing> getAllThings() {
        return this.thingsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Thing getThingById(@PathVariable Integer id) {
        Optional<Thing> maybe = this.thingsRepository.findById(id);

        return maybe.orElse(null);
    }

    @PostMapping()
    public void addThing(@RequestBody Thing thing) {
        this.thingsRepository.save(thing);
    }

    @PutMapping("/{id}")
    public void updateThing(@PathVariable Integer id, @RequestParam(name="name") String newName) {
        Optional<Thing> maybe = this.thingsRepository.findById(id);
        if (maybe.isEmpty()) {
            return;
        }

        Thing updated = maybe.get();
        updated.setName(newName);
        this.thingsRepository.save(updated);
    }

    @DeleteMapping("/{id}")
    public Thing deleteThing(@PathVariable(name="id") Integer id) {
        Optional<Thing> maybe = this.thingsRepository.findById(id);
        if (maybe.isEmpty()) {
            return null;
        }

        this.thingsRepository.delete(maybe.get());
        return maybe.get();
    }
}
