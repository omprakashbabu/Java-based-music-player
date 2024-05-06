import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class myFrame implements ActionListener {
JFrame Frame;
LoadingScreen loadingScreen;
progressBar progressbar;
JFrame frame = new JFrame();
JLabel label = new JLabel();
JLabel app_logo = new JLabel();
JLabel circle_logo = new JLabel();
Icon play_icon= new ImageIcon("src\\play.png");
Icon pause_icon= new ImageIcon("src\\pause.png");
JButton folder = new JButton();
JTextField searchText = new JTextField();
private boolean textFieldVisible;
RoundedButton play = new RoundedButton(new Color(14, 70, 124),new Color(152, 70, 124));
RoundedButton previous = new RoundedButton(new Color(14, 70, 124),new Color(152, 70, 124));
RoundedButton next = new RoundedButton(new Color(14, 70, 124),new Color(152, 70, 124));
RoundedButton shuffle = new RoundedButton(new Color(14, 70, 124),new Color(152, 70, 124));
RoundedButton repeat = new RoundedButton(new Color(14, 70, 124),new Color(152, 70, 124));
RoundedButton home = new RoundedButton(new Color(14, 70, 124),new Color(152, 70, 124));
RoundedButton liked = new RoundedButton(new Color(14, 70, 124),new Color(152, 70, 124));
RoundedButton search = new RoundedButton(new Color(14, 70, 124),new Color(152, 70, 124));
JButton menu = new JButton(new ImageIcon("src\\menu.png"));
GradientPanel panel_l = new GradientPanel(Color.decode("#8E0E00"),Color.decode("#1F1C18"),70);
GradientPanel panel_d = new GradientPanel(Color.decode("#333300"),Color.decode("#b21f1f"),70);
GradientPanel panel_t = new GradientPanel(Color.decode("#6f0000"),Color.decode("#200122"),70);
GradientPanel panel_r = new GradientPanel(Color.decode("#6f0000"),Color.decode("#1D4350"),70);
boolean img = true;
App song = new App();
myFrame(){
frame.setTitle("Music player application"); //Title of the frame
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits when the user clicks the close button
frame.setResizable(false); //prevent frame from being resized
frame.setSize(1000,700); //sets the x-dimension and y-dimension of the frame
frame.setLocationRelativeTo(null);
frame.setLayout(null);
//Button
folder = new JButton("Import your music folder");
folder.setIcon(new ImageIcon("src\\Folder.png"));
//folder.setOpaque(false);
folder.setBounds(35,235,180,40);
folder.setBackground(new Color(80,23,84));
folder.setFocusable(false);
folder.setBorder(BorderFactory.createCompoundBorder());
folder.setForeground(Color.pink);
folder.addActionListener(this);
folder.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e){ openFileChooser(); }
});
folder.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent e){ folderclicked(e); }
public void mouseEntered(MouseEvent e){ folderEntered(e); }
public void mouseExited(MouseEvent e){ folderExited(e);}
});
home.setIcon(new ImageIcon("src\\Home.png"));
home.setText("Home");
home.setOpaque(false);
home.setBounds(50,70,150,40);
home.setBackground(new Color(90,37,53));
home.setFocusable(false);
home.setBorder(BorderFactory.createEmptyBorder());
home.setForeground(Color.BLACK);
menu.setBounds(10, 12, 40, 40);
menu.setBackground(null);
menu.setOpaque(false);
menu.setFocusable(false);
menu.setBorder(BorderFactory.createEmptyBorder());
menu.addActionListener(this);
menu.addMouseListener(new MouseAdapter()
{
public void mouseClicked(java.awt.event.MouseEvent e){ menuclicked(e); }
public void mouseExited(java.awt.event.MouseEvent e){ menuexited(e); }
});
liked.setText("Favorites");
liked.setIcon(new ImageIcon("src\\liked.png"));
liked.setOpaque(false);
liked.setBounds(50,200,150,40);
liked.setBackground(Color.BLACK);
liked.setFocusable(false);
liked.setBorder(BorderFactory.createEmptyBorder());
liked.setForeground(Color.black);
liked.addActionListener(this);
liked.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent e){ likedclicked(e); }
public void mouseEntered(MouseEvent e){ likedEntered(e);}
public void mouseExited(MouseEvent e){ likedExited(e); }
});
////////////////////// TextField //////////////////
searchText = new JTextField("What are you looking for",50);
searchText.setBounds(20,445,210,40);
searchText.setBackground(Color.gray);
searchText.setBorder(null);
searchText.setForeground(Color.WHITE);
searchText.setVisible(false);
textFieldVisible = false;
search.setIcon(new ImageIcon("src\\Search.png"));
search.setText("Find");
search.setOpaque(false);
search.setBounds(50, 500, 150, 40);
search.setBackground(null);
search.setFocusable(false);
search.setBorder(BorderFactory.createEmptyBorder());
search.setForeground(Color.BLACK);
search.addActionListener(this);
search.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (textFieldVisible) {
searchText.setVisible(false);
textFieldVisible = false;
} else {
searchText.setVisible(true);
textFieldVisible = true;
}
}
});
searchText.addFocusListener(new FocusListener() {
@Override
public void focusGained(FocusEvent e) {
if (searchText.getText().equals("What are you looking for")) {
searchText.setText("");
}
}
@Override
public void focusLost(FocusEvent e) {
if (searchText.getText().isEmpty()) {
searchText.setText("What are you looking for");
}
}
});
play.setIcon(play_icon);
play.setOpaque(false);
play.setBounds(450, 40, 90, 40);
play.setFocusable(false);
play.setBackground(null);
play.setBorder(BorderFactory.createEmptyBorder());
play.setForeground(Color.BLACK);
play.addActionListener(this);
play.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent e){ playclicked(e); }
public void mouseEntered(MouseEvent e){ playentered(e); }
public void mouseExited(MouseEvent e){ playexited(e); }
});
previous.setIcon(new ImageIcon("src\\prenew.png"));
previous.setOpaque(false);
previous.setBounds(300,605,90,40);
previous.setFocusable(false);
previous.setBackground(null);
previous.setBorder(BorderFactory.createEmptyBorder());
previous.setForeground(Color.black);
previous.addActionListener(this);
previous.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent r){ preclicked(r);}
public void mouseEntered(MouseEvent r){ preEntered(r); }
public void mouseExited(MouseEvent r){preExited(r);}
});
//next = new RoundedButton("next");
next.setIcon(new ImageIcon("src\\nextnew.png"));
next.setOpaque(false);
next.setBounds(600,605,90,40);
next.setFocusable(false);
next.setBackground(null);
next.setBorder(BorderFactory.createEmptyBorder());
next.setForeground(Color.black);
next.addActionListener(this);
next.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent r){nextclicked(r);}
public void mouseEntered(MouseEvent r){nextEntered(r);}
public void mouseExited(MouseEvent r){nextExited(r);}
});
shuffle.setIcon(new ImageIcon("src\\shuffle.png"));
shuffle.setOpaque(false);
shuffle.setBounds(150,605,90,40);
shuffle.setFocusable(false);
shuffle.setBackground(null);
shuffle.setBorder(BorderFactory.createEmptyBorder());
shuffle.setForeground(Color.black);
shuffle.addActionListener(this);
shuffle.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent r){shuffleclicked(r);}
public void mouseEntered(MouseEvent r){shuffleEntered(r);}
public void mouseExited(MouseEvent r){shuffleExited(r);}
});
repeat.setIcon(new ImageIcon("src\\repeat.png"));
repeat.setOpaque(false);
repeat.setBounds(750,605,80,40);
repeat.setFocusable(false);
repeat.setBackground(null);
repeat.setBorder(BorderFactory.createEmptyBorder());
repeat.setForeground(Color.black);
repeat.addActionListener(this);
repeat.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent r){repeatclicked(r);}
public void mouseEntered(MouseEvent r){repeatEntered(r);}
public void mouseExited(MouseEvent r){repeatExited(r);}
});
//Adding to the panel
panel_l.add(folder);
panel_l.add(search);
panel_l.add(home);
panel_l.add(liked);
panel_l.add(searchText);
panel_l.add(menu);
panel_d.add(previous);
panel_d.add(next);
panel_d.add(repeat);
progressbar = new progressBar();
progressbar.setBounds(240, 13, 550, 15);
progressbar.setLayout(null);
panel_d.add(progressbar);
panel_t.add(label);
//panels
panel_t.setBounds(0,0,1000,100);
panel_t.setBackground(Color.black);
panel_t.setLayout(null);
panel_t.setBorder(BorderFactory.createEmptyBorder());
panel_l.setBounds(0,100,250, 465);
panel_l.setBackground(new Color(30,10,20));
panel_l.setLayout(null);
panel_t.setBorder(BorderFactory.createEmptyBorder());
panel_d.setBounds(0,565,1000,105);
panel_d.setBackground( new Color(48,25,52));
panel_d.setLayout(null);
panel_t.setBorder(BorderFactory.createEmptyBorder());
panel_d.add(play);
panel_r.setBounds(250,100,750,465);
panel_r.setBackground(new Color(10,10, 20));
panel_r.setLayout(null);
panel_t.setBorder(BorderFactory.createEmptyBorder());
panel_r.setLayout(new FlowLayout(FlowLayout.CENTER));
panel_t.setBorder(BorderFactory.createEmptyBorder());
//Adding
frame.add(folder);
frame.add(searchText);
frame.add(search);
frame.add(previous);
frame.add(next);
frame.add(shuffle);
frame.add(repeat);
frame.add(panel_l);
frame.add(panel_d);
frame.add(panel_t);
frame.add(panel_r);
ImageIcon m_image = new ImageIcon("src\\nlogo.png"); //Creates image icon
frame.setIconImage(m_image.getImage()); //Change Icon of the frame
frame.getContentPane().setBackground(new Color(30,30,30));
app_logo = new JLabel(new ImageIcon("src\\applogo.png"));
app_logo.setBounds(90,12,80,80);
//app_logo.setForeground(Color.WHITE);
panel_t.add(app_logo);
circle_logo = new JLabel(new ImageIcon("src\\circle.png"));
circle_logo.setBounds(80,0,100,100);
//app_logo.setForeground(Color.WHITE);
panel_t.add(circle_logo);
//play.getContentPane().setBackground(getForeground());
label = new JLabel("RYTHMIX");
label.setFont(new Font("Josepin Sans",Font.BOLD,50));
label.setBounds(400,0,440,100);
label.setForeground(new Color(185,100,100));
panel_t.add(label);
frame.setVisible(true); //frame line is mandatory , because it makes the frame visible
}
public void menuclicked(java.awt.event.MouseEvent e){menu.setBackground(Color.LIGHT_GRAY);}
public void menuexited(java.awt.event.MouseEvent e){menu.setBackground(null);}
public void actionPerformed(ActionEvent e){
if (e.getSource() == play) {
Icon image = play.getIcon();
if (image.equals(play_icon)) {
// Start the progress bar
progressbar.start_();
play.setIcon(pause_icon);
song.playerThread.resumePlayback();
}
if (image.equals(pause_icon)) {
// Stop the progress bar
progressbar.stop_();
play.setIcon(play_icon);
song.playerThread.pausePlayback();
}
}
}
public void playclicked(MouseEvent e){ play.setBackground(Color.CYAN);}
public void playentered(MouseEvent e){play.setBackground(Color.RED);}
public void playexited(MouseEvent e){play.setBackground(Color.lightGray);}
public void precolor(ActionEvent r){}
public void preclicked(MouseEvent r){previous.setBackground(Color.CYAN);}
public void preEntered(MouseEvent r){previous.setBackground(Color.RED);}
public void preExited(MouseEvent r){previous.setBackground(Color.lightGray);}
public void nextcolor(ActionEvent r){}
public void nextclicked(MouseEvent r){next.setBackground(Color.CYAN);}
public void nextEntered(MouseEvent r){next.setBackground(Color.RED);}
public void nextExited(MouseEvent r){next.setBackground(Color.lightGray);}
public void shufflecolor(ActionEvent r){}
public void shuffleclicked(MouseEvent r){shuffle.setBackground(Color.CYAN);}
public void shuffleEntered(MouseEvent r){shuffle.setBackground(Color.RED);}
public void shuffleExited(MouseEvent r){shuffle.setBackground(Color.lightGray);}
public void repeatcolor(ActionEvent r){}
public void repeatclicked(MouseEvent r){repeat.setBackground(Color.CYAN);}
public void repeatEntered(MouseEvent r){repeat.setBackground(Color.RED);}
public void repeatExited(MouseEvent r){repeat.setBackground(Color.lightGray);}
public void homecolor(ActionEvent r){}
public void homeclicked(MouseEvent r){home.setBackground(Color.CYAN);}
public void homeEntered(MouseEvent r){home.setBackground(Color.RED);}
public void homeExited(MouseEvent r){home.setBackground(new Color(90,37,53));}
public static void openFileChooser(){
JFileChooser fileChooser = new JFileChooser();
int result = fileChooser.showOpenDialog(null);
if(result == JFileChooser.APPROVE_OPTION){
String selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();
JOptionPane.showMessageDialog(null, "Selected File: " + selectedFilePath);
}
}
public void foldercolor(ActionEvent r){}
public void folderclicked(MouseEvent r){folder.setBackground(Color.CYAN);}
public void folderEntered(MouseEvent r){folder.setBackground(Color.RED);}
public void folderExited(MouseEvent r){folder.setBackground(new Color(80,23,84));}
public void likedcolor(ActionEvent r){}
public void likedclicked(MouseEvent r){liked.setBackground(Color.CYAN);}
public void likedEntered(MouseEvent r){liked.setBackground(Color.RED);}
public void likedExited(MouseEvent r){liked.setBackground(Color.GRAY);}
}