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
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class Level2Activity extends AppCompatActivity {

    ImageView iv2_11, iv2_12, iv2_13, iv2_14, iv2_21, iv2_22, iv2_23, iv2_24;
    Integer[] cardsArray = {101, 102, 103, 104, 201, 202, 203, 204};

    int image101, image102, image103, image104,
            image201, image202, image203, image204;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    int playerPoints = 0;
    AddMove m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);

        m = new AddMove();

        iv2_11 = (ImageView) findViewById(R.id.iv2_11);
        iv2_12 = (ImageView) findViewById(R.id.iv2_12);
        iv2_13 = (ImageView) findViewById(R.id.iv2_13);
        iv2_14 = (ImageView) findViewById(R.id.iv2_14);
        iv2_21 = (ImageView) findViewById(R.id.iv2_21);
        iv2_22 = (ImageView) findViewById(R.id.iv2_22);
        iv2_23 = (ImageView) findViewById(R.id.iv2_23);
        iv2_24 = (ImageView) findViewById(R.id.iv2_24);

        iv2_11.setTag("0");
        iv2_12.setTag("1");
        iv2_13.setTag("2");
        iv2_14.setTag("3");
        iv2_21.setTag("4");
        iv2_22.setTag("5");
        iv2_23.setTag("6");
        iv2_24.setTag("7");

        frontOfCardsResources();

        Collections.shuffle(Arrays.asList(cardsArray));

        iv2_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv2_11, theCard);
            }
        });

        iv2_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv2_12, theCard);
            }
        });

        iv2_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv2_13, theCard);
            }
        });

        iv2_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv2_14, theCard);
            }
        });

        iv2_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv2_21, theCard);
            }
        });

        iv2_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv2_22, theCard);
            }
        });

        iv2_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv2_23, theCard);
            }
        });

        iv2_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv2_24, theCard);
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
        }else if (cardsArray[card] == 104) {
            iv.setImageResource(image104);
        }else if(cardsArray[card] == 201){
            iv.setImageResource(image201);
        }else if(cardsArray[card] == 202){
            iv.setImageResource(image202);
        }else if(cardsArray[card] == 203){
            iv.setImageResource(image203);
        }else if (cardsArray[card] == 204) {
            iv.setImageResource(image204);
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

            iv2_11.setEnabled(false);
            iv2_12.setEnabled(false);
            iv2_13.setEnabled(false);
            iv2_14.setEnabled(false);
            iv2_21.setEnabled(false);
            iv2_22.setEnabled(false);
            iv2_23.setEnabled(false);
            iv2_24.setEnabled(false);

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
                iv2_11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv2_12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                iv2_13.setVisibility(View.INVISIBLE);
            } else if(clickedFirst == 3) {
                iv2_14.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv2_21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv2_22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                iv2_23.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                iv2_24.setVisibility(View.INVISIBLE);
            }


            if (clickedSecond == 0) {
                iv2_11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv2_12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                iv2_13.setVisibility(View.INVISIBLE);
            }else if (clickedSecond == 3) {
                iv2_14.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv2_21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv2_22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                iv2_23.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                iv2_24.setVisibility(View.INVISIBLE);
            }
            playerPoints++;
        } else {
            iv2_11.setImageResource(R.drawable.ic_back);
            iv2_12.setImageResource(R.drawable.ic_back);
            iv2_13.setImageResource(R.drawable.ic_back);
            iv2_14.setImageResource(R.drawable.ic_back);
            iv2_21.setImageResource(R.drawable.ic_back);
            iv2_22.setImageResource(R.drawable.ic_back);
            iv2_23.setImageResource(R.drawable.ic_back);
            iv2_24.setImageResource(R.drawable.ic_back);

            playerPoints++;
        }

        iv2_11.setEnabled(true);
        iv2_12.setEnabled(true);
        iv2_13.setEnabled(true);
        iv2_14.setEnabled(true);
        iv2_21.setEnabled(true);
        iv2_22.setEnabled(true);
        iv2_23.setEnabled(true);
        iv2_24.setEnabled(true);

        checkEnd();

    }

    private void checkEnd() {
        if (iv2_11.getVisibility() == View.INVISIBLE &&
                iv2_12.getVisibility() == View.INVISIBLE &&
                iv2_13.getVisibility() == View.INVISIBLE &&
                iv2_14.getVisibility() == View.INVISIBLE &&
                iv2_21.getVisibility() == View.INVISIBLE &&
                iv2_22.getVisibility() == View.INVISIBLE &&
                iv2_23.getVisibility() == View.INVISIBLE &&
                iv2_24.getVisibility() == View.INVISIBLE) {

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();

            String date_move = dateFormat.format(date);

            m.create(date_move, "Level 2", playerPoints);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Level2Activity.this);
            alertDialogBuilder
                    .setMessage("Level Completed!\nMove: " + playerPoints)
                    .setCancelable(false)
                    .setPositiveButton("NEXT LEVEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(),LevelActivity.class);
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
        image104 = R.drawable.ic_image104;
        image201 = R.drawable.ic_image201;
        image202 = R.drawable.ic_image202;
        image203 = R.drawable.ic_image203;
        image204 = R.drawable.ic_image204;
    }
}
