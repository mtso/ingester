package io.mtso;

@FunctionalInterface
public interface Ingester {
    void ingest(String value);
}
