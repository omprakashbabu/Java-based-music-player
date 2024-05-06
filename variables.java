import java.util.ArrayList;
public class Variables{
static int n; //Total number of songs in the table
static ArrayList<Integer> songs_played = new ArrayList<>(); //Stores the number of the records which've already been played (Will be used by previous function)
}
AudioPlayerThread.java:
public class AudioPlayerThread extends Thread {
public Decode decode;
public AudioPlayerThread(Decode decode) {
this.decode = decode;
}
public void run() {
try {
decode.play();
} catch (Exception e) {
e.printStackTrace();
}
}
public void pausePlayback() {
decode.pause();
}
public void resumePlayback() {
decode.resume();
}
}