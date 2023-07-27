package com.example.raiff;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Proiect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idulProiect;
    private String nume;
    private String descriere;
    private int costLunar;
    @OneToMany(/*cascade = CascadeType.ALL,*/mappedBy = "proiect", fetch = FetchType.LAZY)
    private List<Angajat> angajat = new ArrayList<>();

    public List<Angajat> getAngajat() {
        return angajat;
    }

    public Long getIdulProiect() {
        return idulProiect;
    }

    public void setIdulProiect(Long idulProiect) {
        this.idulProiect = idulProiect;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setCostLunar(int costLunar) {
        this.costLunar = costLunar;
    }


    public String getNume() {
        return nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public int getCostLunar() {
        return costLunar;
    }


}
