package test;

import bean.ReqXmlBean;
import bean.ReqXmlHead;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import util.MyRandomUtil;
import util.XmlBeanTransfer;

import java.io.File;
import java.util.List;

/**
 * 测试
 *
 * @Authuor Administrator
 * @Create 2016-09-07-15:24
 */
public class MyTest {
    public static void main(String[] args) throws DocumentException {
        System.out.println(MyRandomUtil.randomString(15));
        File file = new File("innertrans.xml");
        SAXReader reader = new SAXReader();
        Document doc = reader.read(file);
        ReqXmlHead head = new ReqXmlHead();
        List<ReqXmlHead> list = new XmlBeanTransfer().xmlToBean(head ,doc.getRootElement().asXML());
        for(ReqXmlHead r : list){
            System.out.println(r.getAtom_tr_count()+"\t" + r.getChannel() + "\t" + r.getReq_no());
        }
    }
}
