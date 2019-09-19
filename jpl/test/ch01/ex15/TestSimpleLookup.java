package ex15;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSimpleLookup {

	@Test
	void test() {
		SimpleLookup simpleLookup = new SimpleLookup();
		
		simpleLookup.add("name1", 1111);
		
		// can add & find Object
		assertNotNull(simpleLookup.find("name1"));
		// return null if Object doed not exists
		assertNull(simpleLookup.find("name2"));
		
		// can remove and find method return null after remove
		simpleLookup.remove("name1");
		assertNull(simpleLookup.find("name1"));
	}

}
