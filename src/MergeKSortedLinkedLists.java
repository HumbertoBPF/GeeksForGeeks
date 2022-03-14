import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLinkedLists {

	public static void main(String[] args) {
		Node linkedList1 = new Node(1,new Node(4,new Node(5)));
		
		Node linkedList2 = new Node(1,new Node(3,new Node(4)));
		
		Node linkedList3 = new Node(2,new Node(8));
		
		System.out.println(linkedList1.toString());
		System.out.println(linkedList2.toString());
		System.out.println(linkedList3.toString());
		
		Node[] arr = {linkedList1,linkedList2,linkedList3};
		System.out.println(mergeKList(arr,arr.length).toString());
	}
	
	// a is an array of Nodes of the heads of linked lists
	// and N is size of array a

    //Function to merge K sorted linked list.
    public static Node mergeKList(Node[] arr,int K) {
    	// If the list of LinkedLists has no items, return a null LinkedList
		if (K == 0) {
			return null;
		}
		// If the list of LinkedLists has a unique item, return it
		if (K == 1) {
			return arr[0];
		}
		// Variable with all the LinkedLists to be merged
		List<Node> listsToMerge = new ArrayList<>();
		// Add all the LinkedLists of the input array
		for (Node node : arr) {
			listsToMerge.add(node);
		}
		// Merge the LinkedLists two by two
		while (listsToMerge.size() != 1) {
			// List to store the result of a merging(intermediary results)
			List<Node> remainingLists = new ArrayList<>();
			// Here the LinkedLists are effectively merged two by two
			for (int i = 0;i < listsToMerge.size()/2;i++) {
				remainingLists.add(mergeTwoLists(listsToMerge.get(2*i),listsToMerge.get(2*i+1)));
			}
			// When we have an odd number of LinkedLists, we do not merge the last one,
			// which has to be added to 'remainingLists' separately
			if (listsToMerge.size()%2 != 0) {
				remainingLists.add(listsToMerge.get(listsToMerge.size()-1));
			}
			// Store the new LinkedLists to merge after the two by two merging
			listsToMerge = remainingLists;
		}
		// After merging all the LinkedLists, hopefully we have a unique LinkedList. So we return it
		return listsToMerge.get(0);
    }
    
    public static Node mergeTwoLists(Node list1, Node list2) {
		// If one of the lists if null, return the other one
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		// Last node that was inserted into the merged list
        Node lastNodeMergedList = null;
        // Node to detach from one of the input lists and to add to the merged list
        Node nodeToDetach = null;
        // Head of the merged list(to be returned at the end)
        Node headMergedList = null;
        
        while (list1 != null && list2 != null) {
        	// We compare the current node of the input lists and we detach the lowest one
        	if (list1.data <= list2.data) {
        		nodeToDetach = list1;
        		// Go to the next node of the list with the lowest current node
        		list1 = list1.next;
        		// Detach the node
        		nodeToDetach.next = null;
        		// If the merged list has not been created yet, create it by adding the selected
        		// node. Besides we indicate that this node is the head of the merged list
        		if (lastNodeMergedList == null) {
        			lastNodeMergedList = nodeToDetach;
        			headMergedList = lastNodeMergedList;
        		// If the merged list has already been initialized, we add the selected node to it
        		// and we move the variable 'lastNodeMergedList' to the node that was just added
        		}else {
        			lastNodeMergedList.next = nodeToDetach;
        			lastNodeMergedList = lastNodeMergedList.next;
        		}
        	}else {
        		nodeToDetach = list2;
        		list2 = list2.next;
        		nodeToDetach.next = null;
        		if (lastNodeMergedList == null) {
        			lastNodeMergedList = nodeToDetach;
        			headMergedList = lastNodeMergedList;
        		}else {
        			lastNodeMergedList.next = nodeToDetach;
        			lastNodeMergedList = lastNodeMergedList.next;
        		}
        	}
        }
        // If, after comparing both LinkedList, there are remaining items in one of 
        // the lists, add them to the merged list
        if (list1 != null) {
        	lastNodeMergedList.next = list1;
        }
        
        if (list2 != null) {
        	lastNodeMergedList.next = list2;
        }
        
        return headMergedList;
    }
    
    public static class Node {
    	
    	public int data;
        public Node next;
        
        Node(int key) {
        	this.data = key;
        	this.next = null;
        }
        
        Node(int key, Node nextNode) {
        	this.data = key;
        	this.next = nextNode;
        }
        
        public String toString() {
        	Node currentNode = this.next;
        	String nodeString = this.data + "";
        	while (currentNode != null) {
        		nodeString += (" -> "+currentNode.data);
        		currentNode = currentNode.next;
        	}
        	
        	return nodeString;
        }
        
    }
	
}
