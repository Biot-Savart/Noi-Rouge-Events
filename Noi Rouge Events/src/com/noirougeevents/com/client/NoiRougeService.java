/**
 * 
 */
package com.noirougeevents.com.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


/**
 * @author RynoM
 *
 */
@RemoteServiceRelativePath("NoiRouges")
public interface NoiRougeService extends RemoteService
{
	/**
	 * @param ask
	 * @return String
	 */
	String getPrices(String ask);	
	
	
	/**
	 * @param filename
	 * @return String
	 */
	String getFileContent(String filename);
	
	/**
	 * @param text
	 * @return String
	 */
	String getData();
	
	/**
	 * @param one
	 * @param two
	 */
	public void setData(String one, String two);
	
	/**
	 * @param recipientAdress
	 * @param recipientName
	 * @param message
	 * @param subject
	 */
	public void sendEmail(String recipientAdress,String recipientName, String message, String subject);
	
	
}
