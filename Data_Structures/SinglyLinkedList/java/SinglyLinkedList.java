import java.io.*;

public class SinglyLinkedList<E> {
  private static class Node<E> {
    private E element;
    private Node<E> next;
  
    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }
    public E getElement() { return element; }
    public Node<E> getNext() { return next; }
    public void setNext(Node<E> n) { next = n; }
  }

  private Node<E> head = null;
  private Node<E> tail = null;
  private int size = 0;

  public SinglyLinkedList() {}
  public int size() { return size; }
  public boolean isEmpty() { return size == 0; }

  public E first() {
    if (isEmpty()) {
      return null;
    }
    else {
      return head.getNext().getElement();
    }
  }

  public E last() {
    if (isEmpty()) {
      return null;
    }
    else {
      return tail.getNext().getElement();
    }
  }

  public void addFirst(E e) {
    head = new Node<>(e, head);
    if (isEmpty()) {
      tail = head;
    }
    size++;
  }

  public void addLast(E e) {
    Node<E> n = new Node(e, null);
    if (isEmpty()) {
      head = n;
    }
    else {
      tail.setNext(n);
    }
    tail = n;
    size++;
  }

  public E removeFirst() {
    if (isEmpty()) return null;
    E e = head.getElement();
    head = head.getNext();
    size--;
    if (isEmpty()) { tail = null; }
    return e;
  }

  public void listAll() {
    Node<E> n = head;
    while (n != tail) {
      System.out.print(n.getElement() + " -> ");
      n = n.getNext();
    }
    System.out.print(n.getElement() + "\n");
  }

  public static void main(String[] args) {
    System.out.println("Howdy!\n");
    SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
    sll.addFirst("A");
    sll.addFirst("B");
    sll.addLast("C");
    sll.listAll();
  }
}