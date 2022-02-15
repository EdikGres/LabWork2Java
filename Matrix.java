public class Matrix {
    private Integer[][] arr;
    private final int side;

    public Matrix(int side) {
        this.side = side;
        arr = new Integer[side][side]; // вопрос на счёт хипа и стека?!?!?!?!?!?
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                arr[i][j] = 0;
                if (i == j)
                    arr[i][j] = 1;
            }
        }
    }

    public Matrix(Matrix b) {
        this.side = b.side;
        this.arr = new Integer[side][side];
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                this.arr[i][j] = b.arr[i][j];
            }
        }
    }

    // -1 or not?
    public Matrix setElement(int row, int column, int value) {
        arr[row][column] = value;
        return this;
    }

    // -1 or not?
    public int getElement(int row, int column) {
        return arr[row][column];
    }

    //нужен ли сеттер для этого поля?
    public int getSide() {
        return side;
    }

    // n^3
    //Cij=Ai0*B0j+Ai1*B1j+...
    public Matrix product(Matrix b) {
        if (this.side != b.side) {
            System.out.println("ERROR!");
            return this;
        }
        Matrix res = new Matrix(this.side);
        for(int i = 0; i < side; i++){
            for(int j = 0; j < side; j++){
                res.arr[i][j] = 0;
                for(int k = 0; k < side; k++){
                    res.arr[i][j] += this.arr[i][k] * b.arr[k][j];
                }
            }
        }
        return res;
    }

    public Matrix sum(Matrix b) {
        if (this.side != b.side) {
            System.out.println("ERROR!");
            return this;
        }
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                this.arr[i][j] += b.arr[i][j];
            }
        }
        return this;
    }
    public void showOrder (int ord) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ord; i++) {
            sb.append("[");
            for (int j = 0; j < ord; j++) {
                sb.append(arr[i][j]);
                if (j != ord - 1) //fix last space
                    sb.append("\t");
            }
            sb.append("]");
            if (i != ord - 1) //fix last new row
                sb.append("\n");
        }
        System.out.println(sb);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); //not synchro and mutable
        for (int i = 0; i < side; i++) {
            sb.append("[");
            for (int j = 0; j < side; j++) {
                sb.append(arr[i][j]);
                if (j != side - 1) //fix last space
                    sb.append("\t");
            }
            sb.append("]");
            if (i != side - 1) //fix last new row
                sb.append("\n");
        }
        return sb.toString();
    }
}
