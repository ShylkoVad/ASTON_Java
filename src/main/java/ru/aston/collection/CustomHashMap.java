package ru.aston.collection;

import java.util.Objects;


public class CustomHashMap <K, V>{

    /**
     * Массив в котором хранятся все ноды
     */
    private Node<K, V> [] table;

    /**
     * Количество пар ключ-значение, содержащихся в массиве
     */
    private int size;

    /**
     * Начальная емкость по умолчанию
     */
    private static final int INITIAL_CAPACITY = 16;

    /**
     * Фактор загруженности массива
     */
    private static final float LOAD_FACTOR = 0.75f;

    /**
     * Конструктор, создающий пустой список с начальной ёмкостью шестнадцать
     */
    public CustomHashMap() {
        this.table = new Node[INITIAL_CAPACITY];
        this.size = 0;
    }

    public class Entry {
        private K key;
        private V value;

        public Entry (K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }
    }

    public void put(K key, V value){
        if(key == null){
            throw new NullPointerException("Ключ не может быть null");
        }
        int hashIndex = getIndex(key);
        Node<K, V> newNode = new Node<>(key, value);
        if(table[hashIndex] == null){
            table[hashIndex] = newNode;
        } else {
            Node<K, V> current = table[hashIndex];
            while (current != null){
                if(current.key.equals(key)){
                    current.value = value;
                    return;
                }
                if (current.next == null){
                    current.next = newNode;
                    break;
                }
                current = current.next;
            }
        }
        size++;
        if (size > table.length * LOAD_FACTOR){
            resize();
        }
    }

    public V get (K key){
        int hashIndex = getIndex(key);
        Node<K, V> current = table[hashIndex];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(K key) {
        int hashIndex = getIndex(key);
        Node<K, V> current = table[hashIndex];
        Node<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[hashIndex] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    private int getIndex(K key){
        return Objects.hashCode(key) % table.length;
    }

    private void resize() {
        Node<K, V>[] oldTable = table;
        table = new Node[oldTable.length * 2];
        size = 0;

        for (Node<K, V> node : oldTable) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public Iterable<Entry> entrySet() {
        return new Iterable<>() {
            @Override
            public java.util.Iterator<Entry> iterator() {
                return new java.util.Iterator<Entry>() {
                    private int currentIndex = 0;
                    private Node<K, V> currentNode = null;

                    private void advance() {
                        while (currentNode == null && currentIndex < table.length) {
                            currentNode = table[currentIndex++];
                        }
                    }

                    @Override
                    public boolean hasNext() {
                        advance();
                        return currentNode != null;
                    }

                    @Override
                    public Entry next() {
                        if (currentNode == null) {
                            throw new java.util.NoSuchElementException();
                        }
                        Entry entry = new Entry(currentNode.key, currentNode.value);
                        currentNode = currentNode.next;
                        return entry;
                    }
                };
            }
        };
    }
}
