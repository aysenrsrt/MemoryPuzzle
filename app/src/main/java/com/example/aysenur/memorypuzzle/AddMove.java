package com.example.aysenur.memorypuzzle;

import android.text.TextUtils;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddMove {

    private static final String TAG = MainActivity.class.getSimpleName();
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    private String moveId;


    public AddMove() {
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("moves");
        mFirebaseInstance.getReference("app_title").setValue("MemoryPuzzle");
    }
    public void create(String date, String level, int move_num) {
        // TODO
        // In real apps this userId should be fetched
        // by implementing firebase auth
        if (TextUtils.isEmpty(moveId)) {
            moveId = mFirebaseDatabase.push().getKey();
        }

        Move move = new Move(date, level, move_num);

        mFirebaseDatabase.child(moveId).setValue(move);

        addMoveChangeListener();
    }

    /**
     * User data change listener
     */
    private void addMoveChangeListener() {
        // User data change listener
        mFirebaseDatabase.child(moveId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Move move = dataSnapshot.getValue(Move.class);

                // Check for null
                if (move == null) {
                    Log.e(TAG, "Data is null!");
                    return;
                }

                Log.e(TAG, "Move data is changed!" + move.getDate() + ", " + move.getLevel() + "," + move.getMove());

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", error.toException());
            }
        });
    }

}
