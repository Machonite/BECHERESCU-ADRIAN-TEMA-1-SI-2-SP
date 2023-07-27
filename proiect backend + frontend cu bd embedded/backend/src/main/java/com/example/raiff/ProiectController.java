package com.example.raiff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProiectController {
    @Autowired
    ProiectService proiectService;
    @Autowired
    ProiectRepository proiectRepository;


   /* public List<Proiect> getAllProiect(){
        return proiectService.getAllProiect();
    }*/

    @GetMapping("/proiect")
    public ResponseEntity<List<Proiect>> getProiecteWithAngajati() {
        List<Proiect> proiect = proiectRepository.getAllProiect();
        if (proiect == null) {
            return ResponseEntity.notFound().build();
// return null;
        }
        return ResponseEntity.ok(proiect);
    }
    @GetMapping("/proiect/{id}")
    public Proiect getProiect(@PathVariable("id") Long id){
        return proiectService.getProiectById(id);
    }
    @DeleteMapping("/proiect/{id}")
    public void deleteProiect(@PathVariable ("id") Long id){
        proiectService.delete(id);
    }

    @PostMapping("/proiect")
    public Long saveProiect(@RequestBody Proiect proiect){
        proiectService.saveOrUpdate(proiect);
        return proiect.getIdulProiect();
    }

    @PutMapping("/proiect")
    public Proiect proiect(@RequestBody Proiect proiect){
        proiectService.saveOrUpdate(proiect);
        return proiect;
    }

}
