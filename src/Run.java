public class Run {
    public static final double L_1 = 5; //Length of first rod
    public static final double L_2 = 9; //Length of second rod
    public static final double M_1 = 1000; //Mass of first object
    public static final double M_2 = 1100; //Mass of second object
    public static final double H = 0.0001; //Each increment
    public static final int ITERATION = 500000; //Total iteration
    public static final double ANGLE_1 = Math.PI * 0.8; //Angle of first object
    public static final double ANGLE_2 = Math.PI; //Angle of second object
    public static final double ANGULAR_VELOCITY_1 = 0; //Initial angular velocity of first object
    public static final double ANGULAR_VELOCITY_2 = 0; //Initial angular velocity of second object
    public static void main(String[] args) {
        Draw.drawIt();
    }
}
