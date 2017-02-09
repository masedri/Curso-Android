package com.example.masedri.androidstackexchange.events;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.masedri.androidstackexchange.model.Item;

import java.util.List;

/**
 * Created by masedri on 7/2/17.
 */

public class QuestionsOpenHelper extends SQLiteOpenHelper {

    public static final  String AVATAR_COLUM = "PROFILE_IMAGE";
    public static final  String QUESTION_TITLE_COLUM = "TITLE";
    public static final  String QUESTION_ID_COLUM = "QUESTION_ID";
    public static final  String QUESTION_LINK_COLUM = "LINK";
    public static final  String QUESTION_USERID_COLUM = "USER_ID";


    public static final String QUESTIONS_TABLE = "QUESTIONS";

    public static final  String QUESTION_DB = "questionsDB";
    public static final  int VERSION = 1;

    private  static QuestionsOpenHelper questionsOpenHelper; //ferencia del singleton
    private  static  Context ctx;

    public  static  QuestionsOpenHelper getInstance(Context ctx){ // eta clase solo va a poder trabajar para el contexto que esta constdo
        if (questionsOpenHelper == null){
            questionsOpenHelper = new QuestionsOpenHelper(ctx);
            questionsOpenHelper.ctx = ctx;
        }
        return  questionsOpenHelper;
    }

    public QuestionsOpenHelper(Context context) {
        super(context,QUESTION_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE QUESTIONS(" +"_id INTEGER PRIMARY KEY AUTOINCREMENT," + QUESTION_ID_COLUM+ " INTEGER, " + QUESTION_TITLE_COLUM + " TEXT," + QUESTION_LINK_COLUM + " TEXT, " + QUESTION_USERID_COLUM + " INTEGER,"
                    + AVATAR_COLUM + " INTEGER)";

            db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        throw new RuntimeException("No se admiten modificaciones de la BD");

    }

    public Cursor insert(List<Item> questions){

        String sql = "insert into " + QUESTIONS_TABLE + "(" + QUESTION_ID_COLUM + "," + QUESTION_TITLE_COLUM + "," + QUESTION_LINK_COLUM + "," + QUESTION_USERID_COLUM + "," + AVATAR_COLUM + ") VALUES(?,?,?,?,?)";

      SQLiteDatabase db =  questionsOpenHelper.getWritableDatabase();
        // Las transacciones es una undad o se hacetodo o no se hace nada
        db.beginTransaction();

        for (Item item: questions){
            db.execSQL(sql, new Object[]{item.questionId, item.title, item.link, item.owner.userId, item.owner.profileImage});
        }

        db.setTransactionSuccessful();
        db.endTransaction(); // para terminar la transaccion hay que marcarla como exitosa

        db.query(QUESTIONS_TABLE, new String[]{"_id",QUESTION_TITLE_COLUM, AVATAR_COLUM}, null, null, null, null, null); // la primera es la table, el segundo arguento es el SELECT, y l tercer argumento es el WHERE, etc etc de una peticion query.


        return null;
    }
}
