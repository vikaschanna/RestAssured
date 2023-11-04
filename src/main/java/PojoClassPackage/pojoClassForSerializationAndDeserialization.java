package PojoClassPackage;

public class pojoClassForSerializationAndDeserialization {
	//declare
	public String EName;
	public String id;
	public int age;
	
	//crate a constructor to initialize the golbal variables
	public pojoClassForSerializationAndDeserialization(String eName, String id, int age) {
		super();
		this.EName = eName;
		this.id = id;
		this.age = age;
	}
	
	//to trigger for de-serialization
	public pojoClassForSerializationAndDeserialization() {
		
	}

	//to utilize using getters and setters
	

	public void setEName(String eName) {
		EName = eName;
	}

	

	public void setId(String id) {
		this.id = id;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	
}
