package hw2;

public class RealScalar extends Scalar  {
	private double _value;
	
	public RealScalar(double value) {
		this._value=value;
	}

	public RealScalar(Scalar other){
		RealScalar real = (RealScalar) other;
		_value = real.getValue();	
	}
	/**
	 * addition of two RealNumbers.
	 * assuming arg is a RealNumber.
	 **/
	
	public Scalar add(Scalar arg) {
			RealScalar rs=(RealScalar) arg;
			double Value = rs.getValue();
			double  tValue = Value + _value;
			Scalar newScalar = new RealScalar (tValue);	
			return newScalar;
	}

	/**
	 * multiplication of two RealNumbers.
	 * assuming arg is a RealNumber.
	**/
	
	public Scalar mul(Scalar arg) {
		RealScalar realArg = (RealScalar) arg;
			double valueArg = realArg.getValue();
			double tValue = valueArg * _value;
			Scalar newScalar = new RealScalar(tValue);		
			return newScalar;
		}
							
	/**
	 * negation of the Real Number.
	 */
	public  Scalar neg() {
		double tvalue = _value;
		
		if(_value==0 ){
			return new RealScalar(this);
		}
		else
		{
			tvalue = _value * (-1);
		}
					
		return new RealScalar(tvalue);
	}

	/**
	 * inverse of the Real Number.
	 */
		public Scalar inv() {
		double tValue =  _value;
		if(_value == 0){
			return new RealScalar(this);
		}
		else {
			tValue = (1/_value);
		}
	
		Scalar newScalar = new RealScalar(tValue);		
		return newScalar;
	}
		public String toString(){
			String str = new String();		
			String.format("%.3f", _value);
			str = str + _value ;
			return str;		
		}

	public double getValue() {
		return _value;
	}

	public void setValue(double value) {
		this._value = value;
	}

	@Override
	public boolean isZero() {
		return _value==0;
	}

}