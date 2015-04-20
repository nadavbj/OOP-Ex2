package hw2;

public class tester {
	public static void main(String[] args) {
		Polynomial p=new Polynomial("2x^3+x^2+1+2x^2");
		System.out.println(p);
		System.out.println(p.add(p));
		System.out.println(p);
		System.out.println(p.derivate());
		System.out.println(p.mul(p));
		
	}
}
