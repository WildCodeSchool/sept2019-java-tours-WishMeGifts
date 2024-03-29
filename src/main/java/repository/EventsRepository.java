package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Event;


public class EventsRepository {
	
	private final static String DB_URL = "jdbc:mysql://localhost:3306/wish_me_gifts?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";
    
    public void deleteById(long id) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM gift WHERE id=?"
            );
            statement.setLong(1, id);

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to delete data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Event save( String intitule, String adresse,String message, Date dateEvent, String occasion) {
    	try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO event ( intitule, adresse,  message, dateEvent,occasion) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
           
            statement.setString(1, intitule);
            statement.setString(2, adresse);
            statement.setString(3, message);
            statement.setDate(4, dateEvent);
            statement.setString(5, occasion);
         

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                return new Event(id, intitule, adresse, message, dateEvent, occasion);
            } else {
                throw new SQLException("failed to get inserted id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        return null;
    }
    /**
     * Méthode permettant d'aller récupérer un évènement par son id. 
     * @param id : identifiant de l'évènement recherché
     * @return : un objet évènement ou null si l'évènement n'existe pas ou qu'il y a un quelconque problème d'accès à la base. 
     *
     */
    public Event findById(long id) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM event WHERE id = ?;"
            );
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            
            if (resultSet.next()) {
            	
            	String intitule = resultSet.getString("intitule");
                String adresse = resultSet.getString("adresse");             
                String message = resultSet.getString("message");
                Date dateEvent = resultSet.getDate("dateEvent");
                String occasion = resultSet.getString("occasion"); 
               
                return new Event(id,intitule, adresse,  message, dateEvent, occasion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


