package hw2;/**
 * 
 */

/**
 * @author nadav
 *
 */
public class RealScalar extends Scalar {
	private double value;
	
	public RealScalar(double value) {
		this.value=value;
	}

	/**
	 * @see Scalar#add(Scalar)
	 */
	@Override
	public Scalar add(Scalar s) {
		if(s instanceof RationalScalar){
			RationalScalar rs=(RationalScalar) s;
			return new RealScalar(value+((double)rs.getNumenator())/rs.getDenominator());
		}
		RealScalar rs=(RealScalar)s;
		return new RealScalar(value+rs.value);
	}

	/**
	 * @see Scalar#mul(Scalar)
	 */
	@Override
	public Scalar mul(Scalar s) {
		if(s instanceof RationalScalar){
			RationalScalar rs=(RationalScalar) s;
			return new RealScalar(value*((double)rs.getNumenator())/rs.getDenominator());
		}
		RealScalar rs=(RealScalar)s;
		return new RealScalar(value*rs.value);
	}

	/**
	 * @see Scalar#neg()
	 */
	@Override
	public Scalar neg() {
		return new RealScalar(-value);
	}

	/**
	 * @see Scalar#inv()
	 */
	@Override
	public Scalar inv() {
		return new RealScalar(1/value);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
