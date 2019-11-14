/**
 * 
 */
package ex02;

/**
 * @author Watari-Home
 *
 */
public class BitCount {

	
	public static int bitcount(int num) {
		int count = 0;
		while(num != 0) {
			if((num & 0x0001) == 0x0001) {
				count++;
			}
			num = num >>> 1;
		}
		return count;
	}
	
	//reference1
	public static int bitcountref1(int bits)
	{
	    int num;

	    num = (bits >> 1) & 03333333333;
	    num = bits - num - ((num >> 1) & 03333333333);  
	    num = ((num + (num >> 3)) & 0707070707) % 077;

	    return num;
	}
	
	//reference2
	public static long bitcountref2(long bits)
	{
	    bits = (bits & 0x55555555) + (bits >> 1 & 0x55555555);
	    bits = (bits & 0x33333333) + (bits >> 2 & 0x33333333);
	    bits = (bits & 0x0f0f0f0f) + (bits >> 4 & 0x0f0f0f0f);
	    bits = (bits & 0x00ff00ff) + (bits >> 8 & 0x00ff00ff);
	    return (bits & 0x0000ffff) + (bits >>16 & 0x0000ffff);
	}
	
	
	public static void main(String[] args) {
		
		int num = 255;
		
		// ˆ—‘O‚Ì‚ğæ“¾
        long startTime = System.currentTimeMillis();
		
        for(int i = 0; i<1000000; i++) {
        	bitcount(num);				// 9-10ms
//        	bitcountref1(num);			//	4ms
//        	bitcountref2((long)num);	//	3ms
        }
		
		// ˆ—Œã‚Ì‚ğæ“¾
        long endTime = System.currentTimeMillis();
        System.out.println("ˆ—ŠÔF" + (endTime - startTime) + " ms");
	}

}
