package com.esig.helder.desafio.backend.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esig.helder.desafio.backend.model.Owner;
import com.esig.helder.desafio.backend.repo.OwnerRepo;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/owner")
public class OwnerController {
  @Autowired
  private OwnerRepo repo;

  @PostMapping
    public ResponseEntity<Owner> createOwner(@RequestBody Owner o) {
        Owner savedOwner = repo.save(o);
        return new ResponseEntity<>(savedOwner, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Owner>> getOwners() {
        Iterable<Owner> owners = repo.findAll();
        return new ResponseEntity<>(owners, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable Long id) {
      Optional<Owner> optionalOwner = repo.findById(id);

      if (!optionalOwner.isPresent()) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(optionalOwner.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable Long id, @RequestBody Owner ownerDetails) {
        Optional<Owner> optionalOwner = repo.findById(id);

        if (!optionalOwner.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Owner existingOwner = optionalOwner.get();
        existingOwner.setName(ownerDetails.getName());

        Owner updatedOwner = repo.save(existingOwner);
        return new ResponseEntity<>(updatedOwner, HttpStatus.OK);
    }

    // Método para deletar um proprietário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        Optional<Owner> optionalOwner = repo.findById(id);

        if (!optionalOwner.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  
}
