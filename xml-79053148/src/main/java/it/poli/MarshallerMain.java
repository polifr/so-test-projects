package it.poli;

import it.poli.model.Employee;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.List;

public class MarshallerMain {
  public static void main(String[] args) throws JAXBException {
    final Employee employee1 = new Employee("Name1");

    final List<String> names = new ArrayList<String>();
    names.add("one");
    names.add("two");
    names.add("three");

    final Employee employee2 = new Employee(names);

    final JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
    final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    System.out.println("Employee 1 Simple String : ");
    jaxbMarshaller.marshal(employee1, System.out);

    System.out.println("Employee 2 List of String : ");
    jaxbMarshaller.marshal(employee2, System.out);
  }
}
