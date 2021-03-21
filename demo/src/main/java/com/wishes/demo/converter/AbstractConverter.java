package com.wishes.demo.converter;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public abstract class AbstractConverter<S,T> implements IConverter<S,T> {

    protected Logger logger;

    protected abstract T createTarget();
    protected abstract S createSource();


    @Override
    public Collection convertAll(Iterable<S> sources) {
        List<T> targets = new ArrayList<>();
        sources.iterator().forEachRemaining(s -> targets.add(convert(s)));
        return targets;
    }

    @Override
    public Collection convertAllBack(Iterable<T> targets) {
        List<S> sources = new ArrayList<>();
        targets.iterator().forEachRemaining(t -> sources.add(convertBack(t)));
        return sources;
    }

    @Override
    public <C extends Collection<S>> C convertAllBack(Iterable<T> targets, Supplier<C> supplier) {
        C collection = supplier.get();
        collection.addAll(convertAllBack(targets));
        return collection;
    }

    @Override
    public <C extends Collection<T>> C convertAll(Iterable<S> sources, Supplier<C> supplier) {
        C collection = supplier.get();
        collection.addAll(convertAll(sources));
        return collection;
    }

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

}
