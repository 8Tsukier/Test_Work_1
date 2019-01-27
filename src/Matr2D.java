import java.util.Scanner;

public class Matr2D extends MatrixAbs{
    public double [][] Matrix;

    public Matr2D(){
        Matrix = new double[size][size];
    }

    public Matr2D(int size){
        Matrix = new double[size][size];
    }

    public Matr2D(char a){
        Matrix = new double[][] {{1, 2, 3}, {5, 0, 7}, {8, -2, 11}};
    }

    public Matr2D(int size, int check0){
        Matrix = new double[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                double val = i + j + 1;
                setElement(i, j, val);
            }
        }
    }

    //Input form console
    public Matr2D(int size, int check0, int check1){
        Matrix = new double[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                double inputVal = new Scanner(System.in).nextDouble();
                setElement(i, j, inputVal);
            }
        }
    }

    @Override
    public double getElement(int i, int j) {

        return Matrix[i][j];
    }

    @Override
    public void setElement(int i, int j, double Val) {

        Matrix[i][j] = Val;
    }

    @Override
    public int getSize(){

        return Matrix.length;
    }

    @Override
    public Matr2D instance(int a){
        Matr2D A = new Matr2D(a);
        return A;
    }
}