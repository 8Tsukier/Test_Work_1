public class Matr1D extends MatrixAbs {
    public double[] arr;

    public Matr1D(){};

    public Matr1D(int i){
        arr = new double[i*i];
    }

    public Matr1D(char a){
        arr = new double[] {1, 2, 3, 5, 0, 7, 8, -2, 11};
    }

    @Override
    public double getElement(int i, int j){

        return arr[i*getSize()+j];
    }

    @Override
    public void setElement(int i, int j, double Val){
        arr[i*getSize()+j] = Val;
    }

    public int getSize(){

        return (int)Math.sqrt(arr.length);
    }

    @Override
    public Matr1D instance(int a){
        Matr1D A = new Matr1D(a);
        return A;
    }
}