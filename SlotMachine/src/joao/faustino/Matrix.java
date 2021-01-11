package joao.faustino;

public class Matrix {
    public int row;
    public int column;

    Matrix(int row, int column){
        this.row = row;
        this.column = column;
    }

    public String printMatrix(){
        return "" + row + "|" + column;
    }

}
