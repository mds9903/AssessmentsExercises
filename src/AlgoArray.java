import java.util.Scanner;

// assessment qn# 18:
// write a program to perform the matrix operations
// 1. Matrix Add/Subtract, Multiply, Transpose
public class AlgoArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // generate and print two matrices
        int[][] mat1 = generateMatrix();
        int[][] mat2 = generateMatrix();
        System.out.println("Matrix 1");
        printMatrix(mat1);
        System.out.println("Matrix 2");
        printMatrix(mat2);

        boolean running = true; // for continuous display of menu
        do {
            // menu for choosing operations on the two matrices
            System.out.println("*** Matrix Operations ***" +
                    "\n1. Matrix Add" +
                    "\n2. Matrix Subtract" +
                    "\n3. Matrix Multiply" +
                    "\n4. Matrix Transpose" +
                    "\n5. Exit");
            System.out.println("Enter your choice of operation: 1,2,3 or 4");
            String input = sc.next();

            // in case user enters something that's not an integer
            while (!isInteger(input)) {
                // ask them again for a valid,i.e., integer input
                // until a valid option is entered
                System.out.println("Entered value is not a correct option number" +
                        "\ncorrect options are: 1,2,3,4 or 5" +
                        "\nplease try again");
                input = sc.next();
            }
            int ch = Integer.parseInt(input); // convert the input to an integer
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
                    printTransposeMats(mat1);
                    printTransposeMats(mat2);
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

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            // returns true if the given string is an integer
            return true;
        } catch (NumberFormatException numEx) {
            return false;// else false
        }
    }

    private static int countColumns(int[][] mat) {
        return mat[0].length;
    }

    private static int countRows(int[][] mat) {
        return mat.length;
    }

    private static void printMatrix(int[][] mat) {
        int rows = countRows(mat);
        int cols = countColumns(mat);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(" " + mat[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] generateMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the details for matrix");
        System.out.println("Enter the number of rows");
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements into the matrix");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        return matrix;
    }

    private static void printTransposeMats(int[][] mat) {
        System.out.println("*** Matrix Transpose ***");
        int rows = countRows(mat);
        int cols = countColumns(mat);
        System.out.println("Given matrix :-");
        printMatrix(mat);
        System.out.println("Transposed :-");
        // printing given matrix in transpose
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(" " + mat[j][i] + " ");
            }
            System.out.println();
        }
    }

    private static void multiplyMats(int[][] mat1, int[][] mat2) {
        System.out.println("*** Matrix Multiplication ***");
        System.out.println("Matrix A :-");
        printMatrix(mat1);
        System.out.println("Matrix B :-");
        printMatrix(mat2);

        int row1 = countRows(mat1); // get no. of rows from mat2
        int col1 = countColumns(mat1); // get no. of cols from mat1
        int row2 = countRows(mat2); // get no. of rows from mat2
        int col2 = countColumns(mat2); // get no. of cols from mat2

        // multiplication b/w two matrices mat1 and mat2 possible only if column of mat1 = row of mat2
        if (col1 == row2) {
            // perform the multiplication
            int[][] prodMat = new int[row1][col2]; // the product matrix has rows of mat1 and cols of mat2
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col2; j++) {
                    int sum = 0; // reset the sum for each row of product mat
                    for (int k = 0; k < col2; k++) {
                        sum += (mat1[i][k] * mat2[k][j]); // perform dot product

                    }
                    prodMat[i][j] = sum; // update the cell of prodMat[][]
                }
            }
            System.out.println("Product of Matrix A x Matrix B");
            printMatrix(prodMat);
        } else {
            // multiplication not possible
            System.out.println("multiplication not possible" +
                    "\nmultiply bw two matrices mat1 and mat2 possible only if " +
                    "column of mat1 = row of mat2");
        }
    }

    private static void addMats(int[][] mat1, int[][] mat2) {
        System.out.println("*** Matrix Addition ***");

        int row1 = countRows(mat1); // get no. of rows from mat1
        int col1 = countColumns(mat1); // get no. of cols from mat1
        int row2 = countRows(mat2); // get no. of rows from mat2
        int col2 = countColumns(mat2); // get no. of cols from mat2

        System.out.println("Matrix 1");
        printMatrix(mat1);
        System.out.println("Matrix 2");
        printMatrix(mat2);

        // addition possible only if the rows and cols of the two matrices match
        if (row1 == row2 && col1 == col2) {
            // perform matrix addition
            int[][] matSum = new int[row1][col1]; // sumMatrix has same rows, cols as those of involved matrices
            for (int i = 0; i < mat1.length; i++) {
                for (int j = 0; j < mat1[0].length; j++) {
                    matSum[i][j] = mat1[i][j] + mat2[i][j]; // sum each same location cell values
                }
            }
            System.out.println("Sum Matrix");
            printMatrix(matSum);
        } else {
            System.out.println("Addition not possible; rows and columns of the two matrices are not matching");
        }
    }

    private static void subtractMats(int[][] mat1, int[][] mat2) {
        System.out.println("*** Matrix Subtraction ***");

        int row1 = countRows(mat1); // get no. of rows from mat1
        int col1 = countColumns(mat1); // get no. of cols from mat1
        int row2 = countRows(mat2); // get no. of rows from mat2
        int col2 = countColumns(mat2); // get no. of cols from mat2

        System.out.println("Matrix 1");
        printMatrix(mat1);
        System.out.println("Matrix 2");
        printMatrix(mat2);

        // addition possible only if the rows and cols of the two matrices match
        if (row1 == row2 && col1 == col2) {
            // perform matrix subtraction
            int[][] matDiff = new int[row1][col1]; // sumMatrix has same rows and cols as those of involved matrices
            for (int i = 0; i < mat1.length; i++) {
                for (int j = 0; j < mat1[0].length; j++) {
                    matDiff[i][j] = mat1[i][j] - mat2[i][j]; // minus same location cell values
                }
            }
            System.out.println("Difference Matrix");
            printMatrix(matDiff);
        } else {
            System.out.println("Subtraction not possible; rows and columns of the two matrices are not matching");
        }
    }
}