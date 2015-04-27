
//checl rather can real with rat
public class RationalScalar extends Scalar {
	private int _numerator;
	private int _denominator;
	
	public RationalScalar(int numerator, int denominator){
		int gcd;	
		
		gcd = Math.abs(GCD(numerator, denominator));		
		_numerator = numerator / gcd;
		if(denominator==0)
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
	 * could also add instance of, but left it that way, so that the RationalNumber will
	 * only get the same type when it calculates. 
	 * (because of the drawbacks of instance of in software developing.
	 * in the future, when creating more Classes that implements Scalar, should check which one is arg.
	 */
	
	public Scalar add (Scalar arg) {		
		RationalScalar ratArg = (RationalScalar) arg;
		int numeratorArg = ratArg.getNumenator();
		int denominatorArg = ratArg.getDenominator();
		int tNumerator = (_numerator * denominatorArg) + (_denominator * numeratorArg); 
		int tDenominator = _denominator * denominatorArg; 
		int gcd = Math.abs(GCD(tNumerator, tDenominator));
		tNumerator /= gcd;
		tDenominator /= gcd;
		
		Scalar newScalar = new RationalScalar(tNumerator, tDenominator);		
		return newScalar;
	}
	
	
	/**
	 * multiplication of two RationalNumbers.
	 * assuming arg is a RationalNumber.
	 * could also add instance of, but left it that way, so that the RationalNumber will
	 * only get the same type when it calculates. 
	 * (because of the drawbacks of instance of in software developing.
	 * in the future, when creating more Classes that implements Scalar, should check which one is arg.
	 */
		public  Scalar mul(Scalar arg) {	
	    RationalScalar ratArg = (RationalScalar) arg;
		int numeratorArg = ratArg.getNumenator();
		int denominatorArg = ratArg.getDenominator();
		int tNumerator = _numerator * numeratorArg;
		int tDenominator = _denominator * denominatorArg;
		int gcd = Math.abs(GCD(tNumerator, tDenominator));
		tNumerator /= gcd;
		tDenominator /= gcd;					
		
		Scalar newScalar = new RationalScalar(tNumerator, tDenominator);		
		return newScalar;
	}

		/**
		 * negation of the Rational Number.
		 */
		public  Scalar neg() {
			int tnumerator = _numerator;
			int tdenominator = _denominator;
			
			if(_numerator==0 || _denominator==0 ){
				return new RationalScalar(this);
			}
			
			if(_numerator < 0 && _denominator < 0){
				tdenominator *= (-1);			
				return new RationalScalar(tnumerator, tdenominator);
			}
			
			if(_numerator < 0){
				tnumerator *= (-1);
				return new RationalScalar(tnumerator, tdenominator);
			}
			
			if(_denominator < 0){
				tdenominator *= (-1);
				return new RationalScalar(tnumerator, tdenominator);
			}
			
			// if none of them is negative
			tnumerator = _numerator * (-1);					
			return new RationalScalar(tnumerator, tdenominator);
		}

		/**
		 * inverse of the Rational Number.
		 */
			public Scalar inv() {
			if(_numerator == 0){
				return new RationalScalar(this);
			}
			
			int tnumerator =  _denominator;
			int tdenominator = _numerator;			
			
			Scalar newScalar = new RationalScalar(tnumerator, tdenominator);		
			return newScalar;
		}
			
		
		public boolean equals(Object arg){
			RationalScalar rat = (RationalScalar) arg;
			int tNumerator = rat.getNumenator();
			int tDenominator = rat.getDenominator();
			int gcd = Math.abs(GCD(tNumerator, tDenominator));
			tNumerator /= gcd;
			tDenominator /= gcd;		
			
			return ((tNumerator == getNumenator()) && (tDenominator == getDenominator()));
		}
		
		
		public String toString(){
			String str = new String();		
			str = str + _numerator + "/" + _denominator;		
			return str;		
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
	//add sets
	@Override
	public boolean isZero() {
		return _numerator==0;
	}
}