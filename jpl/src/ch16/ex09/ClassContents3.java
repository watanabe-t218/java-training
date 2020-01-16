package ex09;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class ClassContents3 {

	static String className;
	
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			className = c.toString();
			printClass(c, 0);
		} catch (ClassNotFoundException e) {
			System.out.println(e + "\nclass name error: " + args[0]);
		}
	}
	
	private static void printClass(Class<?> c, int indent) {
		for (int i = 0; i < indent; i++) {
			System.out.print("    ");			
		}
		System.out.print(strip(c.toString(), "java.lang."));
		printSuperTypes(c);
		System.out.println(" {");
		printMembers(removeDuplicateMembers(c.getFields(), c.getDeclaredFields()), c.getName() + ".", indent + 1);
		printMembers(removeDuplicateMembers(c.getConstructors(), c.getDeclaredConstructors()), strip(c.getName(), c.getSimpleName()), indent + 1);
		printMembers(removeDuplicateMembers(c.getMethods(), c.getDeclaredMethods()), c.getName() + ".", indent + 1);
		for (Class<?> cls: c.getDeclaredClasses()) {
			printClass(cls, indent + 1);
		}
		for (int i = 0; i < indent; i++)
			System.out.print("    ");
		System.out.println("}");
	}
	
	private static void printMembers(Member[] mems, String prefix, int indent) {
		for (Member m: mems) {
			if (m.getDeclaringClass() == Object.class || m.isSynthetic() == true || m.getName() == className)
				continue;
			String decl = m.toString();
			printAnnotation(m, indent);
			for (int i = 0; i < indent; i++)
				System.out.print("    ");
			System.out.println(strip(strip(decl, "java.lang."), prefix) + ";");
		}
	}
	
	private static String strip(String str, String target) {
		return str.replaceAll(target, "");
	}
	
	private static void printAnnotation(Member mem, int indent) {
		if (mem instanceof AnnotatedElement) {
			for (Annotation a: ((AnnotatedElement)mem).getAnnotations()) {
				for (int i = 0; i < indent; i++) {
					System.out.print("    ");
				}
				System.out.println(a);
			}
		}
			
	}
	
  private static void printSuperTypes(Class<?> cls) {
	  Type sType = cls.getGenericSuperclass();
	  if (sType != null) {
	      Class<?> scls = null;
	      if (sType instanceof Class<?>) {
	    	  scls = (Class<?>) sType;	    	  
	      }
	      else if (sType instanceof ParameterizedType) {
	    	  scls = (Class<?>)((ParameterizedType)sType).getRawType();	    	  
	      }
	      if (scls != Object.class) {
	    	  System.out.print(" extends ");
	    	  System.out.print(scls.getSimpleName());
	    	  System.out.print(scls.getTypeParameters());
	    	  System.out.print(" ");
	      }
	    }
	  
	    Type[] interfaces = cls.getGenericInterfaces();
	    if (interfaces.length > 0){
	    	System.out.print(" implements ");
	    }
	    for (Type iface :interfaces) {
	    	Class<?> iClass = null;
	    	if (iface instanceof Class<?>) {
	    		iClass = (Class<?>) iface;
	    	}
	    	else if (iface instanceof ParameterizedType) {
	    		iClass = (Class<?>)((ParameterizedType) iface).getRawType();
	        }
	    	
	      System.out.print(iClass.getSimpleName() + " ");
	    }
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
