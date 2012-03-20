/**
 * 
 */
package com.noirougeevents.com.server;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.noirougeevents.com.client.NoiRougeService;
import com.noirougeevents.com.server.datastore.DataTest;
import com.noirougeevents.com.server.datastore.PMF;
import com.noirougeevents.com.server.email.Mail;

/**
 * @author RynoM
 *
 */
@SuppressWarnings("serial")
public class NoiRougeServiceImpl extends RemoteServiceServlet implements
					NoiRougeService
{

	/* (non-Javadoc)
	 * @see com.noirougeevents.com.client.NoiRougeService#getPrices(java.lang.String)
	 */
	public String getPrices(String ask)
	{
		// TODO Auto-generated method stub
		return "Works " + ask;
	}
	
	
	public String getFileContent(String filename)
	{
		
		StringBuffer fileData = new StringBuffer(1000);
      BufferedReader reader = new BufferedReader(new InputStreamReader(this
          .getClass().getClassLoader().getResourceAsStream(filename)));
      char[] buf = new char[1024];
      int numRead = 0;
      try
		{
			while ((numRead = reader.read(buf)) != -1) {
			    String readData = String.valueOf(buf, 0, numRead);
			    fileData.append(readData);
			    buf = new char[1024];
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      try
		{
			reader.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
      return fileData.toString();		
	
	}
	
	public String getData()
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    String query = "select from " + DataTest.class.getName() + " order by date desc";
	    List<DataTest> greetings = (List<DataTest>) pm.newQuery(query).execute();
	    
	    String text = "";
	    if (greetings.isEmpty())
	    {
	   	 text = "No data availible";
	    }
	    else 
	    {
	        for (DataTest g : greetings) 
	        {
	      	  text = text + "<br>" + g.getDate() + " - " + g.getAuthor() + " - " + g.getContent();
	        }
	    }
		return text;
		
	}
	
	/**
	 * @param one
	 * @param two
	 */
	public void setData(String one, String two)
	{
		Date date = new Date();
      DataTest greeting = new DataTest(one, two, date);

      PersistenceManager pm = PMF.get().getPersistenceManager();
      try 
      {
          pm.makePersistent(greeting);
      } 
      finally 
      {
          pm.close();
      }
	}
	
	public void sendEmail(String recipientAdress,String recipientName, String message, String subject)
	{
		Mail em = new Mail();
		em.sendMail(recipientAdress,recipientName,message,subject);
	}

}
