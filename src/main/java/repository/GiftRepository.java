package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Gift;

public class GiftRepository{
	

	    private final static String DB_URL = "jdbc:mysql://localhost:3306/WishMeAGiftBaby?serverTimezone=GMT";
	    private final static String DB_USER = "h4rryp0tt3r";
	    private final static String DB_PASSWORD = "Horcrux4life!";
	    
	 
	    public Gift save(String nom, String lien, Long id_event_list) {
	        try {
	            Connection connection = DriverManager.getConnection(
	                    DB_URL, DB_USER, DB_PASSWORD
	            );
	            PreparedStatement statement = connection.prepareStatement(
	                    "INSERT INTO gift (nom, lien, id_event_list) VALUES (?, ?, ?)",
	                    Statement.RETURN_GENERATED_KEYS
	            );
	            
	            statement.setString(1, nom);
	            statement.setString(2, lien);
	            statement.setLong(3, id_event_list);
	            
	       
	            if (statement.executeUpdate() != 1) {
	                throw new SQLException("failed to insert data");
	            }

	            ResultSet generatedKeys = statement.getGeneratedKeys();

	            if (generatedKeys.next()) {
	                Long id = generatedKeys.getLong(1);
	                return new Gift(id, nom, lien, id_event_list);
	            } else {
	                throw new SQLException("failed to get inserted id");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	    
	 /**
	  * Renvoi un tableau de cadeaux correspondant à l'id de l'évènement fournit en paramètre. 
	  * @param event_id : identifiant de l'évènement
	  * @return : une liste de Gift potentiellement vide si aucun cadeaux n'est associé à l'évènement 
	  * ou null s'il y a un problème d'accès à la base.
	  */
	    public List<Gift> findAllByEventId(long event_id) {
	        try {
	            Connection connection = DriverManager.getConnection(
	                    DB_URL, DB_USER, DB_PASSWORD
	            );
	            PreparedStatement statement = connection.prepareStatement(
	                    "SELECT * FROM gift WHERE id_event_list = ?;"
	            );
	            statement.setLong(1, event_id);
	            ResultSet resultSet = statement.executeQuery();
				List<Gift> gifts = new ArrayList<>();
	            while (resultSet.next()) {
	                String nom = resultSet.getString("nom");
	                String lien = resultSet.getString("lien");
	                Long id = resultSet.getLong("id");
					gifts.add(new Gift(id, nom, lien, event_id));
				}
				statement.close();
				connection.close();
				return gifts;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	    
	
	    public List<Gift> findAll() {
	        try {
	            Connection connection = DriverManager.getConnection(
	                    DB_URL, DB_USER, DB_PASSWORD
	            );
	            PreparedStatement statement = connection.prepareStatement(
	                    "SELECT * FROM gift;"
	            );
	            ResultSet resultSet = statement.executeQuery();

	            List<Gift> gifts = new ArrayList<>();

	            while (resultSet.next()) {
	                Long id = resultSet.getLong("id");
	                String nom = resultSet.getString("nom");
	                String lien = resultSet.getString("lien");
	                Long id_event_list = resultSet.getLong("id_event_list");
	                gifts.add(new Gift(id, nom, lien, id_event_list));
	            }
	            return gifts;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	 
	    public Gift update( String nom, String lien, Long id_event_list, Long id) {
	        try {
	            Connection connection = DriverManager.getConnection(
	                    DB_URL, DB_USER, DB_PASSWORD
	            );
	            PreparedStatement statement = connection.prepareStatement(
	                    "UPDATE gift SET nom=?, lien=?, id_event_list=? WHERE id=?"
	            );
	            statement.setString(1, nom);
	            statement.setString(2, lien);
	            statement.setLong(3, id_event_list);
	            statement.setLong(4, id);

	            if (statement.executeUpdate() != 1) {
	                throw new SQLException("failed to update data");
	            }
	            return new Gift(id, nom, lien, id_event_list);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }


	    public void deleteById(Long id) {
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

}
