package com.example.raiff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProiectRepository extends JpaRepository<Proiect, Long> {

    @Query(value = "SELECT * FROM proiect JOIN angajat ON proiect.idul_proiect = angajat.idul_proiect", nativeQuery = true)
    List<Proiect> getAllProiect();
}
