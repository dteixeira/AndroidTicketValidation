package org.cmov.validationterminal;

import org.json.JSONObject;

public interface ValidateTicketResultCallback {

	public void onRequestResult(boolean result, JSONObject data, int requestCode);

}
