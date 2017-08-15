package demo;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MacAddress {

	public static void main(String args[]) throws Exception{
		Set<String> list=getMacAddress();
		for(Iterator<String> it= list.iterator();it.hasNext();){
			String str=it.next();
			System.out.println(str);
		}
	}
	
	public static Set<String> getMacAddress() throws SocketException{
		Set<String> set=new HashSet<String>();
		Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
		while (e.hasMoreElements()){
			NetworkInterface ni = e.nextElement();
			byte[] mac = ni.getHardwareAddress();
			if (mac != null){
				System.out.println("displayname: " + ni.getDisplayName());
				String str=getLocalMac(mac);
				set.add(str);
			}
		}
		return set;
	}
	
	private static String getLocalMac(byte[] mac)  {
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<mac.length; i++) {
			if(i!=0) {
				sb.append("-");
			}
			//字节转换为整数
			int temp = mac[i]&0xff;
			String str = Integer.toHexString(temp);
			if(str.length()==1) {
				sb.append("0"+str);
			}else {
				sb.append(str);
			}
		}
		return sb.toString().toLowerCase();
	}

}
