
package mypackage;

import com.sun.istack.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

public class login {
    
    
      Statement st;
    
    void details(String bemail, String bpassword){
        connectToDb();
        String sql = "insert into login(email,password) VALUES ('"+bemail+"','"+bpassword+"')";
        
         try {
        st.executeUpdate(sql);
    } catch (SQLException ex) {
         java.util.logging.Logger.getLogger(homesignup.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
 
 private void connectToDb() {
        String url ="jdbc:mysql://localhost:3306/lwebsdb";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,"root","");
            st = con.createStatement();
         
        } catch (ClassNotFoundException|SQLException  ex) {
            
        }
        
    }
   
}

