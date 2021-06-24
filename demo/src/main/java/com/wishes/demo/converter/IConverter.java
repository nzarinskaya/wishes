package com.wishes.demo.converter;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public interface IConverter<S,T> {

    T convert(S source);
    S convertBack(T target);

    Collection<T> convertAll(Iterable<S> sources);
    Collection<S> convertAllBack(Iterable<T> targets);

    <C extends Collection<T>> C convertAll(Iterable<S> sources, Supplier<C> supplier);
    <C extends Collection<S>> C convertAllBack(Iterable<T> targets, Supplier<C> supplier);

}
