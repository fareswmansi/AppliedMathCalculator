package Functions;

// this class contains the basic functions (+, -, *, /, etc)
public class BasicFunctions {
    private int x;
    private int y;
    private int[] inputs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    //initialize inputs and makes sure inputs are part of the set numbers;
    public BasicFunctions(int x, int y) {
        this.x = x;
        this.y = y;

        for (int i = 0; i < inputs.length; i++) {
            if (x != inputs[i]){
                throw new IllegalArgumentException();
            }

        }
        for (int i = 0; i < inputs.length ; i++) {
            if (y != inputs[i]){
                throw new IllegalArgumentException();
        }
        }
    }

    // algorithm for addition
    public static int Addition(int x, int y) {

        return x+y;
    }

    //algorithm for multiplication
    public static int Multiplication(int x, int y){

        return x*y;
    }

    //algorithm for subtraction
    public static int Subtraction(int x, int y){

        return x-y;
    }

    //algorithm of division
    public static double Division(int x, int y){
        double quotient = ((double)x / y);
        return quotient;
    }

    //algorithm of power
    public static double Power(int x, int y){
        double answer = Math.pow(x, y);
        return answer;
    }

    //algorithm of root
    public static double Root(int x, int y){
        double y_2 = ((double)1 / y);
        double answer = Math.pow(x, y_2);
        return answer;
    }

}
