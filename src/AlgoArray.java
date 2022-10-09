import java.util.Scanner;
// assessment qn# 18:
// write a program to perform the matrix operations
// 1. Matrix Add/Subtract, Multiply, Transpose
public class AlgoArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // generate the matrices
//        int[][] mat1 = generateMatrix();
        System.out.println("Enter the details for matrix 1");
        System.out.println("Enter the number of rows");
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns");
        int cols = sc.nextInt();
        int[][] mat1 = new int[rows][cols];
        System.out.println("Enter the elements into the matrix");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Matrix 1:--");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(" " + mat1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Enter the details for matrix 2");
        System.out.println("Enter the number of rows");
        rows = sc.nextInt();
        System.out.println("Enter the number of columns");
        cols = sc.nextInt();
        int[][] mat2 = new int[rows][cols];
        System.out.println("Enter the elements into the matrix");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat2[i][j] = sc.nextInt(); // input values into each cell of the matrix
            }
        }
        System.out.println("Matrix 2:--");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(" " + mat2[i][j]);
            }
            System.out.println();
        }
        // menu for choosing and performing operations on the two matrices
        boolean running = true; // for continuous display of menu
        do {
            System.out.println("*** Matrix Operations ***");
            System.out.println("1. Matrix Add" +
                                    "\n2. Matrix Subtract" +
                                    "\n3. Matrix Multiply" +
                                    "\n4. Matrix Transpose" +
                                    "\n5. Exit");
            System.out.println("Enter your choice of operation: 1,2,3 or 4");
            String input = sc.next();
            int ch;
            try {
                ch = Integer.parseInt(input);
            }catch (NumberFormatException numEx){
                System.out.println(numEx);
                return; // end the program
            }

            switch (ch) {
                case 1:
                    addMats(mat1, mat2);
                    break;
                case 2:
                    subtractMats(mat1, mat2);
                    subtractMats(mat2, mat1);
                    break;
                case 3:
                    multiplyMats(mat1, mat2);
                    multiplyMats(mat2, mat1);
                    break;
                case 4:
                    transposeMats(mat1);
                    transposeMats(mat2);
                    break;
                case 5:
                    System.out.println("Exiting");
                    running = false;
                    break;
                default:
                    System.out.println("Wrong choice\nPlease Try Again...");
                    break;
            }
        } while (running);
        System.out.println("Thank you. Bye.");
    }

    private static void transposeMats(int[][] mat1) {
        int rows = mat1.length;
        int cols = mat1[0].length;
        System.out.println("Given matrix :-");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(" " + mat1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Transposed :-");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(" " + mat1[j][i] + " ");
            }
            System.out.println();
        }
    }

    private static void multiplyMats(int[][] mat1, int[][] mat2) {
        int row1 = mat1.length; // get the no. of rows from mat1
        int col1 = mat1[0].length; // get the no. of cols from mat1
//        System.out.println("row1: " + row1);
//        System.out.println("col1: " + col1);
        int row2 = mat2.length; // get the no. of rows from mat2
        int col2 = mat2[0].length; // get the no. of cols from mat2
//        System.out.println("row2: " + row2);
//        System.out.println("col2: " + col2);
        // check multiplication possible or not
        // multiplication b/w two matrices mat1 and mat2 possible only if column of mat1 = row of mat2
        if (col1 == row2) {
            // perform the multiplication
            int[][] product = new int[row1][col2]; // product matrix has rows of mat1 and cols of mat2
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col2; j++) {
                    int sum = 0; // reset the sum for each row of product mat
                    // perform dot product
                    for (int k = 0; k < col2; k++) {
                        sum += (mat1[i][k] * mat2[k][j]);

                    }
                    product[i][j] = sum;
//                    System.out.println("sum " + sum);
                }
            }
            System.out.println("Product Matrix");
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col2; j++) {
                    System.out.print(" " + product[i][j]);
                }
                System.out.println("");
            }
        } else {
            System.out.println("multiplication not possible" +
                    "\nmultiply bw two matrices mat1 and mat2 possible only if " +
                    "column of mat1 = row of mat2");
        }
    }

    private static void addMats(int[][] mat1, int[][] mat2) {
        if (mat1.length == mat2.length && mat1[0].length == mat2[0].length) {
            // addition possible only if the rows and cols of the two matrices match
            int[][] matDiff = new int[mat1.length][mat1[0].length];
            for (int i = 0; i < mat1.length; i++) {
                for (int j = 0; j < mat1[0].length; j++) {
                    matDiff[i][j] = mat1[i][j] + mat2[i][j];
                }

            }
            System.out.println("Sum Matrix");
            for (int i = 0; i < mat1.length; i++) {
                for (int j = 0; j < mat1[0].length; j++) {
                    System.out.print(" " + matDiff[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Addition not possible; rows and columns of the two matrices are not matching");
        }
    }

    private static void subtractMats(int[][] mat1, int[][] mat2) {
        if (mat1.length == mat2.length && mat1[0].length == mat2[0].length) {
            // subtraction possible only if the rows and columns of the two matrices match
            int[][] matDiff = new int[mat1.length][mat1[0].length];
            for (int i = 0; i < mat1.length; i++) {
                for (int j = 0; j < mat1[0].length; j++) {
                    matDiff[i][j] = mat1[i][j] - mat2[i][j];
                }

            }
            System.out.println("Difference Matrix");
            for (int i = 0; i < mat1.length; i++) {
                for (int j = 0; j < mat1[0].length; j++) {
                    System.out.print(" " + matDiff[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Subtraction not possible; rows and columns of the two matrices are not matching");
        }

    }
}