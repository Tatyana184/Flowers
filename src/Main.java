import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        JFrame frame;
        BufferedImage image = ImageIO.read(new File("src/19.png"));
        BufferedImage image2 = ImageIO.read(new File("src/20.png")) ;
        BufferedImage image3 = ImageIO.read(new File("src/205.png")) ;

        frame = new JFrame();
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JLabel wIcon = new JLabel(new ImageIcon(image));
        JLabel wIcon2 = new JLabel(new ImageIcon(image2));
        JLabel wIcon3 = new JLabel(new ImageIcon(image3));

        int width2 = image2.getWidth();
        int height2 = image2.getHeight();


        wIcon2.setBounds(300 - width2/2 , 300 - height2/2  , width2, height2);// установка картинки по середине
        frame.add(wIcon2);

        new JThread(wIcon, image, frame).start();
        new JThread(wIcon3, image3,frame).start();


    }
}