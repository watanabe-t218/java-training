package ex03;

import java.util.ArrayList;

public class DelimitedString {

	
	public static String[] delimitedString(String from, char start, char end) {
		int startPos = from.indexOf(start);
		int endPos = from.lastIndexOf(end);
		ArrayList<String> strs = new ArrayList<String>();
		if (startPos == -1)
			return null;
		else if (endPos == -1) {
			strs.add(from.substring(startPos));
			return strs.toArray(new String[strs.size()]);
		} else if (startPos > endPos)
			return null;
		else {
			int startIndex = startPos;
			while(startIndex != -1) {
				int endIndex = endPos;
				while(endIndex != -1) {
					if(startIndex < endIndex) {
						String str = from.substring(startIndex, endIndex + 1);
						if (!strs.contains(str)) {
							strs.add(str);
						}
					}
					endIndex = from.lastIndexOf(end, endIndex - 1);
				}
				startIndex = from.indexOf(start, startIndex + 1);
			}
			return strs.toArray(new String[strs.size()]);
		}
	}
	
	public static void main(String[] args) {
		String from = "[a[b[c[d]e]f]g]";
		
		for(String str: delimitedString(from, '[', ']')) {
			System.out.println(str);
		}
	}
}
