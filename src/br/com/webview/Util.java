package br.com.webview;
/**
 * Classe de Utilidades
 * Roberto Duré
 * 09/04/2015
 * 
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;

public class Util extends Activity {


	private AlertDialog.Builder msg;
	private AlertDialog alert;

	/*
	 * Os metodos abaixo são para mensagens
	 */

	// Mensagem para saida
	public void msgExit() {

		msg = new AlertDialog.Builder(this);
		msg.setTitle("Sair");
		msg.setMessage("Deseja realmente sair?");
		msg.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {

				finish();

			}
		});
		msg.setNegativeButton("NÂO", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {
				// nao faz nada
			}
		});
		AlertDialog alert = msg.create();
		alert.show();

	}

	// Mensagem de conexao
	public void msgConexao() {

		msg = new AlertDialog.Builder(this);
		msg.setTitle("Conexão");
		msg.setMessage("Sem conexão com a internet. Deseja tentar novamente?");
		msg.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {

				finish();
				Intent it = new Intent(Util.this, Webview.class);
				startActivity(it);
			}

		});

		msg.setNegativeButton("Não", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {

				finish();
			}
		});
		AlertDialog alert = msg.create();
		alert.show();

	}

	// Testa conexao
	public boolean verificaConexao() {
		boolean conectado;
		ConnectivityManager conectivtyManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		if (conectivtyManager.getActiveNetworkInfo() != null
				&& conectivtyManager.getActiveNetworkInfo().isAvailable()
				&& conectivtyManager.getActiveNetworkInfo().isConnected()) {
			conectado = true;
		} else {
			conectado = false;
		}
		return conectado;
	}
}