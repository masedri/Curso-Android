package com.example.masedri.androidstackexchange.retrofitresources;

import com.example.masedri.androidstackexchange.model.Item;
import com.example.masedri.androidstackexchange.model.QuestionGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by masedri on 7/2/17.
 */

public interface QuestionCall {
    @GET("/2.1/questions?order=desc&sort=creation&site=stackoverflow")

    Call<QuestionGroup> getQuestionsCall(@Query("tagged")String filtro);
}
