package com.example.raiff;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AngajatRepository extends JpaRepository<Angajat, Long> {

    @Query(value = "SELECT * FROM angajat JOIN proiect ON angajat.idul_proiect = proiect.idul_proiect", nativeQuery = true)
    List<Angajat> getAllAngajat();
    Angajat findById(long id);


}
