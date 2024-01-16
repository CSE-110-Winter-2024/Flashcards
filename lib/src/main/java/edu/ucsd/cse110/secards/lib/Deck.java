package edu.ucsd.cse110.secards.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Deck {
    private final List<Flashcard> flashcards;

    public Deck(List<Flashcard> flashcards) {
        this.flashcards = List.copyOf(flashcards);
    }

    public Flashcard top() {
        return flashcards.get(0);
    }

    public void forward() {
        Collections.rotate(flashcards, -1);
    }

    public void backward() {
        Collections.rotate(flashcards, -1);
    }

    public void shuffle() {
        Collections.shuffle(flashcards);
    }

    public static Deck forward(Deck deck) {
        var cards = new ArrayList<>(deck.flashcards);
        Collections.rotate(cards, -1);
        return new Deck(cards);
    }

    public static Deck backward(Deck deck) {
        var cards = new ArrayList<>(deck.flashcards);
        Collections.rotate(cards, 1);
        return new Deck(cards);
    }

    public static Deck shuffle(Deck deck) {
        var cards = new ArrayList<>(deck.flashcards);
        Collections.shuffle(cards);
        return new Deck(cards);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return Objects.equals(flashcards, deck.flashcards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flashcards);
    }
}
