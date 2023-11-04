package CRUDWithBDD;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import PojoClassPackage.pojoClassForArrayInsideArray;
import PojoClassPackage.pojoClassForComplexData;
import PojoClassPackage.pojoClassForSerializationAndDeserialization;
import PojoClassPackage.Spouse;


public class createEmpWithSerialization {
	@Test
	public void create() throws JsonGenerationException, JsonMappingException, IOException {
	
	ObjectMapper oMap = new ObjectMapper();
	pojoClassForSerializationAndDeserialization pojo = 
			new pojoClassForSerializationAndDeserialization("vikas", "v-001", 27);
	oMap.writerWithDefaultPrettyPrinter().writeValue(new File("./vikas.json"), pojo);
		
	}
	
	@Test
	public void createWithComplexData() throws Throwable, JsonMappingException, IOException {
		int[] ph= {1234,5678};
		
		ObjectMapper obj = new ObjectMapper();
		pojoClassForComplexData po = new pojoClassForComplexData("vikas", "ty", ph);
		obj.writerWithDefaultPrettyPrinter().writeValue(new File("./vikas1.json"), po);
	}
	
	@Test
	public void createWithArrayInsideArray() throws JsonGenerationException,
	JsonMappingException, IOException {
		int[] ephone= {12345,45321};
		int[] sphone= {98765,65789};
		Spouse s=new Spouse("kushi", "s-001", sphone);
		ObjectMapper obj = new ObjectMapper();
		pojoClassForArrayInsideArray pojo = new pojoClassForArrayInsideArray("koushi", "k-001", ephone, s);
		obj.writerWithDefaultPrettyPrinter().writeValue(new File("./koushi.json"), pojo);
	}
	
}
