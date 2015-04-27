package hw2;
public class PolyTerm implements Comparable{
	private Scalar _coefficient;
	private int _exponent;


	public PolyTerm (Scalar coefficient, int exponent){
		this._coefficient = coefficient;
		this._exponent = exponent;
		

	}

	//receives a PolyTerm and returns true if the argument PolyTerm can be added to the

	public PolyTerm (String polystring, Field f){
		if(polystring.indexOf("x")==-1)
			polystring+="x^0";
		if(polystring.indexOf("^")==-1)
			polystring+="^1";
		if(polystring.indexOf("x")==0)
			polystring="1"+polystring;
		if(polystring.indexOf("x")==1 && polystring.indexOf("-")==0)
			polystring="-1"+polystring.substring(1);
		if(polystring.indexOf("/")==-1 && f==Field.Rational)
			polystring=polystring.substring(0, polystring.indexOf("x"))+"/1"+polystring.substring( polystring.indexOf("x"));
		
		String[] temp;
		String delimiter = "x^";
		temp = polystring.split(delimiter);
		if(f==Field.Real)
		{
			this._coefficient = new RealScalar (Double.parseDouble(polystring.substring(0,polystring.indexOf('x'))));
		}
		else if(f==Field.Rational){
			
		int n;
		int d;
		
		n=Integer.parseInt(polystring.substring(0,polystring.indexOf('/')));
		d = Integer.parseInt(polystring.substring(polystring.indexOf('/')+1,polystring.indexOf('x')));
		this._coefficient = new RationalScalar (n,d);  	
		}
		
			 // check for the exponent
			   _exponent = Integer.parseInt(polystring.substring(polystring.indexOf('^')+1));
			   
	}


	boolean canAdd(PolyTerm pt){
		int _exponent=pt.getExponent();
		if (compareTo(pt)==0)
			return true;
		else return false;

	}

	public int compareTo(Object pt){
		int _exponent = this.getExponent();
		PolyTerm ptAns = (PolyTerm) pt;
		int pexp =  ptAns.getExponent();

		if(_exponent == pexp){
			return 0;
		}
		else{ if (_exponent>pexp)
			return 1;

		else
			return -1;
		}
	}


	//receives a PolyTerm and returns a new PolyTerm which is the 
	//result of adding the current PolyTerm and the argument.

	public PolyTerm add(PolyTerm pt){
		Scalar coeff = pt.getCoefficient();
		Scalar newCoeff = coeff.add(_coefficient);
		int pexp = pt.getExponent();
		PolyTerm newPoly = new PolyTerm(newCoeff,pexp );	
		return newPoly;
	}

	//receives a PolyTerm and returns a new PolyTerm which is the result 
	//of multiplying the current PolyTerm and the argument.	

	public PolyTerm mul(PolyTerm pt){
		return new PolyTerm(_coefficient.mul(pt._coefficient), _exponent+pt._exponent);
	}

	//evaluate the current term using scalar as the value
	//of the variable of the polynomial .

	public Scalar evaluate(Scalar scalar){
		Scalar ans= null;
		if (scalar instanceof RealScalar){
			ans = new RealScalar (scalar);
			int exp = (int) _exponent;
			if (exp>=1){
				while (exp>=1){
					ans = scalar.mul(scalar);
					exp--;
				}
			}
			ans = ans.mul(_coefficient);
		}				

		else if (scalar instanceof RationalScalar){
			ans = new RationalScalar (scalar);
			int exp = (int) _exponent;
			if (exp>=1){
				while (exp>=1){
					ans = scalar.mul(scalar);
					exp--;

				}
			}
			ans = ans.mul(_coefficient);		

		}
		return ans;
	}


	//returns the PolyTerm which is the result 
	//of the derivation on the current PolyTerm
	public PolyTerm derivate(){
		Scalar ansC=null;
		int ansE=_exponent;
		if (_coefficient instanceof RealScalar){
			ansC = _coefficient.mul(new RealScalar(_exponent));
		}
		else
			if (_coefficient instanceof RationalScalar)
			{
				ansC = _coefficient.mul(new RationalScalar(_exponent,1));
			}

			ansE = _exponent-1;


		PolyTerm ansP = new PolyTerm(ansC,ansE);
		return ansP;

	}
	// returns true if the argument PolyTerm is equal to the current 
	//PolyTerm (same coefficient and power)

	boolean equals(PolyTerm pt){
		Scalar coeff = pt.getCoefficient();
		int exp = pt.getExponent();
		if (coeff.equals(_coefficient) && (exp==_exponent))
			return true;
		else
			return false;

	}

	public Scalar getCoefficient() {
		return _coefficient;
	}
	public void setCoefficient(Scalar coefficient) {
		this._coefficient = coefficient;
	}
	public int getExponent() {
		return _exponent;
	}
	public void setExponent(int exponent) {
		this._exponent = exponent;
	}
	public PolyTerm clone() {
		return new PolyTerm(_coefficient, _exponent);
	}
	@Override
	public String toString() {
		if(_exponent==0)
			return _coefficient.toString();
		if(_exponent==1)
			return _coefficient.toString()+"x";
		return _coefficient.toString()+"x^"+_exponent;
	}
}