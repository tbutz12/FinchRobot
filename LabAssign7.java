package Code;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Lab Assignment 7 This program uses a JPanel window to initiate Finch robot
 * movements
 *
 * @author tristin.butz
 */
public final class LabAssign7 extends JFrame {
//establish global variables to use throughout class

    private JButton forward, right, backward, left, dance;
    private JPanel p1, p2, p3, p4, p5, main;
    Finch martyMcFinch;

    public LabAssign7() {
        martyMcFinch = new Finch();
        //call methods
        Buttons();
        Panels();
        MainPanel();
        Specialty o = new Specialty();
        //initiate events
        forward.addActionListener(o);
        right.addActionListener(o);
        backward.addActionListener(o);
        left.addActionListener(o);
        dance.addActionListener(o);
        pack();
        setVisible(true);
        this.setLocation(200, 200);

    }

    public void Buttons() {
        //create buttons
        forward = new JButton("Forward");
        forward.setBackground(Color.green);
        right = new JButton("Right");
        right.setBackground(Color.green);
        backward = new JButton("Backward");
        backward.setBackground(Color.green);
        left = new JButton("Left");
        left.setBackground(Color.green);
        dance = new JButton(new ImageIcon("santa.jpg"));
    }

    public void Panels() {
        //create panels
        p1 = new JPanel();
        p1.setBackground(Color.red);
        p1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
        p1.add(forward);
        p2 = new JPanel();
        p2.add(right);
        p2.setBackground(Color.red);
        p2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
        p3 = new JPanel();
        p3.add(backward);
        p3.setBackground(Color.red);
        p3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
        p4 = new JPanel();
        p4.setBackground(Color.red);
        p4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
        p4.add(left);
        p5 = new JPanel();
        p5.setBackground(Color.red);
        p5.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
        p5.add(dance);
    }

    public void MainPanel() {
        //assign panels to main panel
        main = new JPanel(new BorderLayout());
        main.add(p1, BorderLayout.NORTH);
        main.add(p2, BorderLayout.EAST);
        main.add(p3, BorderLayout.SOUTH);
        main.add(p4, BorderLayout.WEST);
        main.add(p5, BorderLayout.CENTER);
        add(main);
    }

    public class PlaySong extends Thread {
        //play a fun Christmas Jingle :)

        @Override

        public void run() {
            try {
                int b = 242;
                int c = 262;
                int d = 294;
                int e = 330;
                int g = 392;
                int f = 350;
                int notes[] = {e, e, e, e, e, e, e, g, c, d, e};
                int notes2[] = {f, f, f, f, f, e, e, e, e, e, d, d, e, d, g};
                int notes3[] = {e, e, e, e, e, e, e, g, c, d, e};
                int notes4[] = {f, f, f, f, f, e, e, e, e, g, g, f, d, c, b};
                int note = 1000;
                int half = note / 2;
                int quarter = note / 4;
                int eighth = note / 8;
                int durations[] = {quarter, quarter, half, quarter, quarter, half, quarter, quarter, quarter + eighth, eighth, half};
                int durations2[] = {quarter, quarter, quarter + eighth, eighth, quarter, quarter, quarter, eighth, eighth, quarter, quarter, quarter, quarter, half, half};
                int durations3[] = {quarter, quarter, half, quarter, quarter, half, quarter, quarter, quarter + eighth, eighth, half};
                int durations4[] = {quarter, quarter, quarter, quarter, quarter, quarter, eighth, eighth, quarter, quarter, quarter, quarter, quarter, half};

                for (int i = 0; i < notes.length; i++) {

                    martyMcFinch.playTone(notes[i], durations[i]);

                }
                for (int i = 0; i < notes2.length; i++) {
                    martyMcFinch.playTone(notes2[i], durations2[i]);
                }
                for (int i = 0; i < notes3.length; i++) {

                    martyMcFinch.playTone(notes3[i], durations3[i]);

                }
                for (int i = 0; i < notes4.length; i++) {

                    martyMcFinch.playTone(notes4[i], durations4[i]);

                }

            } catch (ArrayIndexOutOfBoundsException x) {
                System.out.println("Merry Christmas!");
            }

        }
    }

    public class DoDance extends Thread {
//do a fun dance

        @Override
        public void run() {
            for (int i = 0; i < 7; i++) {
                martyMcFinch.setWheelVelocities(250, 0, 500);
                martyMcFinch.setLED(Color.red);
                martyMcFinch.setWheelVelocities(0, 250, 500);
                martyMcFinch.setWheelVelocities(50, -250, 500);
                martyMcFinch.setLED(Color.green);
                martyMcFinch.setWheelVelocities(-250, 50, 500);
            }
            martyMcFinch.setLED(Color.black);

        }
    }

    private class Specialty implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//creates seperate events for buttons
            if (e.getSource() == forward) {
                martyMcFinch.setLED(Color.CYAN);
                martyMcFinch.setWheelVelocities(200, 200, 2500);
                martyMcFinch.setLED(Color.black);
            } else if (e.getSource() == right) {
                martyMcFinch.setLED(Color.PINK);
                martyMcFinch.setWheelVelocities(250, 50, 2500);
                martyMcFinch.setLED(Color.black);
            } else if (e.getSource() == backward) {
                martyMcFinch.setLED(Color.MAGENTA);
                martyMcFinch.setWheelVelocities(-250, -250, 2500);
                martyMcFinch.setLED(Color.black);
            } else if (e.getSource() == left) {
                martyMcFinch.setLED(Color.magenta);
                martyMcFinch.setWheelVelocities(50, 250, 2500);
                martyMcFinch.setLED(Color.black);
            } else if (e.getSource() == dance) {
                PlaySong bells = new PlaySong();
                bells.start();
                DoDance jiggle = new DoDance();
                jiggle.start();
            }

        }
    }

    public static void main(String[] args) {
        //start class
        LabAssign7 myApp = new LabAssign7();
        //exit class
        myApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
