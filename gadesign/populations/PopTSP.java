package gadesign.populations;

import gadesign.chroms.Chrom;
import gadesign.chroms.ChromTSP;
import gadesign.entitys.DataCon;
import gadesign.entitys.Tool;

import java.util.ArrayList;

/**
 * 
 * @author Jia Ziang
 * @see ziangj92@gmail.com
 * @since 06/01/2014
 * @version 1.0
 *
 */

public class PopTSP extends Population {

	DataCon dc;

	public PopTSP() {
		super();
	}

	public PopTSP(int dim, int genolength, int popNum, DataCon dc) {
		this.popNum = popNum;
		// this.chromPop = new ArrayList<Chrom>(popNum);
		// System.out.println("�״�Ⱥ��Ϊ��");
		this.dc = dc;
		this.chromPop = initialPop(dim, genolength);

	}

	@Override
	public void cross(double crossPosibility) {
		String parent1, parent2, son1, son2;
		int genolength = this.chromPop.get(0).getGenolength();
		int variableDim = this.chromPop.get(0).getVariableDim();
		// �Ըô��е�Ⱦɫ����н������
		// ���㽻�����
		// ������������
		for (int i = 0; i <= this.popNum - 1; i++) {
			if (Math.random() < crossPosibility) {
				double r = Math.random();
				int pos = (int) (Math.round(r * 1000)) % (genolength);// ȷ�����򽻲�λ��
				if (pos == 0) {
					pos = 1;
				}
				parent1 = this.chromPop.get(i).getGenotype();// ȷ������
				parent2 = this.chromPop.get((i + 1) % popNum).getGenotype();
				son1 = parent1.substring(0, pos) + parent2.substring(pos);// �����Ӵ��Ļ������ַ���
				son2 = parent2.substring(0, pos) + parent1.substring(pos);

				// ���Ӵ�ȫ�����뵽chromPop���ã�ͳһ��ѡ�����
				if (this.exsistChrom(son1) == false) {// �ж�son1�Ƿ��Ѵ���,�����ڣ���ִ���κβ���
					this.chromPop.add(new ChromTSP(son1, variableDim, this.dc));// ��д��
					// System.out.println("����µ��Ӵ����壺" + son1);
				} else {
					// System.out.println(son1 + "����Ⱥ�д��ڣ��������");
				}

				if (this.exsistChrom(son2) == false) {// �ж�son2�Ƿ��Ѵ���,�����ڣ���ִ���κβ���
					this.chromPop.add(new ChromTSP(son2, variableDim, this.dc));// ��д��
					// System.out.println("����µ��Ӵ����壺" + son2);
				} else {
					// System.out.println(son2 + "����Ⱥ�д��ڣ��������");
				}
			}
		}
		// System.out.println("�������Ⱥ��СΪ��" + this.chromPop.size());
	}

	@Override
	public void doublecross(double crossPosibility) {
		String parent1, parent2, son1, son2;
		int genolength = this.chromPop.get(0).getGenolength();
		int variableDim = this.chromPop.get(0).getVariableDim();
		// �Ըô��е�Ⱦɫ����н������
		// ˫�㽻�����
		// ��������
		for (int i = 0; i <= this.popNum - 1; i++) {
			if (Math.random() < crossPosibility) {
				int[] pos = new int[2];
				while (pos[0] != pos[1]) {
					double r1 = Math.random();
					pos[0] = (int) (Math.round(r1 * 1000)) % (genolength - 1);// ȷ�����򽻲�λ��
					if (pos[0] == 0) {
						pos[0] = 1;
					}
					double r2 = Math.random();
					pos[1] = (int) (Math.round(r2 * 1000)) % (genolength);
					if (pos[1] == 0) {
						pos[1] = 1;
					}
				}
				parent1 = this.chromPop.get(i).getGenotype();// ȷ������
				parent2 = this.chromPop.get((i + 1) % popNum).getGenotype();
				son1 = parent1.substring(0, pos[0])
						+ parent2.substring(pos[0], pos[1])
						+ parent1.substring(pos[1]);
				son2 = parent2.substring(0, pos[0])
						+ parent1.substring(pos[0], pos[1])
						+ parent2.substring(pos[1]);

				ChromTSP cTSP1 = new ChromTSP(son1, variableDim, this.dc);
				// ���Ӵ�ȫ�����뵽chromPop���ã�ͳһ��ѡ�����
				if (this.exsistChrom(son1) == false
						&& this.jugdePeoplNum(cTSP1.getPhenotype()) == true) {// �ж�son1�Ƿ��Ѵ���,�����ڣ���ִ���κβ���
					this.chromPop.add(cTSP1);// ��д��
					// System.out.println("����µ��Ӵ����壺" + son1);
				} else {
					// System.out.println(son1 + "����Ⱥ�д��ڣ��������");
				}

				ChromTSP cTSP2 = new ChromTSP(son2, variableDim, this.dc);
				if (this.exsistChrom(son2) == false
						&& this.jugdePeoplNum(cTSP2.getPhenotype()) == true) {// �ж�son2�Ƿ��Ѵ���,�����ڣ���ִ���κβ���
					this.chromPop.add(cTSP2);// ��д��
					// System.out.println("����µ��Ӵ����壺" + son2);
				} else {
					// System.out.println(son2 + "����Ⱥ�д��ڣ��������");
				}
			}
		}
	}

	@Override
	public ArrayList<Chrom> initialPop(int dim, int genolength) {
		ArrayList<Chrom> icp = new ArrayList<Chrom>();
		for (int i = 0; i <= this.popNum - 1; i++) {
			ChromTSP cr = null;
			cr = new ChromTSP(dim, genolength, this.dc);// ��д����
			//System.out.println(cr.getGenotype());
			while (this.jugdePeoplNum(cr.getPhenotype()) == false) {
				//System.out.println("��·����������");
				cr = new ChromTSP(dim, genolength, this.dc);
			}
			icp.add(cr);
			if (this.bestIndividual == null) {
				this.setBestIndividual(cr);
			}
			if (cr.getFitness() > this.bestIndividual.getFitness()) {
				this.setBestIndividual(cr);// �����Ÿ��帳ֵ
			}
		}
		return icp;
	}

	@Override
	public void mutaion(double mutationPosibility) {
		String mut, sub1, sub2;
		int genolength = this.chromPop.get(0).getGenolength();
		int variableDim = this.chromPop.get(0).getVariableDim();
		// �Ըô��е�Ⱦɫ����б������
		int chromNum;
		int genoNum;
		for (int i = 0; i <= popNum * genolength - 1; i++) {
			if (Math.random() <= mutationPosibility) {
				chromNum = (int) i / genolength;// ȷ��Ⱦɫ����
				genoNum = i % genolength;// ȷ��������
				// System.out.println("����ǰ"+this.chromPop.get(chromNum).getGenotype());
				sub1 = this.chromPop.get(chromNum).getGenotype().substring(0,
						genoNum);
				sub2 = this.chromPop.get(chromNum).getGenotype().substring(
						genoNum + 1);
				char gene = this.chromPop.get(chromNum).getGenotype().charAt(
						genoNum);// ȡ����Ҫ����Ļ���

				if (gene == '0') {// ����ȡ��
					gene = '1';
				} else if (gene == '1') {
					gene = '0';
				}
				mut = sub1 + gene + sub2;// ���ɱ�����Ⱦɫ��Ļ���������
				// System.out.print("����ǰ"
				// + this.chromPop.get(chromNum).getGenotype());
				// System.out.println("�����" + mut);

				ChromTSP cTSP = new ChromTSP(mut, variableDim, this.dc);
				if (this.exsistChrom(mut) == false
						&& this.jugdePeoplNum(cTSP.getPhenotype()) == true) {// �ж�mut�Ƿ��Ѵ���,�����ڣ���ִ�в���
					this.chromPop.add(cTSP);// �������ڣ���������Ⱦɫ�����Ⱥ����//��д��
					// System.out.println("��ӱ������壺" + mut);
				} else {
					// System.out.println("���������Ѵ��ڣ��������");
				}
			}
		}
		// System.out.println("�������Ⱥ��СΪ��" + this.chromPop.size());
	}

	public DataCon getDc() {
		return dc;
	}

	public void setDc(DataCon dc) {
		this.dc = dc;
	}

	private boolean jugdePeoplNum(double[] variables) {
		boolean falg = true;
		// ���������ÿ��·���ϵ�ѧ�������ܺ�
		//int count = 0;
		double temp;
		for (int j = 0; j <= variables.length - 1; j++) {
			if (variables[j] == 1.0) {
				temp = 0;
				int i = j+1;
				while (variables[i % variables.length] != 1.0) {
					temp = temp
							+ this.dc.getPeopleNum().get(
									(int) variables[i % variables.length] - 1);
					i++;
				}
				//count += 1;
				//System.out.print("��"+count+"��·��");
				//System.out.println(temp+",");
				if (temp > Tool.BUSCAP) {
					//System.out.println(temp);
					return false;
				}else{
					//System.out.println("��·�����У�");
				}
			}
			
		}
		//System.out.println();
		return falg;
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
