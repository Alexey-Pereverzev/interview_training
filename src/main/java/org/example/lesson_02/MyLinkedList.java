package org.example.lesson_02;

import java.util.Collection;

public class MyLinkedList<T> {

    private ListEntry first;

    private ListEntry last;

    private int size;

    private class ListEntry {                       //  внутренний класс - node списка
        private T content;
        private ListEntry next;
        private ListEntry previous;

        public ListEntry(T content, ListEntry next, ListEntry previous) {
            this.content = content;
            this.next = next;
            this.previous = previous;
        }
    }

    public MyLinkedList() {
        size = 0;
    }                   //  пустой конструктор

    public MyLinkedList(Collection<? extends T> collection) {       //  конструктор из заданной коллекции
        size = 0;
        collection.forEach(this::add);
    }

    public void addFirst(T t) {                     //  добавление элемента в начало списка
        if (t != null) {
            if (first != null) {
                ListEntry newEntry = new ListEntry(t, first, null);
                first.previous = newEntry;
                first = newEntry;
                size = size + 1;
            } else {
                first = new ListEntry(t, null, null);
                last = first;
                size = 1;
            }
        }
    }

    public void addLast(T t) {                  //  добавление в конец списка
        if (t != null) {
            if (last != null) {
                ListEntry newEntry = new ListEntry(t, null, last);
                last.next = newEntry;
                last = newEntry;
                size = size + 1;
            } else {
                last = new ListEntry(t, null, null);
                first = last;
                size = 1;
            }
        }
    }

    public void add(T t) {          //  то же самое, метод-синоним
        addLast(t);
    }

    public T peekFirst() {          //  возврат элемента головы списка
        if (first != null) {
            return first.content;
        } else {
            return null;
        }
    }

    public T peekLast() {           //  возврат элемента хвоста списка
        if (last != null) {
            return last.content;
        } else {
            return null;
        }
    }

    private void unlink(ListEntry entry) {      //  "отвязывание" node при удалении - подготовка node к сборке мусора
        if (entry != null) {
            entry.next = null;
            entry.previous = null;
            entry.content = null;
        }
    }


    public T pollFirst() {                  // удаление первого элемента списка с возвратом содержимого
        if (first != null) {
            T result = first.content;
            ListEntry save = first;
            first = first.next;
            if (first!=null) {
                first.previous = null;
            }
            size = size - 1;
            unlink(save);
            return result;
        } else {
            return null;
        }
    }

    public void removeFirst() {         // удаление первого элемента списка без возврата
        pollFirst();
    }

    public T pollLast() {               // удаление последнего элемента списка с возвратом содержимого
        if (last != null) {
            T result = last.content;
            ListEntry save = last;
            last = last.previous;
            if (last!=null) {
                last.next = null;
            }
            size = size - 1;
            unlink(save);
            return result;
        } else {
            return null;
        }
    }

    public void removeLast() {      // удаление последнего элемента списка без возврата
        pollLast();
    }

    private ListEntry search(int i) {           //  поиск node по индексу
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index " + i + " is out of List range (from 0 to " + Math.max(size - 1, 0) + ")");
        } else {
            if (i <= size / 2) {
                return searchFromLeftToRight(i);
            } else {
                return searchFromRightToLeft(size - i - 1);
            }

        }
    }

    public T get(int i) {             // получение элемента по индексу
        return search(i).content;
    }

    private ListEntry searchFromLeftToRight(int i) {        // поиск по индексу слева направо
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index " + i + " is out of List range (from 0 to " + Math.max(size - 1, 0) + ")");
        } else {
            if (i == 0) {
                return first;
            } else {
                ListEntry pointer = first;
                for (int j = 0; j < i; j++) {
                    pointer = pointer.next;
                }
                return pointer;
            }
        }
    }

    private ListEntry searchFromRightToLeft(int i) {        // поиск по индексу справа налево (считая от хвоста)
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index " + i + " is out of List range (from 0 to " + Math.max(size - 1, 0) + ")");
        } else {
            if (i == 0) {
                return last;
            } else {
                ListEntry pointer = last;
                for (int j = 0; j < i; j++) {
                    pointer = pointer.previous;
                }
                return pointer;
            }
        }
    }

    public void add(int i, T t) {           //  добавление элемента в проивольное место списка - после элемента с номером i
        if (i < 0 || i >= size + 1) {
            throw new IndexOutOfBoundsException("Index " + i + " is out of List range (from 0 to " + size + ")");
        } else {
            if (i == 0) {
                addFirst(t);
            } else {
                ListEntry insertPlace = search(i-1);
                ListEntry nextItem = insertPlace.next;
                insertPlace.next = new ListEntry(t, insertPlace.next, insertPlace);
                if (nextItem!=null) {
                    nextItem.previous = insertPlace.next;
                }
                size = size + 1;
            }
        }
    }

    public void remove(int i) {             //  удаление node по индексу
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index " + i + " is out of List range (from 0 to " + Math.max(size - 1, 0) + ")");
        } else if (i == 0) {
            removeFirst();
        } else if (i == size - 1) {
            removeLast();
        } else {
            ListEntry toRemove = search(i);
            toRemove.previous.next = toRemove.next;
            toRemove.next.previous = toRemove.previous;
            size = size - 1;
            unlink(toRemove);
        }
    }


    public void remove(T t) {           //  удаление node по значению (первое вхождение начиная с головы списка)
        if (size > 0) {
            ListEntry pointer = first;
            while (true) {
                if (pointer.content.equals(t)) {
                    if (pointer.previous != null && pointer.next != null) {
                        pointer.previous.next = pointer.next;
                        pointer.next.previous = pointer.previous;
                    } else if (pointer.previous != null) {
                        pointer.previous.next = null;
                    } else if (pointer.next != null) {
                        pointer.next.previous = null;
                    }
                    size = size - 1;
                    unlink(pointer);
                    return;
                } else if (pointer.next != null) {
                    pointer = pointer.next;
                } else {
                    return;
                }
            }
        }
    }

    public void set(int i, T t) {           //  записать новое значение по индексу
        if (i < 0 || i >= size) {
            if (size == 0) {
                throw new IndexOutOfBoundsException("List is null");
            } else {
                throw new IndexOutOfBoundsException("Index " + i + " is out of List range (from 0 to " + (size - 1) + ")");
            }
        } else {
            search(i).content = t;
        }
    }

    @Override
    public String toString() {
        String s = "";
        if (first != null) {
            ListEntry pointer = first;
            while (pointer != null) {
                s = s.concat(pointer.content.toString()).concat(", ");
                pointer = pointer.next;
            }
        }
        return (s.length()>1)?("{".concat(s.substring(0, s.length() - 2)).concat("}")):"{}";
    }

    public int size() {
        return size;
    }       //  возврат длины списка
}
