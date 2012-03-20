
package com.noirougeevents.com.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.TabBar;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.noirougeevents.com.client.pages.ContactUs;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Noi_Rouge_Events implements EntryPoint
{
	DockPanel contentPanel = new DockPanel();
	TabBar menuBar = new TabBar();
	HTML contentHtml = new HTML();
	private String[] tabNames = new String[10];
	StackPanel menuPanel = new StackPanel();
	DockPanel centerPanel = new DockPanel();
	ScrollPanel scrolPanel = new ScrollPanel();
	VerticalPanel leftPanel = new VerticalPanel();
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	/*private static final String SERVER_ERROR = "An error occurred while "
						+ "attempting to contact the server. Please check your network "
						+ "connection and try again.";*/

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	/*private final GreetingServiceAsync greetingService = GWT
						.create(GreetingService.class);*/
	
	

	/**
	 * This is the entry point method.
	 */
	@SuppressWarnings({ "unchecked", "unchecked" })
	public void onModuleLoad()
	{
		//final Button sendButton = new Button("Send");
	//	final TextBox nameField = new TextBox();
	//	nameField.setText("GWT User");		
		
//===Menu Bar===
		addTab("Home");
		addTab("About Us");
		addTab("Contact Us");		
		//addTab("Login");
		
		menuBar.selectTab(0);
		String tabName = tabNames[0];
		String fileName = "Pages/"+tabName+".html";   	
   	GetFileContents(fileName);

		
		//final TabNames tn = new TabNames();
		
	// Hook up a tab listener to do something when the user selects a tab.
		menuBar.addSelectionHandler(new SelectionHandler() 
		{
	      public void onSelection(SelectionEvent event) 
	      {
	        // Let the user know what they just did.
	       // Window.alert("You clicked tab " + event.getSelectedItem());
	      //	event.getSelectedItem().getClass().getName();
	      	//menuBar.getTab(1).toString();
	      	
	      	leftPanel.clear();
	      	leftPanel.setHeight("100%");
	      	
	      	String tabName = tabNames[Integer.parseInt(event.getSelectedItem().toString())];
	      	
	      	//String tabName = GetTabName(Integer.parseInt(event.getSelectedItem().toString()));
	      	
	      //	RootPanel.get().add(new HTML(event.getSource().toString()));
	      //	RootPanel.get().add(new HTML(event.getSelectedItem().getClass().getName()));
	      //	contentPanel.getWidget(4).removeFromParent();
	      //	contentPanel.add(new HTML(""),DockPanel.CENTER);
	      //	contentPanel.getWidget(4).setHeight("100%");
	      //	contentPanel.getWidget(4).setWidth("824px");
	      //	contentPanel.getWidget(4).setStyleName("Content");
	      	String fileName = "Pages/"+tabName+".html";
	      	
	      	GetFileContents(fileName);
	      }

			
	    });
		
		menuBar.addStyleName("menuBar");
		
		//============================
		
		
	/*	StackPanel menuPanel = new StackPanel();
		
		menuPanel.add(new Label("Test"),"test");
		menuPanel.add(new Label("Two"),"two");
		//menuPanel.add(new Hyperlink("test",""),"tester");
		
		menuPanel.add(new HTML("<a href='test'>Test</a><br><a href='test'>Test2</a>"),"tester");*/
		
		
		
		/**
		 * Content Panel 
		 */
		
		contentPanel.setSize("1024px", "100%");
		contentPanel.setHorizontalAlignment(DockPanel.ALIGN_CENTER);
		contentPanel.setVerticalAlignment(DockPanel.ALIGN_TOP);
		//contentPanel.setBorderWidth(1);	

		//===Heading(0)===
		contentPanel.add(new HTML("<img src='images/web_page/Noi_Rouge_Banner.jpg'>"), DockPanel.NORTH);		
		contentPanel.getWidget(0).addStyleName("Heading");
		contentPanel.getWidget(0).setHeight("180px");
		//contentPanel.getWidget(0).
		//=============
		
		//===Menu Bar(1)===
		contentPanel.add(menuBar, DockPanel.NORTH);
		contentPanel.getWidget(1).setHeight("35px");
		//==============		
		
		//===Left Panel(2)===			
	   contentPanel.add(leftPanel, DockPanel.WEST);
		contentPanel.getWidget(2).setWidth("160px");	
		contentPanel.getWidget(2).addStyleName("leftPanel");
		
		//===================
		
		//===Right Panel(3)===
		contentPanel.add(new HTML(""), DockPanel.EAST);
		contentPanel.getWidget(3).setWidth("200px");
		contentPanel.getWidget(3).addStyleName("rightPanel");
		//================
		
		//===Bottom Panel(4)===
		contentPanel.add(new Label(""), DockPanel.SOUTH);
		contentPanel.getWidget(4).setHeight("0px");
		contentPanel.addStyleName("bottomBar");
		//================
		
		//===Content(5)===			
		centerPanel.setStyleName("Content");
		contentPanel.add(centerPanel, DockPanel.CENTER);		
		contentPanel.getWidget(5).setStyleName("Content");
		//=============
		
		
		//===Menu Bar(6)===
	/*	contentPanel.add(new HTML(), DockPanel.SOUTH);
		contentPanel.getWidget(6).setHeight("0px");
		contentPanel.addStyleName("bottomBar");*/
		//==============
		
		//=============================================
		
	// Initialize the service proxy.
	    if (loadFileService == null) 
	    {
	   	 loadFileService = GWT.create(NoiRougeService.class);
	    }	   
	    
	    // Set up the callback object.
	    AsyncCallback<Void> sendmail = new AsyncCallback<Void>() 
	    {
	      public void onFailure(Throwable caught) 
	      {
	        // TODO: Do something with errors.
	      }
	      
			public void onSuccess(Void result)
			{
				// TODO Auto-generated method stub
				
			}
	    }; 
	    
	    loadFileService.sendEmail("rynomyburgh@gmail.com", "Ryno Myburgh", "<b>The webpage got accessed!</b> <br><br> <img src='www.noirougeevents.com/images/web_page/Noi_Rouge_email.jpg'>", "Test email", sendmail);
	    
		//==============================================
		
		
		contentPanel.addStyleName("contentPanel");
		RootPanel.get("Main").add(contentPanel);
		
		

		// We can add style names to widgets
		//sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		//RootPanel.get("nameFieldContainer").add(nameField);
		//RootPanel.get("sendButtonContainer").add(sendButton);

		// Focus the cursor on the name field when the app loads
	//	nameField.setFocus(true);
	//	nameField.selectAll();

		// Create the popup dialog box
	/*	final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);*/

		// Add a handler to close the DialogBox
	/*	closeButton.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});*/

		// Create a handler for the sendButton and nameField
	/*	class MyHandler implements ClickHandler, KeyUpHandler
		{
		
			public void onClick(ClickEvent event)
			{
				sendNameToServer();
			}

			
			public void onKeyUp(KeyUpEvent event)
			{
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER)
				{
					sendNameToServer();
				}
			}*/

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
		/*	private void sendNameToServer()
			{
				sendButton.setEnabled(false);
				String textToServer = nameField.getText();
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer,
									new AsyncCallback<String>()
									{
										public void onFailure(Throwable caught)
										{
											// Show the RPC error message to the user
											dialogBox
																.setText("Remote Procedure Call - Failure");
											serverResponseLabel
																.addStyleName("serverResponseLabelError");
											serverResponseLabel.setHTML(SERVER_ERROR);
											dialogBox.center();
											closeButton.setFocus(true);
										}

										public void onSuccess(String result)
										{
											dialogBox.setText("Remote Procedure Call");
											serverResponseLabel
																.removeStyleName("serverResponseLabelError");
											serverResponseLabel.setHTML(result);
											dialogBox.center();
											closeButton.setFocus(true);
										}
									});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);*/
	}
	
	
	 
	private NoiRougeServiceAsync loadFileService = GWT.create(NoiRougeService.class);

	private void GetFileContents(String pageName)
	{		
		 // Initialize the service proxy.
	    if (loadFileService == null) 
	    {
	   	 loadFileService = GWT.create(NoiRougeService.class);
	    }

	    // Set up the callback object.
	    AsyncCallback<String> callback = new AsyncCallback<String>() 
	    {
	      public void onFailure(Throwable caught) 
	      {
	        // TODO: Do something with errors.
	      }

	      public void onSuccess(String result) 
	      {		      	     	
	      	contentHtml.setHTML(result);	 
	      	
	      	if (result.indexOf("About Noi Rouge Events")> 0)
	      	{
	      		AboutPage();
	      	}
	      }
	    };  	 	  
	   
	    if (pageName.indexOf("Contact Us") > 0)
	    {
	   	 centerPanel.clear();
	   	 centerPanel.setStyleName("Content");
	   	 ContactUs cu = new ContactUs();
	   	 centerPanel.add(cu.inetPage(centerPanel),DockPanel.CENTER);
	   	// contentPanel.add(centerPanel, DockPanel.SOUTH);
	    }
	    else if (pageName.indexOf("About Us") > 0)
	    {
	   	 centerPanel.clear();
	   	 centerPanel.setStyleName("Content");
	   	 centerPanel.add(contentHtml,DockPanel.CENTER);
	   	 loadFileService.getFileContent("Pages/Weddings.html", callback);
	    }
	    else
	    {
	   	 centerPanel.clear();
	   	 centerPanel.setStyleName("Content");
	   	 centerPanel.add(contentHtml,DockPanel.CENTER);
	   	 loadFileService.getFileContent(pageName, callback);
	    }
	    
	    //store data
	  
	  AsyncCallback<Void> datacallback = new AsyncCallback<Void>() 
	    {
	      public void onFailure(Throwable caught) 
	      {
	        // TODO: Do something with errors.
	      }

	      public void onSuccess(Void result) 
	      {		      	     	
	      	 // TODO: Do something with result.
	      }
	    };  
	    
	    loadFileService.setData(pageName, pageName, datacallback);
       
       //============

	    
		
	}
	
	

	
		
	
	/**
	 * @param name 
	 */
	public void addTab(String name)
	{
		menuBar.addTab(name);
		tabNames[menuBar.getTabCount()-1] = name;
	}
	
	
	@SuppressWarnings("deprecation")
	public void AboutPage()
	{
				
		/*Hyperlink wed = new Hyperlink("Weddings","");
			
		wed.addClickHandler(new ClickHandler()
		{

			public void onClick(ClickEvent event)
			{
				// TODO Auto-generated method stub
				GetFileContents("Pages/About Us.html");
			}

		});
		
		Hyperlink func = new Hyperlink("Functions","");
		
		func.addClickHandler(new ClickHandler()
		{

			public void onClick(ClickEvent event)
			{
				// TODO Auto-generated method stub
				GetFileContents("Pages/Corporate Functions.html");
			}

		});*/
		
		Hyperlink weddings = getHyperlink("Weddings");
		Hyperlink cFunctions = getHyperlink("Corporate Functions");
		Hyperlink anniversary = getHyperlink("Anniversary Parties");
		Hyperlink birthday = getHyperlink("Birthday Parties");
		Hyperlink yearend = getHyperlink("Yearend Functions");
		
		if (leftPanel.getWidgetCount() == 0)
		{
			
			
			leftPanel.setWidth("160px");
			
			leftPanel.setVerticalAlignment(leftPanel.ALIGN_TOP);
			
		VerticalPanel lp = new VerticalPanel();	
		
			
		//leftPanel.add(new HTML("<br>"));
		lp.add(weddings);
		lp.add(cFunctions);
		lp.add(yearend);
		lp.add(birthday);
		lp.add(anniversary);
		
		leftPanel.add(lp);
		
		leftPanel.setHeight("100%");
			
		
		}
		

		
	//	menuPanel.add(wedding,"About");
	//	menuPanel.add(function,"Functions");
		
		
		
		
	}
	
	//String glinkname = "";
	@SuppressWarnings("deprecation")
	private Hyperlink getHyperlink(String displayName)
	{
		//glinkname = filename;
		Hyperlink link = new Hyperlink(displayName,"");
		
		link.addClickHandler(new ClickHandler()
		{

			public void onClick(ClickEvent event)
			{
				String x = event.getSource().toString();
				//String y = event.getSource().getClass().getSimpleName();
				
				String linkname = "";
				if (x.indexOf("</a>") > 0)
				{
					for (int i = x.lastIndexOf("<a href="+'"'+"#"+'"'+">") + 12; i < x.lastIndexOf("</a>"); i++)
					{
						linkname = linkname + x.charAt(i);
					}
				}
				else
				{
					for (int i = x.lastIndexOf("<A href="+'"'+"#"+'"'+">") + 12; i < x.lastIndexOf("</A>"); i++)
					{
						linkname = linkname + x.charAt(i);
					}
				}
				//displayDialog("Pages/"+linkname+".html" + x);
				// TODO Auto-generated method stub
				GetFileContents("Pages/"+linkname+".html");
			}

		});
		
		return link;
		
	}
	
	final DialogBox dialogBox = new DialogBox();
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
