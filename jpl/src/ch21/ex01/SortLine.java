package ex01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortLine {
	
	public static List<String> sort(File file) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			LinkedList<String> sorted = new LinkedList<>();
			String line;
			while((line = in.readLine()) != null) {
				int i = 0;
				for (String s: sorted) {
					if (line.compareTo(s) < 0) {
						sorted.add(i, line);
						break;
					}
					i++;
				}
				if (sorted.size() == i)
					sorted.add(line);
			}
			return sorted;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return Collections.emptyList();
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
		
	}
	
	public static void main(String[] args) {
		if (args.length == 0) {
			args = new String[1];
			args[0] = "testfile.txt";
		}
		String path = System.getProperty("user.dir") + "\\src\\ch21\\ex01\\" + args[0];
		List<String> sortedList = sort(new File(path));
		for (String str: sortedList)
			System.out.println("sorted: " + str);
	}
}
