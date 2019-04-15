package com.example.aysenur.memorypuzzle;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;
import java.util.Collections;

public class Level1Activity extends AppCompatActivity {

    ImageView iv1_11, iv1_12, iv1_13, iv1_21, iv1_22, iv1_23;
    Integer[] cardsArray = {101, 102, 103, 201, 202, 203};

    int image101, image102, image103,
            image201, image202, image203;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    int playerPoints = 0;

    AddMove m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        m = new AddMove();

        iv1_11 = (ImageView) findViewById(R.id.iv1_11);
        iv1_12 = (ImageView) findViewById(R.id.iv1_12);
        iv1_13 = (ImageView) findViewById(R.id.iv1_13);
        iv1_21 = (ImageView) findViewById(R.id.iv1_21);
        iv1_22 = (ImageView) findViewById(R.id.iv1_22);
        iv1_23 = (ImageView) findViewById(R.id.iv1_23);

        iv1_11.setTag("0");
        iv1_12.setTag("1");
        iv1_13.setTag("2");
        iv1_21.setTag("3");
        iv1_22.setTag("4");
        iv1_23.setTag("5");

        frontOfCardsResources();

        Collections.shuffle(Arrays.asList(cardsArray));

        iv1_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv1_11, theCard);
            }
        });

        iv1_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv1_12, theCard);
            }
        });

        iv1_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv1_13, theCard);
            }
        });

        iv1_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv1_21, theCard);
            }
        });

        iv1_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv1_22, theCard);
            }
        });

        iv1_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv1_23, theCard);
            }
        });
    }

    private  void doStuff(ImageView iv, int card) {

        if (cardsArray[card] == 101) {
            iv.setImageResource(image101);
        } else if (cardsArray[card] == 102) {
            iv.setImageResource(image102);
        } else if (cardsArray[card] == 103) {
            iv.setImageResource(image103);
        }else if(cardsArray[card] == 201){
            iv.setImageResource(image201);
        }else if(cardsArray[card] == 202){
            iv.setImageResource(image202);
        }else if(cardsArray[card] == 203){
            iv.setImageResource(image203);
        }

        if(cardNumber == 1){
            firstCard = cardsArray[card];
            if(firstCard > 200 ){
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);

        }else if(cardNumber == 2) {
            secondCard = cardsArray[card];
            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            iv1_11.setEnabled(false);
            iv1_12.setEnabled(false);
            iv1_13.setEnabled(false);
            iv1_21.setEnabled(false);
            iv1_22.setEnabled(false);
            iv1_23.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculated();
                }
            }, 1000);
        }
    }


    private void calculated() {
        if (firstCard == secondCard) {
            if (clickedFirst == 0) {
                iv1_11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv1_12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                iv1_13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                iv1_21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv1_22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv1_23.setVisibility(View.INVISIBLE);
            }


            if (clickedSecond == 0) {
                iv1_11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv1_12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                iv1_13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                iv1_21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv1_22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv1_23.setVisibility(View.INVISIBLE);
            }
            playerPoints++;
        } else {
            iv1_11.setImageResource(R.drawable.ic_back);
            iv1_12.setImageResource(R.drawable.ic_back);
            iv1_13.setImageResource(R.drawable.ic_back);
            iv1_21.setImageResource(R.drawable.ic_back);
            iv1_22.setImageResource(R.drawable.ic_back);
            iv1_23.setImageResource(R.drawable.ic_back);

            playerPoints++;
        }

        iv1_11.setEnabled(true);
        iv1_12.setEnabled(true);
        iv1_13.setEnabled(true);
        iv1_21.setEnabled(true);
        iv1_22.setEnabled(true);
        iv1_23.setEnabled(true);

        checkEnd();

    }


    private void checkEnd() {
        if (iv1_11.getVisibility() == View.INVISIBLE &&
                iv1_12.getVisibility() == View.INVISIBLE &&
                iv1_13.getVisibility() == View.INVISIBLE &&
                iv1_21.getVisibility() == View.INVISIBLE &&
                iv1_22.getVisibility() == View.INVISIBLE &&
                iv1_23.getVisibility() == View.INVISIBLE) {

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();

            String date_move = dateFormat.format(date);

            m.create(date_move, "Level 1", playerPoints);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Level1Activity.this);
            alertDialogBuilder
                    .setMessage("Level Completed!\nMove: " + playerPoints)
                    .setCancelable(false)
                    .setPositiveButton("NEXT LEVEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(),Level2Activity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

    }

    private void frontOfCardsResources() {
        image101 = R.drawable.ic_image101;
        image102 = R.drawable.ic_image102;
        image103 = R.drawable.ic_image103;
        image201 = R.drawable.ic_image201;
        image202 = R.drawable.ic_image202;
        image203 = R.drawable.ic_image203;
    }



}
