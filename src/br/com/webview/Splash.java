package br.com.webview;

/* Tela para splash
 * @author: Roberto Duré
 * @version 1.0 
 */

import br.com.webview.*;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;




public class Splash extends Activity {
		
	private int tempo = 2000; 
    @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ActionBar bar = getActionBar();
        bar.hide();       
   
        new Handler().postDelayed(new Runnable() {
		@Override
		public void run() {
			
			
			Intent it = new Intent(Splash.this, Webview.class);
			startActivity(it);
			finish();
		//...
		}
    	   
	
	}, tempo);
        	
		}
       
}
