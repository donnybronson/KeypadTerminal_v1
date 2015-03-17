package uk.co.slingshoteffect.keypadterminal_v1;

import android.app.Activity;
import android.content.Intent;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.CountDownTimer;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class holdDown extends Activity {
    //View holdView = new View();

    // String AudioPath =R.raw;
    //String beep1="chirp1.mp3";
    private MediaPlayer beep;
    private int pageLive = 0;
    int secToMil = 1000;
    int timeOut5=5000;
    int timeOut10=10000;
    int resetTime = 10000;
    int beat = 1000;
    String lTimeOut;
    //CountDownTimer Sand;
    //
    CountDownTimer reset = new CountDownTimer(resetTime, beat) {

        public void onTick(long millisUntilFinished) {
            Log.d("holdDown reset:", "seconds remaining: " + millisUntilFinished / 1000);
        }

        public void onFinish() {
            Log.d("LOG", "No one loves me");
            //
            moveBack();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.sharPref1), 0);
        //
        String locMess = sharedPref.getString("FM", "Hold for 6 seconds");
        //
        pageLive = 1;
        //
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hold_down);
        //final View messageView =findViewById(R.id.full_lock_message);
        TextView textView = (TextView) findViewById(R.id.full_lock_message);
        textView.setText(locMess);
        beep = MediaPlayer.create(this, R.raw.chirp1);
        reset.start();
        lTimeOut = sharedPref.getString("TO", "5");
        //timeOutInt = lTimeOut * secToMil;
        //int timeOutInt =1;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hold_down, menu);
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = MotionEventCompat.getActionMasked(event);
        switch (action) {
//TODO: FIX THE DAM TIMER
            //TODO: the timer is a hack, instead of dynamically setting the duration ive just made 2
            //TODO FIX THE DAMM TIMER!
            case (MotionEvent.ACTION_DOWN):
                Log.d("LOG ", "ACTION_DOWN");
               // timerFun(true);
                if(lTimeOut.equals("5")){
                    sand.start();
                    Log.d("sand",lTimeOut);
                }else if(lTimeOut.equals("10")){
                    sand2.start();
                    Log.d("sand2",lTimeOut);
                }else{//just in case someone enters a number not 5 or 10
                    sand.start();
                }
                //sand.start();//starts the time that causes teh beeping
                reset.cancel();// cancels the timer that resets the page on inactivity
                return true;
            case (MotionEvent.ACTION_UP):
                Log.d("LOG", "ACTION_UP");
                //timerFun(false);
                sand.cancel();//cancels the timer that causes the beeping
                if (pageLive == 1) {
                    reset.start();// re-starts the timer
                }

                return true;
            default:
                return super.onTouchEvent(event);

        }
    }

    public void moveOn() {
        pageLive = 0;
        sand.cancel();
        reset.cancel();
        Intent intent = new Intent(this, gridRefFS.class);
        startActivity(intent);


    }

   // public void timerFun(Boolean set) {
    //if(set) {


       CountDownTimer sand = new CountDownTimer(timeOut5, beat) {


            public void onTick(long millisUntilFinished) {
                Log.d("holdDown sand: ", "seconds remaining: " + millisUntilFinished / 1000);


                try {
                    // mp.selectTrack();
                    beep.start();
                    Log.d("sandRunnin"," beep");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onFinish() {
                Log.d("LOG", "You have sand");
                beep.start();
                moveOn();
            }
        };

    //TODO here is that second timer...uggh
    CountDownTimer sand2 = new CountDownTimer(timeOut10, beat) {


        public void onTick(long millisUntilFinished) {
            Log.d("holdDown sand2: ", "seconds remaining: " + millisUntilFinished / 1000);


            try {
                // mp.selectTrack();
                beep.start();
                Log.d("sand2 Runnin"," beep");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onFinish() {
            Log.d("LOG", "You have sand");
            beep.start();
            moveOn();
        }
    };
        //.start();
    //}else{
   //     sand.cancel();
    //}
//}

    //### AUDIO STUFF

    //AssetFileDescriptor AFD = this.getResources().openRawResourceFd(R.raw.chirp1);
    //MediaPlayer beeper= new MediaPlayer(this,R.raw.chirp1);
//MediaPlayer playBeep = MediaPlayer.create(this, AFD);


    /*
    public void playBeep(){
        //set up MediaPlayer
        MediaPlayer mp = new MediaPlayer();



        try {
            // mp.selectTrack();
            mp.setDataSource(R.raw.chirp1);
            mp.prepare();
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
    public void moveBack(){
        pageLive=0;
        sand.cancel();
        reset.cancel();
        // this is the function that moves us back to the keypad activity
        Intent intent = new Intent(this, KeypadActivity.class);
        startActivity(intent);

    }
}


