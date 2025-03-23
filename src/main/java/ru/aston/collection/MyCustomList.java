package ru.aston.collection;

import java.util.Iterator;

public interface MyCustomList<E> {
    void add(E o);               // Добавляет элемент в конец списка
    void set(E o, int index);    // Устанавливает элемент по указанному индексу
    E get(int index);            // Получает элемент по указанному индексу
    boolean remove(int index);    // Удаляет элемент по индексу
    void clear();                // Очищает список
    boolean contains(Object o);   // Проверяет, содержится ли элемент в списке
    int size();                  // Возвращает текущий размер списка
    void trimToSize();           // Уменьшает размер массива до текущего размера
    boolean isEmpty();           // Проверяет, пуст ли список
    int indexOf(Object o);       // Возвращает индекс первого вхождения элемента
    int lastIndexOf(Object o);    // Возвращает индекс последнего вхождения элемента
    Iterator<E> iterator();       // Возвращает итератор
}
