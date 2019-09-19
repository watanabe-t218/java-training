package ex12;

/**
 * @author Watari-Home
 *
 *	�A�����X�g�̒P��I�u�W�F�N�g�̂��߁CVehicle��ێ�����ۂɂ͉ϒ������͕s�v
 *	Vehicle�̕��ނ������ꍇ 
 *	����A:[vehicle1, vehicle2], 
 *	����B:[vehicle1, vehicle2, vehicle2]
 *	�Ȃǂ����X�g�Ƃ��Ď��ꍇ�ϒ��������K�v�ɂȂ�ƍl������D
 *
 */
public class LinkedList {
	public Object data;
	public LinkedList next;
	
	/**
	 * generate null list object (for start point)
	 * 
	 * */
	public LinkedList() {
		this.data = null;
		this.next = null;
	}
	
	/**
	 * generate with data 
	 * 
	 * */
	public LinkedList(Object data) {
		this.data = data;
		this.next = null;
	}
	
	/**
	 * generate with data & next list object
	 * 
	 * */
	public LinkedList(Object data, LinkedList next) {
		this.data = data;
		this.next = next;
	}
}
