package io.mtso;

public interface Parser<T> {
    public T parse(String[] fields);
}
