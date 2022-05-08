package com.managementsystem.model;

public class Team {
	private int teamID;
	private int teamLeaderID;
	private String teamName;
	private String teamLeader;
	private int numberDev;
	
//	public Team(String teamName,String teamLeader,int noDeveloper){
//		this.teamName=teamName;
//		this.teamLeader=teamLeader;
//		this.noDeveloper=noDeveloper;
//	}
	public int getTeamID(){
		return teamID;
	}
	
	public void setTeamID(int teamID){
	   this.teamID=teamID;
	}
	
	public int getTeamLeaderID(){
		return teamLeaderID;
	}
	
	public void setTeamLeaderID(int teamLeaderID){
	   this.teamLeaderID=teamLeaderID;
	}
	
	public String getTeamName(){
		return teamName;
	}
	
	public void setTeamName(String teamName){
	   this.teamName=teamName;
	}
	
	public String getTeamLeader(){
		return teamLeader;
	}
	
	public void setTeamLeader(String teamLeader){
	   this.teamLeader=teamLeader;
	}
	
	public int getNumberDev(){
		return numberDev;
	}
	
	public void setNumberDev(int numberDev){
	   this.numberDev=numberDev;
	}
}
