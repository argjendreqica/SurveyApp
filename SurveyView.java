import javax.swing.*;
import java.awt.*;


public class SurveyView extends JPanel{
    private int WIDTH = 1000;
    private int HEIGHT = 75;
    private int space = 15;
    private String[][] dates;


    public SurveyView( String[][] vargu ) {

        dates = vargu;
    }
    
    
    public void display() {
        int i = dates.length+1;
        JFrame frame = new JFrame();
        frame.setSize(WIDTH + 2*space,i*HEIGHT);
        frame.setTitle("Survey App");
        frame.setVisible(true);
        frame.getContentPane().add(this);
        frame.setLocationRelativeTo(null);


    }
    public void paintComponent(Graphics g){
       
        System.out.print(dates.length);
        for(int i = 0; i<dates.length; i++) {
		      if(i==0) {
		          g.setColor(Color.GRAY);
		          g.fillRect(0,i*HEIGHT, WIDTH, HEIGHT);
		          g.setColor(Color.BLACK);
		          g.drawRect(0,i*HEIGHT, WIDTH, HEIGHT);
		      }
		      else {
		          g.setColor(Color.LIGHT_GRAY);
		          g.fillRect(0,i*HEIGHT, WIDTH, HEIGHT);
		          g.setColor(Color.BLACK);
		          g.drawRect(0,i*HEIGHT, WIDTH, HEIGHT);
		      }
		      for(int j=0; j<5; j++) {
		          g.setColor(Color.BLUE);
		          g.drawLine(j*WIDTH/5, i*HEIGHT, j*WIDTH/5, HEIGHT*(i+1));
		          if(i==0) g.setColor(Color.BLACK);

		          g.drawString(dates[i][j], space + j*(WIDTH/5),((i+1)*HEIGHT)-35);
		      }
        }
    }
}









