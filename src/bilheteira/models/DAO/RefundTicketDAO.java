package bilheteira.models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RefundTicketDAO {

	    public static void refundTicket (int codigoBilhete) {
	        Connection conn = DBConnector.getConnection();
	        PreparedStatement stats = null;
	    	try {
	    	 stats = conn.prepareStatement(
	    					"UPDATE bilhete "
	    	                + "SET isDevolvido = 1 "
	    	                + "WHERE codigoBilhete = ?;"); 
	            stats.setInt(1, codigoBilhete);
	            stats.execute();
	         
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("erro no refund");
	        }
}
	    
	    public static double getPreco(int codigoBilhete) {
	    	double preco = 0;
	    	Connection conn = DBConnector.getConnection();
	    	try (java.sql.PreparedStatement stats = conn.prepareStatement("select (taxa * precoBase) from " + 
              		"	                      zona inner join evento_zona ON zonaID = zonaID_ev_zon inner join evento ON " + 
              		"	                      eventoID = eventoID_ev_zon inner join bilhete on eventoZonaID_bilhete = eventoZonaID " + 
              		"                          where codigoBilhete = ?;")){
	    		
	    	
              stats.setInt(1, codigoBilhete);
              ResultSet rs = stats.executeQuery();
              if (rs.next()){
                    preco = rs.getDouble(1);
                    } 
  			return preco;
	    	} 
	    	catch (SQLException e) {
				e.printStackTrace();
				System.out.println("erro no getPreco");
			}	
	    	return 0;
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
}