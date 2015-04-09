package latlongtrans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class LatitudeUtils extends wrin {
	
	public static final String KEY_1 = "7d9fbeb43e975cd1e9477a7e5d5e192a";
	// String key2 = "8ec6cd98bd56554407a207d597c0f3e5";
	// String key3 = "be025dc280e1e3f7ffb95fe42a01fab2";
	// String key4 = "327db7009617d6806b9c38e819ea06ac";
	
	/**
	 * ���������ַ�ľ�γ������
	 * key lng(����),lat(γ��)
	 */
	public static Map<String,String> getGeocoderLatitude(String address){
		BufferedReader in = null;
		try {
			//����ַת����utf-8��16����
			address = URLEncoder.encode(address, "UTF-8");
//       ����д���Ҫ���ô���û�����ע��
//		System.setProperty("http.proxyHost","192.168.1.188");
//		System.setProperty("http.proxyPort","3128");
			URL tirc = new URL("http://api.map.baidu.com/geocoder?address="+ address +"&output=json&key="+ KEY_1);
			//��ȡ��ͼapi
			in = new BufferedReader(new InputStreamReader(tirc.openStream(),"UTF-8"));
			String res;
			StringBuilder sb = new StringBuilder("");
			while((res = in.readLine())!=null){
				sb.append(res.trim());//�ۻ��ַ�����trimȥ�ո�
			}
			String str = sb.toString();
			Map<String,String> map = null;
			if(!str.equals("")){
				int lngStart = str.indexOf("lng\":");
				int lngEnd = str.indexOf(",\"lat");
				int latEnd = str.indexOf("},\"precise");
				//------------------
				int cfdStart = str.indexOf("confidence");
				int cfdEnd = str.indexOf("level");
				if(lngStart > 0 && lngEnd > 0 && latEnd > 0){
					String lng = str.substring(lngStart+5, lngEnd);
					String lat = str.substring(lngEnd+7, latEnd);
					String cfd  = str.substring(cfdStart, cfdEnd);
					//--------------
				
					map = new HashMap<String,String>();
					map.put("confidence", cfd);
					map.put("lng", lng);
					map.put("lat", lat);//������ֵ��ֵ������
					return map;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static void main(String args[]) {
	
		String[] jwdj=new String[999];//����
		String[] jwdw=new String[999];//γ��
		int i=0;
		for (i=0;i<tm;i++){
		String mm=args[i];//��wrin��ȡ��ַ����
		Map<String, String> json = LatitudeUtils.getGeocoderLatitude(mm);//��ȡ��ַ
		System.out.println("�ص� : "+mm);
//if (json.get("lng") != null)
//continue;
		System.out.println("lng : "+json.get("lng"));
		System.out.println("lat : "+json.get("lat"));
	System.out.println("SSSSS: "+json.get("cfd"));
		jwdj[i]=json.get("lng");   //��γ������
		jwdw[i]=json.get("lat");
		System.out.println("jwd : "+jwdj[i]+jwdw[i]);
		address getjw=new address();
		getjw.main(jwdj,jwdw);
		//LatitudeUtils getjw=new LatitudeUtils();
		//getjw.jw(jwd);
		//ReadWriteExcelUtil c=new ReadWriteExcelUtil();
	//	ReadWriteExcelUtil.main(jwd);
		}
	
}
	public void jw(String st[]) {   //jw[]ȡ����γ��
		String[] jw=new String[999];
		int j=0;
		for (j=0;j<tm;j++){
		jw[j]=st[j];
		//System.out.println("jwd : "+j+"==="+jw[j]);
		}
	}
}