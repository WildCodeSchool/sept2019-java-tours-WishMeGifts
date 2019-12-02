# sept2019-java-tours-WishMeGifts
Project 2 - Share my wishlist
Install project
1 - clone depôt git
2 - crée un user dans mysql:
Ex:
CREATE USER nom_user@localhost IDENTIFIED BY 'mot_de_passe' ;
3 - Créer la base 
Ex:
CREATE DATABASE wish_me_gifts;
4 - Ajuster les droits de l'utilisateur 
Ex: GRANT ALL ON wish_me_gifts.* TO nom_user@localhost;
5 - Importer la Base de données
Ex:
mysql -u nom_user -p -D wish_me_gifts < dump.sql;
6 - Lancer projet
Ex: 
mvn spring-boot:run
7 - Pour acceder au site:
Ex:
http://localhost:8080/ 

