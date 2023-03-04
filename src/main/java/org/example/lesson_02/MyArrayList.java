package org.example.lesson_02;

import java.util.Collection;

public class MyArrayList<T> {
    private int size;
    private int capacity;
    private T[] content;

    public int size() {
        return size;
    }           //  возврат длины ArrayList

    public MyArrayList() {                        //    конструктор без параметров - пустой ArrayList с макс. емкостью 10
        size = 0;
        capacity = 10;
        content = (T[]) new Object[capacity];
    }

    public MyArrayList(int initialCapacity) {      //   конструктор с параметром максимальной емкости
        size = 0;
        if (initialCapacity<=0) {
            throw new IllegalStateException("Capacity of ArrayList must be positive number");
        }
        capacity = initialCapacity;
        content = (T[]) new Object[capacity];
    }

    public MyArrayList(Collection<? extends T> collection) {       //   конструктор из другой коллекции
        size = 0;
        capacity = collection.size();
        collection.forEach(this::add);
    }

    public void ensureCapacity(int newCapacity) {               // увеличение емкости до нового значения, если оно больше текущей
        if (newCapacity>capacity) {
            T[] newContent = (T[]) new Object[newCapacity];
            System.arraycopy(content, 0, newContent, 0, content.length);
            content = newContent;
            capacity = newCapacity;
            newContent = null;
        }
    }

    boolean add(T t) {                               // добавление элемента в конец ArrayList
        if (size >= capacity) {                      // если размер достиг максимальной емкости, увеличиваем емкость в 1.5 раза
            ensureCapacity((capacity * 3 + 1) / 2);
        }
        content[size] = t;
        size = size + 1;
        return true;
    }

    public void add(int index, T t) {               // вставка элемента на произвольную позицию в ArrayList
        if (index < 0 || index >= size + 1) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of List range (from 0 to " + size + ")");
        } else {
            if (size >= capacity) {                // если требуется увеличкение емкости
                T[] newContent = (T[]) new Object[(capacity * 3 + 1) / 2];
                System.arraycopy(content, 0, newContent, 0, index);
                newContent[index] = t;
                if (index+1 <= size) {
                    System.arraycopy(content, index, newContent, index + 1, content.length - index);
                }
                content = newContent;
                capacity = (capacity * 3 + 1) / 2;
                newContent = null;
                size = size + 1;
            } else {                        //  если увеличение емкости не требуется
                T save = content[index];
                content[index] = t;
                if (index+1 <= size) {
                    for (int i = size; i > index+1; i--) {
                        content[i] = content[i-1];
                    }
                }
                content[index+1] = save;
                size = size + 1;
            }
        }
    }

    public T get(int index) {                   //  получение элемента по индексу
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of List range (from 0 to " + Math.max(size - 1, 0) + ")");
        } else {
            return content[index];
        }
    }

    void set(int index, T t) {                  // сохранение элемента на нужную позицию ArrayList
        if (index < 0 || index >= size) {
            if (size == 0) {
                throw new IndexOutOfBoundsException("ArrayList is empty");
            } else {
                throw new IndexOutOfBoundsException("Index " + index + " is out of List range (from 0 to " + (size - 1) + ")");
            }
        } else {
            content[index] = t;
        }
    }

    public T remove(int index) {            //  удаление произвольного элемента ArrayList со сдвигом хвоста на 1 позицию
        if (index < 0 || index >= size) {
            if (size == 0) {
                throw new IndexOutOfBoundsException("ArrayList is empty");
            } else {
                throw new IndexOutOfBoundsException("Index " + index + " is out of List range (from 0 to " + (size - 1) + ")");
            }
        } else {
            T result = content[index];
            for (int i = index; i < size; i++) {
                if (i<capacity-1) {
                    content[i] = content[i+1];
                } else {
                    content[i] = null;
                }
            }
            size = size-1;
            return result;
        }
    }

    public boolean remove(T t) {        //  удаление элемента массива по значению (если такое есть, удаляется первое вхождение)
        boolean found = false;
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (content[i].equals(t)){
                found = true;
                index = i;
                break;
            }
        }
        if (found) {
            remove(index);
        }
        return found;
    }

    public boolean contains(T t) {              //  проверка, есть ли в ArrayList элемент с нужным значением
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (content[i].equals(t)){
                found = true;
                break;
            }
        }
        return found;
    }

    public void trimToSize() {              //  уменьшение емкости ArrayList до его размера
        if (size<capacity) {
            if (size==0) {
                throw new IllegalStateException("Capacity cannot be equal 0");
            } else {
                T[] newContent = (T[]) new Object[size];
                for (int i = 0; i < size; i++) {
                    newContent[i] = content[i];
                }
                content = newContent;
                capacity = size;
                newContent = null;
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s.concat(content[i].toString()).concat(", ");
        }
        return (s.length()>1)?"[".concat(s.substring(0, s.length() - 2)).concat("]"):"[]";
    }

    public Object[] toArray() {             //  преобразование в массив типа Object
        if (size==0) {
            return null;
        } else {
            Object[] result = new Object[size];
            System.arraycopy(content, 0, result, 0, size);
            return result;
        }
    }

    public void toArray(T[] array) {        // копирование в заданный массив того же типа, что и элементы ArrayList
        if (array.length < size) {
            throw new IndexOutOfBoundsException("The size of target array is less than of the source");
        }
        for (int i = 0; i < size; i++) {
            array[i] = (T) content[i];
        }
        for (int i = size; i < array.length; i++) {
            array[i] = null;
        }
    }


}
