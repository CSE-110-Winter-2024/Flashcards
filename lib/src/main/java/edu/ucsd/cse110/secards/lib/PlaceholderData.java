package edu.ucsd.cse110.secards.lib;

import java.util.List;

public class PlaceholderData {
    public final static Deck DECK = new Deck(List.of(
            new Flashcard("SRP", "Single Responsibility Principle"),
            new Flashcard("OCP", "Open-CLosed Principle"),
            new Flashcard("LSP", "Liskov Substitution Principle"),
            new Flashcard("ISP", "Interface Substitution Principle"),
            new Flashcard("DIP", "Dependency Inversion Principle"),
            new Flashcard("LKP", "Least Knowledge Principle (Law of Demeter)")
    ));
}
