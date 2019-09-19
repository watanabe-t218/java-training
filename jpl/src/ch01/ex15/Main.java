package ex15;

/**
 * @author Watari-Home
 *
 */
public class Main {

	public static void main(String[] args) {
		SimpleLookup simpleLookup = new SimpleLookup();
		
		simpleLookup.add("name1", 1111);
		simpleLookup.add("name2", 2222);
		
		System.out.println(simpleLookup.find("name1").toString());
		System.out.println(simpleLookup.find("name2").toString());
		
		try {
			System.out.println(simpleLookup.find("name3").toString());
		}catch (NullPointerException e) {
			System.out.println("name3 is null\n" + e.toString());
		}
		
		simpleLookup.remove("name1");
		try {
			System.out.println(simpleLookup.find("name1").toString());
		}catch (NullPointerException e) {
			System.out.println("name1 is null\n" + e.toString());
		}
	}

}
