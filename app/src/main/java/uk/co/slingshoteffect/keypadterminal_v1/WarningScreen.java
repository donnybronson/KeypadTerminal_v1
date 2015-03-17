package uk.co.slingshoteffect.keypadterminal_v1;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class WarningScreen extends Activity {
//
CountDownTimer reset = new CountDownTimer(5000, 1000) {

    public void onTick(long millisUntilFinished) {
        Log.d("LOG", "seconds remaining: " + millisUntilFinished / 1000);
    }

    public void onFinish() {
        Log.d("LOG", "Done and Dusted");
        //
        moveOn();
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning_screen);
        reset.start();//the timer that resets the activity to the keypad
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_warning_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void moveOn(){
        // this is the function that moves us back to the keypad activity
        Intent intent = new Intent(this, KeypadActivity.class);
        startActivity(intent);
    }
}
