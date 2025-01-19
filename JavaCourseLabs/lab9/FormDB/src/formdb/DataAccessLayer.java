
package formdb;

import java.sql.Connection;
import org.apache.derby.jdbc.ClientDriver ; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessLayer {
    
    static private Connection con  ; 
    static{
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/USERS","root","root");
            System.out.println("yes you work weel");
            
                    } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int insert(String id , String fName , String midName , String lName , String email , String phone) throws SQLException ,Exception  {
        
        int val = -100 ; 
   
            String myStatment = 
                    "INSERT INTO USERSINFO (ID, FIRSTNAME ,MIDDLENAME, LASTNAME , EMAIL,PHONE) "
                    + "VALUES ( ?,? ,?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(myStatment);
            
            pst.setString( 1, id ); 
            pst.setString( 2, fName); 
            pst.setString( 3, midName);
            pst.setString( 4, lName ); 
            pst.setString( 5, email); 
            pst.setString( 6, phone); 
            
            val = pst.executeUpdate();
            System.out.println("this is from insert ");
            
        
        return val ;
    }
    
    public int delete(String id ) throws SQLException{
        
        int val = -100 ; 
 
            String myStatment = 
                    "DELETE FROM USERSINFO WHERE id = ?";
            
            PreparedStatement pst = con.prepareStatement(myStatment);
            
            pst.setString( 1, id ); 
            
            
            val = pst.executeUpdate();
            System.out.println("this is from delete ");
            

            return val ;
    }
    
    
        public ResultSet next(int currentIndex) throws SQLException{
        
            // have to add limit ; 
         String myStatment = 
                    "SELECT * FROM USERSINFO ";
            
            PreparedStatement pst = con.prepareStatement(myStatment , ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = pst.executeQuery();
            rs.absolute(currentIndex);
            if (rs.next()){
                return rs;
            }
            else{
            return null ;
            }
    }
    
    
    public ResultSet first() throws SQLException{
        
            // have to add limit ; 
         String myStatment = 
                    "SELECT * FROM USERSINFO ";
            
            PreparedStatement pst = con.prepareStatement(myStatment , ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = pst.executeQuery();
            
                if (rs.first()) {
                return rs; 
               } else {
                return null; // Return null if ResultSet is empty
            }
        
    }
    
    public ResultSet last() throws SQLException{
        
            // have to add limit ; 
         String myStatment = 
                    "SELECT * FROM USERSINFO  ";
            
            PreparedStatement pst = con.prepareStatement(myStatment , ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = pst.executeQuery();
                    
                if (rs.last()) {
                return rs; 
                
               } else {
                return null; // Return null if ResultSet is empty
            }
        
    }
    
    
    public int update(String id , String fName , String midName , String lName , String email , String phone) throws SQLException ,Exception  {
        
        int val = -100 ; 
   
            String myStatment = 
                    "UPDATE USERSINFO "
                    + "SET FIRSTNAME = ? ,MIDDLENAME = ? , LASTNAME = ?  , EMAIL = ? ,PHONE = ?  "
                    +"WHERE ID = ? ";
            
            PreparedStatement pst = con.prepareStatement(myStatment);
            
            pst.setString( 1, fName); 
            pst.setString( 2, midName);
            pst.setString( 3, lName ); 
            pst.setString( 4, email); 
            pst.setString( 5, phone); 
            pst.setString( 6, id ); 

            
            val = pst.executeUpdate();
            System.out.println("this is from update ");
            
        
        return val ;
    }
    
   
    
    
    
    public DataAccessLayer() {
    }
    
}
