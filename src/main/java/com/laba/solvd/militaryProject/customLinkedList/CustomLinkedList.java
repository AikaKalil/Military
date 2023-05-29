package com.laba.solvd.militaryProject.customLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CustomLinkedList<E> implements Iterable<E>{
        private Node<E> head;
        private int size;

        public CustomLinkedList() {
            head = null;
            size = 0;
        }

    @Override
    public Iterator<E> iterator() {
        return new CustomLinkedListIterator();
    }

    private class CustomLinkedListIterator implements Iterator<E> {
        private Node<E> currentNode;

        public CustomLinkedListIterator() {
            currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = currentNode.data;
            currentNode = currentNode.next;
            return data;
        }
    }



    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return Iterable.super.spliterator();
    }

    private static class Node<E> {
            E data;
            Node<E> next;

            Node(E element) {
                this.data = element;
                this.next = null;
            }
        }

        public E remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Invalid index: " + index);
            }

            if (index == 0) {
                E removedData = head.data;
                head = head.next;
                size--;
                return removedData;
            }

            Node<E> current = head;
            Node<E> previous = null;
            int currentIndex = 0;

            while (currentIndex < index) {
                previous = current;
                current = current.next;
                currentIndex++;
            }

            E removedData = current.data;
            previous.next = current.next;
            size--;
            return removedData;
        }

        public void add(int index, E element) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Invalid index: " + index);
            }

            Node<E> newNode = new Node<>(element);

            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node<E> current = head;
                Node<E> previous = null;
                int currentIndex = 0;

                while (currentIndex < index) {
                    previous = current;
                    current = current.next;
                    currentIndex++;
                }

                newNode.next = current;
                previous.next = newNode;
            }

            size++;
        }

        public E set(int index, E element) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Invalid index: " + index);
            }

            Node<E> current = head;
            int currentIndex = 0;

            while (currentIndex < index) {
                current = current.next;
                currentIndex++;
            }

            E replacedData = current.data;
            current.data = element;
            return replacedData;
        }

        public E get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Invalid index: " + index);
            }

            Node<E> current = head;
            int currentIndex = 0;

            while (currentIndex < index) {
                current = current.next;
                currentIndex++;
            }

            return current.data;
        }

        public int hashCode() {
            return super.hashCode();
        }

        public boolean equals(Object o) {
            return super.equals(o);
        }

        public void clear() {
            head = null;
            size = 0;
        }

        public boolean removeAll(Collection<?> c) {
            boolean modified = false;
            Node<E> current = head;
            Node<E> previous = null;

            while (current != null) {
                if (c.contains(current.data)) {
                    if (previous == null) {
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    modified = true;
                    size--;
                } else {
                    previous = current;
                }
                current = current.next;


            }
            return modified;
        }

        public boolean addAll(int index, Collection<? extends E> c) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Invalid index: " + index);
            }

            if (c.isEmpty()) {
                return false;
            }

            Node<E> current = head;
            Node<E> previous = null;
            int currentIndex = 0;

            while (currentIndex < index && current != null) {
                previous = current;
                current = current.next;
                currentIndex++;
            }

            for (E element : c) {
                Node<E> newNode = new Node<>(element);

                if (previous == null) {
                    newNode.next = head;
                    head = newNode;
                } else {
                    newNode.next = current;
                    previous.next = newNode;
                }

                previous = newNode;
                size++;
            }

            return true;
        }

        public boolean containsAll(Collection<?> c) {
            for (Object element : c) {
                if (!contains(element)) {
                    return false;
                }
            }
            return true;
        }

        public boolean remove(Object o) {
            Node<E> current = head;
            Node<E> previous = null;

            while (current != null) {
                if (o.equals(current.data)) {
                    if (previous == null) {
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    size--;
                    return true;
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

        public boolean add(E e) {
            add(size, e);
            return true;
        }

        public boolean contains(Object o) {
            Node<E> current = head;

            while (current != null) {
                if (o.equals(current.data)) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }


    }


