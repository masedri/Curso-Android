package com.example.masedri.androidstackexchange.model;

import com.google.gson.annotations.SerializedName;


/**
 * Created by masedri on 7/2/17.
 */

public class Item {
    @SerializedName("question_id") public  int questionId; // PARA mapearlo
    public String link;
    public String title;
    public Owner owner;



}
