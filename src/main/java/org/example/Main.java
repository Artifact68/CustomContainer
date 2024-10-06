package org.example;


public class Main {
    public static void main(String[] args) {
// Создаем экземпляр контейнера
        CustomContainer<Integer> container = new CustomContainer<>();

        // Добавляем элементы в контейнер
        container.add(10);
        container.add(20);
        container.add(30);

        // Печатаем текущее состояние контейнера
        System.out.println("Container size: " + container.size()); // Ожидается: 3
        for (int i = 0; i < container.size(); i++) {
            System.out.println("Element at index " + i + ": " + container.get(i));
        }

        // Удаляем элемент по индексу 1
        Integer removedElement = container.remove(1);
        System.out.println("Removed element: " + removedElement); // Ожидается: 20

        // Печатаем состояние контейнера после удаления
        System.out.println("Container size after removal: " + container.size()); // Ожидается: 2
        for (int i = 0; i < container.size(); i++) {
            System.out.println("Element at index " + i + ": " + container.get(i));
        }
    }
}