package com.aol.cyclops.util.validation;

import com.aol.cyclops.Reducer;
import com.aol.cyclops.Semigroup;
import com.aol.cyclops.control.Xor;
import com.aol.cyclops.data.collections.extensions.standard.ListX;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A class that represents Validation Results from multiple validation events
 * 
 * @author johnmcclean
 *
 * @param <T>  Successful result type
 * @param <E>  Error type
 */
@Getter
@AllArgsConstructor
public class ValidationResults<T, E> {
    private final ListX<ValidationResult<T, E>> results;

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return results.toString();
    }

    public ListX<Xor<E, T>> toXors() {
        return results.map(v -> v.toXor());
    }

    public Xor<ListX<T>, ListX<E>> toErrorSequence() {
        return Xor.sequenceSecondary(toXors());
    }

    public <R> Xor<?, R> accumulateErrors(Reducer<R> reducer) {
        return Xor.accumulateSecondary(toXors(), reducer);
    }

    public <R> Xor<?, E> accumulateErrors(Semigroup<E> combiner) {
        return Xor.accumulateSecondary(toXors(), combiner);
    }

    public Xor<ListX<E>, ListX<T>> toSuccessSequence() {
        return Xor.sequencePrimary(toXors());
    }

    public <R> Xor<?, R> accumulateSuccess(Reducer<R> reducer) {
        return Xor.accumulateSecondary(toXors(), reducer);
    }

    public <R> Xor<?, E> accumulateSuccess(Semigroup<E> combiner) {
        return Xor.accumulateSecondary(toXors(), combiner);
    }

}
