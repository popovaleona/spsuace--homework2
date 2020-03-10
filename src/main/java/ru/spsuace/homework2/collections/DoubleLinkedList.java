package ru.spsuace.homework2.collections;

import java.util.Iterator;

/**
 * Реализовать двусвязный список, аналог LinkedList в java (то что я рассказывал на лекции)
 * Если не понятно, что должны возвращать методы, смотрите документацию интерфейсов List и Collection
 * Если в метод передается индекс, которого не существует (за исключением, add(size(), obj)), то надо бросить ошибку:
 * throw new IndexOutOfBoundsException()
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    private Data head;
    private Data tail;
    private int count;

    public int size() {
        return count;
    }

    public boolean contains(Object t) {
        if (indexOf((T) t) != -1) {
            return true;
        }
        return false;
    }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(int index, T element) {
        //ошибка для несуществующего индекса
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        //добвление элементов
        if (index == count) {
            addLast(element);
        } else if (index == 0) {
            addFirst(element);
        } else {
            Data<T> newElement = new Data(element);
            Data<T> currentElement = findElement(index);
            currentElement.previous.next = newElement;
            newElement.previous = currentElement.previous;
            currentElement.previous = newElement;
            newElement.next = currentElement;
            count++;
        }

    }

    public void addLast(T element) {
        Data<T> newElement = new Data(element);
        if (tail == null) {
            head = newElement;
            tail = newElement;
        } else {
            tail.next = newElement;
            newElement.previous = tail;
            tail = newElement;
        }
        count++;
    }


    public void addFirst(T element) {
        Data<T> newElement = new Data(element);
        if (head == null) {
            head = newElement;
            tail = newElement;
        } else {
            head.previous = newElement;
            newElement.next = head;
            head = newElement;
        }
        count++;
    }


    public T set(int index, T element) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Data<T> currentElement = findElement(index);
        T currentData = currentElement.data;
        currentElement.data = element;
        return currentData;
    }

    public T get(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Data<T> currentElement = findElement(index);
        return currentElement.data;
    }

    public int indexOf(T o) {
        Data<T> currentElement = head;
        for (int i = 0; i < count; i++) {
            if (currentElement.data.equals(o)) {
                return i;
            }
            currentElement = currentElement.next;
        }
        return -1;
    }

    public T remove(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Data<T> currentElement = findElement(index);
        T currentData = currentElement.data;
        if (index == count - 1) {
            currentElement.previous.next = null;
            tail = currentElement.previous;
        } else if (index == 0) {
            currentElement.next.previous = null;
            head = currentElement.next;
        } else {
            currentElement.previous.next = currentElement.next;
            currentElement.next.previous = currentElement.previous;
        }
        count--;
        return currentData;
    }

    private Data<T> findElement(int index) {
        Data<T> currentElement;
        if (index < (count / 2)) {
            currentElement = head;
            for (int i = 0; i < index; i++) {
                currentElement = currentElement.next;
            }
        } else {
            currentElement = tail;
            for (int i = count - 1; i > index; i--) {
                currentElement = currentElement.previous;
            }
        }
        return currentElement;
    }

    private class Data<T> {
        private Data<T> previous;
        private T data;
        private Data<T> next;

        Data(T data) {
            this.data = data;
        }
    }

    /**
     * Дополнительное задание
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
