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
		String polyTerms[]=expr.split("+");
		for (int i = 0; i < polyTerms.length; i++) {
			terms.addElement(new PolyTerm(polyTerms[i]));
		}
	}
	/**
	 * @return a Polynomial which is the sum of the current Polynomial
	 * with the argument.
	 */
	public Polynomial add(Polynomial poly){
		sortTerms();
		poly.sortTerms();
		Vector<PolyTerm> result=new Vector<PolyTerm>();
		int i1=0,i2=0;
		while (i1<terms.size()&&i2<poly.terms.size()) {
			if(terms.get(i1).getExponent()==terms.get(i2).getExponent())
				;//TODO: continue
		}
		
		return new Polynomial(result);
	}
	private void sortTerms() {
		terms.sort(new Comparator<PolyTerm>() {
			@Override
			public int compare(PolyTerm o1, PolyTerm o2) {
				return o1.getExponent()-o2.getExponent();
			}
		});
	}
}
