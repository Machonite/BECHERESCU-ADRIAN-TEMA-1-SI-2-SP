package com.example.raiff;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

@Entity
public class Angajat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long angajatid;
    private String nume;
    private String prenume;
    private String functie;
    private int salariu;
    private String data_angajare;
    private String email;
    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"nume", "descriere", "costLunar", "angajat","applications", "hibernateLazyInitializer"})
    @JoinColumn(name="idulProiect")
    private Proiect proiect;

    public Proiect getProiect() {
        return proiect;
    }

    public void setProiect(Proiect proiect) {
        this.proiect = proiect;
    }

    public void setAngajatid(Long angajatid) {
        this.angajatid = angajatid;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public void setData_angajare(String data_angajare) {
        this.data_angajare = data_angajare;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAngajatId() {
        return angajatid;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getFunctie() {
        return functie;
    }

    public int getSalariu() {
        return salariu;
    }

    public String getData_angajare() {
        return data_angajare;
    }

    public String getEmail() {
        return email;
    }

}
