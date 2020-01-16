package ex07;

/*
 * 
 * 
 * false 2 aaa bbb ccc ddd
1.
aaa
aaa
ddd
ddd
ccc
ccc
bbb
bbb

2.
aaa
ccc
ccc
bbb
bbb
ddd
ddd
aaa


 * */

public class Babble extends Thread {

	static boolean doYield;	// ���̃X���b�h�Ɏ��s�����邩�H
	static int howOften;	// �\�������
	private String word;	// ���̃X���b�h�̒P��

	Babble(String whatToSay) {
		word = whatToSay;
	}

	public void run() {
		for (int i = 0; i < howOften; i++) {
			System.out.println(word);
			if (doYield)
				Thread.yield(); // ���̃X���b�h�𑖂点��
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		doYield = new Boolean(args[0]).booleanValue();
		howOften = Integer.parseInt(args[1]);

		for (int i = 2; i < args.length; i++)
			new Babble(args[i]).start();
	}
}