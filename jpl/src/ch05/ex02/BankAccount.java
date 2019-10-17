/**
 * 
 */
package ex02;

/**
 * @author takahiro watanabe
 *
 */
public class BankAccount {
	private long number;
	private long balance;
	private History history = new History();

	public BankAccount(long number) {
		this.number = number;
		this.balance = 0;
	}
	
	public class Action {
		private String act;
		private long amount;
		
		Action(String act, long amount) {
			this.act = act;
			this.amount = amount;
		}
		
		public String toString() {
			// identify our enclosing account
			return act + " " + amount;
		}
		
	}
	
	public void deposit(long amount) throws IllegalArgumentException {
		if (amount > 0) {
			balance += amount;
			history.addHistory("deposit", amount);
		} else
			throw new IllegalArgumentException();
	}
	
	public void withdraw(long amount) throws IllegalArgumentException {
		if (amount > 0) {
			balance -= amount;
			history.addHistory("withdraw", amount);
		} else
			throw new IllegalArgumentException();
	}
	
	// -- Start Task from Here --
	public History history() {
		return history;
	}
	
	// BankAccountに紐づいて持っているHistoryなのでネスト，
	// それぞれのアカウントが個別にHisoryを持つべきなのでStaticではない
	public class History {
		private int head = 0;
		private final int max = 10;
		private Action[] actions = new Action[max];
	
		public Action next() {
			if(head < max) {
				Action action = actions[head];
				head++;
				return action;				
			} else {
				return null;
			}
		}

		public void addHistory(String act, long amount) {
			head = (head + 1) % max;
			actions[head] = new Action(act, amount);	
		}

		public String toString() {
			String str = "";
			for (int i = max; i > 0; i--) {
				if (actions[(head + i) % max] != null) {
					str += i + ": " + actions[(head + i) % max] + "\n";					
				}
			}
			return str;
		}

	}

}
