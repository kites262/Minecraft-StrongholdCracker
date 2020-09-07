
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class GetThePosOfStronghold {
    static final double v = 1.4;
    static Scanner scan = new Scanner(System.in);
    static pos a = new pos();
    static pos b = new pos();
    static pos s = new pos();
    static double m = 0;
    static double n = 0;
    static double deg1 = 0;
    static double deg2 = 0;
    static long stime = -1;
    public static void main(String[] args) {
        System.out.println("You are running version " + v);
        System.out.println("For latest version, https://github.com/kites262/Javasr/releases");
        System.out.println("");
        for(;;) {
            System.out.println("Now enter two sets of data:");
            try{
                System.out.print("->");
                {
                    a.x = scan.nextDouble();
                    a.z = scan.nextDouble();
                    deg1 = scan.nextDouble();
                }
                System.out.print("->");
                {
                    b.x = scan.nextDouble();
                    b.z = scan.nextDouble();
                    deg2 = scan.nextDouble();
                }
                stime = System.currentTimeMillis();
                m = getdis(a,s);
                n = getdis(b,s);
            }catch(Exception error) {
                System.out.println("[Error]Data error: Exist unsignificant figure(s)");
                error.printStackTrace();
                try{Thread.sleep(6400);}catch(Exception sleep) {}
                System.exit(-1);
            }finally {
                s.x=
                        a.x*sind(deg2)*cosd(deg1) - b.x*sind(deg1)*cosd(deg2) + ( a.z - b.z )*sind(deg1)*sind(deg2);
                s.x=
                        s.x/sind(deg2-deg1);
                s.z=
                        b.z*sind(deg2)*cosd(deg1) - a.z*sind(deg1)*cosd(deg2) - ( a.x - b.x )*cosd(deg1)*cosd(deg2);
                s.z=
                        s.z/sind(deg2-deg1);
            }
        System.out.println("[INFO]>Done!("+(System.currentTimeMillis()-stime)/1000.0+"s)");
        System.out.println("The pos of the Stronghold:");
        System.out.printf("==> %.3f , %.3f",s.x,s.z);
        System.out.println("");
        System.out.println("EOC");
    }

 }

    public static double sind(double deg) {
        System.out.println("[INFO]>sind operation started");
        double r =
                Math.sin(deg / 180 * Math.PI);
        System.out.println("[INFO]>sind operation completed");
        return r;
    }

    public static double cosd(double deg) {
        System.out.println("[INFO]>cosd operation started");
        double r =
                Math.cos(deg / 180 * Math.PI);
        System.out.println("[INFO]>cosd operation completed");
        return r;
    }

    private static double getdis(pos aa,pos bb) {
        System.out.println("[INFO]>distance operation started");
        double r =
                rt(sq(aa.x-bb.x)+sq(aa.z-bb.z));
        System.out.println("[INFO]>distance operation completed");
        return r;
    }

    public static double sq(double a) {
        System.out.println("[INFO]>pow operation started");
        double r = Math.pow(a, 2);
        System.out.println("[INFO]>pow operation completed");
        return r;
    }

    public static double rt(double a) {
        System.out.println("[INFO]>rt operation started");
        double r = Math.sqrt(a);
        System.out.println("[INFO]>et operation completed");
        return r;
    }

}


/*
 *
 * Find StrongHold Calculate:
 * a.x sin thetaO cos thetaP - b.x sin thetaP cos thetaO +( a.z- b.z )sin thetaP sin thetaO
 * b.z sin thetaO cos thetaP - a.z sin thetaP cos thetaO -( a.x - b.x )cos thetaP cos thetaO
 *
 */