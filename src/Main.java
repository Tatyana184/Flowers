import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedImage image = ImageIO.read(new File("src/19.png"));
        BufferedImage image2 = ImageIO.read(new File("src/20.png")) ;

        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JLabel wIcon = new JLabel(new ImageIcon(image));
        JLabel wIcon2 = new JLabel(new ImageIcon(image2));

        int width = image.getWidth();
        int height = image.getHeight();

        int width2 = image2.getWidth();
        int height2 = image2.getHeight();

        wIcon2.setBounds(300 - width2/2 , 300 - height2/2, width2, height2);// установка картинки по середине
        wIcon.setBounds(300- width/2, 300/20, width,height);


        frame.add(wIcon2);
        frame.add(wIcon);

        int radius= 600/2-Math.max(width, height);// находим оптимальный радиус окружности
        int deltaX= 600/2-width/2, deltaY= 600/2-height/2;//константы для смещения картинки, чтобы не рассчитывать их постоянно
        for (int t = 0; t < 360;) {
            try {//сперва работает таймер
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            wIcon.setBounds((int) (radius*Math.cos(t*Math.PI/180))+deltaX, (int) (radius*Math.sin(t*Math.PI/180))+deltaY, width,height);//перемещаем картинку в нужную точку, которую вычисляем по формуле параметрических уравнений линий, приводя градусы t к радианам
            wIcon.repaint();//перерисовываем картинку
            t=t==359?0:t+1;//этой формулой обеспечиваем постоянный цикл и обнуление t при 359
        }
    }
}