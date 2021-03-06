/*
 * GAparamFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package gadesign.TSPframes;

import gadesign.entitys.Station;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jia Ziang
 * @see ziangj92@gmail.com
 * @since 06/01/2014
 * @version 1.0
 *
 */

public class GAparamFrame extends javax.swing.JFrame {

	/** Creates new form GAparamFrame */
	public GAparamFrame() {
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		popNumberText = new javax.swing.JTextField();
		generationText = new javax.swing.JTextField();
		bgnCrossPosText = new javax.swing.JTextField();
		bgnMutPosText = new javax.swing.JTextField();
		Apply = new javax.swing.JButton();
		Default = new javax.swing.JButton();
		Back = new javax.swing.JButton();
		jLabel6 = new javax.swing.JLabel();
		geneLengthText = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("\u6bcf\u4ee3\u4e2a\u4f53\u6570");

		jLabel3.setText("\u6700\u5927\u9057\u4f20\u4ee3\u6570");

		jLabel4.setText("\u521d\u59cb\u4ea4\u53c9\u6982\u7387");

		jLabel5.setText("\u521d\u59cb\u53d8\u5f02\u6982\u7387");

		jLabel2.setText("GA\u53c2\u6570\u5de5\u5177\u7bb1");

		popNumberText.setText("20");
		

		generationText.setText("7000");

		bgnCrossPosText.setText("0.8");

		bgnMutPosText.setText("0.3");

		Apply.setText("\u5e94\u7528");
		Apply.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ApplyActionPerformed(evt);
			}
		});

		Default.setText("\u9ed8\u8ba4");
		Default.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DefaultActionPerformed(evt);
			}
		});

		Back.setText("\u8fd4\u56de");
		Back.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				BackActionPerformed(evt);
			}
		});

		jLabel6.setText("\u7b49\u4f4d\u57fa\u56e0\u957f\u5ea6");

		geneLengthText.setText("8");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(53, 53, 53)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jSeparator1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																232,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				Apply)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				Default)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				43,
																				Short.MAX_VALUE)
																		.addComponent(
																				Back))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel5)
																		.addGap(
																				65,
																				65,
																				65)
																		.addComponent(
																				bgnMutPosText,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				86,
																				Short.MAX_VALUE))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel4)
																						.addComponent(
																								jLabel6)
																						.addComponent(
																								jLabel3)
																						.addComponent(
																								jLabel1))
																		.addGap(
																				65,
																				65,
																				65)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								popNumberText,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								86,
																								Short.MAX_VALUE)
																						.addComponent(
																								geneLengthText,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								86,
																								Short.MAX_VALUE)
																						.addComponent(
																								generationText,
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								86,
																								Short.MAX_VALUE)
																						.addComponent(
																								bgnCrossPosText,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								86,
																								Short.MAX_VALUE))))
										.addGap(57, 57, 57)).addGroup(
								layout.createSequentialGroup().addGap(116, 116,
										116).addComponent(jLabel2)
										.addContainerGap(138, Short.MAX_VALUE)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(30, 30, 30)
										.addComponent(jLabel2)
										.addGap(27, 27, 27)
										.addComponent(
												jSeparator1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												10,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(46, 46, 46)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(
																popNumberText,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																26,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(42, 42, 42)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(
																generationText,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(41, 41, 41)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel6)
														.addComponent(
																geneLengthText,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(34, 34, 34)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel4)
														.addComponent(
																bgnCrossPosText,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(38, 38, 38)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel5)
														.addComponent(
																bgnMutPosText,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(49, 49, 49)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(Apply)
														.addComponent(Default)
														.addComponent(Back))
										.addContainerGap(72, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 * 
	 * @author Jia Ziang
	 * @see ziangj92@gmail.com
	 * @since 06/01/2014
	 * @version 1.0
	 *
	 */

	private void BackActionPerformed(java.awt.event.ActionEvent evt) {
		// 返回
		this.setVisible(false);
	}

	private void DefaultActionPerformed(java.awt.event.ActionEvent evt) {
		// 恢复默认值
	}

	private void ApplyActionPerformed(java.awt.event.ActionEvent evt) {
		// 保存参数设置

		Station.GENELENGTH = Integer.parseInt(geneLengthText.getText());
		Station.POP_NUM = Integer.parseInt(popNumberText.getText());
		Station.SEARCH_TIME = Integer.parseInt(generationText.getText());
		Station.CROSS_POS = Double.parseDouble(bgnCrossPosText.getText());
		Station.MUTA_POS = Double.parseDouble(bgnMutPosText.getText());

		JOptionPane.showMessageDialog(this, "参数保存成功！");
	}

	/**
	 * @param args the command line arguments
	 */
//	public static void main(String args[]) {
//		java.awt.EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				new GAparamFrame().setVisible(true);
//			}
//		});
//	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton Apply;
	private javax.swing.JButton Back;
	private javax.swing.JButton Default;
	private javax.swing.JTextField bgnCrossPosText;
	private javax.swing.JTextField bgnMutPosText;
	private javax.swing.JTextField geneLengthText;
	private javax.swing.JTextField generationText;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTextField popNumberText;
	// End of variables declaration//GEN-END:variables

}