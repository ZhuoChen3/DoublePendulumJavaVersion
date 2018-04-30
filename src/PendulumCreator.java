import java.util.ArrayList;
public class PendulumCreator {
    public static ArrayList<DoublePendulum> pendulumList = new ArrayList<>();
    public static void creatPendulumList() {
        DoublePendulum pendulum = new DoublePendulum(Math.PI / 2, Math.PI, 0,0,0);
        pendulumList.add(pendulum);
        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
            double[] out = pendulum.move(0.00001);
            for (double o : out) {
                System.out.print(o + "   ");
            }
            pendulum = new DoublePendulum(out[0], out[1], out[2], out[3], out[4]);
            pendulumList.add(pendulum);
            System.out.println();
        }
    }
    public static void main(String[] test) {
        creatPendulumList();
    }
}
