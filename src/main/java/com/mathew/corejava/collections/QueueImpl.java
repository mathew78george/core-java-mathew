package com.mathew.corejava.collections;

/**
 * FIFO - first in first out
 * 
 * @author u0117078
 *
 */
public class QueueImpl<E> {

	private Object[] queue;
	private static final int DEFAULT_CAPACITY = 10;
	private int count;
	private int capacity;

	public QueueImpl() {
		capacity = DEFAULT_CAPACITY;
		queue = new Object[capacity];
		count = 0;
	}

	public QueueImpl(int cap) {
		capacity = cap;
		queue = new Object[capacity];
		count = 0;
	}

	public void add(E element) throws QueueFull {
		if (count == capacity) {
			throw new QueueFull();
		}
		queue[count++] = element;
	}

	public E poll() throws QueueEmpty {
		if (count == 0) {
			throw new QueueEmpty();
		}
		E element = (E) queue[0];
		for (int ii = 0; ii < capacity - 1; ii++) {
			queue[ii] = queue[ii + 1];
		}
		return element;
	}

	public E peek() throws QueueEmpty {
		E element = (E) queue[0];
		return element;
	}

	public static void main(String[] args) {
		QueueImpl<String> queue = new QueueImpl<String>(10);
		try {
			queue.add("1");
			queue.add("2");
			queue.add("3");
			queue.add("4");
			queue.add("5");
			System.out.println(queue.poll());
			System.out.println(queue.poll());
			System.out.println(queue.poll());
			System.out.println(queue.poll());
		} catch (QueueFull e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueueEmpty e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class QueueFull extends Exception {
	private String message;

	public QueueFull() {
		message = "Queue is Full";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

class QueueEmpty extends Exception {
	private String message;

	public QueueEmpty() {
		message = "Queue is Empty";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}