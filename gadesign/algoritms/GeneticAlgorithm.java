package gadesign.algoritms;

import gadesign.populations.Population;

/**
 * 
 * @author Jia Ziang
 * @see ziangj92@gmail.com
 * @since 06/01/2014
 * @version 1.0
 *
 */

public class GeneticAlgorithm {

	// ѡ������,�Ը��������������Ӵ�����
	public Population select(Population parentPop) {
		Population cp = new Population();
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
			// System.out.println("����Ⱦɫ����ۻ�ѡ����ʣ�"+cumulativePos[j]);
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
		// System.out.println("�Ӵ�����Ⱥ��СΪ��"+cp.getPopNum());
		return cp;
	}

	// ����GAʵ��,��ʵ������������±���
	public OverallBest singleGaAlgorithm(InitialParameters param) {
		// ����һ�ε���ʵ�鲢��������ʱ��
		long startTime = System.currentTimeMillis();// ��ʼ��ʱ��

		//Map<Integer, Population> popMap = new HashMap<Integer, Population>();// ����Map���洢ÿһ����Ⱦɫ��
		Population parentPop = new Population(param.getVariableDim(), param
				.getGenolength(), param.getPopNum());// ���ɵ�һ��Ⱦɫ�岢�洢
		//popMap.put(0, parentPop);
		OverallBest ob = new OverallBest();
		// ��ʼ�Ŵ��㷨����
		for (int i = 1; i <= param.getGeneration(); i++) {

			parentPop.cross(param.getCrossPos());// ����������
			parentPop.mutaion(param.getMutPos());// ����������
			Population sonpop = this.select(parentPop);// ������ѡ�񣬷����Ӵ�
			sonpop.setGeneration(i);// ���Ӵ���generation��ֵ
			//popMap.put(sonpop.getGeneration(), sonpop);// ���Ӵ�����Map

			// if (i >= 2000) {
			// if (sonpop.getBestIndividual().getFitness() == popMap.get(
			// i - 500).getBestIndividual()
			// .getFitness()) {
			// ob.setMaxGeneration(sonpop.getGeneration());
			// ob.setBestPhenotype(popMap.get(sonpop.getGeneration())
			// .getBestIndividual().getPhenotype());
			// ob.setBestGenotype(popMap.get(sonpop.getGeneration())
			// .getBestIndividual().getGenotype());
			// ob.setBestFtn(popMap.get(sonpop.getGeneration())
			// .getBestIndividual().getFitness());
			// break;
			// }
			// } else {
			if(Math.abs(parentPop.getBestIndividual().getFitness()-sonpop.getBestIndividual().getFitness())>0.01){
			System.out.println(sonpop.getBestIndividual().getFitness());
			}
			parentPop = sonpop;// ���Ӵ�����Ϊ������������һ��ѭ��
			
			if(Math.abs(parentPop.getBestIndividual().getFitness()+8)<0.001){
				System.out.println(parentPop.getGeneration());
				break;
			}
		}

		long stopTime = System.currentTimeMillis();// ����ʱ��
		ob.setBestPhenotype(parentPop.
//				popMap.get(param.getGeneration())
				getBestIndividual().getPhenotype()
				);
		ob.setBestGenotype(parentPop
//				popMap.get(param.getGeneration())
				.getBestIndividual().getGenotype());
		ob.setBestFtn(parentPop
//				popMap.get(param.getGeneration())
				.getBestIndividual()
				.getFitness());
		double time = stopTime - startTime;
		ob.setTime(time);
//		ob.setPopMap(popMap);
		ob.setMaxGeneration(param.getGeneration());

		// System.out.println("ȫ�����Ÿ���Ϊ��"
		// + "("
		// + ob.getBestPhenotype()[0]
		// + ","
		// + ob.getBestPhenotype()[1]
		// + ")"
		// + "\n"
		// + "ȫ������ֵ��"
		// + ob.getBestFtn() + "\n" + "�㷨����ʱ�䣺"
		// + ob.getTime());
		return ob;

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
