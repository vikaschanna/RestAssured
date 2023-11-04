package CRUDWithBDD;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClassPackage.pojoClassForArrayInsideArray;
import PojoClassPackage.pojoClassForComplexData;
import PojoClassPackage.pojoClassForSerializationAndDeserialization;

public class readEmpDetailsWithDeserialization {
	
	@Test
	public void read() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper oMap = new ObjectMapper();

		pojoClassForSerializationAndDeserialization pojo = 
				oMap.readValue(new File("./vikas.json"), pojoClassForSerializationAndDeserialization.class);
//		System.out.println(pojo.getEName());
//		System.out.println(pojo.getId());
//		System.out.println(pojo.getAge());
		System.out.println(pojo.EName);
		System.out.println(pojo.id);
		System.out.println(pojo.age);
	}
	
	@Test
	public void readComplexData() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper oMap = new ObjectMapper();
		
		pojoClassForComplexData pojo = oMap.readValue("./vikas1.json", pojoClassForComplexData.class);
		System.out.println(pojo.geteName());
		System.out.println(pojo.getEid());
		System.out.println(pojo.getPhno());
	}
	
	@Test
	public void readArrayInsideArray() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper();
		
		pojoClassForArrayInsideArray pojo = obj.readValue("./koushi.json", pojoClassForArrayInsideArray.class);
		System.out.println(pojo.geteName());
		System.out.println(pojo.geteId());
		System.out.println(pojo.getPhones()[0]);
		System.out.println(pojo.getSpouse().getsName());
		System.out.println(pojo.getSpouse().getsId());
		System.out.println(pojo.getSpouse().getPhNo()[0]);
		
	}
	
}
