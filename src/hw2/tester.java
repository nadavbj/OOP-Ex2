package hw2;

public class tester {
	public static void main(String[] args) {
		Polynomial p=new Polynomial("1+x+5x+x^2+8x^3");
		
		System.out.println(p.mul(p));
		
	}
}
