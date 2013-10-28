package org.cmov.ticketclient;

import org.cmov.validationterminal.bluetooth.BluetoothHelper;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothSocket;
import android.os.AsyncTask;
import android.util.Log;

public class ValidateTicketAsyncTask extends AsyncTask<Void, Void, Void> {
	
	/**
	 * Constants.
	 */
	private static final String TAG = ValidateTicketAsyncTask.class.getSimpleName();
	
	/**
	 * Instance variables.
	 */
	private Ticket ticket = null;
	private ProgressDialog progressDialog = null;
	private Activity callingActivity = null;
	private BluetoothSocket socket = null;
	private String login = null;
	private Ticket newTicket = null;
	
	/**
	 * Creates a new async task instance.
	 */
	public ValidateTicketAsyncTask(ValidateTicketResultCallback activity, 
			Ticket ticket, BluetoothSocket socket, String login) {
		this.socket = socket;
		this.callingActivity = (Activity) activity;
		this.progressDialog = new ProgressDialog(this.callingActivity);
		this.ticket = ticket;
		this.login = login;
	}
	
	/**
	 * Sets up a progress dialog.
	 */
	@Override
	protected void onPreExecute() {
		
		// Show a progress modal dialog.
		progressDialog.setMessage("Validating ticket.");
		progressDialog.setCancelable(false);
		progressDialog.setCanceledOnTouchOutside(false);
		progressDialog.show();
	}

	/**
	 * Tries to find the remote device and establish a
	 * bluetooth connection with it.
	 */
	@Override
	protected Void doInBackground(Void... params) {
		try {
			JSONObject json = new JSONObject();
			json.put("login", login);
			json.put("id", ticket.getId());
			BluetoothHelper.bluetoothWriteObject(json.toString(), socket);
			json = new JSONObject((String) BluetoothHelper.bluetoothReadObject(socket));
			if(json != null && json.getBoolean("success")) {
				newTicket = new Ticket(json.getJSONObject("ticket"));
			}
			socket.getInputStream().close();
			socket.getInputStream().close();
			socket.close();
		} catch (Exception e) {}
		return null;
	}
	
	/**
	 * Closes the progress dialog and informs the activity that
	 * the task ended.
	 */
	@Override
	protected void onPostExecute(Void result) {
		
		// Dismiss the progress dialog.
		if (progressDialog.isShowing()) {
			progressDialog.dismiss();
        }
		
		// Callback the task executor.
		Log.d(TAG, "Invoking result callback.");
		((ValidateTicketResultCallback) callingActivity).onValidationResult(newTicket != null, newTicket);
	}

}
