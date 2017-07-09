package br.com.webview;



import br.com.teramag.R;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.SearchView;
import android.widget.Toast;
import android.os.Build;

/**
 * Classe Main View
 * @author Roberto Duré
 * 09/04/2015
 *
 */
public class Webview extends Activity {
	WebView Wv;
	SearchView mSearchView;
	String url = "http://URL";
	ProgressDialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		try {


			// Cria webview
			Wv = (WebView) findViewById(R.id.web);
			WebSettings webSettings = Wv.getSettings();
			Wv.getSettings().setJavaScriptEnabled(true);
			Wv.setWebViewClient(new MyCustomWebViewClient());
			if (savedInstanceState == null)
			Wv.loadUrl(url);
				// Fim a Criacao
				//Barra de progresso
			
				dialog = ProgressDialog.show(Webview.this, "",
						"Inicializando...", true);
		

				//Thread da barra de progresso
				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {

						dialog.cancel();

					}
				}, 3000);
			
		} catch (Exception e) {
			Toast.makeText(Webview.this, "Erro ao carregar o site", 1000)
			.show();
		}

	}

	// Evita que ao clicar num link de uma página do webview seja aberto no navegador do sistema
	private class MyCustomWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
	}

	/// Evita que ao girar o dispositivo o Webview seja recarregado
	@Override
	protected void onSaveInstanceState(Bundle outState )
	{
		super.onSaveInstanceState(outState);
		Wv.saveState(outState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState)
	{
		super.onSaveInstanceState(savedInstanceState);
		Wv.restoreState(savedInstanceState);
	}

	// Captura o botao voltar e "repassa" comando para webview
	@Override
	public void onBackPressed() {
		if (Wv.canGoBack()) {
			Wv.goBack();
		} else {

			super.onBackPressed();
		}
	}
}