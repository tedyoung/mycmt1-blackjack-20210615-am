package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class HandBustedTest {

    @Test
    public void handWithValueOf22IsBusted() throws Exception {
        Hand hand = new Hand(List.of(new Card(Suit.CLUBS, "9"),
                                     new Card(Suit.SPADES, "8"),
                                     new Card(Suit.DIAMONDS, "5")));

        assertThat(hand.isBusted())
                .isTrue();
    }

    @Test
    public void handWithValueOf21IsNotBusted() throws Exception {
        Hand hand = new Hand(List.of(new Card(Suit.CLUBS, "8"),
                                     new Card(Suit.SPADES, "8"),
                                     new Card(Suit.DIAMONDS, "5")));

        assertThat(hand.isBusted())
                .isFalse();
    }

    @Test
    public void handWithValueOf20IsNotBusted() throws Exception {
        Hand hand = new Hand(List.of(new Card(Suit.CLUBS, "10"),
                                     new Card(Suit.SPADES, "Q")));

        assertThat(hand.isBusted())
                .isFalse();
    }
}
