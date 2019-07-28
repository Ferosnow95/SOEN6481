import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double upc = calconst();
        float x;
        float y;
        char operator;
        char unit;
        String a="";



        double result = 0.00;
        //DecimalFormat df = new DecimalFormat("#.##");
        Scanner input = new Scanner(System.in);

        System.out.println("-----Please Select your unit---------\n" +
                "1 for Centimiter\n" +
                "2 for meter\n" +
                "3 for Inches\n" +
                "------------------------------------------------" );

        unit = input.next().charAt(0);

        switch (unit){

            case '1':
                a="cm";
                break;
            case '2':
                a="m";
                break;
            case '3':
                a="in";
                break;
        }

        System.out.println("Please Enter your first Numnber");
        x = input.nextFloat();

        System.out.println("Please Enter your Second Numnber");
        y = input.nextFloat();

        System.out.println("--Please Select your Operation---------\n" +
                "+ for Add\n" +
                "- for Substract\n" +
                "/ for Divide\n" +
                "* for Multiply\n" +
                "S for Approximate distance from Parabola\n" +
                "P for Universal Parabola Constant\n" +
                "\"-------------------------------------------------\" ");
        operator = input.next().charAt(0);


        switch (operator) {


            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '/':
                result = x / y;
                break;
            case 's':
                result = upc / x;
                break;
            case 'p':
                result = upc;
                break;
        }
        if (operator=='s'||operator=='p'){

            System.out.println("-Result---------------------------\n"+
                    result+"\n"+
                    "-------------------------------------");

        }
        else {
            System.out.println("-Result---------------------------\n"+
                    result+a+"\n"+
                    "-------------------------------------");
        }

    }

    public static double sqrtRoot() {
        double d = 2;
        if (d == 0) {
            return 0;
        }

        double i = 0;
        double x1, x2 = 0;
        while ((i * i) <= d) {
            i += 0.1;
        }
        x1 = i;
        for (int j = 0; j < 10; j++) {
            x2 = d;
            x2 /= x1;
            x2 += x1;
            x2 /= 2;
            x1 = x2;
        }
        return x2;
    }

    public static double calconst() {
        double v = sqrtRoot();
        double lnofx; //result
        double x = (1 + v) + v;
        double y;
        double ySquared;
        double upc=0.0;

        y = (x - 1) / (x + 1);
        ySquared = y * y;

        double increment = 1;

        for (double i = 1 / increment; i > .00000000001; increment = increment + 2) {
            double repeatingValue = (i + ySquared);
            double newRepeat = repeatingValue;
            double finalRepeat = newRepeat * repeatingValue;
            lnofx = 2 * y * finalRepeat;
            lnofx = lnofx + 0.18202222540468;


            if (lnofx == (2.2955871493899918)) {
                upc=lnofx;
                break;
            }


        }
        return upc;


    }
}