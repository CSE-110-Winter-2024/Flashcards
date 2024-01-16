package edu.ucsd.cse110.secards.app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import edu.ucsd.cse110.secards.app.databinding.ActivityMainBinding;
import edu.ucsd.cse110.secards.lib.Deck;
import edu.ucsd.cse110.secards.lib.PlaceholderData;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private boolean isShowingFront = true;
    private Deck deck = PlaceholderData.DECK;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.app_title);

//        var textView = new TextView(this);
//        textView.setText("Hello World");
//        setContentView(R.layout.activity_main);
//
//        var cardText = (TextView) findViewById(R.id.card_text);
//        cardText.setText("Hello, World!");

        this.binding = ActivityMainBinding.inflate(getLayoutInflater());

        binding.cardText.setText(deck.top().front());

        binding.card.setOnClickListener(v -> {
            isShowingFront = !isShowingFront;
            updateCardText();
        });

        binding.nextButton.setOnClickListener(v -> {
            deck = Deck.forward(deck);
            updateCardText();
        });

        binding.prevButton.setOnClickListener(v -> {
            deck = Deck.backward(deck);
            updateCardText();
        });

        binding.shuffleButton.setOnClickListener(v -> {
            deck = Deck.shuffle(deck);
            updateCardText();
        });

        setContentView(binding.getRoot());
    }

    private void updateCardText() {
        if (isShowingFront) {
            binding.cardText.setText(deck.top().front());
        } else {
            binding.cardText.setText(deck.top().back());
        }
    }
}