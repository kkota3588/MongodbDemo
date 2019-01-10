import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.jbhunt.beans.Employee;

public class Test {
public static void main(String args[]) {
	File xmlFile = new File("D://JBHunt//SPRING_TOOL_SUITE//SpringBoot_ReadXML//src//main//resources//data.xml");
	 
	JAXBContext jaxbContext;
	try
	{
	    jaxbContext = JAXBContext.newInstance(Employee.class);             
	 
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	 
	    Employee employee = (Employee) jaxbUnmarshaller.unmarshal(xmlFile);
	     
	    System.out.println(employee);
	}
	catch (JAXBException e)
	{
	    e.printStackTrace();
	}
}
}
