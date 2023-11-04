package PojoClassPackage;

public class pojoClassForComplexData {
	
	String eName ;
	String eid ;
	int[] phno;
	
	public pojoClassForComplexData() {
		
	}
	
	public pojoClassForComplexData(String eName,String eid,int[] phno) {
		super();
		this.eName=eName;
		this.eid=eid;
		this.phno=phno;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public int[] getPhno() {
		return phno;
	}

	public void setPhno(int[] phno) {
		this.phno = phno;
	}
	
	
}
