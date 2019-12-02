# sept2019-java-tours-WishMeGifts

Project 2 - Share my wishlist

#Install project

##1 - clone depôt git

2 - Modifier dans les fichiers : src/main/java/repository/GiftRepository.java  et EventsRepository.java les lignes 17 et 18 :

    - private final static String DB_USER = "h4rryp0tt3r";

    - private final static String DB_PASSWORD = "Horcrux4life!";

En remplaçant  *h4rryp0tt3r*  par le nom_user choisi ainsi que  *Horcrux4life!*  par le mot de passe choisi.

3 - crée un user dans mysql:

Ex:


*CREATE USER nom_user@localhost IDENTIFIED BY 'mot_de_passe' ;*

4 - Créer la base 

Ex:

*CREATE DATABASE wish_me_gifts;*

5 - Ajuster les droits de l'utilisateur 

Ex: GRANT ALL ON wish_me_gifts.* TO nom_user@localhost;

6 - Importer la Base de données

Ex:

**mysql -u nom_user -p -D wish_me_gifts < dump.sql;**

7 - Lancer projet

Ex: 

**mvn spring-boot:run**

8 - Pour acceder au site:

Ex:

**http://localhost:8080/** 

