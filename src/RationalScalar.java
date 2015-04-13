import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class RationalScalar extends Scalar {
	int a,b;
	public RationalScalar(int a,int b) {
		this.a=a;
		if(b==0)
			throw new RuntimeException("Can't devied by zero");
		this.b=b;
	}
	@Override
	public Scalar add(Scalar s) {
		try{
			RationalScalar rs=(RationalScalar) s;
			return new RationalScalar(a*rs.b+b*rs.a,b*rs.b);
		}
		catch(Exception e){
			throw new NotImplementedException();
		}
	}

	@Override
	public Scalar mul(Scalar s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scalar neg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scalar inv() {
		// TODO Auto-generated method stub
		return null;
	}

}
