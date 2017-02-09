package com.example.masedri.androidstackexchange.events;

import android.database.Cursor;

/**
 * Created by masedri on 7/2/17.
 */
public class NewDataEvent {

    public NewDataEvent(Cursor cursor) {
        this.cursor = cursor;
    }

    private Cursor cursor;

    public Cursor getCursor() {
        return cursor;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }
}
