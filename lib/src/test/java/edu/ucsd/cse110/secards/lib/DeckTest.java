package edu.ucsd.cse110.secards.lib;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

public class DeckTest {

    @Test
    public void top() {
        var deck = new Deck(List.of(
                new Flashcard("A", "1"),
                new Flashcard("B", "2"),
                new Flashcard("C", "3")
        ));
        var expected = new Flashcard("A", "1");
        var actual = deck.top();
        assertEquals(expected, actual);
    }

    @Test
    public void forward() {
        var initialDeck = new Deck(List.of(
                new Flashcard("A", "1"),
                new Flashcard("B", "2"),
                new Flashcard("C", "3")
        ));

        var expectedDeck = new Deck(List.of(
                new Flashcard("B", "2"),
                new Flashcard("C", "3"),
                new Flashcard("A", "1")
        ));

        var actualDeck = Deck.forward(initialDeck);

        assertEquals(expectedDeck, actualDeck);
    }

    @Test
    public void backward() {
        var initialDeck = new Deck(List.of(
                new Flashcard("A", "1"),
                new Flashcard("B", "2"),
                new Flashcard("C", "3")
        ));

        var expectedDeck = new Deck(List.of(
                new Flashcard("C", "3"),
                new Flashcard("A", "1"),
                new Flashcard("B", "2")
        ));

        var actualDeck = Deck.backward(initialDeck);
        assertEquals(expectedDeck, actualDeck);
    }

    @Test
    public void shuffle() {
        var initialDeck = new Deck(List.of(
                new Flashcard("A", "1"),
                new Flashcard("B", "2"),
                new Flashcard("C", "3"),
                new Flashcard("D", "4"),
                new Flashcard("E", "5")
        ));

        var shuffledDeck = Deck.shuffle(initialDeck);

        boolean same = true;

        for (int i = 0; i < 5; i++) {
            if (initialDeck.top() != shuffledDeck.top()) {
                same = false;
                break;
            } else {
                initialDeck.forward();
                shuffledDeck.forward();
            }
        }

        assertEquals(false, same);
    }
}