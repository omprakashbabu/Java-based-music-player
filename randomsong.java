import java.util.Random;
import java.util.ArrayList;
import java.sql.*;
public class RandomSong {
static int random_number(int n){
Random rand = new Random();
return rand.nextInt(n);
}
//Code for shuffling music from the playlist:
public static String[] rand_song(Connection con,ArrayList<Integer> dynamicArray){
String[] ret = null;
try{
String sqlQuery = "SELECT * FROM songs";
Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //This ensures that ResultSet.last() and resultSet.beforeFirst() can be used in the program
ResultSet resultSet = statement.executeQuery(sqlQuery);
int rand_num = 0;
while(rand_num == 0){ //Ensures that the returned integer isn't zero.
rand_num = random_number(Variables.n+1); //Produces a random number for the music player to shuffle to
}
dynamicArray.add(rand_num); //This ensures that the already played song isn't played again
for(int i=0;i<rand_num;i++){
resultSet.next();
}
String name = resultSet.getString("Name");
String filename = resultSet.getString("Filename");
ret = new String[]{name, filename};
}catch(Exception e){
e.printStackTrace();
}
return ret;
}
}