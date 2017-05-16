package alda‹bung6;

public class IntList {
	public Node head;
	
	public IntList(){
		head = null;
	}
	public void addAtEnd(int n){
		Node newNode = new Node(n);
		if(head == null){
			head = newNode;
		} else {
			Node nd = head;
			while(nd.next != null){
				nd = nd.next;
			}
			nd.next = newNode;
		}
	}
	public void addAtSP(int n, IntList list){
		Node prev = list.head;
		for(Node nd = list.head.next; nd != null; nd = nd.next){
			if(n <= nd.value){
				Node newNode = new Node(n);
				newNode.next = nd;
				prev.next = newNode;
				return;
			}
			prev = prev.next;
		}
		list.addAtEnd(n);
	}
	public void addFront(int n, IntList list){
		Node newNode = new Node(n);
		newNode.next = list.head;
		list.head = newNode;
	}
	public void printList(){
		for(Node n = head; n != null; n = n.next){
			System.out.println(n.value);
		}
	}
	public IntList ListInsert(IntList list1, IntList list2){
		for(Node n = list1.head; n != null; n = n.next){
			if(list2.head == null){
				list2.addAtEnd(n.value);
			} else {
				if(n.value < list2.head.value){
					list2.addFront(n.value, list2);
				} else {
					list2.addAtSP(n.value, list2);
				}
			}
		}
		return list2;
	}
}
