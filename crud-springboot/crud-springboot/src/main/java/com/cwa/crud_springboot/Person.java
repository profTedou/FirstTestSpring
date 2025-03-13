package com.cwa.crud_springboot;

import jakarta.persistence.*;

@Entity
@Table(name= "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

/*Bien evidemment on cree une class de toutes nos entités et on precise la dependance Entity
* pour que la table de cette classe se cree automatiquement en BD
* On profite au passage pour lui creer des methodes de base pour la manipuler à l'instar des getter et setter*/

/*@Table permet de preciser le nom qu'aura l'ntiite de classe Person dans la BD à l'occurence "persons"*/

/*@ID permet de generer automatiquement une valeur auto-incrementer*/