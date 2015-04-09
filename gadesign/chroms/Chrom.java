package gadesign.chroms;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jia Ziang
 * @see ziangj92@gmail.com
 * @since 06/01/2014
 * @version 1.0
 *
 */

public class Chrom {

	int variableDim;// ���߱���ά��
	int genolength;// ��λ���򳤶�
	double fitness;// ��Ⱦɫ�����Ӧֵ
	double fitPos;// ��Ⱦɫ�屻ѡ�н�����һ���ĸ���
	String genotype = null;// �ַ������飬�洢Ⱦɫ��Ļ����ͣ�{0,1}�ռ䣩
	double[] phenotype = null;// ˫�������飬�洢Ⱦɫ��ı����ͣ����߱����ռ䣩

	// ���췽��
	public Chrom() {

	}

	public Chrom(String genotype, int dim) {// ֱ�����ñ任�õ��ַ����鹹���Ӵ�Ⱦɫ�壬��Ҫָ������Dim����ɽ���
		this.genotype = genotype;
		this.genolength = genotype.length();
		this.phenotype = discode(genotype, dim);// ���ɶ�Ӧ�ı�����
		this.variableDim = this.phenotype.length;
		// System.out.println(this.genotype);
		calculateFitness();// ������Ӧ��ֵ
	}

	public Chrom(int variableDim, int genolength) {// �������ɳ���Ⱦɫ��
		this.genolength = genolength;
		this.variableDim = variableDim;
		this.genotype = initialChrom();
		discode();
		calculateFitness();
	}

	// ��ʼ��Ⱦɫ������
	public String initialChrom() {
		String gt = new String();
		for (int i = 0; i <= genolength - 1; i++) {
			if (Math.random() > 0.5) {
				gt += '1';
			} else {
				gt += '0';
			}
		}
		// System.out.println(new String(gt));
		return gt;
	}

	// ��֪������,�Լ�����ά��������Ⱦɫ�����ж�Ӧ�ı�����,ͨ��������ʹ�ñ����ͺͻ����Ͷ�Ӧ
	public double[] discode(String genotype, int variableDim) {
		double[] pt = null;
		List<Integer> tempVariable = new ArrayList<Integer>(variableDim);

		int percode = genolength / variableDim;// ÿ�ζ������ַ����ĳ��ȣ�������ʾһ������

		for (int i = 0; i <= variableDim - 1; i++) {
			tempVariable.add(Integer.parseInt(genotype.substring(percode * i,
					percode * (i + 1)), 2));// �ַ����ֶδ���ת��Ϊʮ��������
			// System.out.println(str.substring(percode*i, percode*(i+1)));
			// System.out.println(tempVariable[i]);
			// System.out.println(pt[i]);
		}

		pt = selftrans(tempVariable, percode);
		return pt;
	}

	// discode()��������
	void discode() {
		List<Integer> tempVariable = new ArrayList<Integer>(variableDim);
		int percode = genolength / variableDim;// ÿ�ζ������ַ����ĳ��ȣ�������ʾһ������

		for (int i = 0; i <= variableDim - 1; i++) {
			tempVariable.add(Integer.parseInt(genotype.substring(percode * i,
					percode * (i + 1)), 2));// �ַ����ֶδ���ת��Ϊʮ��������
			// System.out.println(str.substring(percode*i, percode*(i+1)));
			// System.out.println(tempVariable[i]);
			// System.out.println(pt[i]);
		}
		this.phenotype = selftrans(tempVariable, percode);
	}

	// ��֪�����ͣ��Լ����򳤶ȣ����ض�Ӧ�Ļ��������в��洢�ڻ������ַ������У�ͨ��������ʹ�û����ͺͱ����Ͷ�Ӧ
	public String code(double[] phenotype, int genolength) {
		String gt = new String();

		return gt;
	}

	// ������򣬶�Ⱦɫ����ÿ���ַ������в���������double�͵�ʮ���Ʊ����洢�ڱ����������У�����д�÷���
	double[] selftrans(List<Integer> tempVariable, int percode) {
		double[] variable = new double[tempVariable.size()];
		
		return variable;
	}

	// ���㱾Ⱦɫ�����Ӧֵ��������д
	void calculateFitness() {
		double ftn = 0;
		// ͨ������������û����͵���Ӧֵ
		
		this.fitness = ftn;
	}

	// ������������
	public double calculateFitness(double[] phenotype) {
		double ftn = 0;
		// ͨ������������û����͵���Ӧֵ
		
		return ftn;
	}

	public String getGenotype() {
		return genotype;
	}

	public int getVariableDim() {
		return variableDim;
	}

	public void setVariableDim(int variableDim) {
		this.variableDim = variableDim;
	}

	public int getGenolength() {
		return genolength;
	}

	public void setGenolength(int genolength) {
		this.genolength = genolength;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public double[] getPhenotype() {
		return phenotype;
	}

	public void setPhenotype(double[] phenotype) {
		this.phenotype = phenotype;
	}

	public void setGenotype(String genotype) {
		this.genotype = genotype;
	}

	public double getFitPos() {
		return fitPos;
	}

	public void setFitPos(double fitPos) {
		this.fitPos = fitPos;
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