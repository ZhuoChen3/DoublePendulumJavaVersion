import java.awt.*;
import javax.swing.JComponent;
public class TimeHeight extends JComponent{
    public void paint(Graphics g) {
        double totalTime = Graph.iteration * Graph.h;
        Graphics2D g2d = (Graphics2D) g;
        double l1 = DoublePendulum.getL1();
        double l2 = DoublePendulum.getL2();
        for (int i = 0; i < DoublePendulum.size; i++) {
//            double angle1 = -DoublePendulum.pendulums[i].getTheta1();
//            double angle2 = -DoublePendulum.pendulums[i].getTheta2();
            int height1 = (int) ((DoublePendulum.y1s[i]) / (l1 + l2) * Draw.height4 / 2 * 0.8 + Draw.height4 / 2);
            int height2 = (int) ((DoublePendulum.y2s[i]) / (l1 + l2) * Draw.height4 / 2 * 0.8 + Draw.height4 / 2);
            int time = (int)(DoublePendulum.ts[i] * Draw.width4 / (totalTime));
            g2d.setColor(Color.RED);
            g2d.drawLine(time, height1, time, height1);
            g2d.setColor(Color.BLUE);
            g2d.drawLine(time, height2, time, height2);
        }
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, (int) (Draw.height4 / 2 * 0.2), Draw.width3, (int) (Draw.height4 / 2 * 0.2));
        g2d.drawLine(0, (int) (Draw.height4 / 2 * 1.8), Draw.width3, (int) (Draw.height4 / 2 * 1.8));
        g2d.drawLine(0, Draw.height4 / 2, Draw.width3, (int) (Draw.height4 / 2));
        g2d.drawString(String.valueOf(l1 + l2) + "m", 10, (int) (Draw.height4 / 2 * 0.2) - 15);
        g2d.drawString(String.valueOf(- l1 - l2) + "m", 10, (int) (Draw.height4 / 2 * 1.8) - 15);
        g2d.drawString("0m", 10, (int) (Draw.height4) / 2 - 15);
        for (double i = 0; i < totalTime; i += totalTime / 10) {
            g2d.drawLine((int) (i / totalTime * Draw.width4), 0, (int) (i / totalTime * Draw.width4), Draw.height4);
            g2d.drawString((String.valueOf(i) + "s"), (int) (i / totalTime * Draw.width4) + 20, 10);
        }
    }
}
