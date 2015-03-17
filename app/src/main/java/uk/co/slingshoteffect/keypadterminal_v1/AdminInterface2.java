package uk.co.slingshoteffect.keypadterminal_v1;

import uk.co.slingshoteffect.keypadterminal_v1.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class AdminInterface2 extends Activity {
    String localStGR ="";
    EditText localEditGR;
    View localVGR;
    int timeOutInt;
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
   // private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
   // private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * If set, will toggle the system UI visibility upon interaction. Otherwise,
     * will show the system UI visibility upon interaction.
     */
   // private static final boolean TOGGLE_ON_CLICK = true;

    /**
     * The flags to pass to {@link SystemUiHider#getInstance}.
     */
   // private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

    /**
     * The instance of the {@link SystemUiHider} for this activity.
     */
   // private SystemUiHider mSystemUiHider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.sharPref1), 0);
        //
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.activity_admin_interface2);

        //final View controlsView = findViewById(R.id.fullscreen_content_controls);
        //final View contentView = findViewById(R.id.fullscreen_content);
        //
        //
        //
        // Set up an instance of SystemUiHider to control the system UI for
        // this activity.
       /* mSystemUiHider = SystemUiHider.getInstance(this, contentView, HIDER_FLAGS);
        mSystemUiHider.setup();
        mSystemUiHider.hide();
        */
        /*
        mSystemUiHider
                .setOnVisibilityChangeListener(new SystemUiHider.OnVisibilityChangeListener() {
                    // Cached values.
                    int mControlsHeight;
                    int mShortAnimTime;

                    @Override
                    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
                    public void onVisibilityChange(boolean visible) {

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
                            // If the ViewPropertyAnimator API is available
                            // (Honeycomb MR2 and later), use it to animate the
                            // in-layout UI controls at the bottom of the
                            // screen.
                            if (mControlsHeight == 0) {
                                mControlsHeight = controlsView.getHeight();
                            }
                            if (mShortAnimTime == 0) {
                                mShortAnimTime = getResources().getInteger(
                                        android.R.integer.config_shortAnimTime);
                            }
                            controlsView.animate()
                                    .translationY(visible ? 0 : mControlsHeight)
                                    .setDuration(mShortAnimTime);
                        } else {
                            // If the ViewPropertyAnimator APIs aren't
                            // available, simply show or hide the in-layout UI
                            // controls.
                            controlsView.setVisibility(visible ? View.VISIBLE : View.GONE);
                        }

                        if (visible && AUTO_HIDE) {
                            // Schedule a hide().
                            delayedHide(AUTO_HIDE_DELAY_MILLIS);
                        }
                    }
                });

        // Set up the user interaction to manually show or hide the system UI.
        contentView.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                if (TOGGLE_ON_CLICK) {
                    mSystemUiHider.toggle();
                } else {
                    mSystemUiHider.show();
                    mSystemUiHider.hide();
                }

            }

        });*/

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        //findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        //delayedHide(100);
    }


    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    /*
    View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    Handler mHideHandler = new Handler();
    Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            mSystemUiHider.hide();
        }
    };
    */
    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    /*
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }*/
    //########
    //########
    //########
    //######## and now for my stuff
    //########

    public void adminUpdate(View view){

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.sharPref1), 0);
        Log.d("adminUpdate", "update");
        //localVGR =findViewById(R.id.GridrefId);
        //localEditGR=findViewById(R.id.GridrefId)
                //getResources().getString(R.id.EditTe GridrefId)

        //Log.d("GR", localVGR.getText().toString());
        //Now go and get the text that was entered and turn it in to a string.
        final EditText lEdit1 =(EditText) findViewById(R.id.GridrefId);
        String lGR =lEdit1.getText().toString();
        //
        final EditText lEdit2 =(EditText) findViewById(R.id.addressId);
        String lAD =lEdit2.getText().toString();
        //
        final EditText lEdit3 =(EditText) findViewById(R.id.timeoutId);
        String lTO =lEdit3.getText().toString();
        //
        final EditText lEdit4 =(EditText) findViewById(R.id.passcodeId1);
        String lPC1 =lEdit4.getText().toString();
        //
        //
        final EditText lEdit5 =(EditText) findViewById(R.id.passcodeId2);
        String lPC2 =lEdit5.getText().toString();
        //
        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkDouble);
        boolean checkD = checkBox1.isChecked();

        final String timeOutSt= sharedPref.getString("TO","5");
        //int timeOutInt =1;
        try{
            timeOutInt = Integer.parseInt(timeOutSt);
            //timeOutInt = timeOutInt * 1000;


        }catch (NumberFormatException nfe){
            //
            // Log.d("nfe",nfe)
        }
        //
        Log.d("GR", lGR);
        Log.d("PC1", lPC1);
        if(checkD){
            Log.d("CHECK", "is Checked");
        }else{
            Log.d("CHECK", " ! Checked");
        }
        //R.string.grid_ref_zone1=lGR;
        //Now get the shared Preferences and update the settings
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("GR", lGR);
        editor.putString("AD", lAD);
        editor.putString("TO",lTO);
        editor.putString("PC1",lPC1);
        editor.putString("PC2", lPC2);
        editor.putInt("TOi", timeOutInt);
        editor.putString("FM", getString(R.string.lockScreen_message3)+lTO+getString(R.string.lockScreen_message4));
        editor.putBoolean("DE",checkD);
        editor.commit();
        //editor.
        String lShare = sharedPref.getString("PC1", "toad");
        Log.d("lShare",lShare);
        //
        //Then lets head off to the start page
        Intent intent = new Intent(this, KeypadActivity.class);
        startActivity(intent);


    }


}