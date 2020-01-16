package ex08;

public class Friendly {

	private static Object lock = new Object();
	private Friendly partner;
	private String name;
	
	public Friendly(String name) {
		this.name = name;
	}
	
	public void hug() {
		synchronized(lock) {
			System.out.println(Thread.currentThread().getName() +
					" in " + name + ".hug() trying to invoke " +
					partner.name + ".hugBack()");
			partner.hugBack();
		}
	}
	
	private void hugBack() {
		System.out.println(Thread.currentThread().getName() +
				" in " + name + ".hugBack()");
	}
	
	public void becomeFriend(Friendly partner) {
		this.partner = partner;
	}
}
