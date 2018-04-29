package com.example.daniel.signin3;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.LinkedList;
import java.util.List;

import static com.google.firebase.database.FirebaseDatabase.*;

public class chatUtils {

    public interface OnMessageListener {
        void onMessage(String newMessage);
    }

    private static final DatabaseReference database = FirebaseDatabase.getInstance().getReference("chat");
    private static final List<OnMessageListener> messageListeners = new LinkedList<>();

    public static void sendMessage(String message) {
        database.push().setValue(message);
    }

    public static void addOnMessageListener(OnMessageListener listener) {
        messageListeners.add(listener);
    }

    static {
        database.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String newMessage = dataSnapshot.getValue(String.class);
                for (OnMessageListener messageListener : messageListeners) {
                    messageListener.onMessage(newMessage);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
