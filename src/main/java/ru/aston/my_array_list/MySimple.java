package ru.aston.my_array_list;

public interface MySimple {
    public void add(Object o);
    public void set (Object o, int index);
    public Object get (int index);
    public boolean remove (int index);
    public void clear();
    public boolean contains (Object o);
    public int size();
    public void TrimToSize ();
    public boolean isEmpty ();
    public int indexOf(Object o);
    public int lastIndexOf (Object o);
}
