package Yuyin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class MyRecord6 extends JFrame implements MouseListener{
		 
		//����¼����ʽ
		AudioFormat af = null;
		//����Ŀ��������,���Դ��ж�ȡ��Ƶ����,�� TargetDataLine �ӿ��ṩ��Ŀ�������еĻ�������ȡ���������ݵķ�����
		TargetDataLine td = null;
		//����Դ������,Դ�������ǿ���д�����ݵ������С����䵱���Ƶ����Դ��Ӧ�ó�����Ƶ�ֽ�д��Դ�����У������ɴ����ֽڻ��岢�����Ǵ��ݸ���Ƶ����
		SourceDataLine sd = null;
		//�����ֽ��������������
		ByteArrayInputStream bais = null;
		ByteArrayOutputStream baos = null;
		//������Ƶ������
		AudioInputStream ais = null;
		//����ֹͣ¼���ı�־��������¼���̵߳�����
		Boolean stopflag = false;
		//��¼��ʼ¼����ʱ��
		long startPlay;
		//����һ�����ŵı�־
		Boolean playflag;
		//ÿ�α���������ļ���
		File tarFile = null;
		//������Ƶ����ÿ����ʾ���ֽ���
		int intBytes = 0;
		//����ÿ��¼����ʱ��ÿ����ȡ�ֽ�������Ƶ��
		byte audioDataBuffer[] = null;
		//��������Ҫ�����
		JPanel jp1,jp2,jp3;
		JLabel jl1=null;
		JButton captureBtn;
		//���û������̵߳���ֹ�ı�־
		boolean flag = true;
		//���岥��¼��ʱ��һ������ֵ
		int cnt;
		//���岥��¼��ʱһ����������
		byte btsPlay[] = null;
	 
		int gridx, gridy, gridwidth, gridheight, anchor, fill, ipadx, ipady;
		double weightx, weighty;
		Insets inset;
		GridBagConstraints c;
		
		public static void main(String[] args) {
			
		//����һ��ʵ��
		MyRecord6 mr = new MyRecord6();
			
		}
		//���캯��
		public MyRecord6()
		{
			//�����ʼ��
			jp1 = new JPanel();
			jp2 = new JPanel();
			jp3 = new JPanel();
		
			//����jp1������
			Font jpFont = new Font("������κ",Font.BOLD,40);
			jl1 = new JLabel("����������˵�Ļ�");
			jl1.setFont(jpFont);
			jl1.setForeground(Color.red);
			jp1.add(jl1);
			//���尴ť���������
			Font btFont = new Font("������κ",Font.BOLD,40);
			captureBtn = new JButton("��ס ˵��");
			//setForeground�������ð�ť�����������ɫ
			captureBtn.setForeground(Color.RED);
			captureBtn.setFont(btFont);
			//�Կ�ʼ¼����ť����������
			captureBtn.addMouseListener(this);
			
			
			this.add(jp1,BorderLayout.NORTH);
			this.add(jp2,BorderLayout.CENTER);
			this.add(jp3,BorderLayout.SOUTH);
			GridBagLayout gridbag = null;
			jp3.setLayout(gridbag = new GridBagLayout());
			gridx=1;
			gridy=2;
			gridwidth=1;
			gridheight=1;
			weightx=1;
			weighty=1;
			anchor=GridBagConstraints.CENTER;
			fill=GridBagConstraints.HORIZONTAL;
			inset=new Insets(1,1,1,1);
			ipadx=0;
			ipady=30;
			c = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
					weightx, weighty, anchor, fill, inset, ipadx, ipady);
			gridbag.setConstraints(captureBtn, c);
			jp3.add(captureBtn);

		}
}
