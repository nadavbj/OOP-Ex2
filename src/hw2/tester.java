package hw2;
public class tester {
	public static void main(String[] args) {
		String testExpressionsReal[]={
									"0.5x^2+0.324x^3",
									"-3x^1+6x^3-0.5x^7",
									"1x^2+10000x^2",
									"3x^2+5x^1000",
									
									};
		String testExpressionsRat[]={
				"2/3-x^3+x^23",
				"1/1x^2+2/3x^3-7x+0"};
		testExp(testExpressionsReal,Field.Real);
		testExp(testExpressionsRat,Field.Rational);
	}
		public static void testExp (String[]testExpressions, Field f){
			System.out.println("Build from strings:");
		for (String expr : testExpressions) {
			Polynomial p=new Polynomial(expr,f);
			System.out.println(p);
		}
		System.out.println("Addition:");
		for (String expr1 : testExpressions) {
			for (String expr2 : testExpressions) {
				Polynomial p1=new Polynomial(expr1,f);
				Polynomial p2=new Polynomial(expr2,f);
				
				System.out.println("("+p1+")  +  ("+p2+")  =  "+p1.add(p2));
			}
		}
		
		System.out.println("Multipication:");
		for (String expr1 : testExpressions) {
			for (String expr2 : testExpressions) {
				Polynomial p1=new Polynomial(expr1,f);
				Polynomial p2=new Polynomial(expr2,f);
				
				System.out.println("("+p1+")  *  ("+p2+")  =  "+p1.mul(p2));
			}
		}
		System.out.println("derivation:");
		for (String expr : testExpressions) {
			Polynomial p=new Polynomial(expr,f);
			System.out.println("("+p+")'="+p.derivate());
		}
		
		System.out.println("Evaluation:");
		for (String expr : testExpressions) {
			Polynomial p=new Polynomial(expr,f);
			for (int i = 0; i < 10; i++) {
				if(f==Field.Real)
					System.out.println("("+p+")("+i+")="+p.evaluate(new RealScalar(i)));
				else
					System.out.println("("+p+")("+i+")="+p.evaluate(new RationalScalar(i,1)));
					
			}
			
		}
	
	System.out.println("Build from strings:");
	for (String expr : testExpressions) {
		Polynomial p=new Polynomial(expr,f);
		System.out.println(p);
	}
	System.out.println("Addition:");
	for (String expr1 : testExpressions) {
		for (String expr2 : testExpressions) {
			Polynomial p1=new Polynomial(expr1,f);
			Polynomial p2=new Polynomial(expr2,f);
			
			System.out.println("("+p1+")  +  ("+p2+")  =  "+p1.add(p2));
		}
	}
	
	System.out.println("Multipication:");
	for (String expr1 : testExpressions) {
		for (String expr2 : testExpressions) {
			Polynomial p1=new Polynomial(expr1,f);
			Polynomial p2=new Polynomial(expr2,f);
			
			System.out.println("("+p1+")  *  ("+p2+")  =  "+p1.mul(p2));
		}
	}
	System.out.println("derivation:");
	for (String expr : testExpressions) {
		Polynomial p=new Polynomial(expr,f);
		System.out.println("("+p+")'="+p.derivate());
	}
	
	System.out.println("Evaluation:");
	for (String expr : testExpressions) {
		Polynomial p=new Polynomial(expr,f);
		for (int i = 0; i < 10; i++) {
			if(f==Field.Real)
				System.out.println("("+p+")("+i+")="+p.evaluate(new RealScalar(i)));
			else
				System.out.println("("+p+")("+i+")="+p.evaluate(new RationalScalar(i,1)));
		}
		
	}
}
}