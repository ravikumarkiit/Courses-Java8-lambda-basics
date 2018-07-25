package io.javabrains.unit1;

@FunctionalInterface
public interface FunctionalInterfaceMy {
//    static FunctionalInterfaceMy DEFAULT = s->true;
    boolean authorize(String value);
}
