import MemontoCache.PreviousCalculation;
import MemontoCache.PreviousCalculationImp;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    private static double firstNumber;
    private static double secondNumber;
    private static double result;

    private static PreviousCalculation memo ;




    public static void main(String[] args) {

        calculate();



    }

    public static char GetOp()
    {
        Scanner input = new Scanner(System.in);
        return input.next().charAt(0);
    }

    public static double calculate() {


        String a = unitSelection();

        char operator='@';

        double result = 0.00;
        boolean go = true;


        Scanner input = new Scanner(System.in);

        System.out.println(
                         "---Please Select your Operation--------------------\n" +
                        "+ for Add\n" +
                        "- for Substract\n" +
                        "/ for Divide\n" +
                        "* for Multiply\n" +
                        "S for Approximate distance from Parabola\n" +
                        "P for Universal Parabola Constant\n" +
                        "\"-------------------------------------------------\" ");

        while (go) {
            operator = GetOp();
            switch (operator) {  /*Calculator Operand Selection  */


                case '+':
                    result = caladd();
                    go = false;
                    break;
                case '-':
                    result = calsubstract();
                    go = false;
                    break;
                case '*':
                    result = calmultiply();
                    go = false;
                    break;
                case '/':
                    result = caldivide();
                    go = false;
                    break;
                case 's':
                    result = caldistance();
                    go = false;
                    break;
                case 'p':
                    result = calconst();
                    go = false;
                    break;

                default:
                    System.out.println("Incorrect operator, Please Select Again"); /*Error Handling */
                    break;
            }
        }



        DecimalFormat df = new DecimalFormat("#.##");  // Output format initializer 2DP
        DecimalFormat df2 = new DecimalFormat("#.##########"); // Output format initializer 10DP


        if (operator == 'p') {

            System.out.println(
                            "-Result---------------------------------------\n" +
                            df2.format(result) + "\n" +
                            "----------------------------------------------");

        } else if(operator =='s'){
            System.out.println(
                           "-Result----------------------------------------\n" +
                            df2.format(result) + a + "\n" +
                            "-----------------------------------------------");



        }
        else{ System.out.println(
                        "-Result----------------------------------------\n"
                                +df.format(result) + a + "\n" +
                        "-----------------------------------------------");;

        }
        return (result);
    }




    /*public static void output()
    {
        char operator = GetOp();
        String a = unitSelection();
        double result=calculate();
        DecimalFormat df = new DecimalFormat("#.##");  // Output format initializer 2DP
        DecimalFormat df2 = new DecimalFormat("#.##########"); // Output format initializer 10DP
        if (operator == 's' || operator == 'p') {
            System.out.println(
                    "-Result---------------------------------------\n" +
                            df2.format(result) + "\n" +
                            "----------------------------------------------");
        } else {
            System.out.println(
                    "-Result----------------------------------------\n" +
                            df.format(result) + a + "\n" +
                            "-----------------------------------------------");
        }
    }*/

    public static String unitSelection () {

        char unit;
        String a = "";
        boolean go = true;
        Scanner input = new Scanner(System.in);


        System.out.println(

                        "-Welcome to UPC Calculator ,Please Select your input unit----------\n" +
                        "1 for Centimiter\n" +
                        "2 for meter\n" +
                        "3 for Inches\n" +
                        "--------------------------------------------------------------------");

        while (go) {

            unit = input.next().charAt(0);

            switch (unit) {

                case '1':
                    a = "cm";
                    go = false;
                    break;
                case '2':
                    a = "m";
                    go = false;
                    break;
                case '3':
                    a = "in";
                    go = false;
                    break;
                default:

                    System.err.println("Invalid option selected"); /*Error Handling */

            }
        }
        return a;
    }

    public static double caladd () {


        Scanner input = new Scanner(System.in);

        System.out.println("Please Enter your first Numnber");
        firstNumber = input.nextFloat();

        System.out.println("Please Enter your Second Numnber");
        firstNumber = input.nextFloat();

        double result = firstNumber + secondNumber;
        return result;
    }


    public static double calsubstract () {


        Scanner input = new Scanner(System.in);

        System.out.println("Please Enter your first Numnber");
        firstNumber = input.nextFloat();

        System.out.println("Please Enter your Second Numnber");
        firstNumber = input.nextFloat();
        double result = firstNumber - secondNumber;
        return result;
    }

    public static double caldivide () {


        Scanner input = new Scanner(System.in);

        System.out.println("Please Enter your first Numnber");
        firstNumber= input.nextFloat();

        System.out.println("Please Enter your Second Numnber");
        secondNumber = input.nextFloat();
        result = firstNumber / secondNumber;
        return result;
    }

    public static double calmultiply () {

        Scanner input = new Scanner(System.in);

        System.out.println("Please Enter your first Numnber");
        firstNumber= input.nextFloat();

        System.out.println("Please Enter your Second Numnber");
        secondNumber = input.nextFloat();
        result = firstNumber * secondNumber;
        return result;
    }

    public static double caldistance () {
        Scanner input = new Scanner(System.in);
        double upc = calconst();

        System.out.println("Please enter your distance point");
        firstNumber = input.nextFloat();

        result = upc / firstNumber;
        return result;
    }





    public static double sqrtRoot () {/*Square Root Calculation Method */
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

    public static double calconst () {  /*Universal Parabolic Constant + Natural Log Calculation*/
        double v = sqrtRoot();
        double lnofx; //result
        double x = (1 + v) + v;  /*Constant Equation*/
        double y;
        double ySquared;
        double upc = (0.0);






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
                upc = lnofx;
                break;
            }


        }
        return upc;





    }


    public static void numberCache(){
        memo = new PreviousCalculationImp();
        memo.setFirstNumber(firstNumber);
        memo.setSecondNumber(secondNumber);
        memo.setResult(result);
    }


    public static double getFirstNumber() {
        return firstNumber;
    }

    public static void setFirstNumber(double firstNumber) {
        Main.firstNumber = firstNumber;
    }

    public static double getSecondNumber() {
        return secondNumber;
    }

    public static void setSecondNumber(double secondNumber) {
        Main.secondNumber = secondNumber;
    }

    public static double getResult() {
        return result;
    }

    public static void setResult(double result) {
        Main.result = result;
    }
}
