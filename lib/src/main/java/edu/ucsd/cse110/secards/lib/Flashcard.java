package edu.ucsd.cse110.secards.lib;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Flashcard {
    private final @NonNull String front;
    private final @NonNull String back;

    public Flashcard(@NonNull String front, @NonNull String back) {
        this.front = front;
        this.back = back;
    }

    public @NonNull String front()  {
        return front;
    }

    public @NonNull String back() {
        return back;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flashcard flashcard = (Flashcard) o;
        return Objects.equals(front, flashcard.front) && Objects.equals(back, flashcard.back);
    }

    @Override
    public int hashCode() {
        return Objects.hash(front, back);
    }
}
