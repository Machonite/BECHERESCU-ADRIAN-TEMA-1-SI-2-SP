package com.example.raiff;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin("*")
public class AngajatController {
    @Autowired
    AngajatService angajatService;

    @Autowired
    AngajatRepository angajatRepository;
    @GetMapping("/angajat")
    public ResponseEntity<List<Angajat>> getAngajatieWithProiecte() {
        List<Angajat> angajat = angajatRepository.getAllAngajat();
        if (angajat == null) {
            return ResponseEntity.notFound().build();
// return null;
        }
        return ResponseEntity.ok(angajat);
    }

    @GetMapping("/angajat/{angajatid}")
    private Angajat getAngajat(@PathVariable("angajatid") Long angajatid){
        return angajatService.getAngajatById(angajatid);
    }

    @DeleteMapping("/angajat/{angajatid}")
    private void deleteAngajat(@PathVariable("angajatid")Long angajatid)
    {
        angajatService.delete(angajatid);
    }

    @PostMapping("/angajat")
    private Long saveAngajat(@RequestBody Angajat angajat){
        angajatService.saveOrUpdate(angajat);
        return angajat.getAngajatId();

    }

    @PutMapping("/angajat")
    private ResponseEntity<Angajat> update(@RequestBody Angajat angajat){
        Long id = angajat.getAngajatId();
        Angajat angajatAct = angajatService.findById(id);
        if(angajatAct == null) {
            return ResponseEntity.notFound().build();
        }

        angajatAct.setNume(angajat.getNume());
        angajatAct.setPrenume(angajat.getPrenume());
        angajatAct.setFunctie(angajat.getFunctie());
        angajatAct.setSalariu(angajat.getSalariu());
        angajatAct.setEmail(angajat.getEmail());
        angajatAct.setData_angajare(angajat.getData_angajare());
        angajatAct.setProiect(angajat.getProiect());

        angajatService.saveOrUpdate(angajatAct);
        return ResponseEntity.ok(angajatAct);
    }
}
