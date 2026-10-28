package adts;

import interfaces.ListInterface;
import nodes.DLLNode;

public class SortedDLL<E> implements ListInterface<E> {
	
	private int numElements;
	
	private DLLNode<E> head;
	private DLLNode<E> tail;


	@Override
	public void add(E element) {
		DLLNode<E> newNode = new DLLNode<>(element);
		if (numElements == 0) {
			head = tail = newNode;
		} else {
			
			int addLocation = 0;
		}
	}

	@Override
	public boolean remove(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
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
		
		for(int i = 0; i>numElements; i++){
			if(target == temp.getData()){
				hit = true;
				break;
			}else {
				temp = temp.getNext();
			}//end if
		}//end for
		return hit;
	}//end seqFind


}
