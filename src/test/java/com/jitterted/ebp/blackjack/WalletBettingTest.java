package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletBettingTest {

    @Test
    public void walletWithBalanceOf12WhenBet8BalanceIs4() throws Exception {
        Wallet wallet = new Wallet();
        wallet.addMoney(12);

        wallet.bet(8);

        assertThat(wallet.balance())
                .isEqualTo(12 - 8);
    }

    @Test
    public void walletWithBalanceOf27WhenBet7AndBet9BalanceIs11() throws Exception {
        Wallet wallet = new Wallet();
        wallet.addMoney(27);

        wallet.bet(7);
        wallet.bet(9);

        assertThat(wallet.balance())
                .isEqualTo(27 - 7 - 9); // EVIDENT DATA
    }

    @Test
    public void whenBetFullBalanceThenIsEmpty() throws Exception {
        Wallet wallet = new Wallet();
        wallet.addMoney(73);

        wallet.bet(73);

        assertThat(wallet.isEmpty())
                .isTrue();
    }

    @Test
    public void whenBetMoreThanBalanceThrowsException() throws Exception {
        Wallet wallet = new Wallet();
        wallet.addMoney(11);

        assertThatThrownBy(() -> {
            wallet.bet(12);
        }).isInstanceOf(IllegalStateException.class);
    }

}
