package br.com.fiap.agenda_coleta_lixo.controller;

import br.com.fiap.agenda_coleta_lixo.model.LixoModel;
import br.com.fiap.agenda_coleta_lixo.service.LixoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lixo")
public class LixoController {

    @Autowired
    private LixoService lixoService;

    @GetMapping
    public List<LixoModel> getAllLixo() {
        return lixoService.getAllLixo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LixoModel> getLixoById(@PathVariable String id) {
        Optional<LixoModel> lixo = lixoService.getLixoById(id);
        return lixo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LixoModel> createLixo(@RequestBody LixoModel lixoModel) {
        LixoModel createdLixo = lixoService.createLixo(lixoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLixo);
    }


    @PutMapping("/{id}")
    public ResponseEntity<LixoModel> updateLixo(@PathVariable String id, @RequestBody LixoModel lixoDetails) {
        LixoModel updatedLixo = lixoService.updateLixo(id, lixoDetails);
        return ResponseEntity.ok(updatedLixo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLixo(@PathVariable String id) {
        lixoService.deleteLixo(id);
        return ResponseEntity.noContent().build();
    }
}

