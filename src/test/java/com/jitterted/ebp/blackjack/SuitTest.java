package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

// probably delete this test
// does this detect Unintentional Changes?
class SuitTest {

    @Test
    public void heartsAreRed() throws Exception {
        assertThat(Suit.HEARTS.isRed())
                .isTrue();
    }

    @Test
    public void spadesAreNotRed() throws Exception {
        assertThat(Suit.SPADES.isRed())
                .isFalse();
    }
}