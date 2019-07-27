import java.util.Scanner;

public class Main {


    static void calconst(){

        double p;
        double root2= 1.414213562373095;

        upc =



    }


    public static void main(String[] args)

    {
        System.out.println("Hello World!");


        int x;
        int y;
        char operator;




        double result = 0.0;

        Scanner input = new Scanner(System.in);

        System.out.println("Please Enter your first Numnber");
        x= input.nextInt();

        System.out.println("Please Enter your Second Numnber");
        y= input.nextInt();

        System.out.println("Please Select your Operation");
        operator = input.next().charAt(0);



        switch (operator){


            case '+': result = x+y;
                break;
            case '-': result = x-y;
                break;
            case '*': result = x*y;
                break;
            case '/': result = x-y;
                break;
            case 'P': result = calconst();/x; ; //Our freaking constant
                break;
        }

        System.out.println(result);
    }
}
