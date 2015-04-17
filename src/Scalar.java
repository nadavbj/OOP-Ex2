package hw2;

public interface Scalar {
	/**
	 * accepts a scalar argument and returns a
	 * scalar which is the sum of the current scalar and the argument.
	 */
	public abstract Scalar add(Scalar s);
	/**
	 * accepts a scalar argument and returns a
	 * scalar which is the multiplication of the current scalar and the
	 * argument.
	 */
	public abstract Scalar mul(Scalar s);
	/** 
	 * @return  a scalar which is the result of multiplying the
	 * current scalar by (-1).
	 */
	public abstract Scalar neg();
	/**
	 * @return (1/scalar)
	 */
	public abstract Scalar inv();


}
