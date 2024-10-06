package org.example;


public class CustomContainer<T> {
    private Object[] elements;
    private int size;


    public CustomContainer() {
        elements = new Object[10]; // Начальный размер массива
        size = 0;
    }

    public void add(T element) {
        // Если массив полон, увеличиваем его размер
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element; // Добавляем элемент и увеличиваем размер
    }


    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        T removedElement = (T) elements[index]; // Сохраняем удаляемый элемент
        // Сдвигаем элементы для удаления
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null; // Уменьшаем размер и очищаем последний элемент
        return removedElement;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) elements[index]; // Возвращаем элемент
    }

    public int size() {
        return size; // Возвращаем текущий размер
    }

    private void resize() {
        // Создаем новый массив в два раза больше
        Object[] newElements = new Object[elements.length * 2];
        // Копируем существующие элементы в новый массив
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements; // Устанавливаем новый массив как текущий
    }
}
