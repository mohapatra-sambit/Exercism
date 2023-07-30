import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

class SimpleLinkedList<T> {

	private Node<T> head;

	private int len;

	SimpleLinkedList() {
		head = new Node<T>(null, null);
		len = 0;
	}

	SimpleLinkedList(T[] values) {
		IntStream.range(0, values.length).forEach(i -> push(values[i]));
	}

	void push(T value) {
		Node<T> temp = new Node<T>(value, null);
		temp.setNext(head);
		len++;
		head = temp;
	}

	T pop() {
		if (len == 0) {
			throw new NoSuchElementException();
		}
		Node<T> temp = head;
		head = temp.getNext();
		len--;
		return temp.getData();
	}

	void reverse() {
		Node<T> curr = head;
		Node<T> prev = null;
		while (curr.getNext() != null) {
			Node<T> next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	@SuppressWarnings("unchecked")
	T[] asArray(Class<T> clazz) {
		T[] arr = (T[]) Array.newInstance(clazz, len);
		if (len > 0) {
			Node<T> curr = head;
			for (int i = 0; i < len; i++) {
				arr[i] = curr.getData();
				curr = curr.getNext();
			}
		}
		return arr;
	}

	int size() {
		return len;
	}

	@SuppressWarnings("hiding")
	class Node<T> {
		
		private T data;
		
		private Node<T> next;
		
		public Node(T data, Node<T> next) {
			super();
			this.data = data;
			this.next = next;
		}
		
		public void setData(T data) {
			this.data = data;
		}
		
		public void setNext(Node<T> next) {
			this.next = next;
		}
		
		public T getData() {
			return data;
		}
		
		public Node<T> getNext() {
			return next;
		}
		
		@Override
		public String toString() {
			return "" + data;
		}
		
	}
}

