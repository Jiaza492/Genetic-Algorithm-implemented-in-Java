package latlongtrans;


//�����򣬴��������У�wrin�������ַ��Lati����ת����γ�ȣ�address���𴢴澭γ�ȣ�wrout�������excel

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

public class wrout extends address{

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//
//	//	String fileName = "d:" + File.separator + "test.xls";
//	//	System.out.println(wrout.readExcel(fileName));
//		String fileName1 = "d:" + File.separator + "bcd.xls";
//		wrout.writeExcel(fileName1);
//	}

	
	/**
	 * �у��݌���excel�ļ���
	 * 
	 * @param fileName
	 *            Ҫ������ļ������Q
	 */
	public static void writeExcel(String fileName) {
		
		WritableWorkbook wwb = null;
		try {
			// ����Ҫʹ��Workbook��Ĺ�����������һ����д��Ĺ�����(Workbook)����
			wwb = Workbook.createWorkbook(new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (wwb != null) {
			// ����һ����д��Ĺ�����
			// Workbook��createSheet������������������һ���ǹ���������ƣ��ڶ����ǹ������ڹ������е�λ��
			WritableSheet ws = wwb.createSheet("sheet1", 0);

			// ���濪ʼ��ӵ�Ԫ��
			wrin ggg=new wrin();//**�����ǵ���D�̵�test�ļ���wrin������
			wrin.main(tj);
		String jww;
		

			//int j=0;int k=0;
			//int[] ag = new int[tj.length]; 
	    	//int[] bg = new int[tw.length]; 
			// for (k=0;k<=20;k++)
			 // {	
				// ag[k]=Integer.parseInt(tj[k]);
			 // bg[k]=Integer.parseInt(tw[k]);
				// }
			for (int i = 0; i < tm; i++) {
				
				for (int j1 = 0; j1 < 2; j1++) {
					// ������Ҫע����ǣ���Excel�У���һ��������ʾ�У��ڶ�����ʾ��
					Label labelC = new Label(0, i, tj[i]);
					Label labelD =new  Label(1, i, tw[i]);
				
					
					try {
						// �����ɵĵ�Ԫ����ӵ���������
						ws.addCell(labelC);
						ws.addCell(labelD);
					} catch (RowsExceededException e) {
						e.printStackTrace();
					} catch (WriteException e) {
						e.printStackTrace();
					}

				}
			}

			try {
				// ���ڴ���д���ļ���
				wwb.write();
				// �ر���Դ���ͷ��ڴ�
				wwb.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}
	}

	public void jw(String st[]) {   //jw[]ȡ����γ��
		String[] jw=new String[999];
		int j=0;
		for (j=0;j<=tm;j++){
		jw[j]=st[j];
		//System.out.println("jwd : "+j+"==="+jw[j]);
		}
}
}


