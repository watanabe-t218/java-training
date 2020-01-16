package ex02;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;


public class FixedTypeDesc2 {

	public static void main(String[] args) {
		FixedTypeDesc2 desc = new FixedTypeDesc2();
		for (String name: args) {
			try {
				Class<?> startClass = Class.forName(name);
				desc.printType(startClass, 0, basic);
			} catch (ClassNotFoundException e) {
				System.err.println(e);
			}
		}
	}
	
	// �f�t�H���g�ŕW���o�͂ɕ\������
	private java.io.PrintStream out = System.out;
	
	// �^���Ƀ��x���t������printType()�Ŏg�p�����
	private static String[]
			basic	= {	"class",	"interface",
						"enum", 	"annotation"},
			supercl = {	"extends",	"implements"},
			iFace	= {	null,	 	"extends"};
	
	private void printType(Type type, int depth, String[] labels) {
		if (type == null || type == Object.class) // �ċA�Ăяo���֎~�F�X�[�p�[�^�C�v�����݂��Ȃ� 
			return;
		
		// Type��Class�I�u�W�F�N�g�ɕϊ�����
		Class<?> cls = null;
		if (type instanceof Class<?>)
			cls = (Class<?>) type;
		else if (type instanceof ParameterizedType)
			cls = (Class<?>)((ParameterizedType)type).getRawType();
		else
			throw new Error("Unexpected non-class type");
		
		// ���̌^��\��
		for (int i = 0; i < depth; i++)
			out.print(" ");
		int kind = cls.isAnnotation() ? 3 : // Annotation�Ȃ�3
			cls.isEnum() ? 2 :				// Enum�Ȃ�2
			cls.isInterface() ? 1 : 0;		// Interface�Ȃ�1, ����ȊO��0
		out.print(labels[kind] + " ");
		out.print(cls.getCanonicalName());
		
		// ����΁C�W�F�l���b�N�^�p�����[�^��\��
		TypeVariable<?>[] params = cls.getTypeParameters();
		if (params.length > 0) {
            out.print('<');
            for (TypeVariable<?> param : params) {
                out.print(param.getName());
                out.print(", ");
            }
            out.println("\b\b>");
        } else
			out.println();
		
		// ���̃N���X���������Ă��邷�ׂẴC���^�t�F�[�X��\��
		Type[] interfaces = cls.getGenericInterfaces();
		for (Type iface: interfaces) {
			printType(iface, depth + 1,
					cls.isInterface() ? iFace : supercl);
		}
		
		// �l�X�g�����^���������C�l�X�g�����^�Ȃ�ǂ̌^�̒��Ƀl�X�g���Ă��邩������
		Class<?> nestedClass = cls.getDeclaringClass();
		boolean isNested = cls.getDeclaringClass() == null? false : true;
		System.out.println("isNested: " + isNested);
		if (isNested) {
			out.println("Nested�F " + nestedClass.getCanonicalName());
		}
		
		// �X�[�p�[�N���X�ɑ΂��čċA
		printType(cls.getGenericSuperclass(),
				depth + 1, supercl);
	}
}