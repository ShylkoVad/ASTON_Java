package ru.aston.collection;

/**
 * Внутренний класс для представления узла в хеш-карте.
 *
 * @param <K> Тип ключа
 * @param <V> Тип значения
 */
public class Node <K, V>{
    K key;
    V value;
    Node <K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
