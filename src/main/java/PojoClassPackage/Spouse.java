package PojoClassPackage;

public class Spouse {
	String sName;
	String sId;
	int[] phNo;
	
	public Spouse(String sName, String sId, int[] phNo) {
		super();
		this.sName = sName;
		this.sId = sId;
		this.phNo = phNo;
	}

	public Spouse() {
		
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public int[] getPhNo() {
		return phNo;
	}

	public void setPhNo(int[] phNo) {
		this.phNo = phNo;
	}
	
	
	
}
