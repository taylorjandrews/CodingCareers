package com.codingcareers.project.client;

import java.util.ArrayList;

public class TaskManager{
	private RPCAsync rpc;
	
	
	// TODO: readInstruction(task: int): String
	public String readInstruction(int task){
		return "readInstruction";
	}
	
	// TODO: readTestCases(task: int):Array<String>
	public ArrayList<String> readTestCases(int task){
		ArrayList<String> testCases = null;
		testCases.add("readTestCases");
		return testCases;
	}
	
	// TODO: readDescription(task: int): String
	public String readDescrpition(int task){
		return "readDescription";
	}
	
	// TODO: readHint(task: int): String
	public String readHint(int task){
		return "readHint";
	}
}