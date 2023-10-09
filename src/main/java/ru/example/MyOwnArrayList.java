package ru.example;

public class MyOwnArrayList<E> {

    Object[] elementData;
    private int size;


    public MyOwnArrayList() {
        this.elementData = new Object[0];
        this.size = 0;
    }

    public MyOwnArrayList(int initialSize) {
        if (initialSize >= 0) {
            this.elementData = new Object[initialSize];
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns the size of the object.
     *
     * @return the size of the object
     */
    public int size() {
        return this.size;
    }

    /**
     * Checks if the collection is empty.
     *
     * @return true if the collection is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Determines whether the collection contains the specified element.
     *
     * @param o the element to be checked for containment in this collection
     * @return true if this collection contains the specified element, false otherwise
     */
    public boolean contains(Object o) {
        if (this.size == 0) {
            return false;
        }

        for (int i = 0; i < this.size; i++) {
            if (this.elementData[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(E e) {
        this.add(e, this.elementData, this.size);
        return true;
    }

    private void add(E e, Object[] elementData, int i) {
        if (elementData.length <= i) {
            this.elementData = grow();
        }
        this.elementData[i] = e;
        this.size++;
    }

    private Object[] grow() {
        return this.grow(this.size + 1);
    }

    private Object[] grow(int minSize) {
        int newSize = minSize * 3 / 2 + 1;
        Object[] newArray = new Object[newSize];
        System.arraycopy(this.elementData, 0, newArray, 0, this.elementData.length);
        return newArray;
    }

    /**
     * Removes the specified element from this list if it is present.
     *
     * @param  o the element to be removed
     * @return true if this list contained the specified element
     */
    public boolean removeValue(Object o) {
        if (this.contains(o)) {
            Object[] newArray = new Object[this.size - 1];
            for (int i = 0; i < this.size; i++) {
                if (this.elementData[i].equals(o)) {
                    System.arraycopy(this.elementData, 0, newArray, 0, i);
                    System.arraycopy(this.elementData, i + 1, newArray, i, this.size - i - 1);
                    this.size--;
                    break;
                }
            }
            this.elementData = newArray;
            return true;
        }
        return false;
    }

    /**
     * Clears the data in the object.
     */
    public void clear() {
        this.elementData = new Object[0];
        this.size = 0;
    }

    /**
     * Retrieves the element at the specified index in this list.
     *
     * @param i the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (i < 0 || i >= size)
     */
    public E get(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) this.elementData[i];
    }

    //TODO
    public E set(int i, E e) {
        return null;
    }

    /**
     * Adds an element at the specified index in the array.
     *
     * @param i the index at which the element should be added
     * @param e the element to be added
     */
    public void add(int i, E e) {
        this.elementData[i] = e;
    }

    /**
     * Remove the element at the specified index from the list.
     *
     * @param i the index of the element to be removed
     * @return true if the element is successfully removed, false otherwise
     * @throws IndexOutOfBoundsException if the index is out of range (i < 0 || i >= this.size)
     */
    public boolean remove(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.removeValue(this.elementData[i]);
    }

    /**
     * Finds and returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param o the element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    public int indexOf(Object o) {
        for (int i = 0; i < this.size; i++) {
            if (this.elementData[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public void sort() {
        quickSort(this.elementData, 0, this.size - 1);
    }

    /**
     * Sorts the given array using the QuickSort algorithm.
     *
     * @param array the array to be sorted
     * @param low   the starting index of the array to be sorted
     * @param high  the ending index of the array to be sorted
     */
    public void quickSort(Object[] array, int low, int high) {
        if (this.size < 2) {
            return;
        }

        int i = low;
        int j = high;
        int middle = (low + high) / 2;
        var pivot = array[middle].hashCode();

        while (i <= j) {
            while (array[i].hashCode() < pivot) {
                i++;
            }
            while (array[j].hashCode() > pivot) {
                j--;
            }
            if (i <= j) {
                Object temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(array, low, j);
        }
        if (high > i) {
            quickSort(array, i, high);
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.hashCode() == o.hashCode();
    }

    /**
     * Calculates the hash code for the object.
     *
     * @return the hash code value for the object.
     */
    public int hashCode() {
        int hashCode = 1;

        for (int i = 0; i < this.size; ++i) {
            Object e = this.elementData[i];
            hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
        }

        return hashCode;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object
     */
    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < this.size - 1; i++) {
            s.append(this.elementData[i]).append(", ");
        }
        return s.toString() + this.elementData[this.size - 1] + "]";
    }
}
