/**
 * 
 */
package com.noirougeevents.com.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author RynoM
 *
 */
public interface NoiRougeServiceAsync
{

	/**
	 * 
	 * @param ask 
	 * @param callback 
	 * @see com.noirougeevents.com.client.NoiRougeService#getPrices(java.lang.String)
	 */
	void getPrices(String ask, AsyncCallback<String> callback);

	/**
	 * @param filename
	 * @param callback
	 */
	void getFileContent(String filename, AsyncCallback<String> callback);

	/**
	 * @param text
	 * @param callback
	 */
	void getData(AsyncCallback<String> callback);

	/**
	 * @param one
	 * @param two
	 * @param callback
	 */
	void setData(String one, String two, AsyncCallback<Void> callback);

	/**
	 * @param recipientAdress
	 * @param recipientName
	 * @param message
	 * @param subject
	 * @param callback
	 */
	void sendEmail(String recipientAdress, String recipientName, String message,
						String subject, AsyncCallback<Void> callback);

}
