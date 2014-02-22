package com.abc.kurtis.stores;



public class ListEmp {

	public ListEmp(){
		
	}
	
	private String Aid;
	private String Aforename;
	private String Asurname;
	private String Aemail;
	private String Aprivilege;
	private String Aidfault;
	
	public void setAuthortid(String id){
		Aid=id;
	}
	public String getAuthorid(){
		return Aid;
	}
	
	public void setForename(String forename){
		Aforename=forename;
	}
	public String getForename(){
		return Aforename;
	}
	
	public void setSurname(String surname){
		Asurname=surname;
	}
	public String getSurname(){
		return Asurname;
	}
	
	public void setEmail(String email){
		Aemail=email;
	}
	
	public String getEmail(){
		return Aemail;
	}
	
	public void setPrivilege(String privilege){
		Aprivilege=privilege;
	}
	public String getPrivilege(){
		return Aprivilege;
	}
	
	public void setFid(String idFault){
		Aidfault = idFault;
	}
	
	public String getFid(){
		return Aidfault;
	}
}
