/**
 * 
 */
package ex04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Watari-Home
 *
 */
public class StringSplit {

	public List<Object> makeList(String str) {
		List<Object> list = new ArrayList<Object>();
	
		List<String> stringLines = Arrays.asList(str.split("\n"));		
		for(String line: stringLines) {
			String type = line.split(" ")[0];
			String value = line.split(" ")[1];
			
			switch (type) {
			case "Boolean":
				list.add(Boolean.valueOf(value));
				break;
			
			case "Character":
				list.add(value.toCharArray()[0]);
				break;
			
			case "Byte":
				list.add(Byte.valueOf(value));
				break;
			
			case "Short":
				list.add(Short.valueOf(value));
				break;
			
			case "Integer":
				list.add(Integer.valueOf(value));
				break;
			
			case "Long":
				list.add(Long.valueOf(value));
				break;
			
			case "Float":
				list.add(Float.valueOf(value));
				break;
			
			case "Double":
				list.add(Double.valueOf(value));
				break;
			}
		}
		
		return list;
	}
}
