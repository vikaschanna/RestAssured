package PojoClassPackage;

public class pojoClassForArrayInsideArray {
	String eName;
	String eId;
	int[] phones;
	Spouse spouse;
	
	public pojoClassForArrayInsideArray(String eName, String eId, int[] phones, PojoClassPackage.Spouse spouse) {
		super();
		this.eName = eName;
		this.eId = eId;
		this.phones = phones;
		this.spouse = spouse;
	}

	public pojoClassForArrayInsideArray() {
		
		
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public int[] getPhones() {
		return phones;
	}

	public void setPhones(int[] phones) {
		this.phones = phones;
	}

	public Spouse getSpouse() {
		return spouse;
	}

	public void setSpouse(Spouse Spouse) {
		this.spouse = Spouse;
	}
	
	
}
