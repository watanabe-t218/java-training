/**
 * 
 */
package ex03;

/**
 * @author takahiro watanabe
 *
 */
public class Pascal {

	int depth = 14;
	
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
	
	
	public static void main(String[] args) {
		Pascal pascal = new Pascal();
		
		// create 12 depth pascal triangle
		pascal.showPascalTriangle(pascal.generatePascal(12));
		
		System.out.println();
		
		// other depth
		pascal.showPascalTriangle(pascal.generatePascal(pascal.depth));
	}

}
