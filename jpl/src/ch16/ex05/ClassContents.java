package ex05;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class ClassContents {

	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			printMembers(removeDuplicateMembers(c.getFields(), c.getDeclaredFields()));
			printMembers(removeDuplicateMembers(c.getConstructors(), c.getDeclaredConstructors()));
			printMembers(removeDuplicateMembers(c.getMethods(), c.getDeclaredMethods()));
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}
	
	private static void printMembers(Member[] mems) {
		for (Member m: mems) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			System.out.print("    ");
			System.out.println(strip(decl, "java.lang."));
			printAnnotations(m);
		}
	}
	
	private static void printAnnotations(Member mem) {
		for (Annotation a: ((AnnotatedElement)mem).getAnnotations())
			System.out.println("        [annotation]" + a);
			
	}
	
	private static String strip(String str, String target) {
		return str.replaceAll(target, "");
	}
	
	private static Member[] removeDuplicateMembers(Member[] mem1, Member[] mem2) {
		Set<Member> set = new LinkedHashSet<Member>();
		for (Member m: mem1) {
			set.add(m);
		}
		for (Member m: mem2) {
			set.add(m);
		}
		return set.toArray(new Member[set.size()]);
	}

}