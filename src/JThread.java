import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class JThread extends Thread{
    JLabel wIcon;
    BufferedImage image;
    JThread(JLabel wIcon, BufferedImage image){
     this.wIcon = wIcon;
     this.image = image;

    }

    public void run(){


        int radius= 600/ 2 -Math.max(image.getWidth(), image.getHeight());// ������� ����������� ������ ����������
        int deltaX= 600/2-image.getWidth()/2, deltaY= 600/2-image.getHeight()/2;//��������� ��� �������� ��������


        for (int t = 0; t < 360;) {
            try {//������ �������� ������
                Thread.sleep((int) (Math.random() * 50));
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            wIcon.setBounds((int) (radius*Math.cos(t*Math.PI/180))+deltaX, (int) (radius*Math.sin(t*Math.PI/180))+deltaY, image.getWidth(),image.getHeight());
            //���������� �������� � ������ �����, ������� ��������� �� ������� ��������������� ��������� �����, ������� ������� t � ��������
            wIcon.repaint();//�������������� ��������
            t=t==359?0:t+1;//���� �������� ������������ ���������� ���� � ��������� t ��� 359
        }
    }
}
