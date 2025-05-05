package ru.aston.collection;

import java.util.Objects;

/**
 * Реализация хеш-карты, позволяющая использовать пары ключ-значение.
 *
 * <p>
 * Данная хеш-карта использует массив связных списков для хранения элементов.
 * Поддерживает основные операции: добавление (put), получение (get), удаление (remove),
 * а также проверку наличия ключа (containsKey).
 * </p>
 *
 * @param <K> Тип ключа
 * @param <V> Тип значения
 */

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

    /**
     * Внутренний класс для представления пары ключ-значение в хеш-карте.
     *
     * @param <K> Тип ключа
     * @param <V> Тип значения
     */
    public class Entry {
        private K key;
        private V value;

        /**
         * Конструктор для создания новой пары ключ-значение.
         *
         * @param key   Ключ, связанный с данным значением
         * @param value Значение, связанное с данным ключом
         */
        public Entry (K key, V value){
            this.key = key;
            this.value = value;
        }

        /**
         * Получает ключ, связанный с данной парой.
         *
         * @return Ключ данного узла
         */
        public K getKey(){
            return key;
        }

        /**
         * Получает значение, связанное с данным ключом.
         *
         * @return Значение данного узла
         */
        public V getValue(){
            return value;
        }
    }

    /**
     * Добавляет пару ключ-значение в хеш-карту.
     * Если ключ уже существует, обновляет его значение.
     *
     * @param key   Ключ, который будет добавлен в карту
     * @param value Значение, связанное с данным ключом
     * @throws NullPointerException Если ключ равен null
     */
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

    /**
     * Возвращает значение, связанное с указанным ключом.
     *
     * @param key Ключ, значение которого нужно получить
     * @return Значение, связанное с ключом; или null, если ключ не найден
     */
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

    /**
     * Удаляет пару ключ-значение из хеш-карты по указанному ключу.
     *
     * @param key Ключ, который нужно удалить
     */
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

    /**
     * Проверяет, существует ли заданный ключ в хеш-карте.
     *
     * @param key Ключ для проверки
     * @return true, если ключ существует; иначе false
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    /**
     * Проверяет, пуста ли хеш-карта.
     *
     * @return true, если карта пуста; иначе false
     */
    private int getIndex(K key){
        return Objects.hashCode(key) % table.length;
    }

    /**
     * Увеличивает емкость хеш-карты в случае превышения порога нагрузки.
     */
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

    /**
     * Возвращает количество элементов в хеш-карте.
     *
     * @return Количество пар ключ-значение
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет, пуста ли хеш-карта.
     *
     * @return true, если карта пуста; иначе false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Возвращает Iterable для получения всех пар ключ-значение в хеш-карте.
     *
     * <p>
     * Это позволяет итерацию по всем элементам карты, предоставляя доступ
     * к каждому элементу в формате Entry, что делает его удобным для использования
     * в циклах foreach или при необходимости преобразования в коллекции.
     * </p>
     *
     * @return Iterable, который позволяет обходить все пары ключ-значение
     */
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
