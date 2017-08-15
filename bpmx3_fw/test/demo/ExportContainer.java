package demo;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "bpm")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExportContainer {

	
	@XmlElement(name="objectMap")
	@XmlJavaTypeAdapter(MapAdapter.class) 
	private Map<String,Object> maps=new HashMap<String, Object>();

	public Map<String, Object> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}
	
	

}
