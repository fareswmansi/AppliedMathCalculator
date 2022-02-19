package Functions;

public class LinearAlgebra {
    //this class contains basic functions to compute matrix solutions, it is restricted to 3x3 matrices;
    double[][] x;
    int[][] Perfect = {{1, 0, 0},{0, 1, 0},{0,0,1}};


    //initialize x, y, x
    public LinearAlgebra(double[][] x){
        this.x = x;

    }


    //gets the value of the discriminant of a 3x3 matrix
    public static double Discriminant(double[][] x){
        double a1 = x[0][0];
        double a2 = x[0][1];
        double a3 = x[0][2];
        double firstPart = a1*((x[1][1]*x[2][2])-(x[1][2]*x[2][1]));
        double secondPart = a2*((x[1][0] * x[2][2])-(x[1][2] * x[2][0]));
        double thirdPart = a3*((x[1][0]*x[2][1])-(x[1][1]*x[2][0]));
        double answer = firstPart - secondPart + thirdPart;
        return answer;
    }




    public static void main(String[] args) {
        double[][] x = {{1, 2, 3}, {4, 3, 2}, {3, 2, 1}};

        double disc = Discriminant(x);
        System.out.print(disc);

       // }




    }
}
