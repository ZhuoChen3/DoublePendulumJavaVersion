import javax.swing.JFrame;
public class Draw {
    public static int width1 = 1000;
    public static int height1 = 1000;
    public static int width2 = 2000;
    public static int height2 = 1000;
    public static int width3 = 2000;
    public static int height3 = 500;
    public static int width4 = 2000;
    public static int height4 = 500;
    public static void drawIt() {
        JFrame window1 = new JFrame();

        window1.setSize(width1, height1);
        window1.setVisible(true);
        window1.setTitle("Double Pendulum");
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Graph G = new Graph();
        window1.add(G);
        JFrame window2 = new JFrame();
        window2.setSize(width2, height2);
        window2.setVisible(true);
        window2.setTitle("Angle-Time Graph");
        window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TimeAngle TA = new TimeAngle();
        window2.add(TA);
        JFrame window3 = new JFrame();
        window3.setSize(width3, height3);
        window3.setVisible(true);
        window3.setTitle("Position-Time Graph");
        window3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TimePosition TP = new TimePosition();
        window3.add(TP);
        JFrame window4 = new JFrame();
        window4.setSize(width4, height4);
        window4.setVisible(true);
        window4.setTitle("Height-Time Graph");
        window4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TimeHeight TH = new TimeHeight();
        window4.add(TH);
    }
    public static void main(String[] args) {
        System.out.println(String.valueOf((char) 960));
    }
}
