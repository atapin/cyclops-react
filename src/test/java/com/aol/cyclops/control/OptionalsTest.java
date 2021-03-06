package com.aol.cyclops.control;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Test;

import com.aol.cyclops.data.collections.extensions.standard.ListX;
import com.aol.cyclops.util.Optionals;

public class OptionalsTest {
	@Test
	public void testSequence() {
		Optional<ListX<Integer>> maybes =Optionals.sequence(ListX.of(Optional.of(10),Optional.of(20),Optional.of(1)));
		assertThat(maybes,equalTo(Optional.of(ListX.of(10,20,1))));
	}
	@Test
    public void testSequencePresent() {
        Optional<ListX<Integer>> maybes =Optionals.sequencePresent(ListX.of(Optional.of(10),Optional.empty(),Optional.of(1)));
        assertThat(maybes,equalTo(Optional.of(ListX.of(10,1))));
    }
	@Test
    public void testSequenceEmpty() {
        Optional<ListX<Integer>> maybes =Optionals.sequence(ListX.of(Optional.of(10),Optional.empty(),Optional.of(1)));
        assertThat(maybes,equalTo(Optional.empty()));
    }
}
