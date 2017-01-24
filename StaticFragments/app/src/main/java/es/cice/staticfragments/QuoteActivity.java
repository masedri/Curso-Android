package es.cice.staticfragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.cice.staticfragments.fragments.QuoteFragment;

public class QuoteActivity extends AppCompatActivity {

    public static final String QUOTE_INDEX="index";
    private QuoteFragment qFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);
        qFragment = (QuoteFragment) getSupportFragmentManager().findFragmentById(R.id.quoteFragment2);
        Intent intent = getIntent();
        int index = intent.getIntExtra(QUOTE_INDEX, -1);
        qFragment.showTitle(index);
    }

    
}
