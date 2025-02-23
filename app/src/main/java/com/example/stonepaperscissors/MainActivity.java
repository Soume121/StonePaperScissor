package com.example.stonepaperscissors;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView, youChooseTextView, computerChooseTextView;
    private ImageView userChoiceImageView, computerChoiceImageView;
    private Button stoneButton, paperButton, scissorsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        resultTextView = findViewById(R.id.resultTextView);
        youChooseTextView = findViewById(R.id.youChooseTextView);
        computerChooseTextView = findViewById(R.id.computerChooseTextView);
        userChoiceImageView = findViewById(R.id.userChoiceImageView);
        computerChoiceImageView = findViewById(R.id.computerChoiceImageView);
        stoneButton = findViewById(R.id.stoneButton);
        paperButton = findViewById(R.id.paperButton);
        scissorsButton = findViewById(R.id.scissorsButton);

        // Set click listeners for the buttons
        stoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame("Stone");
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame("Paper");
            }
        });

        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame("Scissors");
            }
        });
    }

    private void playGame(String userChoice) {
        // Set user choice text and image
        youChooseTextView.setText("You choose: " + userChoice);
        if (userChoice.equals("Stone")) {
            userChoiceImageView.setImageResource(R.drawable.stone);
        } else if (userChoice.equals("Paper")) {
            userChoiceImageView.setImageResource(R.drawable.paper);
        } else {
            userChoiceImageView.setImageResource(R.drawable.scissors);
        }

        // Generate a random choice for the computer
        String computerChoice = getComputerChoice();

        // Set computer choice text and image
        computerChooseTextView.setText("Computer choose: " + computerChoice);
        if (computerChoice.equals("Stone")) {
            computerChoiceImageView.setImageResource(R.drawable.stone);
        } else if (computerChoice.equals("Paper")) {
            computerChoiceImageView.setImageResource(R.drawable.paper);
        } else {
            computerChoiceImageView.setImageResource(R.drawable.scissors);
        }

        // Determine the winner
        String result = getResult(userChoice, computerChoice);
        resultTextView.setText(result);
    }

    private String getComputerChoice() {
        String[] choices = {"Stone", "Paper", "Scissors"};
        Random random = new Random();
        return choices[random.nextInt(choices.length)];
    }

    private String getResult(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a Tie!";
        } else if (userChoice.equals("Stone") && computerChoice.equals("Scissors") ||
                userChoice.equals("Paper") && computerChoice.equals("Stone") ||
                userChoice.equals("Scissors") && computerChoice.equals("Paper")) {
            return "You Win!";
        } else {
            return "Computer Wins!";
        }
    }
}
