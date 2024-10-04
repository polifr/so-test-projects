package it.poli.xml.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CustomNameAdapter extends XmlAdapter<Object, Object> {
  @Override
  public Object unmarshal(Object v) {
    return null;
  }

  // During the writing of XML handle either simple String or List<String> and write name field
  @Override
  public Object marshal(Object name) throws Exception {
    System.out.println("Obtained Name Values : " + name);
    final Document document =
        DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

    if (name instanceof String) {
      final Element root = document.createElement("name");
      root.setTextContent((String) name);
      return root;
    } else if (name instanceof List) {
      final List<String> infoList = (List<String>) name;
      final Element root = document.createElement("namex");

      for (final String item : infoList) {
        final Element element = document.createElement("name");
        element.setTextContent(item);
        root.appendChild(element);
      }
      return root;
    }
    return null;
  }
}
