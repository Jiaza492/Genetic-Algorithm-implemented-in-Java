package gadesign.populations;

 /**
 * 
 * @author Jia Ziang
 * @see ziangj92@gmail.com
 * @since 06/01/2014
 * @version 1.0
 *
 */
import gadesign.chroms.Chrom;

import java.util.ArrayList;
import java.util.List;

public class Population {

	Chrom bestIndividual = null;// ÿһ�����������Ⱦɫ��
	int generation = 0;// ������־
	int popNum;// ÿһ����Ⱦɫ������
	double mutationPosibility;// �ô��ı������
	double crossPosibility;// �ô��Ľ������
	List<Chrom> chromPop = null;// Population���飬���ڴ洢�����е�Ⱦɫ��

	// ���췽��
	public Population() {
		this.chromPop = new ArrayList<Chrom>();
	}

	public Population(Population pop) {
		this.chromPop = pop.getChromPop();
		this.popNum = pop.getChromPop().size();
		this.bestIndividual = pop.getBestIndividual();

	}

	public Population(int dim, int genolength, int popNum) {
		this.popNum = popNum;
		// this.chromPop = new ArrayList<Chrom>(popNum);
		//System.out.println("�״�Ⱥ��Ϊ��");
		this.chromPop = initialPop(dim, genolength);
	}

	// ��ʼ���״�Ⱦɫ��
	public ArrayList<Chrom> initialPop(int dim, int genolength) {
		ArrayList<Chrom> icp = new ArrayList<Chrom>();
		for (int i = 0; i <= this.popNum - 1; i++) {
			Chrom cr = new Chrom(dim, genolength);
			if (this.bestIndividual == null) {
				this.setBestIndividual(cr);
			}
			if (cr.getFitness() > this.bestIndividual.getFitness()) {
				this.setBestIndividual(cr);// �����Ÿ��帳ֵ
			}
			icp.add(cr);
		}
		return icp;
	}

	// Ⱦɫ��������������һ��������Ⱦɫ��
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

				if (this.exsistChrom(mut) == false) {// �ж�mut�Ƿ��Ѵ���,�����ڣ���ִ�в���
					this.chromPop.add(new Chrom(mut, variableDim));// �������ڣ���������Ⱦɫ�����Ⱥ����
					// System.out.println("��ӱ������壺" + mut);
				} else {
					// System.out.println("���������Ѵ��ڣ��������");
				}
			}
		}
		// System.out.println("�������Ⱥ��СΪ��" + this.chromPop.size());
	}

	// ���㽻�����ӣ�Ⱦɫ�彻��������������ɵ��Ӵ�Ⱦɫ��
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

				if (this.exsistChrom(son1) == false) {// �ж�son1�Ƿ��Ѵ���,�����ڣ���ִ���κβ���
					this.chromPop.add(new Chrom(son1, variableDim));
					// System.out.println("����µ��Ӵ����壺" + son1);
				} else {
					// System.out.println(son1 + "����Ⱥ�д��ڣ��������");
				}

				if (this.exsistChrom(son2) == false) {// �ж�son2�Ƿ��Ѵ���,�����ڣ���ִ���κβ���
					this.chromPop.add(new Chrom(son2, variableDim));// ���Ӵ�ȫ�����뵽chromPop���ã�ͳһ��ѡ�����
					// System.out.println("����µ��Ӵ����壺" + son2);
				} else {
					// System.out.println(son2 + "����Ⱥ�д��ڣ��������");
				}
			}
		}
		// System.out.println("�������Ⱥ��СΪ��" + this.chromPop.size());
	}

	/**
	 * 
	 * @author Jia Ziang
	 * @see ziangj92@gmail.com
	 * @since 06/01/2014
	 * @version 1.0
	 *
	 */
	
	//˫�㽻������
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
					pos[1] = (int) (Math.round(r2 * 1000)) % (genolength);//��֤�ڶ�λ�ô��ڵ�һλ��
					if (pos[1] == 0) {
						pos[1] = 1;
					}
				}
				parent1 = this.chromPop.get(i).getGenotype();// ȷ������
				parent2 = this.chromPop.get((i + 1) % popNum).getGenotype();
				son1 = parent1.substring(0, pos[0])
						+ parent2.substring(pos[0], pos[1])
						+ parent1.substring(pos[1]);//ȷ���Ӵ�
				son2 = parent2.substring(0, pos[0])+parent1.substring(pos[0], pos[1])+parent2.substring(pos[1]);
				
				// ���Ӵ�ȫ�����뵽chromPop���ã�ͳһ��ѡ�����
				if (this.exsistChrom(son1) == false) {// �ж�son1�Ƿ��Ѵ���,�����ڣ���ִ���κβ���
					this.chromPop.add(new Chrom(son1, variableDim));// ��д��
					// System.out.println("����µ��Ӵ����壺" + son1);
				} else {
					// System.out.println(son1 + "����Ⱥ�д��ڣ��������");
				}

				if (this.exsistChrom(son2) == false) {// �ж�son2�Ƿ��Ѵ���,�����ڣ���ִ���κβ���
					this.chromPop.add(new Chrom(son2, variableDim));// ��д��
					// System.out.println("����µ��Ӵ����壺" + son2);
				} else {
					// System.out.println(son2 + "����Ⱥ�д��ڣ��������");
				}

			}
		}
	}

	
	// �ж�genotype������Ⱥ�����Ƿ��Ѵ��ڣ������ڷ���true���������ڣ�����false
	boolean exsistChrom(String genotype) {
		boolean judge = false;
		for (int j = 0; j <= this.chromPop.size() - 1; j++) {
			if (genotype.equals(this.chromPop.get(j).getGenotype())) {
				judge = true;
				// System.out.println("������ͬ��Ⱦɫ�壺"+this.chromPop.get(j).getGenotype());
			}
		}
		return judge;
	}

	public void selectbestindividual() {

	}

	public Chrom getBestIndividual() {
		return bestIndividual;
	}

	public void setBestIndividual(Chrom bestIndividual) {
		this.bestIndividual = bestIndividual;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public int getPopNum() {
		return popNum;
	}

	public void setPopNum(int popNum) {
		this.popNum = popNum;
	}

	public double getMutationPosibility() {
		return mutationPosibility;
	}

	public void setMutationPosibility(double mutationPosibility) {
		this.mutationPosibility = mutationPosibility;
	}

	public double getCrossPosibility() {
		return crossPosibility;
	}

	public void setCrossPosibility(double crossPosibility) {
		this.crossPosibility = crossPosibility;
	}

	public List<Chrom> getChromPop() {
		return chromPop;
	}

	public void setChromPop(List<Chrom> chromPop) {
		this.chromPop = chromPop;
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