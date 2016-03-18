package com.codingcareers.project.client;

import java.util.ArrayList;

public class PageBodyFactory {
	//TODO constants in Factory
	private int reward;
	private String instruction;
	private ArrayList<String> tests;
	private String solutions;
	private ArrayList<Integer> progress;
	private String profile;
	
	//TODO buildPageBody
	public PageBody buildPageBody(String pageType){
		return new TaskPageBody();
	};
	//TODO
	public void setRewards(int rewardAmount){
		return;
	}
	//TODO + setInstructions(instructions: String): void
	public void setInstructions(String instructions){
		return;
	}
	//TODO + setPreviousSolution(solution: String): void
	public void setPreviousSolution(String solution){
		return;
	}
	//TODO + setProgress(completedTasks: ArrayList<Integer>): void
	public void setProgress(ArrayList<Integer> completedTasks){
		return;
	}
	//TODO + setTestCases(testCases: ArrayList<String>): void
	public void setTestCases(ArrayList<String> testCases){
		return;
	}
	//TODO + setProfile(profile: String): void
	public void setProfile(String profile){
		return;
	}
	
}
