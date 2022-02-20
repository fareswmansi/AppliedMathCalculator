package Functions;

//this class contains basic functions to compute matrix solutions, it is restricted to 3x3 matrices;
public class LinearAlgebra {
    double[][] y;
    double[][] x;
    int[][] Perfect = {{1, 0, 0},{0, 1, 0},{0,0,1}};


    //initialize x, y, x
    public LinearAlgebra(double[][] x, double[][] y){
        this.x = x;
        this.y = y;
    }

    //constructor gets the value of the discriminant of a 3x3 matrix
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

    //constructor puts matrix x into row echelon form
    public static double[][] RowEchelonForm(double[][] x){
        double[][] answer = {{}, {}, {}};
        return answer;
    }

    //constructor puts matrix x into reduced row echelon form
    public static double[][] ReducedRowEchelonForm(double[][] x){
        double[][] answer = {{}, {}, {}};
        return answer;
    }

    //constructor gets the inverse of matrix x
    public static double[][] Inverse(double[][] x, int[][] perfect){
        double[][] answer = {{}, {}, {}};
        return answer;
    }

    //constructor computes matrix multiplication
    public static double[][] MatrixMultiplication(double[][] x, double[][] y){
        double[][] c = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                c[i][j] = 0;
                for (int k = 0; k < 3; k++){
                    c[i][j] += x[i][k]*y[k][j];
                } // end of k loop
            } // end of j loop
        }// end of i loop
        return c;
    }

    //test constructor to test other constructors
    public static void main(String[] args) {
        double[][] x = {{1, 2, 3}, {4, 3, 2}, {3, 2, 1}};
        double[][] y = {{4, 2, 1}, {0, 8, 2}, {3, 2, 9}};
        double[][] product = MatrixMultiplication(x, y);

        // method for printing contents of multiplied matrix
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                System.out.print(product[i][j]);
            }
            System.out.println();
        }

        // more test methods
        System.out.print(product);
        double disc = Discriminant(x);
        //System.out.print(disc);

       // }




    }
}
