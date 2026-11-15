package adts;
import interfaces.ListInterface;
import nodes.DLLNode;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class SortedDLL<E> implements ListInterface<E>, Iterable<E> {
	
	protected int numElements = 0;
	
	private DLLNode<E> head;
	private DLLNode<E> tail;
	private DLLNode<E> location;
	
	private String findType = "Sequential";
	private String iteratorType = "Forward";
	
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
		find(element);
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
		return find(element);
	}
	@Override
	public E get(E element) {
		if (find(element)) {
			return location.getData();
		}
		
		return null;
	}
	@Override
	public E get(int index) {
		DLLNode<E> temp = head;
		for (int i=0; i < index; i++) {
			temp = temp.getNext();
		}
		return temp.getData();
	}
	
	public void setFind(String type) {
		
		if (type.equalsIgnoreCase("Sequential")) {
			findType = "Sequential";
		} else if (type.equalsIgnoreCase("Binary")) {
			findType = "Binary";
		}
	}
	
	private boolean find(E target) {
		if (findType.equalsIgnoreCase("Sequential")) {
			return seqFind(target);
		} else {
			return binFind(target);
		}
	}
	
	private boolean seqFind(E target){
		boolean hit = false;
		location = head;
		// Was not able to test this but it looks correct
		// Or we could use a while loop
		// while(temp.getData() != null) ???
		
		for(int i = 0; i<numElements; i++){
			if(target == location.getData()){
				hit = true;
				break;
			}else {
				location = location.getNext();
			}//end if
		}//end for
		return hit;
	//end seqFind
	}
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
	
	private class RandomIterator implements Iterator<E> {
		E[] array = (E[]) new Object[numElements];
		DLLNode<E> current = head;
		int index = 0;
		public void RandomIterator () {

			for (int i=0; i < numElements; i++){
				array[i] = current.getData();
				current = current.getNext();
			}
	
	
			for (int i = array.length -1; i>0; i--){
				int x = (int)(Math.random() * (i+1));
				E temp = array[i];
				array[i] = array[x];
				array[x] = temp;
			}

		}

		@Override
		public boolean hasNext() {
			return index < numElements;
		}

		@Override
		public E next() {
			return array[index++];
		}
	}
	
	private class ReverseIterator implements Iterator<E> {
		private DLLNode<E> current = tail;
		
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
	
	public void setIterator(String type) {

		if (type.equalsIgnoreCase("Forward")) {
			iteratorType = "Forward";
		} else if (type.equalsIgnoreCase("Reverse")) {
			iteratorType = "Reverse";
		} else if (type.equalsIgnoreCase("Random")) {
			iteratorType = "Random";
		}

	}
	
	public String getIterator() {
		return iteratorType;
	}
	
	public Iterator<E> iterator() {
		if (iteratorType.equalsIgnoreCase("Reverse")) {
			return new ReverseIterator();
		} else if (iteratorType.equalsIgnoreCase("Random")) {
			return new RandomIterator();
		}
		return new ForwardIterator();
	}
	
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		DLLNode<E> current = head;

		while (current != null) {
			sb.append(current.getData() + " ");
			current = current.getNext();
		}
		return sb.toString();
 
	}
}
