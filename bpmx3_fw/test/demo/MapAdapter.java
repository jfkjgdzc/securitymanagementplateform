package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MapAdapter extends XmlAdapter<MapAdapter.Converter, Map<String, List<BaseModel>>>  {
    @XmlType(name = "Converter")  
    @XmlAccessorType(XmlAccessType.FIELD)  
    public static class Converter {
        @XmlTransient
        private List<MapEntry> entries = new ArrayList<MapEntry>();  

        public void addEntry(MapEntry entry) {  
            entries.add(entry);  
        }  

        @XmlElement(name = "entry")
        public List<MapEntry> getEntries() {  
            return entries;  
        }  

        public static class MapEntry {  

            private String key;  

            private List<BaseModel> value;  

            public MapEntry() {  
                super();  
            }  

            public MapEntry(Map.Entry<String, List<BaseModel>> entry) {  
                super();  
                this.key = entry.getKey();  
                this.value = entry.getValue();  
            }  

            public MapEntry(String key, List<BaseModel> value) {  
                super();  
                this.key = key;  
                this.value = value;  
            }  

            @XmlElement(name="objectName")
            public String getKey() {  
                return key;  
            }  

            public void setKey(String key) {  
                this.key = key;  
            }  

            @XmlElementWrapper(name = "objects")
            @XmlElement(name = "object")
            public List<BaseModel> getValue() {  
                return value;  
            }  

            public void setValue(List<BaseModel> value) {  
                this.value = value;  
            }  
        }  
    }

    @Override
    public Map<String, List<BaseModel>> unmarshal(Converter v) throws Exception {
        Map<String, List<BaseModel>> result = new HashMap<String, List<BaseModel>>();  
        for (Converter.MapEntry e : v.getEntries()) {  
            result.put(e.getKey(), e.getValue());  
        }  
        return result;  
    }

    @Override
    public Converter marshal(Map<String, List<BaseModel>> map) throws Exception {
        Converter convertor = new Converter();  
        for (Map.Entry<String, List<BaseModel>> entry : map.entrySet()) {  
            Converter.MapEntry e = new Converter.MapEntry(entry);  
            convertor.addEntry(e);  
        }  
        return convertor;  
    }
}
