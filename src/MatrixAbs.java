public abstract class MatrixAbs {
    public int size;

    public MatrixAbs(){}

    public abstract double getElement(int i, int j);
    public abstract void setElement(int i, int j, double Val);
    public abstract int getSize();
    public abstract MatrixAbs instance(int a);

    public double determMatrix(){
        size = getSize();

        if(size == 2){
            return (getElement(0, 0)*getElement(1,1)) - (getElement(0,1)*getElement(1, 0));
        }
        double sum = 0;
        int sign = 1;
        for(int in = 0; in < size; in++){
                sum += sign * getElement(0, in) * new HelpClass(0, in, this).determMatrix();
                sign = -sign;
        }
        return sum;
    }

    public MatrixAbs matrixMultiplication(MatrixAbs A){
        MatrixAbs C = instance(A.getSize());

        if(getSize() != A.getSize()) {
            System.out.println("Invalid matrix sizes");
            return null;
        }

        for(int i = 0; i < A.getSize(); i++){
            for(int j = 0; j < A.getSize(); j++){
                double someResult = 0;
                for(int k = 0; k < A.getSize(); k++) {
                    someResult += getElement(i, k) * A.getElement(k, j);
                }
                C.setElement(i, j, someResult);
            }
        }
        return C;
    }

    public boolean isIdentityMatrix(){
        int counterDiagonal = 0;
        int counterZeroes = 0;

        for(int i = 0; i < getSize(); i++){
            for (int j = 0; j < getSize(); j++){
                if((i == j) && (aboutEqual(getElement(i,j),1))){
                    counterDiagonal++;
                }
                if((i != j) && (aboutEqual(getElement(i, j), 0))){
                    counterZeroes++;
                }
            }
        }

        return ((counterDiagonal == getSize())&&counterZeroes == (getSize()*(getSize()-1)));
    }

    public static boolean aboutEqual(double x, double y) {
        return (Math.abs(x - y) < 0.005);
    }

    public MatrixAbs transpont(){
        double determinator = determMatrix();
        double mult = 1.0 / determinator;
        MatrixAbs C = instance(getSize());

        for(int i = 0; i < getSize(); i++){
            for(int j = 0; j < getSize(); j++){
                C.setElement(i,j, getElement(j,i));
            }
        }
        return C;
    }

    public MatrixAbs invert(){
        int size = getSize();
        double determ = determMatrix();
        MatrixAbs answerMatr = instance(size);

        if(determ == 0){
            return null;
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                int k = (i + j) % 2 == 0 ? 1 : -1; // знак (+1, если i+j - четное)
                answerMatr.setElement(j, i, k * new HelpClass(i, j, this).determMatrix() / determ);
            }
        }

        return answerMatr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                sb.append(String.format("%9.5f ", getElement(i, j)));
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}