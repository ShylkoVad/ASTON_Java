package ru.aston.my_array_list;

/**
 * Класс MyArrayList реализует интерфейс MySimple и представляет собой динамический массив.
 * Поддерживаемые методы описаны ниже.
 * У каждого экземпляра MyArrayList есть емкость. Емкость — это размер массива, используемого для хранения
 элементов в списке. Она всегда не меньше размера списка. По мере добавления элементов в MyArrayList его емкость
 автоматически увеличивается.
 * @param <E> тип элементов в списке
 */

public class MyArrayList<E>  implements MySimple{

    /**
     * Массив в котором хранятся все элементы списка
     */
    Object[] elementsData;


    /**
     * Начальная емкость списка по умолчанию
     */
    private static final int ARRAY_lENGTH = 10;


    /**
     * Количество содержащихся в списке элеентов
     */
    private int size;

    /**
     * Конструктор, создающий пустой список с начальной ёмкостью десять
     */
    public MyArrayList(){
        this.elementsData = new Object[ARRAY_lENGTH];
        size = 0;
    }


    /**
     * Конструктор, создающий пустой список с заданной начальной ёмкостью
     * @param arrayLength начальная емкость списка
     * IllegalArgumentException – если указанная начальная емкость отрицательна
     */
    public MyArrayList(int arrayLength){
        if (arrayLength > 0){
            this.elementsData = new Object[arrayLength];
        } else {
            throw new IllegalArgumentException("Некорректная длинна: "+
                    arrayLength);
        }
        size = 0;
    }

    /**
     * Метод добавляет указанный элемент в конец списка
     * @param o элемент, который будет добавлен в этот список
     */
    @Override
    public void add(Object o) {
        if (o != null){
            if (!isEmpty()){
                if (size < elementsData.length){
                    elementsData [size] = o;
                    size++;
                } else {
                    Object[] temp = elementsData;
                    elementsData = new Object[temp.length + temp.length/2];
                    System.arraycopy(temp,0,elementsData, 0, temp.length);
                    elementsData[size]= 0;
                    size++;
                }
            }else {
                elementsData[size] = 0;
                size++;
            }
        } else {
            System.out.println("Некорректный ввод. Вы пытаетесь добавить пустой объект");
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
    public void set(Object o, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона: " + index);
        }
        if(elementsData.length == size) {
            Object [] temp = elementsData;
            elementsData = new Object[temp.length + temp.length/2];
            System.arraycopy(temp,0,elementsData,0,temp.length);
        }
        if(index == size){
            elementsData[index] = o;
            size++;
        }  else if (index < size){
            elementsData[index] = o;
        }
    }

    /**
     * Метод возвращает элемент в указанной позиции в списке
     * @param index позици вовращаемого элемента списка
     */

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона: " + index);
        } else {
            return (E) elementsData[index];
        }
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
        boolean flag = false;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона: " + index);
        } else {
            Object [] temp = elementsData;
            elementsData = new Object[temp.length];
            System.arraycopy(temp,0,elementsData,0,index);
            int amountElementAfterIndex = temp.length - 1 - index;
            System.arraycopy(temp, index + 1, elementsData, index, amountElementAfterIndex);
            size--;
            flag = true;
        }
        return flag;
    }

    /**
     * Метод удаляет все элементы из списка. После вызова анного метода список будет пуст
     */
    @Override
    public void clear() {
        elementsData = new Object[ARRAY_lENGTH];
        size = 0;
    }

    /**
     * Метод осуществляет проверку наличия переданного элемента в списке
     * возвращает true, если  этот список содержит хотя бы один элемент e,
     такой что Objects.equals(o, e)
     * @param o элемент, наличие которого в списке должно быть проверено
     */
    @Override
    public boolean contains(Object o) {
        boolean flag = false;
        for (int i = 0; i < elementsData.length;i++){
            if(elementsData[i].equals(o)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * Метод возвращает количество элементов в списке
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Метод обрезает емкость этого экземпляра ArrayList до текущего размера списка
     */
    @Override
    public void TrimToSize() {
        Object [] temp = elementsData;
        elementsData = new Object[size];
        System.arraycopy(temp,0,elementsData,0,size);
    }

    /**
     * Метод возвращает true, если этот список не содержит элементов
     */
    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Возвращает индекс первого вхождения указанного элемента Objects.equals(o, get(i)) в этом списке или -1,
     если этот список не содержит элемента.
     * @param o элемент, поиск индекса которого осуществляется
     */
    @Override
    public int indexOf(Object o) {
        int index = -1;
        for (int i = 0; i < elementsData.length; i++){
            if (elementsData[i].equals(o)){
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Возвращает индекс первого вхождения указанного элемента Objects.equals(o, get(i)) в этом списке или -1,
     если этот список не содержит элемента.
     * Поиск индекса элемента осуществляется от конца списка к началу
     * @param o элемент, поиск индекса которого осуществляется
     */
    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = size - 1; i >= 0; i--){
            if (elementsData[i].equals(o)){
                index = i;
                break;
            }
        }
        return index;
    }
}
