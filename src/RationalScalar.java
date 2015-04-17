package hw2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class RationalScalar implements Scalar {
	private int _numerator;
	private int _denominator;
	
	public RationalScalar(int numerator, int denominator){
		int gcd;		
		gcd = Math.abs(GCD(numerator, denominator));		
		_numerator = numerator / gcd;
		if(_denominator==0)
			throw new RuntimeException("Can't devied by zero");
		_denominator = denominator / gcd;				
	}
	
	public RationalScalar(Scalar other){
		RationalScalar rat = (RationalScalar) other;
		_numerator = rat.getNumenator();
		_denominator = rat.getDenominator();		
	}
	
	
	/**
	 * addition of two RationalNumbers.
	 * assuming arg is a RationalNumber.
	 * could also add instanceof, but left it that way, so that th RationalNumber will
	 * only get the same type when it calculates. 
	 * (because of the drawbacks of instanceof in software developing.
	 * in the future, when creating more Classes that implements Scalar, should check which one is arg.
	 */
	
	public Scalar adding (Scalar arg) {		
		RationalScalar ratArg = (RationalNumber) arg;
		int numeratorArg = ratArg.getNumenator();
		int denominatorArg = ratArg.getDenominator();
		int tNumerator = (_numerator * denominatorArg) + (_denominator * numeratorArg); 
		int tDenominator = _denominator * denominatorArg; 
		int gcd = Math.abs(GCD(tNumerator, tDenominator));
		tNumerator /= gcd;
		tDenominator /= gcd;
		
		Scalar newScalar = new RationalNumber(tNumerator, tDenominator);		
		return newScalar;
	}
	
	
	
	
	
	public int GCD(int a, int b){
		if (b==0) return a;	
		return GCD(b,a%b);
	}
	
	
	public int getNumenator(){
		return _numerator;		
	}
	
	public int getDenominator(){
		return _denominator;
	}
		
	/**
	 * @see Scalar#add(Scalar)
	 */
	@Override
	public Scalar add(Scalar s) {
		if(s instanceof RationalScalar){
			RationalScalar rs=(RationalScalar) s;
			return new RationalScalar(a*rs.b+b*rs.a,b*rs.b);
		}
		RealScalar rs=(RealScalar)s;
		return new RealScalar((rs.getValue()*a)/b);
	}
	
	/**
	 * @see Scalar#mul(Scalar)
	 */
	@Override
	public Scalar mul(Scalar s) {

		if(s instanceof RationalScalar){
			RationalScalar rs=(RationalScalar) s;
			return new RationalScalar(a*rs.a,b*rs.b);
		}
		RealScalar rs=(RealScalar)s;
		return new RealScalar((rs.getValue()*a)/b);
	
	}
	
	/**
	 * @see Scalar#neg()
	 */
	@Override
	public Scalar neg() {
		return new RationalScalar(-a, b);
	}
	
	/**
	 * @see Scalar#inv()
	 */
	@Override
	public Scalar inv() {
		return new RationalScalar(b, a);
	}

}
