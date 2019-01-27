public class HelpClass extends MatrixAbs{
    int row;
    int column;
    MatrixAbs A;

    public HelpClass(int iSkip, int jSkip, MatrixAbs A){
        row = iSkip;
        column = jSkip;
        this.A = A;
    }

    @Override
    public double getElement(int i, int j) {
        if(j < column && i < row) {
            return A.getElement(i, j);
        }
        if(j < column && i >= row){
            return A.getElement(i+1, j);
        }
        if(j >= column && i < row){
            return A.getElement(i, j+1);
        }
        else{
            return A.getElement(i+1, j+1);
        }
    }

//    @Override
//    public double getElement(int i, int j) {
//        // iBase и jBase - индексы, пересчитанные для базовой матрицы
//        int iBase = i < row ? i : i + 1;
//        int jBase = j < column? j : j + 1;
//        return A.getElement(iBase, jBase);
//    }

    @Override
    public void setElement(int i, int j, double Val) {}

    @Override
    public int getSize() {
        return A.getSize()-1;
    }

    @Override
    public MatrixAbs instance(int a) {
        return null;
    }
}