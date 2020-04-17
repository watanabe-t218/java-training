package ex01;

public class GarbageCollectionTest {

	public static void checkFreeMemory() {
		System.out.println("Free Memory: " + Runtime.getRuntime().freeMemory());
	}
	
	public static void checkFreeMemory(String str) {
		System.out.print("Åy" + str + "Åz ");
		checkFreeMemory();
	}

	public static void main(String[] args) {
		checkFreeMemory("Awalening");
		int size = 1000000;
		String[] str = new String[size];
		for (int i = 0; i < size; i++) {
			str[i] = new String("Number" + i);
		}
		checkFreeMemory("Create Object");
		for (int i = 0; i < size; i++)
			str[i] = null;
		checkFreeMemory("Delete Object");
		Runtime.getRuntime().gc();
		checkFreeMemory("GC");
		
	}

}