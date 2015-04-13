import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class RationalScalar extends Scalar {
	private int a,b;
	public RationalScalar(int a,int b) {
		this.a=a;
		if(b==0)
			throw new RuntimeException("Can't devied by zero");
		this.b=b;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		if(b==0)
			throw new RuntimeException("Can't devied by zero");
		this.b = b;
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
