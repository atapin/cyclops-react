package com.aol.cyclops.internal.react;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DelegateStream<T> implements Stream<T> {
    private final Stream<T> delegate;

    public Iterator<T> iterator() {
        return delegate.iterator();
    }

    public Spliterator<T> spliterator() {
        return delegate.spliterator();
    }

    public boolean isParallel() {
        return delegate.isParallel();
    }

    public Stream<T> sequential() {
        return delegate.sequential();
    }

    public Stream<T> parallel() {
        return delegate.parallel();
    }

    public Stream<T> unordered() {
        return delegate.unordered();
    }

    public Stream<T> onClose(Runnable closeHandler) {
        return delegate.onClose(closeHandler);
    }

    public void close() {
        delegate.close();
    }

    public Stream<T> filter(Predicate<? super T> predicate) {
        return delegate.filter(predicate);
    }

    public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
        return delegate.map(mapper);
    }

    public IntStream mapToInt(ToIntFunction<? super T> mapper) {
        return delegate.mapToInt(mapper);
    }

    public LongStream mapToLong(ToLongFunction<? super T> mapper) {
        return delegate.mapToLong(mapper);
    }

    public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        return delegate.mapToDouble(mapper);
    }

    public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return delegate.flatMap(mapper);
    }

    public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return delegate.flatMapToInt(mapper);
    }

    public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        return delegate.flatMapToLong(mapper);
    }

    public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return delegate.flatMapToDouble(mapper);
    }

    public Stream<T> distinct() {
        return delegate.distinct();
    }

    public Stream<T> sorted() {
        return delegate.sorted();
    }

    public Stream<T> sorted(Comparator<? super T> comparator) {
        return delegate.sorted(comparator);
    }

    public Stream<T> peek(Consumer<? super T> action) {
        return delegate.peek(action);
    }

    public Stream<T> limit(long maxSize) {
        return delegate.limit(maxSize);
    }

    public Stream<T> skip(long n) {
        return delegate.skip(n);
    }

    public void forEach(Consumer<? super T> action) {
        delegate.forEach(action);
    }

    public void forEachOrdered(Consumer<? super T> action) {
        delegate.forEachOrdered(action);
    }

    public Object[] toArray() {
        return delegate.toArray();
    }

    public <A> A[] toArray(IntFunction<A[]> generator) {
        return delegate.toArray(generator);
    }

    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return delegate.reduce(identity, accumulator);
    }

    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return delegate.reduce(accumulator);
    }

    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return delegate.reduce(identity, accumulator, combiner);
    }

    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return delegate.collect(supplier, accumulator, combiner);
    }

    public <R, A> R collect(Collector<? super T, A, R> collector) {
        return delegate.collect(collector);
    }

    public Optional<T> min(Comparator<? super T> comparator) {
        return delegate.min(comparator);
    }

    public Optional<T> max(Comparator<? super T> comparator) {
        return delegate.max(comparator);
    }

    public long count() {
        return delegate.count();
    }

    public boolean anyMatch(Predicate<? super T> predicate) {
        return delegate.anyMatch(predicate);
    }

    public boolean allMatch(Predicate<? super T> predicate) {
        return delegate.allMatch(predicate);
    }

    public boolean noneMatch(Predicate<? super T> predicate) {
        return delegate.noneMatch(predicate);
    }

    public Optional<T> findFirst() {
        return delegate.findFirst();
    }

    public Optional<T> findAny() {
        return delegate.findAny();
    }

}
