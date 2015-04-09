package gadesign.algoritms;

import gadesign.entitys.DataCon;
import gadesign.populations.PopTSP;

/**
 * 
 * @author Jia Ziang
 * @see ziangj92@gmail.com
 * @since 06/01/2014
 * @version 1.0
 *
 */

public class TSPAlgorithm extends GeneticAlgorithm{

	//ѡ�񷽷�
	public PopTSP select(PopTSP parentPop) {
		PopTSP cp = new PopTSP();
		// �Ըô��е�Ⱦɫ�������ѡ�����
		double ftnSum = 0;
		for (int i = 0; i <= parentPop.getChromPop().size() - 1; i++) {// ���㸸��Ⱥ��������Ⱦɫ�����Ӧ��֮��
			ftnSum = ftnSum + parentPop.getChromPop().get(i).getFitness();
		}

		double[] cumulativePos = new double[parentPop.getChromPop().size()];// ���ۼƸ��ʸ�ֵ������
		for (int j = 0; j <= parentPop.getChromPop().size() - 1; j++) {// ��ÿ��Ⱦɫ������Ӧ��ѡ����ʺ��ۼƸ���
			parentPop.getChromPop().get(j).setFitPos(
					parentPop.getChromPop().get(j).getFitness() / ftnSum);
			if (j == 0) {
				cumulativePos[j] = parentPop.getChromPop().get(j).getFitPos();
			} else {
				cumulativePos[j] = cumulativePos[j - 1]
						+ parentPop.getChromPop().get(j).getFitPos();// �����۽�����
			}
			//System.out.println("����Ⱦɫ����ۻ�ѡ����ʣ�"+cumulativePos[j]);
		}

		// ����ͨ������Ӧ��������ѡ�������һ����Ⱦɫ��
		// �������̶ķ���ѡ������Ӵ���Ⱦɫ��
		for (int i = 0; i <= parentPop.getPopNum() - 2; i++) {
			double r = Math.random();// ����һ��0-1�������
			if (r <= cumulativePos[0]) {
				cp.getChromPop().add(parentPop.getChromPop().get(0));
				// System.out.println(parentPop.getChromPop().get(0).getGenotype()+"�ɹ���������һ��");
			} else {
				for (int j = 1; j < parentPop.getChromPop().size(); j++) {// ���԰��ۼƸ������ѡ�������һ����Ⱦɫ�壬ʵ�и������ű�������
					if (r <= cumulativePos[j]) {
						cp.getChromPop().add(parentPop.getChromPop().get(j));// ��ѡ�и�Ⱦɫ�壬�������뵽�Ӵ���
						// System.out.println(parentPop.getChromPop().get(j).getGenotype()+"�ɹ��������Ӵ�");
						break;
					}
				}
			}
		}

		cp.getChromPop().add(parentPop.getBestIndividual());// �����������Ÿ�����ӵ���һ��List��

		// ѭ�������Ӵ��е����Ÿ���
		for (int i = 0; i <= cp.getChromPop().size() - 1; i++) {
			if (cp.getBestIndividual() == null) {
				cp.setBestIndividual(cp.getChromPop().get(i));
			} else if (cp.getChromPop().get(i).getFitness() > cp
					.getBestIndividual().getFitness()) {
				cp.setBestIndividual(cp.getChromPop().get(i));
			}
		}

		cp.setPopNum(cp.getChromPop().size());// ���Ӵ���popNum��ֵ
		cp.setDc(parentPop.getDc());
		// System.out.println("�Ӵ�����Ⱥ��СΪ��"+cp.getPopNum());
		return cp;
	}
	
	/**
	 * 
	 * @author Jia Ziang
	 * @see ziangj92@gmail.com
	 * @since 06/01/2014
	 * @version 1.0
	 *
	 */
	
	public OverallBest singleGaAlgorithm(InitialParameters param, DataCon dc) {
		//����һ�ε���ʵ�鲢��������ʱ��
		long startTime = System.currentTimeMillis();// ��ʼ��ʱ��

		//Map<Integer, Population> popMap = new HashMap<Integer, Population>();// ����Map���洢ÿһ����Ⱦɫ��
		PopTSP parentPop = new PopTSP(param.getVariableDim(), param
				.getGenolength(), param.getPopNum(), dc);// ���ɵ�һ��Ⱦɫ�岢�洢
		//popMap.put(0, parentPop);
		// ��ʼ�Ŵ��㷨����
		PopTSP finalPop = null;
		for (int i = 1; i <= param.getGeneration(); i++) {

			parentPop.doublecross(param.getCrossPos());// ����������
			parentPop.mutaion(param.getMutPos());// ����������
			PopTSP sonpop = this.select(parentPop);// ������ѡ�񣬷����Ӵ�
			sonpop.setGeneration(i);// ���Ӵ���generation��ֵ
			//popMap.put(sonpop.getGeneration(), sonpop);// ���Ӵ�����Map
			parentPop = sonpop;// ���Ӵ�����Ϊ������������һ��ѭ��
			finalPop = sonpop; 
			System.out.println("��"+i+"��");

		}

		long stopTime = System.currentTimeMillis();// ����ʱ��
//		double[] bestPhtp = popMap.get(param.getGeneration())
//				.getBestIndividual().getPhenotype();
//		String bestGntp = popMap.get(param.getGeneration())
//		.getBestIndividual().getGenotype();
//		double bestFtn = popMap.get(param.getGeneration()).getBestIndividual().getFitness();
		double time = stopTime - startTime;
//		OverallBest ob = new OverallBest(bestPhtp, bestGntp, bestFtn, time);
//		ob.setPopMap(popMap);
		double[] bestPhtp = finalPop.getBestIndividual().getPhenotype();
		String bestGntp = finalPop.getBestIndividual().getGenotype();
		double bestFtn = finalPop.getBestIndividual().getFitness();
		OverallBest ob = new OverallBest(bestPhtp, bestGntp, bestFtn, time);
//		System.out.println("ȫ�����Ÿ���Ϊ��"
//				+ "("
//				+ ob.getBestPhenotype()[0]
//				+ ","
//				+ ob.getBestPhenotype()[1]
//				+ ")"
//				+ "\n"
//				+ "ȫ������ֵ��"
//				+ ob.getBestFtn() + "\n" + "�㷨����ʱ�䣺"
//				+ ob.getTime());
		return  ob;

	
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
