public class Demo {

    public static void main(String[] args){
        System.out.println("Demo on first child class with 2D array storage: ");

        Matr2D A = new Matr2D('a');
        System.out.println(A); //My matrix with some default values

        double det1 = A.determMatrix();
        System.out.print("Determinator is: ");
        System.out.println(det1); //Determinator of that matrix
        System.out.println();

        MatrixAbs C = A.matrixMultiplication(A);
        System.out.println(C); //Result of multiplication A*A

        //The method of invert Matrix is not working correctly (in Algorithm?)=(
        MatrixAbs D = A.invert();
        System.out.println("Invert matrix is: ");
        System.out.println(D);
        C = D.matrixMultiplication(A);
        System.out.println(C.isIdentityMatrix()); // Checking if D the right invert Matrix
        MatrixAbs edinMatr = D.matrixMultiplication(A);
        System.out.println(edinMatr);

        System.out.println("////////////////////////////////////////");
        System.out.println("Demo on second child class with simple array storage: ");

        Matr1D E = new Matr1D('a');
        System.out.println(E);

        double det2 = E.determMatrix();
        System.out.print("Determinator is: ");
        System.out.println(det2);
        System.out.println();

        MatrixAbs F = A.matrixMultiplication(A);
        System.out.println(F);

        MatrixAbs G = A.invert();
        System.out.println("Invert matrix is: ");
        System.out.println(G);
        MatrixAbs L = G.matrixMultiplication(E);
        System.out.println(L.isIdentityMatrix());
    }
}
