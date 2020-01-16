package ex01;

import java.lang.reflect.*;

public class FixedTypeDesc {

	public static void main(String[] args) {
		FixedTypeDesc desc = new FixedTypeDesc();
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
		
		// �X�[�p�[�N���X�ɑ΂��čċA
		printType(cls.getGenericSuperclass(),
				depth + 1, supercl);
	}
}