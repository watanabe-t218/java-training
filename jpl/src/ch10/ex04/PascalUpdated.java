/**
 * 
 */
package ex04;

/**
 * @author takahiro watanabe
 *
 */
public class PascalUpdated {

	int depth = 20;
	
	// [After]--------------------------------------------------------------
	// Generate and pascal triangle
	public int[][] generatePascal2(int depth) {
		int[][] pascalTriangle = new int[depth][];
		int i = 0;
		do {
			pascalTriangle[i] = new int[i + 1];
			pascalTriangle[i][0] = pascalTriangle[i][i] = 1;
			int j = 1;
			while(j++ < i) //1段目の処理は行わないためdo-whileでない．
		    {
				pascalTriangle[i][j - 1] = pascalTriangle[i - 1][j - 2] + pascalTriangle[i - 1][j - 1];
		    }
		}while(i++ < depth - 1); //i++処理をwhile内で記述できる
		return pascalTriangle;
	}
	
	// show pascal triangle
	public void showPascalTriangle2(int[][] pascalTriangle) {
		int d = 1;
		for (int[] p: pascalTriangle) { //リスト内要素に合わせて繰り返し回数を変えるためforが簡潔
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
