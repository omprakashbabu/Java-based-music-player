import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LoadingScreen {
private JFrame frame;
public JProgressBar progressBar;
private JLabel titleLabel;
private Timer timer;
private int progress;
public LoadingScreen() {
frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(400, 200);
frame.setLayout(new BorderLayout());
frame.setLocationRelativeTo(null);
JPanel panel = new JPanel();
panel.setLayout(new BorderLayout());
progressBar = new JProgressBar(0, 100);
progressBar.setValue(0);
progressBar.setStringPainted(true);
titleLabel = new JLabel("Rythmix");
titleLabel.setFont(new Font("Pixelify Sans", Font.PLAIN, 24));
titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
panel.add(progressBar, BorderLayout.CENTER);
frame.add(panel, BorderLayout.SOUTH);
frame.add(titleLabel, BorderLayout.CENTER);
timer = new Timer(10, new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (progress < 100) {
progress++;
progressBar.setValue(progress);
} else {
((Timer) e.getSource()).stop();
frame.dispose();
new myFrame();
// Close the loading screen
}
}
});
}
public void start() {
frame.setVisible(true);
timer.start();
}
}