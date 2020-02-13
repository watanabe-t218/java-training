package interpret;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CreateObject {
	Class<?> cl = null;
	Object instance = null;
	Constructor<?> constructor;
	Constructor<?>[] constructors;
	Field[] fields;

	Method method;

	public Method getMethod() {
		return method;
	}

	Method[] methods;

	public Constructor<?> getConstructor() {
		return constructor;
	}

	public CreateObject(String objectName, String className) {

		try {
			cl = Class.forName(className);
			constructors = cl.getConstructors();
			methods = cl.getMethods();
			fields = cl.getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
			}

			System.out.println("========[Select Constructor]========");
			for (Constructor<?> constructor : constructors) {
				System.out.println(constructor.toString());
			}

		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}

	public Type[] getConstructorParams(int constructorIndex) {
		System.out.println("========[Set Parameters]========");
		constructor = constructors[constructorIndex];
		Type[] params = constructor.getGenericParameterTypes();
		for (Type type : params) {
			System.out.println(type.getTypeName());
		}
		return params;
	}

	public Type[] getMethodParams(int methodIndex) {
		System.out.println("========[Set Parameters]========");
		method = methods[methodIndex];
		Type[] params = method.getGenericParameterTypes();
		for (Type type : params) {
			System.out.println(type.getTypeName());
		}
		return params;
	}

	public void runMethod(Object[] params) {
		System.out.println("========[Parameters]========");
		for (Object object : params) {
			System.out.println(object.toString());
		}
		try {
			System.out.println("========[Method Return]========");
			if (method.invoke(instance, (Object[]) params) != null) {
				Object res = method.invoke(instance, (Object[]) params);
				System.out.println(res.toString());
			}
			System.out.println("========[Method Complete]========");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Object createObject(Object[] params) {
		System.out.println("========[Parameters]========");
		for (Object object : params) {
			System.out.println(object.toString());
		}
		try {
			instance = constructor.newInstance(params);
			System.out.println("========[Creation Complete]========");
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			System.out.println(e);
		}
		return instance;
	}

	public void changeFields(Object[] params) {
		System.out.println("========[Parameters]========");
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			String strField = fields[i].toString();
			Object setParam = (Object) params[i];
			System.out.println(strField + "\t: " + setParam);

			try {
				if (!fields[i].get(instance).toString().equals(params[i].toString())) {
					fields[i].set(instance, setParam);
				}
			} catch (IllegalAccessException | IllegalArgumentException | SecurityException e) {
				System.out.println(e);
			}
		}
		System.out.println("========[Change Fields Complete]========");
	}

	public Constructor<?>[] getConstructors() {
		return constructors;
	}

	public Object getInstance() {
		return instance;
	}

	public Field[] getFields() {

		if (fields == null) {
			return null;
		}
		for (Field f : fields) {
			try {
				f.setAccessible(true);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return fields;
	}
}
