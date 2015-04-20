package hw2;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;



public class Polynomial {
	Vector<PolyTerm>terms;

	public Polynomial(Collection<PolyTerm> terms) {
		this.terms=new Vector<PolyTerm>(terms);
	}

	public Polynomial(String expr) {
		this.terms=new Vector<PolyTerm>();
		expr.replaceAll("\\-", "\\+-");
		expr.replaceAll("\\/+-", "\\/-");
		String polyTerms[]=expr.split("\\+");
		for (int i = 0; i < polyTerms.length; i++) {
			if(!polyTerms[i].equals(""))
				terms.addElement(new PolyTerm(polyTerms[i]));
		}
		sortTerms();
	}
	/**
	 * @return a Polynomial which is the sum of the current Polynomial
	 * with the argument.
	 */
	public Polynomial add(Polynomial poly){
		Vector<PolyTerm> result=new Vector<PolyTerm>(terms);
		result.addAll(poly.terms);
		Polynomial ans= new Polynomial(result);
		ans.sortTerms();
		return ans;
	}
	/**
	 * @return a Polynomial is the multiplication of the current
	 * Polynomial with the argument.
	 */
	public Polynomial mul(Polynomial poly){
		Vector<PolyTerm> result=new Vector<PolyTerm>();
		for (PolyTerm myPolyTerm : terms) {
			for (PolyTerm othersPolyTerm : poly.terms) {
				result.add(myPolyTerm.mul(othersPolyTerm));
			}
		}
		Polynomial ans= new Polynomial(result);
		ans.sortTerms();
		return ans;
	}
	/**
	 *evaluates the polynomial using
	 * the argument scalar. 
	 */
	public Scalar evaluate(Scalar scalar){
		Scalar sum=new RationalScalar(0,1);
		for (PolyTerm polyTerm : terms) {
			sum=sum.add(polyTerm.evaluate(scalar));
		}
		return sum;
	}
	/** 
	 * @return  the Polynomial which is the result
	 * of applying first order derivation
	 */
	public Polynomial derivate(){
		Vector<PolyTerm> result=new Vector<PolyTerm>();
		for (PolyTerm polyTerm : terms) {
			result.add(polyTerm.derivate());
		}
		Polynomial ans= new Polynomial(result);
		ans.sortTerms();
		return ans;
	}
		
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Polynomial))
			return false;
		Polynomial other=(Polynomial)obj;
		sortTerms();
		other.sortTerms();
		if(terms.size()!=other.terms.size())
			return false;
		for (int i = 0; i < terms.size(); i++) {
			if(!terms.get(i).equals(other.terms.get(i)))
				return false;
		}
		return true;
	}	
			
	private void sortTerms() {
		terms.sort(new Comparator<PolyTerm>() {
			@Override
			public int compare(PolyTerm o1, PolyTerm o2) {
				return o1.getExponent()-o2.getExponent();
			}
		});
		for (int i = 0; i < terms.size(); i++) {
			if(terms.get(i).getCoefficient().isZero())
				terms.remove(i);
			while ((i+1)<terms.size() && terms.get(i+1).getExponent()==terms.get(i).getExponent()) {
				PolyTerm sum=terms.get(i).add(terms.get(i+1));
				terms.remove(i);
				terms.remove(i);
				terms.add(sum);
			}
		}
	}
	@Override
	public String toString() {
		String result="";
		for (PolyTerm polyTerm : terms) {
			result+="+"+polyTerm;
		}
		result=result.substring(1);
		result.replaceAll("+-", "-");
		return result;
	}
}
