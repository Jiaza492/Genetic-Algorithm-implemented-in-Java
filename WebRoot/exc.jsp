<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
    <%@  page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ʹ��JSP��ȡTXT��ʽ�ļ�</title>
</head>

<body>

<%//�����Ƕ�ȡ����txt
String path="D:\\";  //Ŀ¼�ָ���������˫б��
File file=new File(path,"jing.txt");
FileReader fr=new FileReader(file);   //�ַ�������
BufferedReader br=new BufferedReader(fr);   //ʹ�ļ��ɰ��ж�ȡ�����л��幦��
StringBuffer strB=new StringBuffer();  //strB�����洢jsp.txt�ļ��������
String str=br.readLine();
String[] jd = new String[99];
String xx=str;
jd[0]=str;
//out.println(jd[0]);
int i=0;
//out.println(str);
while(str!=null){
// out.println(str);

 i=i+1;
 strB.append(str).append(i+"<br>"); //����ȡ�����ݷ���strB
jd[i]=str;
 str=br.readLine();
}
br.close();            //�ر�������
fr.close();
%>
<%//�����Ƕ�ȡγ��wei
String path2="D:\\";  //Ŀ¼�ָ���������˫б��
File file2=new File(path,"wei.txt");
FileReader fr2=new FileReader(file2);   //�ַ�������
BufferedReader br2=new BufferedReader(fr2);   //ʹ�ļ��ɰ��ж�ȡ�����л��幦��
StringBuffer strB2=new StringBuffer();  //strB�����洢jsp.txt�ļ��������
String[] wd = new String[99];
String str2=br2.readLine();
wd[0]=str2;
String xx2=str2;
int j=0;
//out.println(str);
while(str2!=null){
// out.println(str);
 j=j+1;
 strB2.append(str2).append(j+"<br>"); //����ȡ�����ݷ���strB
wd[j]=str2;
 str2=br2.readLine();
}
br2.close();            //�ر�������
fr2.close();
session.setAttribute("jdd",jd);
session.setAttribute("wdd",wd);
%>

<%=strB  %>
<%=strB2  %>
<%//String jdd=jd.toString();
//out.println(jdd);
 %>>
</body>
<a href="try1.jsp">gogogo</a>
<a href="ttt.jsp">go</a>
<script>

var jdd = <%=jd%>.toString();
document.write(jdd.toString())
//out.println(jdd);
//alert(jdd);


 var haha=<%=xx%>;
 var ha=<%=xx2%>
  alert(haha);
</script>

</form>

</html>