package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

    private static final Suit DUMMY_SUIT = Suit.HEARTS;

    @Test
    public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
        Hand hand = createHandWithRanksOf("A", "5");

        // this isn't as "friendly" if the test fails (we don't know what the actual value was)
        assertThat(hand.valueEquals(11 + 5))
                .isTrue();
    }

    @Test
    public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
        Hand hand = createHandWithRanksOf("A", "8", "3");

        assertThat(hand.value())
                .isEqualTo(1 + 8 + 3);
    }

    @Test
    public void handWithOneAceAndOtherCardsEqualTo12ThenAceIsValuedAt1() throws Exception {
        Hand hand = createHandWithRanksOf("A", "7", "5");

        assertThat(hand.value())
                .isEqualTo(1 + 7 + 5);
    }

    private Hand createHandWithRanksOf(String... ranks) {
        List<Card> cards = new ArrayList<>();
        for (String rank : ranks) {
            cards.add(new Card(DUMMY_SUIT, rank));
        }
        return new Hand(cards);
    }

    @Test
    public void handWithOneAceAndOtherCard10ThenAceIsValuedAt11() throws Exception {
        List<Card> cards = List.of(new Card(DUMMY_SUIT, "A"),
                                   new Card(DUMMY_SUIT, "Q"));
        Hand hand = new Hand(cards);

        assertThat(hand.value())
                .isEqualTo(11 + 10);
    }



}
