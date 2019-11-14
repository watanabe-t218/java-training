/**
 * 
 */
package ex01;

/**
 * @author takahiro watanabe
 *
 */
public class CalcInf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Double pInf = Double.POSITIVE_INFINITY;
		Double nInf = Double.NEGATIVE_INFINITY;

		System.out.printf("\t\t[ + ]\t\t[ - ]\t\t[ * ]\t\t[ / ]%n");
		
		System.out.printf("[p,p]\t");
		System.out.printf("%2f\t\t%2f\t\t%2f\t\t%2f%n", pInf + pInf, pInf - pInf, pInf * pInf, pInf / pInf);

		System.out.printf("[p,n]\t");
		System.out.printf("%2f\t\t%2f\t\t%2f\t\t%2f%n", pInf + nInf, pInf - nInf, pInf * nInf, pInf / nInf);

		System.out.printf("[n,p]\t");
		System.out.printf("%2f\t\t%2f\t\t%2f\t\t%2f%n",nInf + pInf, nInf - pInf, nInf * pInf, nInf / pInf);

		System.out.printf("[n,n]\t");
		System.out.printf("%2f\t\t%2f\t\t%2f\t\t%2f%n", nInf + nInf, nInf - nInf, nInf * nInf, nInf / nInf);



	}

}
