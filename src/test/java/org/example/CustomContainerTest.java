package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.example.CustomContainer;
import org.junit.Before;
import org.junit.Test;


public class CustomContainerTest {
    private CustomContainer<Integer> container;

    @Before
    public void setUp() {
        container = new CustomContainer<>();
    }

    @Test
    public void testAddAndSize() {
        // Добавляем элементы в контейнер
        container.add(1);
        container.add(2);
        container.add(3);
        // Проверяем размер контейнера
        assertEquals(3, container.size());
    }

    @Test
    public void testGet() {
        // Добавляем элемент и проверяем его получение
        container.add(1);
        assertEquals((Integer) 1, container.get(0));
    }

    @Test
    public void testRemove() {
        // Добавляем элементы и удаляем один
        container.add(1);
        container.add(2);
        Integer removedElement = container.remove(0); // Удаляем первый элемент
        assertEquals((Integer) 1, removedElement); // Проверяем удаленный элемент
        assertEquals(1, container.size()); // Проверяем новый размер контейнера
        assertEquals((Integer) 2, container.get(0)); // Проверяем, что остался правильный элемент
    }

    @Test
    public void testRemoveFromEmptyContainer() {
        // Проверяем удаление из пустого контейнера
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(0));
    }

    @Test
    public void testGetFromEmptyContainer() {
        // Проверяем получение элемента из пустого контейнера
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(0));
    }

    @Test
    public void testGetInvalidIndex() {
        // Проверяем получение элемента с недопустимым индексом
        container.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(1)); // Запрашиваем индекс, который выходит за пределы
    }

    @Test
    public void testRemoveInvalidIndex() {
        // Проверяем удаление элемента с недопустимым индексом
        container.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(1)); // Запрашиваем индекс, который выходит за пределы
    }
}
