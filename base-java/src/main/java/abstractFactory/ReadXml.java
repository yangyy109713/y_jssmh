package abstractFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URLDecoder;

public class ReadXml {
    public static Object getObject() {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
            Document doc;
            String path = Class.class.getClass().getResource("/").getPath();
            path = URLDecoder.decode(path, "utf-8");//路径中有空格，需要特殊处理，否则编译后获取不到
            doc = dBuilder.parse(new File(path + "abstractFactory/config.xml"));
            NodeList nl = doc.getElementsByTagName("className");
            Node cn = nl.item(0).getFirstChild();
            String ndName = "abstractFactory." + cn.getNodeValue();
            System.out.println("新类名：" + ndName);
            Class<?> c = Class.forName(ndName);
            Object object = c.newInstance();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
