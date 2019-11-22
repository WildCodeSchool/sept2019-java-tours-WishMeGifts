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



public class GiftRepository {
	

	    private final static String DB_URL = "jdbc:mysql://localhost:3306/spring_jdbc_quest?serverTimezone=GMT";
	    private final static String DB_USER = "h4rryp0tt3r";
	    private final static String DB_PASSWORD = "Horcrux4life!";

	    public Gift save(Gift gift) {
	        try {
	            Connection connection = DriverManager.getConnection(
	                    DB_URL, DB_USER, DB_PASSWORD
	            );
	            PreparedStatement statement = connection.prepareStatement(
	                    "INSERT INTO gift (nom, lien) VALUES (?, ?)",
	                    Statement.RETURN_GENERATED_KEYS
	            );
	            statement.setString(1, gift.getNom());
	            statement.setString(2, gift.getLien());
	            

	            if (statement.executeUpdate() != 1) {
	                throw new SQLException("failed to insert data");
	            }

	            ResultSet generatedKeys = statement.getGeneratedKeys();

	            if (generatedKeys.next()) {
	                Long id = generatedKeys.getLong(1);
	                gift.setId(id);
	                return gift;
	            } else {
	                throw new SQLException("failed to get inserted id");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    public Gift findById(Long id) {

	        try {
	            Connection connection = DriverManager.getConnection(
	                    DB_URL, DB_USER, DB_PASSWORD
	            );
	            PreparedStatement statement = connection.prepareStatement(
	                    "SELECT * FROM gift WHERE id = ?;"
	            );
	            statement.setLong(1, id);
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                String nom = resultSet.getString("nom");
	                String lien = resultSet.getString("lien");
	                
	                return new Gift(id, nom, lien);
	            }
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
	                
	                gifts.add(new Gift(id, nom, lien));
	            }
	            return gifts;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    
	    public Gift update(Gift gift) {
	        try {
	            Connection connection = DriverManager.getConnection(
	                    DB_URL, DB_USER, DB_PASSWORD
	            );
	            PreparedStatement statement = connection.prepareStatement(
	                    "UPDATE gift SET nom=?, lien=? WHERE id=?"
	            );
	            statement.setString(1, gift.getNom());
	            statement.setString(2, gift.getLien());
	            statement.setLong(3, gift.getId());

	            if (statement.executeUpdate() != 1) {
	                throw new SQLException("failed to update data");
	            }
	            return gift;
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

		public Object save(String nom, String lien) {
			// TODO Auto-generated method stub
			return null;
		}
	

}
