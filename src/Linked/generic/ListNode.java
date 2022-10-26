package Linked.generic;

public class ListNode <V> {
	private V data;
	public ListNode link;
	
	public ListNode() {
		this.data = null;
		this.link = null;
	}
	
	public ListNode(V data) {
		this.data = data;
		this.link = null;
	}
	
	public ListNode(V data,ListNode link) {
		this.data = data;
//		this.link = link;
	}
	
	public  V getData() {
		return this.data;
	}
}
