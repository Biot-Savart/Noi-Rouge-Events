/**
 * 
 */
package com.noirougeevents.com.client.pages;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.noirougeevents.com.client.NoiRougeService;
import com.noirougeevents.com.client.NoiRougeServiceAsync;

/**
 * @author RynoM
 *
 */
public class ContactUs
{
	
	
	/**
	 * @param parentPanel
	 * @return DockPanel
	 */
	public DockPanel inetPage(DockPanel parentPanel)
	{
		DockPanel contactUsPanel = new DockPanel();
		//contactUsPanel = parentPanel;
	//	contactUsPanel.setStyleName("Content");
		//contactUsPanel.setHeight("1000px");
		contactUsPanel = addDetails(contactUsPanel);
		contactUsPanel = addQueryField(contactUsPanel);
		
		
		
		parentPanel = contactUsPanel;
		return parentPanel;		
	}
	
	
	
	private DockPanel addDetails(DockPanel contactUsPanel)
	{			
		String text = "<h1>Contact Us</h1>" +
				"<table class='infoTable'>" +
				"<tr><th align='left'>Nicolette Myburgh</th></tr>" +
				"<tr><td>Email: nicolette@noirougeevents.com</td></tr>" +
				"<tr><td>Cell: 071 186 2095</td></tr>" +
				"<tr><td>Fax: 086 577 1246</td></tr>" +
				"</table><br>";
		
		HTML html = new HTML(text);
		html.setHeight("180px");
		
		contactUsPanel.add(html,DockPanel.NORTH);		
		return contactUsPanel;	
	}
	
	private NoiRougeServiceAsync loadFileService = GWT.create(NoiRougeService.class);
	final DialogBox dialogBox = new DialogBox();
	
	private DockPanel addQueryField(DockPanel contactUsPanel)
	{
		
		HTML heading = new HTML("<H1>If you have a query.</H1>");
		heading.setHeight("60px");
		contactUsPanel.add(heading,DockPanel.NORTH);
		
		
		Grid grid = new Grid(3,2);
		
		grid.setText(0, 0, "Name:");
		grid.setText(1, 0, "Tel/Cell No:");
		grid.setText(2, 0, "Email Address:");
		
		final TextBox nameBox = new TextBox();
		final TextBox telBox = new TextBox();
		final TextBox emailBox = new TextBox();
		
		grid.setWidget(0, 1, nameBox);
		grid.setWidget(1, 1, telBox);
		grid.setWidget(2, 1, emailBox);
		
		contactUsPanel.add(grid, DockPanel.NORTH);
		
		
		final TextArea ta = new TextArea();
		ta.setWidth("630px");
		ta.setHeight("200px");
		ta.setText("Please Enter your query here.");
		
		contactUsPanel.add(ta,DockPanel.NORTH);
		
		
		Button submit = new Button();
		submit.setText("Submit Query");
		submit.getElement().setId("siteButton");
		
		submit.addClickHandler(new ClickHandler()
		{

			public void onClick(ClickEvent event)
			{
				// TODO Auto-generated method stub
				String query = ta.getText();		
				String name = nameBox.getText();
				String tel = telBox.getText();
				String email = emailBox.getText();
				
				if (name.length() == 0 || tel.length() == 0 || email.length() == 0)
				{
					displayDialog("Please enter all fields.");
				}
				else
				{
				
				if (loadFileService == null) 
			    {
			   	 loadFileService = GWT.create(NoiRougeService.class);
			    }

			    // Set up the callback object.
			    AsyncCallback<Void> callback = new AsyncCallback<Void>() 
			    {
			      public void onFailure(Throwable caught) 
			      {
			        // TODO: Do something with errors.
			      }

					public void onSuccess(Void result)
					{
						displayDialog("Query sent successfully.");
						//dialogBox.setText("Your query has been sent successfully.");
					/*	dialogBox.setAnimationEnabled(true);
						final Button closeButton = new Button("Close");
						// We can set the id of a widget by accessing its Element
						closeButton.getElement().setId("siteButton");
						final Label successLabel = new Label("Query sent successfully.");
						successLabel.addStyleName("successLable");
						
						VerticalPanel dialogVPanel = new VerticalPanel();
						dialogVPanel.addStyleName("dialogVPanel");	
						dialogVPanel.setHorizontalAlignment(dialogVPanel.ALIGN_CENTER);
						dialogVPanel.add(successLabel);
						
						
						dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
						dialogVPanel.add(closeButton);
						dialogBox.setWidget(dialogVPanel);
						dialogBox.center();
						dialogBox.show();
						
						closeButton.addClickHandler(new ClickHandler()
						{
							public void onClick(ClickEvent event)
							{
								dialogBox.hide();								
							}
						});*/
						
						
						}

			      
			    };  	 
			    
			    String message = "<table><tr><td><b>New query from:</b> </td><td>" + name + "</td></tr>"
			    						+ "<tr><td><b>Email:</b> </td><td>" + email + "</td></tr>"
			    						+ "<tr><td><b>Tel/Cell:</b> </td><td>" + tel + "</td></tr>"
			    						+ "<tr><td><b>Query :</b> </td><td>" + query + "</td></tr></table>";
			    
			    message = message + "<br><br> <img src='www.noirougeevents.com/images/web_page/Noi_Rouge_email.jpg'>";
			    
			    loadFileService.sendEmail("rynomyburgh@gmail.com", "Ryno Myburgh", message, "New Query On Web Page", callback);
			    loadFileService.sendEmail("nicolette@noirougeevents.com", "Nicolette Myburgh", message, "New Query On Web Page", callback);
					
				
			}
			}
			
		});
		
		
		
		contactUsPanel.add(submit,DockPanel.NORTH);
		
		
		
		return contactUsPanel;
	}
	
	private void displayDialog(String message)
	{
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("siteButton");
		final Label successLabel = new Label(message);
		successLabel.addStyleName("successLable");
		
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");	
		dialogVPanel.setHorizontalAlignment(dialogVPanel.ALIGN_CENTER);
		dialogVPanel.add(successLabel);
		
		
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);
		dialogBox.center();
		dialogBox.show();
		
		closeButton.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				dialogBox.hide();								
			}
		});
		
}
}
