package adt.queue;

@SuppressWarnings("unused")
public class CircularQueueImpl<T> implements Queue<T> {

	protected T[] array;
	protected int tail;
	protected int head;
	protected int elements;

	@SuppressWarnings("unchecked")
	public CircularQueueImpl(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()){
			throw new QueueOverflowException();
		}
		if(element != null){
			if(isEmpty()){
				head = 0;
				tail = 0;
			}else{
				tail = (tail + 1) % array.length;
			}
			array[tail] = element;
			elements++;
		}
		
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()){
			throw new QueueUnderflowException();
		}
		T result = array[head];
		array[head] = null;
		elements--;
		if(elements == 0){
			head = -1;
			tail = -1;
		}else{
			head = (head + 1) % array.length; 
		}

		return result;
	}

	@Override
	public T head() {
		T result = null;
		if(isEmpty()){
			result = array[head];
		}
		return result;
		
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return elements == array.length;
	}

}
