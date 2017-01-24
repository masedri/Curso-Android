package es.cice.staticfragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import es.cice.staticfragments.fragments.QuoteFragment;
import es.cice.staticfragments.fragments.TitlesListFragment;

public class MainActivity extends AppCompatActivity implements TitlesListFragment.TitlesListFragmetHostingActivity {

    private QuoteFragment qFragment;
    private int orientation;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        qFragment = (QuoteFragment) fm.findFragmentById(R.id.quoteFragment);
        orientation =  getResources().getConfiguration().orientation;

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) { // para detectar la horientacion.
        super.onConfigurationChanged(newConfig);
        // cuando un dispositivo rota android obliga a destruir la actividad y volverla a construir.
        orientation = newConfig.orientation;
        Log.d(TAG, "onConfigurationCahnged[orietation: " + orientation + "]");

    }

    @Override
    public void showTitle(int index) {
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            if (qFragment!=null)
                    qFragment.showTitle(index);

        }else{
            Intent intent =  new Intent(this, QuoteActivity.class);
            intent.putExtra(QuoteActivity.QUOTE_INDEX, index);
            startActivity(intent);
        }

    }
}
