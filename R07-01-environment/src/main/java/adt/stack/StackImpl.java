package adt.stack;

public class StackImpl<T> implements Stack<T> {

	protected T[] array;
	protected int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T result = null;
		if(!this.isEmpty()){
			result = this.array[top];
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return this.top == -1;
	}

	@Override
	public boolean isFull() {
		return this.top == array.length - 1;
	}

	@Override
	public void push(T element) throws StackOverflowException {
        if (this.isFull()) {
            throw new StackOverflowException();
        }
        this.array[++top] = element;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(this.isEmpty()){
			throw new StackUnderflowException();
		}
		T result = top();
		array[top--] = null;

		return result;
	
	}
}
