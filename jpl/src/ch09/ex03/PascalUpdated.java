/**
 * 
 */
package ex03;

/**
 * @author takahiro watanabe
 *
 */
public class PascalUpdated {

	int depth = 20;
	
	
	// [Before]--------------------------------------------------------------
	// Generate and pascal triangle
	public int[][] generatePascal(int depth) {
		int[][] pascalTriangle = new int[depth][];
		for(int i = 0; i < depth; i++) {
			pascalTriangle[i] = new int[i + 1];
			for(int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i)
					pascalTriangle[i][j] = 1;
				else
					pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
			}
		}
		
		return pascalTriangle;
	}
	
	// show pascal triangle
	public void showPascalTriangle(int[][] pascalTriangle) {
		int d = 1;
		for (int[] p: pascalTriangle) {
			System.out.printf("[%d]\t", d++);
			for (int i: p)
				System.out.printf("%d ", i);
			System.out.printf("%n");
		}
	}
	
	// [After]--------------------------------------------------------------
	// Generate and pascal triangle
	public int[][] generatePascal2(int depth) {
		int[][] pascalTriangle = new int[depth][];
		for(int i = 0; i < depth; i++) {
			pascalTriangle[i] = new int[i + 1];
			// •ÏX
			pascalTriangle[i][0] = pascalTriangle[i][i] = 1;
			for(int j = 1; j < i; j++) {
				pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
			}
		}
		
		return pascalTriangle;
	}
	
	// show pascal triangle
	public void showPascalTriangle2(int[][] pascalTriangle) {
		int d = 1;
		for (int[] p: pascalTriangle) {
			System.out.printf("[%d]\t", d++);
			for (int i: p)
				System.out.printf("%d ", i);
			System.out.printf("%n");
		}
	}
	
	
	public static void main(String[] args) {
		PascalUpdated pascal = new PascalUpdated();
		
		// create 12 depth pascal triangle
		pascal.showPascalTriangle2(pascal.generatePascal2(12));
		
		System.out.println();
		
		// other depth
		pascal.showPascalTriangle2(pascal.generatePascal2(pascal.depth));
	}

}
