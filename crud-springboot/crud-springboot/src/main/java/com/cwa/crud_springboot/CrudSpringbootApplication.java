package com.cwa.crud_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringbootApplication.class, args);
	}

}

/* On va creer trois couches dans cette application serveur
* A savoir les couches controller, services et repôsitory
* La couche Repositery etend JPA et permet de recuperer et d'interagir avec la BD
* La couche service permet de de traiter les données recuperées par ex. un formatage
* La couche Controler permet de creer des endpoints pour recevoir les requêtes*/

/*Dans notre projet nous n'utiliserons pas la couche de service car nous n'appliquerons pas de
* traitement sur les dnnées ainsi couche controler et couche service communioqueron
* directement entre eux */

/*Le client ici sera remplacé par postman depuis lequel on enverra des requêtes
* Le but ici etant d'implementer un CRUD sur les sonnées cad Create-Replace-Update-Delete*/