package uk.co.slingshoteffect.keypadterminal_v1;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import uk.co.slingshoteffect.keypadterminal_v1.util.SystemUiHider;


public class KeypadActivity extends Activity {
    //TODO:  set kiosk mode
    //TODO:  set up admin interface
    //TODO:  Style interface DONE!

    //
    String TAG ="Button Pressed";
    String enteredCode = "";//the code users enter in via the keypad
    //

    //String userCode1 = getResources().getString(R.string.zone_1_code);
    String userCode1 ="";//teh main id code
    String userCode2 ="";// the second id code
    Boolean doubleEntry;// are we in doubel id code more
    int codeCount=0;// how many codes have been entered.

    //String adminCode=getResources().getString(R.string.admin_code);
    String adminCode="";
    public static final String prefs="prefs";
    //SharedPreferences sharedPreferences;
    //
//TODO: set up global shared preferences




    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 30;

    /**
     * If set, will toggle the system UI visibility upon interaction. Otherwise,
     * will show the system UI visibility upon interaction.
     */
    private static final boolean TOGGLE_ON_CLICK = true;

    /**
     * The flags to pass to {@link uk.co.slingshoteffect.keypadterminal_v1.util.SystemUiHider#getInstance}.
     */
    private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

    /**
     * The instance of the {@link SystemUiHider} for this activity.
     */
    private SystemUiHider mSystemUiHider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keypad);
        //hideSystemUI();
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.sharPref1), 0);


        doubleEntry = sharedPref.getBoolean("DE", true);
        if(doubleEntry){
            setDouble();
            Log.d("DE on KA","True");
        }else {
            Log.d("DE on KA","False");
        }
        //setPref();
        //SharedPreferences.Editor editor = sharedPref.edit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_keypad, menu);
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
    public void keypadEntry(View view){
        //Log.d(TAG, view.toString());


    }
    public void sendDigit0(View view){
        enteredCode+="0";
        Log.d(TAG, enteredCode);


    }
    //
    public void sendDigit1(View view){
        enteredCode+="1";
        Log.d(TAG, enteredCode);

    }
    //
    public void sendDigit2(View view){

        enteredCode+="2";
        Log.d(TAG, enteredCode);

    }
    public void sendDigit3(View view){
        enteredCode+="3";
        Log.d(TAG, " 3 ");

    }
    //
    public void sendDigit4(View view){

        enteredCode+="4";
        Log.d(TAG, enteredCode);

    }
    //
    public void sendDigit5(View view){

        enteredCode+="5";
        Log.d(TAG, enteredCode);

    }
    //
    public void sendDigit6(View view){

        enteredCode+="6";
        Log.d(TAG, enteredCode);

    }//

    //
    public void sendDigit7(View view){

        enteredCode+="7";
        Log.d(TAG, enteredCode);

    }
    //
    public void sendDigit8(View view){

        enteredCode+="8";
        Log.d(TAG, enteredCode);

    }


    //
    public void sendDigit9(View view){

        enteredCode+="9";
        Log.d(TAG, enteredCode);

    }
    //
    public void sendDigita(View view){

        enteredCode+="a";
        Log.d(TAG, enteredCode);

    }
    //
    public void sendDigitb(View view){

        enteredCode+="b";
        Log.d(TAG, enteredCode);

    }
    //
    public void sendDigitc(View view){

        enteredCode+="c";
        Log.d(TAG, enteredCode);

    }
    //
    public void sendDigitd(View view){

        enteredCode+="d";
        Log.d(TAG, enteredCode);

    }
    //
    public void sendDigite(View view){

        enteredCode+="e";
        Log.d(TAG, enteredCode);

    }
    //
    public void sendDigitf(View view){

        enteredCode+="f";
        Log.d(TAG, enteredCode);

    }
    //

    public void sendDigitenter(View view){
        SharedPreferences sharedPref2 = getSharedPreferences(getString(R.string.sharPref1), 0);
        //Log.d("share pref PC1= ", sharedPref2.getString("PC1", "1111"));
        //userCode1=getResources().getString(R.string.zone_1_code);
        userCode1 = sharedPref2.getString("PC1", "1111");
        userCode2 = sharedPref2.getString("PC2", "1111");
        //doubleEntry = sharedPref2.getBoolean("DE", false);
        adminCode=getResources().getString(R.string.admin_code);
        //
        if(!doubleEntry) {

            if (userCode1.equals(enteredCode)) {

                Log.d(TAG, "BOOM");
                enteredCode = "";
                //Intent intent = new Intent(this, touchTest.class);
                Intent intent = new Intent(this, holdDown.class);
                startActivity(intent);
            } else if (adminCode.equals(enteredCode)) {
                //Log.d(TAG, "its the page!");
                Intent intent = new Intent(this, AdminInterface2.class);
                startActivity(intent);
            } else {
                Log.d(TAG, "easy Tiger!");
                enteredCode = "";


                warnMe();
            }
        }else {
            if (userCode2.equals(enteredCode)) {

                Log.d(TAG, "BOOM");
                enteredCode = "";
                //TODO set the state to normal and reset teh text
                //TODO setNormal()
                //TODO Set NormalTimeOut()
                setSingle();
                setDoubleTimer();
            } else if (adminCode.equals(enteredCode)) {
                //Log.d(TAG, "its the page!");
                Intent intent = new Intent(this, AdminInterface2.class);
                startActivity(intent);
            } else {
                Log.d(TAG, "easy Tiger!");
                enteredCode = "";


                warnMe();
            }
        }
    }
    //
    public void sendDigitclear(View view){

        enteredCode="";
        Log.d(TAG, enteredCode);

    }
    //
    // TODO: Set up kiosking
    //
    //View mDecorView = getActivity().getWindow().getDecorView();

public void warnMe(){
//TODO make sure teh messageing accounts for the double entry state
    TextView textView = (TextView) findViewById(R.id.main_message);
    String lWarn = getString(R.string.warning_message);
    String lWelcome = getString(R.string.start_instructions);
    textView.setText(lWarn);
    textView.setTextColor(Color.RED);
    //warn.start();

   // now try a time out
    CountDownTimer warn = new CountDownTimer(3000, 1000) {

        public void onTick(long millisUntilFinished) {
            Log.d("holdDown reset:", "seconds remaining: " + millisUntilFinished / 1000);
        }

        public void onFinish() {
            Log.d("LOG", "No one loves me");
            //
            if(doubleEntry){
                setDouble();
            }else{
                setSingle();
            }
            /*
            String lWelcome = getString(R.string.start_instructions);
            TextView tv2 = (TextView) findViewById(R.id.main_message);
            tv2.setText(lWelcome);
            tv2.setTextColor(Color.WHITE);
            */

        }
    }.start();
}
    public void setDouble(){
        doubleEntry=true;
        TextView tv4 = (TextView) findViewById(R.id.main_message);
        String lWelcome = getString(R.string.lock_instructions);

        tv4.setText(lWelcome);
        tv4.setTextColor(Color.RED);

    }
    public void setSingle(){
        doubleEntry=false;
        TextView tv3 = (TextView) findViewById(R.id.main_message);
        String lWelcome = getString(R.string.start_instructions);

        tv3.setText(lWelcome);
        tv3.setTextColor(Color.WHITE);
    }
    public void setDoubleTimer(){

        CountDownTimer warn = new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                Log.d("DoubleTimer:", "seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                setDouble();

            }
        }.start();


    }
}
