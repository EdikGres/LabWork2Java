public class Main {

    public static void main(String[] args) {
	    Matrix a = new Matrix(20);
        Matrix b = new Matrix(20);
        a.setElement(0, 1, 55).setElement(2,3,-58);
        b.setElement(0, 1, 12).setElement(3, 1, -78);
        a.setElement(2,2,1235);
        Matrix res = a.product(b);
        System.out.println(res);
        System.out.println("------");
        res.showOrder(10);
    }
}
