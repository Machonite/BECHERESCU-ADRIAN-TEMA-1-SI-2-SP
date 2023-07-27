package com.example.raiff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProiectService {
    @Autowired
    ProiectRepository proiectRepository;
    public List<Proiect> getAllProiect(){
        List<Proiect> proiect = new ArrayList<Proiect>();
        proiectRepository.findAll().forEach(proiect1 -> proiect.add(proiect1));
        return proiect;
    }

    public Proiect getProiectById(Long id)
    {
        return proiectRepository.findById(id).get();
    }

    public void saveOrUpdate(Proiect proiect){
        proiectRepository.save(proiect);
    }

    public void delete(Long id){
        proiectRepository.deleteById(id);
    }
    public void update(Proiect proiect, int id){
        proiectRepository.save(proiect);
    }

}





