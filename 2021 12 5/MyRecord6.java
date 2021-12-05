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
		 
		//定义录音格式
		AudioFormat af = null;
		//定义目标数据行,可以从中读取音频数据,该 TargetDataLine 接口提供从目标数据行的缓冲区读取所捕获数据的方法。
		TargetDataLine td = null;
		//定义源数据行,源数据行是可以写入数据的数据行。它充当其混频器的源。应用程序将音频字节写入源数据行，这样可处理字节缓冲并将它们传递给混频器。
		SourceDataLine sd = null;
		//定义字节数组输入输出流
		ByteArrayInputStream bais = null;
		ByteArrayOutputStream baos = null;
		//定义音频输入流
		AudioInputStream ais = null;
		//定义停止录音的标志，来控制录音线程的运行
		Boolean stopflag = false;
		//记录开始录音的时间
		long startPlay;
		//设置一个播放的标志
		Boolean playflag;
		//每次保存的最后的文件名
		File tarFile = null;
		//定义音频波形每次显示的字节数
		int intBytes = 0;
		//定义每次录音的时候每次提取字节来画音频波
		byte audioDataBuffer[] = null;
		//定义所需要的组件
		JPanel jp1,jp2,jp3;
		JLabel jl1=null;
		JButton captureBtn;
		//设置画波形线程的终止的标志
		boolean flag = true;
		//定义播放录音时的一个计数值
		int cnt;
		//定义播放录音时一个缓冲数组
		byte btsPlay[] = null;
	 
		int gridx, gridy, gridwidth, gridheight, anchor, fill, ipadx, ipady;
		double weightx, weighty;
		Insets inset;
		GridBagConstraints c;
		
		public static void main(String[] args) {
			
		//创造一个实例
		MyRecord6 mr = new MyRecord6();
			
		}
		//构造函数
		public MyRecord6()
		{
			//组件初始化
			jp1 = new JPanel();
			jp2 = new JPanel();
			jp3 = new JPanel();
		
			//定义jp1的字体
			Font jpFont = new Font("华文新魏",Font.BOLD,40);
			jl1 = new JLabel("请留下您想说的话");
			jl1.setFont(jpFont);
			jl1.setForeground(Color.red);
			jp1.add(jl1);
			//定义按钮上面的字体
			Font btFont = new Font("华文新魏",Font.BOLD,40);
			captureBtn = new JButton("按住 说话");
			//setForeground可以设置按钮上面字体的颜色
			captureBtn.setForeground(Color.RED);
			captureBtn.setFont(btFont);
			//对开始录音按钮进行鼠标监听
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
