package latlongtrans;



import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class wrin {
public static int tm;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		String fileName = "d:" + File.separator + "test.xls";
		System.out.println(wrin.readExcel(fileName));
	//	String fileName1 = "d:" + File.separator + "abc.xls";
	//	wrin.writeExcel(fileName1);
	}

	/**
	 * ��excel�ļ����xȡ���еă���
	 * 
	 * @param file
	 *            excel�ļ�
	 * @return excel�ļ��ă���
	 */
	public static String readExcel(String fileName) {
		String[] gege=new String[999];
		StringBuffer sb = new StringBuffer();
		Workbook wb = null;
		try {
			// ����Workbook��������������
			wb = Workbook.getWorkbook(new File(fileName));
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (wb == null)
			return null;

		// �����Workbook����֮�󣬾Ϳ���ͨ�����õ�Sheet��������������
		Sheet[] sheet = wb.getSheets();

		if (sheet != null && sheet.length > 0) {
			// ��ÿ�����������ѭ��
			for (int i = 0; i < sheet.length; i++) {
				// �õ���ǰ�����������
				int rowNum = sheet[i].getRows();
				tm= rowNum;
				System.out.println(tm);
				//------------------------------------------------
				for (int j = 0; j < rowNum; j++) {
					// �õ���ǰ�е����е�Ԫ��
					Cell[] cells = sheet[i].getRow(j);
					if (cells != null && cells.length > 0) {
						// ��ÿ����Ԫ�����ѭ��
						for (int k = 0; k < cells.length; k++) {
							// ��ȡ��ǰ��Ԫ���ֵ
							String cellValue = cells[k].getContents();
							gege[j]=cellValue;
							
							sb.append(k+"---"+j+gege[j]);//��ʾ
						}
					}
					sb.append("\r\n");
				}
				sb.append("\r\n");
			}
			LatitudeUtils.main(gege);
		}
		
		// ���ر���Դ���ͷ��ڴ�
		wb.close();
		return sb.toString();
	}
}