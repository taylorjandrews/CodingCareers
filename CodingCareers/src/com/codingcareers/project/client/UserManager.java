package com.codingcareers.project.client;

import java.util.ArrayList;

public class UserManager{
	private RPCAsync rpc;
	
	
	//TODO:+ createAccount(uname: String, pword: String) :String
	public String createAccount(String uname, String pwd){
		return "createAccount";
	}
	
	//TODO:+ readInfo(info: String): String
	public String readInfo(String info){
		return "readInfo";
	}
	//TODO:+ updateProgress(progress: String): void
	public void updateProgress(String progress){
		return;
	}
	//TODO:+ updateChar(choices: ArrayList<String>): String
	public String updateChar(ArrayList<String> choices){
		return "updateChar"; 
	}
}