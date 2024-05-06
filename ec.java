import java.sql.*;
public class EstablishConnection {
public static Connection connect(){
//Setting the credentials
String url = "jdbc:mysql://localhost:3306/music_player";
String user = "root";
String password = "password";
Connection con = null;
//Establishing the Connection
try{
//Importing the driver for the SQL Connection
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
con = DriverManager.getConnection(url, user, password);
System.out.println("Connection to the server successfully established");
}catch(Exception e){
System.out.println("Could not establish connection with the server.");
return null;
}
return con;
}
}