import java.awt.*;
import javax.swing.JComponent;
public class TimeAngle extends JComponent{
    public void paint(Graphics g) {
        double totalTime = Graph.iteration * Graph.h;
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < DoublePendulum.size; i++) {
            int angle1 = ((int)(-DoublePendulum.angle1s[i] * (Draw.height2 / (12 * Math.PI)) + Draw.height2 / 2));
            int angle2 = ((int)(-DoublePendulum.angle2s[i] * (Draw.height2 / (12 * Math.PI)) + Draw.height2 / 2));
            int time = (int)(DoublePendulum.ts[i] * Draw.width2 / (totalTime));
            g2d.setColor(Color.RED);
            g2d.drawLine(time, angle1, time, angle1);
            g2d.setColor(Color.BLUE);
            g2d.drawLine(time, angle2, time, angle2);
        }
        g2d.setColor(Color.BLACK);
        for (int i = -6; i <= 6; i += 2) {
            g2d.drawLine(0, Draw.height2 / 2 + i * Draw.height2 / 12, Draw.width2, Draw.height2 / 2 + i * Draw.height2 / 12);
            g2d.drawString((String.valueOf(i) + String.valueOf((char) 960)), 10, Draw.height2 / 2 - i * Draw.height2 / 12 + 20);
        }
        for (double i = 0; i < totalTime; i += totalTime / 10) {
            g2d.drawLine((int) (i / totalTime * Draw.width2), 0, (int) (i / totalTime * Draw.width2), Draw.height2);
            g2d.drawString((String.valueOf(i) + "s"), (int) (i / totalTime * Draw.width2) + 20, 10);
        }
    }
}
