package lintcode;

public class Solutionaplusb {
    public int aplusb(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        Solutionaplusb solutionaplusb = new Solutionaplusb();

        int c = solutionaplusb.aplusb(10,2);
        System.out.print(c);

    }
}
