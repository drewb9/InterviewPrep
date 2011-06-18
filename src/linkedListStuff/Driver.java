package linkedListStuff;

public class Driver {

	public static void main(String[] args) {
		IntNode n2 = new IntNode(2,null);
		IntNode n0 = new IntNode(0,n2);
		IntNode n1 = new IntNode(1,n0);
		n2.setNext(n1);
		IntNode n3 = new IntNode(3,n2);
		IntNode n4 = new IntNode(4,n3);
		
		//4,3,2,1,0,2
		
		System.out.println(IntLinkedListUtilities.hasCycle(n4));
		
	}

}
