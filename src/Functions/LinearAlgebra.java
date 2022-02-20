package Functions;

// this class contains basic functions to compute matrix solutions, it is restricted to 3x3 matrices;
public class LinearAlgebra {
    private int rows;
    private int col;
    private double[][] y;
    private double[][] x;
    private int[][] Perfect = {{1, 0, 0},{0, 1, 0},{0,0,1}};

    //initialize x, y, x
    public LinearAlgebra(double[][] x, double[][] y, int rows, int col){
        this.x = x;
        this.y = y;
        this.rows = 3;
        this.col = 3;
    }

    // constructor that swaps rows
    public static void swapRows(double[][] array, int rowA, int rowB){
        double tmpRow[] = array[rowA];
        array[rowA]=array[rowB];
        array[rowB] = tmpRow;
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

    //constructor puts matrix x into row echelon form
    public static double[][] RowEchelonForm(double[][] x){
        int lead = 0;
        int row = 3;
        int col = 3;
        double pivotOne = 0;
        double makeMeZero = 0;
        double makeThisZero = 0;
        double[][] finalMatrix = {{0,0,0},{0,0,0},{0,0,0}};
        //check if first element is == 0.
        if (x[0][0] != 0){
            pivotOne = x[0][0]; // finds value of first element in the first row
            finalMatrix[0][0] = Math.round(pivotOne * (1/pivotOne)); // multiplies the first element by its inverse in order to make it a leading 1
            finalMatrix[0][1] = x[0][1] * (1/pivotOne); // applying same transformation to the remainder of vector
            finalMatrix[0][2] = x[0][2] * (1/pivotOne);
            if (x[1][0] != 0){ // if the first element in the second row is non 0
                if (x[2][0] != 0){ // if the first element in the third row is non 0
                    makeMeZero = x[1][0]; // find the first element in the second row
                    finalMatrix[1][0] = makeMeZero - (makeMeZero*(finalMatrix[0][0])); // make it a leading 1 by multiplying its inverse
                    finalMatrix[1][1] = x[1][1] - (makeMeZero*(finalMatrix[0][1])); // applying transformation
                    finalMatrix[1][2] = x[1][2] - (makeMeZero*(finalMatrix[0][2]));
                } else if (x[2][0] == 0){
                    swapRows(x, 1, 2); // swap rows 2 and 3
                    makeThisZero = x[2][0];
                    finalMatrix[2][0] = makeThisZero - (makeThisZero*(finalMatrix[0][0]));
                    finalMatrix[2][1] = x[2][1] - (makeThisZero*finalMatrix[0][1]);
                    finalMatrix[2][2] = x[2][2] - makeThisZero*finalMatrix[0][2];

                }

            }// end of 2nd if statement

            //finalMatrix[0][1] = x[0][1] * (1/pivotOne);
            //x[0][2] = x[0][2] * (1/pivotOne);
        } // end of first if statement


        /*
         * What the function needs to do:
         * 1. I need to be able to make the first item in the first row a 1, and apply that same transformation to the rest of it
         * 2. I need to go down a row, then make the [0] element = 0 using the 1st row, meaning that I need to find what the value of that element is
         * then multiply each element in row 1 by that value in a new multidimensional array so the initial one doesn't get affected, then I need to
         * subtract that array's elements with the elements in the main array, in order to get a 0 in the first spot.
         * 3. I need to go down another row, then do the same thing with the zero as I did with the first and second array, but now with the first and third.
         * 4. Now, I need to create a 1 in the second row, so I'll find the value of the second element in the second row, then see multiply it by its inverse, then
         * copy that transformation to the remainder of the elements in the second row.
         * 5. I need to go down a row, then create a zero in the element directly below me in the third row, so I need to find what the value of that element is
         * then multiply each element in row 1 by that value in a new multidimensional array so the initial one doesn't get affected, then I need to subtract that array's
         * elements with the elements in the main array, in order to get a 0 in the second spot.
         * 6. Now, I should have 0 zeros in the 3rd row, hence I need to find the value of the [2] element in the [2] row and multiply it by its inverse in order
         * to obtain a 1 in that spot.
         *
         *
         *
         * As I progress through the steps, I need to do checks to see if a zero has been created in the spot I am trying to turn into a 1.
         * After every step I complete (from steps 1-6) I will check if there is a zero leading the remainder of the elements.
         * */
        return finalMatrix;
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









    //test constructor to test other constructors
    public static void main(String[] args) {
        double[][] x = {{6, 2, 3}, {4, 3, 2}, {0, 2, 1}};
        double[][] y = {{4, 2, 1}, {0, 8, 2}, {3, 2, 9}};
        double[][] product = MatrixMultiplication(x, y);


        double[][] testMe = RowEchelonForm(x);
        System.out.print(testMe);

        for (int i = 0; i < testMe.length; i++) {
            for (int k = 0; k < testMe.length; k++){
                System.out.print(testMe[i][k] + "|");
            }
            System.out.println();
        }
        System.out.print(testMe[0][0]);

        // method for printing contents of multiplied matrix


        /*for (int i = 0; i < testMe.length; i++) {
            for (int j = 0; j < testMe.length; i++){
                System.out.print(testMe[i][j] + "|");
            }
            System.out.println();
        }*/
            //System.out.print(testMe[i] + "|");
        //}
        //System.out.print(testMe);




        // more test methods
        //System.out.print(product);
        //double disc = Discriminant(x);
        //System.out.print(disc);
    }
}
