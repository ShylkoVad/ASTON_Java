package ru.aston.collection;

import java.util.Iterator;

/**
 * Класс CustomArrayList реализует интерфейс MyCustomList и представляет собой динамический массив.
 * Поддерживаемые методы описаны ниже.
 * У каждого экземпляра CustomArrayList есть емкость. Емкость — это размер массива, используемого для хранения
 элементов в списке. Она всегда не меньше размера списка. По мере добавления элементов в CustomArrayList его емкость
 автоматически увеличивается.
 * @param <E> тип элементов в списке
 */

public class CustomArrayList<E> implements MyCustomList<E> {

    /**
     * Массив в котором хранятся все элементы списка
     */
    private E[] elementsData;

    /**
     * Начальная емкость списка по умолчанию
     */
    private static final int INITIAL_CAPACITY = 10;

    /**
     * Количество содержащихся в списке элеентов
     */
    private int size;

    /**
     * Конструктор, создающий пустой список с начальной ёмкостью десять
     */
    @SuppressWarnings("unchecked")
    public CustomArrayList() {
        elementsData = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Конструктор, создающий пустой список с заданной начальной ёмкостью
     * @param arrayLength начальная емкость списка
     * IllegalArgumentException – если указанная начальная емкость отрицательна
     */
    @SuppressWarnings("unchecked")
    public CustomArrayList(int arrayLength) {
        if (arrayLength > 0) {
            elementsData = (E[]) new Object[arrayLength];
        } else {
            throw new IllegalArgumentException("Некорректная длинна: " + arrayLength);
        }
        size = 0;
    }

    /**
     * Метод добавляет указанный элемент в конец списка
     * @param o элемент, который будет добавлен в этот список
     */
    @Override
    public void add(E o) {
        if (o != null) {
            if (size == elementsData.length) {
                resize();
            }
            elementsData[size++] = o;
        } else {
            System.out.println("Некорректный ввод. Вы пытаетесь добавить пустой объект.");
        }
    }

    /**
     * Метод добавляет указанный элемент указанную позицию в списке. При добавлении элемента на уже
     заполненную позицию, происходит замена элемента на данной позиции. В другом случае добавление доступно
     только в конец списка.
     * @param o элемент, который будет добавлен в этот список
     * @param index позиция, на которую будет вставлен указанный элемент
     * IndexOutOfBoundsException - если укаанный индекс находится вне допустимого дипазона
     */
    @Override
    public void set(E o, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона: " + index);
        }
        elementsData[index] = o;
    }

    /**
     * Метод возвращает элемент в указанной позиции в списке
     * @param index позици вовращаемого элемента списка
     */
    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона: " + index);
        }
        return elementsData[index];
    }

    /**
     * Удаляет элемент из списка по указанной позиции. При удалении элемента из списка, все остальные элементы
     смещаются на одну позицию влево.
     * @param index позици удаляемого элемента списка
     * Возвращает true при успешном удалении элемента
     * IndexOutOfBoundsException - при передаче индекса, который находится вне диапазона от 0 до size
     */
    @Override
    public boolean remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона: " + index);
        }

        for (int i = index; i < size - 1; i++) {
            elementsData[i] = elementsData[i + 1];
        }
        elementsData[--size] = null;
        return true;
    }

    /**
     * Метод удаляет все элементы из списка. После вызова анного метода список будет пуст
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementsData[i] = null;
        }
        size = 0;
    }

    /**
     * Метод осуществляет проверку наличия переданного элемента в списке
     * возвращает true, если  этот список содержит хотя бы один элемент e
     * @param o элемент, наличие которого в списке должно быть проверено
     */
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementsData[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод возвращает количество элементов в списке
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Метод обрезает емкость этого экземпляра CustomArrayList до текущего размера списка
     */
    @Override
    public void trimToSize() {
        if (size < elementsData.length) {
            @SuppressWarnings("unchecked")
            E[] newElements = (E[]) new Object[size];
            for (int i = 0; i < size; i++) {
                newElements[i] = elementsData[i];
            }
            elementsData = newElements;
        }
    }

    /**
     * Метод возвращает true, если этот список не содержит элементов
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Возвращает индекс первого вхождения указанного элемента Objects.equals(o, get(i)) в этом списке или -1,
     если этот список не содержит элемента.
     * @param o элемент, поиск индекса которого осуществляется
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementsData[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Возвращает индекс первого вхождения указанного элемента Objects.equals(o, get(i)) в этом списке или -1,
     если этот список не содержит элемента.
     * Поиск индекса элемента осуществляется от конца списка к началу
     * @param o элемент, поиск индекса которого осуществляется
     */
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (elementsData[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Метод возвращает итератор, позволяющий перебрать элементы в списке.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @SuppressWarnings("unchecked")
            @Override
            public E next() {
                return (E) elementsData[index++];
            }
        };
    }

    /**
     * Метод возвращает список объектов коллекции.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Collection elements = {[");

        for (int i = 0; i < size; i++) {
            sb.append(elementsData[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }


    // Метод для изменения размера массива
    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = elementsData.length + (elementsData.length / 2);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elementsData[i];
        }
        elementsData = newElements;
    }
}
