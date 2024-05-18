import java.sql.*;
public class App{
//Here starts the main function
//public static void main(String[] args){
//Setting up a scanner
Decode decode = new Decode();
AudioPlayerThread playerThread = new AudioPlayerThread(decode);
App()
{
Connection con = null;
int con_flag=1; //Considering 0 - Connection Established, 1 - Connection could not be established
con = EstablishConnection.connect(); //Credentials are set in the Class
//Setting the con_flag variable accordingly
if(con == null){ con_flag = 1;}
else{ con_flag = 0; }
//If con_flag = 1, the program should terminate as it can't establish the connection to the database
//if(con_flag == 1){ i return; }//Ends the program to not cause further errors
//The connection established is to a database called "music_player"
//In the database is a table called songs which has two fields called Name and Filename (File Location)
//Implementation of Shuffle into the music player - Returns the name and filename of the song for the music player
//Setting up the music player (Decode.java and AudioPlayerThread.java)
//Code to get the total number of songs in the table (Playlist)
try{
String sqlQuery = "SELECT * FROM songs";
Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //This ensures that ResultSet.last() and resultSet.beforeFirst() can be used in the program
ResultSet resultSet = statement.executeQuery(sqlQuery);
resultSet.last(); //Moving the cursor of resultSet to the last
Variables.n = resultSet.getRow(); //Stores the total number of songs present in the table (songs)
}catch(Exception e){};
//Runs a for loop for the songs being played
for(int x=0;x<Variables.n;x++){
try{
String[] rand_song = new String[2];
//Function to return a String[] with names of songs and filepath
rand_song = RandomSong.rand_song(con,Variables.songs_played);
//Code to run the music player
try{
decode.load(rand_song[1]);
System.out.printf("Current music being played: %s\n",rand_song[0]);
long total = decode.getClipSecondLength(); //Length of the song that is being played
playerThread.start(); //Function to play the song (Decode.java)
/*while(true){
System.out.print("1 - Pause the music\n2 - Resume the music\nEnter your choice: ");
Variables.n = input.nextInt();
if(Variables.n == 1){
playerThread.pausePlayback();
}else if(Variables.n == 2){
playerThread.resumePlayback();
}
}*/
}catch(Exception e){
e.printStackTrace();
}
}catch(Exception e){}
finally{
System.out.println("Music player closing");
playerThread.interrupt();
}
}
}
//Closes the connection to the SQL Server
/*try{
con.close();
}catch(Exception e){}
input.close();
}*/
}
