package com.cwa.crud_springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//necesaire lors de la creation d'un repository bien que connu lorsqu'on étend JpaRepository
//des lors le sytême reconnait cette classe en tant que repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}

/*PersonRepository est la classe qui va representer la classe person dans la BD
* Chaque classe doit avoir son ClassRepositoty pour pouvoir interagir avec la BD
* En effet une instance de cette ClasseRepository peremtttra d'interagir avec sa table correspondante
* grace aux methodes implementrer par JPA
* A preci*/