package pizza_package;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet; 

public class PizzaDAO {

	     static List<Pizza> listPizza = new ArrayList<Pizza>();
	
	       static public List<Pizza> listAllPizzas() throws SQLException, ClassNotFoundException {
	       
	        String sql = "SELECT * FROM t_pizza";
	         
	       Connection conn = DatabaseConnection.initializeDatabase() ;
	         
	        Statement statement = conn.createStatement();
	        ResultSet resultSet = statement.executeQuery(sql);
	        listPizza.clear();
	         
	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String DesignPizz = resultSet.getString("DesignPizz");	         
	            Double price = resultSet.getDouble("TarifPizz");
	            String Description = resultSet.getString("Description");	
	             
	            Pizza itemPizza = new Pizza(id, DesignPizz, price, Description);
	            listPizza.add(itemPizza);
	        }
	         
	        resultSet.close();
	        statement.close();
	         
	       // itemPizza disconnect();
	         
	        return listPizza;
	    }
	       
	       static public Pizza getPizzaById(int pizzaid) throws SQLException, ClassNotFoundException {
	    	   
	    	   Connection conn = DatabaseConnection.initializeDatabase() ;
		       		        
	           String query = "select * from t_pizza where id = " + pizzaid;
	           Statement stmt = conn.createStatement();
	           ResultSet res = stmt.executeQuery(query);
	           res.next();
	           
	           Pizza pizza = new Pizza(res.getInt("id"),res.getString("DesignPizz"),res.getDouble("TarifPizz"),res.getString("Description"));
	           stmt.close();
	           res.close();
	           return pizza;
	           
	       }
	       
             static public void ajouterPizza( String DesignPizz, double TarifPizz, String Description) throws SQLException, ClassNotFoundException {
	    	   
            	 String query = "INSERT INTO t_pizza (DesignPizz, TarifPizz, Description) VALUES (?, ?, ?)";
  	    	   	 try (Connection conn = DatabaseConnection.initializeDatabase();
  	    			 PreparedStatement ps = conn.prepareStatement(query);){
  	    	  	 
  	    	   	   ps.setString(1,DesignPizz);
		  	       ps.setDouble(2,TarifPizz);
		  	       ps.setString(3,Description);
  	    	   		 
		  	     ps.executeUpdate();
		    	 ps.close();
		    	 conn.close(); 
  	    	   	 }
  	    	   		 
//	           Statement stmt = conn.createStatement();
//	           ResultSet res = stmt.executeQuery(query);
//	           res.next();
//	           
//	           Pizza addPizza = new Pizza(res.getInt("id"),res.getString("DesignPizz"),res.getDouble("TarifPizz"),res.getString("Description"));
//	           stmt.close();
//	           res.close();
//	           return addPizza;
	           
	       }
             
             static public void updatePizza(int pizzaid, String DesignPizz, double TarifPizz, String Description) throws SQLException, ClassNotFoundException {
  	    	   
//            	 System.out.println("je suis dans la requête update ");
            	 String query = "UPDATE t_pizza SET DesignPizz = ? , TarifPizz = ? , Description = ? where id = ?;";
  	    	   	 try (Connection conn = DatabaseConnection.initializeDatabase();
  	    			 PreparedStatement ps = conn.prepareStatement(query);){
//  	    	   Statement st = conn.createStatement(); 
  	    	   
//  	    	   PreparedStatement ps = conn.prepareStatement("UPDATE t_pizza SET DesignPizz = ? , TarifPizz = ? , Description = ? where id = " + pizzaid);
  	    	   
	  	    	   ps.setString(1,DesignPizz);
		  	       ps.setDouble(2,TarifPizz);
		  	       ps.setString(3,Description);
		  	       ps.setInt(4,pizzaid);
	  	       
	  	
	  	    	 ps.executeUpdate();
		    	 ps.close();
		    	 conn.close(); 
  	    	   	}
  	    	   	 
  	       }
	       
            static public void deletePizzaById(int pizzaid) throws SQLException, ClassNotFoundException {
	    	   
            	
            	String query = "delete from t_pizza where id = ?;";
 	    	   	 try (Connection conn = DatabaseConnection.initializeDatabase();
 	    			 PreparedStatement ps = conn.prepareStatement(query);){
            	
 	    	   		ps.setInt(1,pizzaid);
 	    	   		
 	    	   	 ps.executeUpdate();
		    	 ps.close();
		    	 conn.close(); 
 	    	   	}
            		           
	       }
	
}
