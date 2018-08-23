package com.mathew.corejava.collections;

/**
 * Last in first out
 * 
 * @author u0117078
 *
 */
public class StackImpl<E> {
	private Object[] stack;
	private static final int DEFAULT_CAPACITY = 10;
	private int count;
	private int capacity;

	public StackImpl() {
		capacity = DEFAULT_CAPACITY;
		stack = new Object[capacity];
		count = 0;
	}

	public StackImpl(int cap) {
		capacity = cap;
		stack = new Object[capacity];
		count = 0;
	}

	public void push(E element) throws StackFull {
		if (count == capacity) {
			throw new StackFull();
		}
		stack[count++] = element;
	}

	public E pop() throws StackEmpty {
		if (count == 0) {
			throw new StackEmpty();
		}
		E element = (E) stack[count - 1];
		stack[count - 1] = null;
		count--;
		return element;
	}

	public E peek() throws StackEmpty {
		if (count == 0) {
			throw new StackEmpty();
		}
		E element = (E) stack[count - 1];
		return element;
	}

	public int search(E element) {
		for (int ii = count - 1; ii >= 0; ii--) {
			E existElement = (E) stack[ii];
			if (existElement.equals(element)) {
				return ii;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		try {
			StackImpl<String> stack = new StackImpl<String>();
			stack.push("1");
			stack.push("2");
			stack.push("3");
			stack.push("4");
			stack.push("5");
			System.out.println(stack.peek());
			System.out.println(stack.peek());
			System.out.println(stack.peek());
			System.out.println(stack.peek());
			System.out.println(stack.search("3"));
		} catch (StackFull e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StackEmpty e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class StackFull extends Exception {
	private String message;

	public StackFull() {
		message = "Stack is Full";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

class StackEmpty extends Exception {
	private String message;

	public StackEmpty() {
		message = "Stack is Empty";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
