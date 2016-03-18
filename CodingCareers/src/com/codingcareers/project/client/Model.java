package com.codingcareers.project.client;

import java.util.ArrayList;

public class Model{
	//TODO: - taskMan: TaskManager
	//		- userMan: UserManager
	private TaskManager taskMan;
	private UserManager userMan;
	
	//TODO: + lookup(val: String): String
	public String lookup(String val){
		return "lookup";
	}
	
	//TODO: + lookupUser(uname: String): String
	public String lookupUser(String uname){
		return "lookupUser";
	}
	//TODO: + createUser(uname:String, pword:String): String
	public String createUser(String uname, String pword){
		return "CreateUser";
	}
	//TODO: + updateProgress(progress: String):void
	public void updateProgress(String progress){
		return;
	}
	//TODO: + lookupTaskInfo(taskID: int): ArrayList<String>
	public ArrayList<String> lookupTaskInfo(int taskID){
		ArrayList<String> taskInfo = null;
		return taskInfo;
	}
	//TODO: + selectChar(choices: ArrayList<String>): String
	public String selectChar(ArrayList<String> choice){
		return "selectChar";
	}

}