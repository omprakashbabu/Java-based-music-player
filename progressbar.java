import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class progressBar extends JComponent {
private int totalTime = 300; // Total length of the song in seconds
private int currentTime = 0; // Current progress of the song in seconds
private int circleX = 0;
private Timer timer;
public progressBar() {
setPreferredSize(new Dimension(400, 20)); // Reduced bar height
addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
int progressBarWidth = getWidth();
int clickX = e.getX();
int newTime = (int) (((double) clickX / progressBarWidth) * totalTime);
setCurrentTime(newTime);
}
});
timer = new Timer(1000, e -> {
if (currentTime < totalTime) {
currentTime++;
updateCirclePosition();
repaint();
}
});
}
public void start_() {
if (timer != null && !timer.isRunning()) {
timer.start();
}
}
public void stop_() {
if (timer != null && timer.isRunning()) {
timer.stop();
}
}
private void updateCirclePosition() {
double progressRatio = (double) currentTime / totalTime;
circleX = (int) (progressRatio * getWidth());
}
private void setCurrentTime(int newTime) {
if (newTime >= 0 && newTime <= totalTime) {
currentTime = newTime;
updateCirclePosition();
repaint();
}
}
@Override
protected void paintComponent(Graphics g) {
super.paintComponent(g);
int progressBarHeight = 5; // Further reduced bar height
int circleDiameter = 13; // Diameter of the moving circle
// Draw the progress bar in the background (white)
g.setColor(Color.CYAN);
g.fillRect(0, (getHeight() - progressBarHeight) / 2, getWidth(), progressBarHeight);
// Draw the played part of the progress bar in a different color (gray)
g.setColor(Color.BLACK);
g.fillRect(0, (getHeight() - progressBarHeight) / 2, circleX, progressBarHeight);
// Draw the remaining part of the progress bar (white)
g.setColor(Color.GRAY);
g.fillRect(circleX, (getHeight() - progressBarHeight) / 2, getWidth() - circleX, progressBarHeight);
// Draw the moving circle (black) on top
g.setColor(Color.BLACK);
g.fillOval(circleX - circleDiameter / 2, (getHeight() - circleDiameter) / 2, circleDiameter, circleDiameter);
}
}