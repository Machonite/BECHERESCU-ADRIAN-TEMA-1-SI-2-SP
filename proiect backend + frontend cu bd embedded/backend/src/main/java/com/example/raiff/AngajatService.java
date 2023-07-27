package com.example.raiff;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class AngajatService {
    @Autowired
    AngajatRepository angajatRepository;

    @Autowired
    ProiectRepository proiectRepository;

    public List<Angajat> getAllAngajat() {
        List<Angajat> angajat = new ArrayList<Angajat>();
        angajatRepository.findAll().forEach(angajat1 -> angajat.add(angajat1));
        return angajat;
    }

    public Angajat findById(long id){
        return angajatRepository.findById(id);
    }

    public Angajat getAngajatById(Long angajatid){
        return angajatRepository.findById(angajatid).get();
    }

    public Angajat saveOrUpdate(Angajat angajati) {

        return angajatRepository.save(angajati);

    }

    public void delete(Long angajatid){
        angajatRepository.deleteById(angajatid);
    }

    public void update(Angajat angajat, int angajatid){
        angajatRepository.save(angajat);
    }
}




