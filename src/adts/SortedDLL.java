package adts;
import interfaces.ListInterface;
import nodes.DLLNode;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class SortedDLL<E> implements ListInterface<E>, Iterable<E> {
	
	private int numElements = 0;
	
	private DLLNode<E> head;
	private DLLNode<E> tail;
	private DLLNode<E> location;
	@Override
	public void add(E element) {
		DLLNode<E> newNode = new DLLNode<>(element);
		if(numElements ==0) {
			head = tail = newNode;
		} else {
			DLLNode<E> temp = head;
			for(int i = 0; i<numElements; i++) {
				if (((Comparable)newNode.getData()).compareTo(head.getData()) >=0) {
					newNode.setNext(head);;
					head.setPrev(newNode);;
					head=newNode;
					break;
				}
				else if (temp.getNext() == null) {
					newNode.setPrev(tail);
					tail.setNext(newNode);
					tail = newNode;
					break;
				}
				else if(((Comparable)newNode.getData()).compareTo(temp.getData()) >=0 && ((Comparable)newNode.getData()).compareTo(temp.getPrev().getData()) <= 0) {
					temp.setNext(newNode);
					newNode.setNext(temp);
					newNode.setPrev(temp.getPrev());
					temp.setPrev(newNode);
					break;
				} else {
					temp = temp.getNext();
				}
			}
		}
	}
	@Override
	public boolean remove(E element) {
		seqFind(element);
		   if (seqFind(element) == false) {
		      return false;
		   }
		 
		   location.getPrev().setNext(location.getNext());
		   location.getNext().setPrev(location.getPrev());
		   if (location.getPrev() == null) {
		      head = location.getNext();
		   } else if (location.getNext() == null ){
		      tail = location.getPrev();
		   } else {
		      location.getPrev().setNext(location.getNext());
		      location.getNext().setPrev(location.getPrev());
		   }
		   numElements -= 1;
		   return true;
	}
	@Override
	public int size() {
		return numElements;
	}
	@Override
	public boolean isEmpty() {
		return numElements == 0;
	}
	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public E get(E element) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	private boolean seqFind(E target){
		boolean hit = false;
		DLLNode<E> temp = head;
		// Was not able to test this but it looks correct
		// Or we could use a while loop
		// while(temp.getData() != null) ???
		
		for(int i = 0; i<numElements; i++){
			if(target == temp.getData()){
				hit = true;
				break;
			}else {
				temp = temp.getNext();
			}//end if
		}//end for
		return hit;
	}//end seqFind
	private boolean binFind(E target) {
		
		boolean hit = false;
		int low = 0;
		int high = numElements - 1;
		
		while(low <= high) {
			int mid = low + (low-high)/2;
			E temp = get(mid);
			int comparison = ((Comparable<E>)target).compareTo(temp);
			
			if(comparison == 0) {
				hit = true;
				break;
			} else if (comparison < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return hit;
	}
	
	private class ForwardIterator implements Iterator<E>{
		private DLLNode<E> current = head;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}
		@Override
		public E next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			E data = current.getData();
			current = current.getPrev();
			return data;
		}
	}
	
	public Iterator<E> iterator() {
		return new ForwardIterator();
	}
}
