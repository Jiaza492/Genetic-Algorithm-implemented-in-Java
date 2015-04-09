package gadesign.mapinfos.impls;

import gadesign.entitys.utils.ODdata;
import gadesign.entitys.utils.Place;
import gadesign.mapinfos.MapInfo;
import gadesign.mapinfos.OrigDestString;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 
 * @author Jia Ziang
 * @see ziangj92@gmail.com
 * @since 06/01/2014
 * @version 1.0
 *
 */

public class MapInfoImpl implements MapInfo {

	OrigDestString ods;
	
	public MapInfoImpl(String key){
		this.ods = new OrigDestString(key);
	}
	
	//���ùؼ���
	public ODdata mapInfoRequest(String origin, String destination) {

		ODdata od = null;

		try {
			od = new ODdata();
			URL url = new URL(ods.requestURL(origin, destination));// ��ʼ��һ��URL����

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();// �õ�һ��Dom����ʵ��
			DocumentBuilder db = dbf.newDocumentBuilder();// �ӹ������Dom������

			InputStream is = url.openStream();// ��URL������������

			Document doc = db.parse(is);// ��������������������һ��Dom��

			// ��Dom�����в��������Map���ݣ�������֮��ʱ��Ϊ��
			NodeList durlist = doc.getElementsByTagName("duration");// ��ȡduration�ڵ��б�
			Element durelement = (Element) durlist.item(0);// ��ȡ�б��е�һ���ڵ㣬����ת��
			String duration = durelement.getFirstChild().getNodeValue();// ��ȡDur�ڵ�ĵ�һ���ӽڵ��ֵ
			od.setTime(Double.parseDouble(duration));
			//System.out.println(duration);

			// ������֮�����Ϊ��
			NodeList distlist = doc.getElementsByTagName("distance");
			Element distelement = (Element) distlist.item(0);
			String distance = distelement.getFirstChild().getNodeValue();
			od.setDistance(Double.parseDouble(distance));
			//System.out.println(distance);

			// ������֮��·������Ϊ��
//			List<String[]> path = new ArrayList<String[]>();
//			NodeList pathlist = doc
//					.getElementsByTagName("stepDestinationLocation");
//			for (int i = 0; i <= pathlist.getLength() - 1; i++) {
//				Element pathelement = (Element) pathlist.item(i);
//				String[] location = new String[2];
//				//lng
//				NodeList lngList = pathelement.getElementsByTagName("lng");
//				Element lngelement = (Element)lngList.item(0);
//			    String lng = lngelement.getFirstChild().getNodeValue();
//				location[0] = lng;
//				//System.out.println(lng);
//				//lat
//				NodeList latList = pathelement.getElementsByTagName("lat");
//				Element latelement = (Element)latList.item(0);
//			    String lat = latelement.getFirstChild().getNodeValue();
//			    location[1] = lat;
//				//System.out.println(lat);
//				//String[]
//				path.add(location);
//				}
//				// path.add(position);
//				//System.out.println(name);
//			
//			od.setPath(path);
//			
			is.close();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("��ȡXml����");;
		}

		return od;

	}
	
	//���þ�γ��
	public ODdata mapInfoRequest(Place origin, Place destination) {

		ODdata od = null;

		try {
			od = new ODdata();
			URL url = new URL(ods.requestURL(origin, destination));// ��ʼ��һ��URL����

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();// �õ�һ��Dom����ʵ��
			DocumentBuilder db = dbf.newDocumentBuilder();// �ӹ������Dom������

			InputStream is = url.openStream();// ��URL������������

			Document doc = db.parse(is);// ��������������������һ��Dom��

			// ��Dom�����в��������Map���ݣ�������֮��ʱ��Ϊ��
			NodeList durlist = doc.getElementsByTagName("duration");// ��ȡduration�ڵ��б�
			Element durelement = (Element) durlist.item(0);// ��ȡ�б��е�һ���ڵ㣬����ת��
			String duration = durelement.getFirstChild().getNodeValue();// ��ȡDur�ڵ�ĵ�һ���ӽڵ��ֵ
			od.setTime(Double.parseDouble(duration));
			//System.out.println(duration);

			// ������֮�����Ϊ��
			NodeList distlist = doc.getElementsByTagName("distance");
			Element distelement = (Element) distlist.item(0);
			String distance = distelement.getFirstChild().getNodeValue();
			od.setDistance(Double.parseDouble(distance));
			//System.out.println(distance);

			// ������֮��·������Ϊ��
//			List<String[]> path = new ArrayList<String[]>();
//			NodeList pathlist = doc
//					.getElementsByTagName("stepDestinationLocation");
//			for (int i = 0; i <= pathlist.getLength() - 1; i++) {
//				Element pathelement = (Element) pathlist.item(i);
//				String[] location = new String[2];
//				//lng
//				NodeList lngList = pathelement.getElementsByTagName("lng");
//				Element lngelement = (Element)lngList.item(0);
//			    String lng = lngelement.getFirstChild().getNodeValue();
//				location[0] = lng;
//				//System.out.println(lng);
//				//lat
//				NodeList latList = pathelement.getElementsByTagName("lat");
//				Element latelement = (Element)latList.item(0);
//			    String lat = latelement.getFirstChild().getNodeValue();
//			    location[1] = lat;
//				//System.out.println(lat);
//				//String[]
//				path.add(location);
//				}
//				// path.add(position);
//				//System.out.println(name);
//			
//			od.setPath(path);
//			
			is.close();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("��ȡXml����");;
		}

		return od;

	}
}

/**
 * 
 * @author Jia Ziang
 * @see ziangj92@gmail.com
 * @since 06/01/2014
 * @version 1.0
 *
 */
