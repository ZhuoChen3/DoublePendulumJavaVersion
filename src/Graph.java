import java.awt.*;
import javax.swing.JComponent;
public class Graph extends JComponent{
    public static double h = Run.H;
    public static int iteration = Run.ITERATION;
    public static double ang1 = Run.ANGLE_1;
    public static double ang2 = Run.ANGLE_2;
    public static double angV1 = Run.ANGULAR_VELOCITY_1;
    public static double angV2 = Run.ANGULAR_VELOCITY_2;
    public static double initialTime = 0;
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        DoublePendulum pendulum = new DoublePendulum(ang1, ang2, angV1,angV2,initialTime);
        double l1 = DoublePendulum.getL1();
        double l2 = DoublePendulum.getL2();
        DoublePendulum.angle1s[0] = ang1;
        DoublePendulum.angle2s[0] = ang2;
        DoublePendulum.x1s[0] = l1 * Math.sin(ang1);
        DoublePendulum.y1s[0] = l1 * Math.cos(ang1);
        DoublePendulum.x2s[0] = l1 * Math.sin(ang1) + l2 * Math.sin(ang2);
        DoublePendulum.y2s[0] = l1 * Math.cos(ang1) + l2 * Math.sin(ang2);
        DoublePendulum.ts[0] = initialTime;
//        DoublePendulum.pendulums[0] = pendulum;
        for (int i = 0; i < iteration; i++) {
            System.out.println(i);
            double[] out = pendulum.move(h);
            for (double o : out) {
                System.out.print(o + "   ");
            }
            double xf = l1 * Math.sin(out[0]);
            double yf = l1 * Math.cos(out[0]);
            double xs = l1 * Math.sin(out[0]) + l2 * Math.sin(out[1]);
            double ys = l1 * Math.cos(out[0]) + l2 * Math.cos(out[1]);
            DoublePendulum.x1s[i + 1] = xf;
            DoublePendulum.y1s[i + 1] = yf;
            DoublePendulum.x2s[i + 1] = xs;
            DoublePendulum.y2s[i + 1] = ys;
            DoublePendulum.angle1s[i + 1] = out[0];
            DoublePendulum.angle2s[i + 1] = out[1];
            DoublePendulum.ts[i + 1] = out[4];
            int x1 = (int)(xf * (Draw.width1 / 2) / (l1 + l2) / 1.2 + (Draw.width1 / 2));
            int y1 = (int)(yf * (Draw.height1 / 2) / (l1 + l2) / 1.2 + (Draw.height1 / 2));
            int x2 = (int)((xs) * (Draw.width1 / 2) / (l1 + l2) / 1.2 + (Draw.width1 / 2));
            int y2 = (int)((ys) * (Draw.height1 / 2) / (l1 + l2) / 1.2 + (Draw.height1 / 2));
            g2d.setColor(Color.RED);
            g2d.drawLine(x1, y1, x1, y1);
            g2d.setColor(Color.BLUE);
            g2d.drawLine(x2, y2, x2, y2);
            pendulum = new DoublePendulum(out[0], out[1], out[2], out[3], out[4]);
            System.out.println();
//            DoublePendulum.pendulums[i + 1] = pendulum;
        }
        g2d.setColor(Color.BLACK);
        g2d.drawLine(Draw.width1 / 2 - 2, Draw.height1 / 2, Draw.width1 / 2 + 2, Draw.height1 / 2);
        g2d.drawLine(Draw.width1 / 2, Draw.height1 / 2 - 2, Draw.width1 / 2, Draw.height2 / 2 + 2);
    }
}
