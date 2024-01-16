package me.partlysunny.sunbeam.misc;

public class Wrapper<T> {

    T obj;

    public Wrapper(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }

    public void set(T obj) {
        this.obj = obj;
    }

}
