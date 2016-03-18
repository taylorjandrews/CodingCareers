package com.codingcareers.project.client;

import com.google.gwt.user.client.ui.HorizontalPanel;

public abstract class PageHeader extends HorizontalPanel implements PageComponent{
	private Controller controller;
	
	//TODO PageHeader Load()
	public abstract void load();
	//TODO PageHeader constructPanel
	public abstract void constructPanel();
	
	//TODO + setLoginState(loggedIn: boolean): void
	public void setLoginState(boolean loggedIn){
		return;
	}
	public void setUsername(String username){
		return;
	}
}
