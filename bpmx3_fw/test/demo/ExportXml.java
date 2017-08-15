package demo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.hotent.core.util.XmlBeanUtil;

public class ExportXml {

	/**
	 * @param args
	 * @throws JAXBException 
	 */
	public static void main(String[] args) throws JAXBException {
		ExportContainer container=new ExportContainer();
		
		List<Boy> listBoy=new ArrayList<Boy>();
		
		Boy boy1=new Boy("老王",2);
		Boy boy2=new Boy("老李",3);
		
		listBoy.add(boy1);
		listBoy.add(boy2);
		
		container.getMaps().put("boy", listBoy);
		
		List<Admin> listAdmin=new ArrayList<Admin>();
		
		Admin admin1=new Admin("zyg1", "男");
		Admin admin2=new Admin("zyg2", "男");
		
		listAdmin.add(admin1);
		listAdmin.add(admin2);
		
		container.getMaps().put("admin", listAdmin);
		
		
		
		String str= XmlBeanUtil.marshall(container, ExportContainer.class);
		
		System.out.println(str);

	}

}
