package Yuyin;

import java.io.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.net.*; 
public class Yuyinliaotian extends Frame
{
 TextField tf=new TextField(20);
 TextArea ta=new TextArea();
 
 Button send=new Button("send");
 Button voiceChat=new Button("voiceChat");
 
 ServerSocket serSocket;
 Socket client;
 
 InputStream in;
 BufferedReader br;
 OutputStream out;
 BufferedWriter bw;
 
  
 
 public Yuyinliaotian()
 {
  super("Server");
  add("North",tf);
  add("Center",ta);
  add("South",send);
  add("East",voiceChat);
  setBackground(Color.yellow);
  setSize(250,250);
  show();
  addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
     dispose();
     System.exit(0);
    }
   });
  try
  {
   ServerSocket serSocket=new ServerSocket(5000);
   client=serSocket.accept();
   ta.append("client host"+client.getInetAddress().getHostName()+"/n/n");
   in=client.getInputStream();
   br=new BufferedReader(new InputStreamReader(in));
   out=client.getOutputStream();
   bw=new BufferedWriter(new OutputStreamWriter(out)); 
  }
  catch(Exception e)
  {
   
  }
  
  while(true) 
  { 
   try 
   { 
    byte[] buf=new byte[200]; 
    in.read(buf); 
    String str=new String(buf); 
    ta.append("Client say:"+str); 
    ta.append("/n"); 
   } 
   catch(IOException e)
   {
   } 
  } 
   
  
   
 }
 
  public boolean action (Event evt, Object arg) {
   if(evt.target.equals(send))
   {
    try 
   { 
    String str=tf.getText(); 
    byte[] buf=str.getBytes(); 
    tf.setText(null); 
    out.write(buf); 
    ta.append("I say:"+str); 
    ta.append("/n"); 
   } 
   catch(IOException ioe){} 
   }
   else if(evt.target.equals(voiceChat))
   {
    try {
    	String str=tf.getText();
    	
    	
    }
   catch(Exception e){}
  }
   return true;
 }
 public static void main(String[] args)
 {
  Yuyinliaotian server=new Yuyinliaotian();
 }
}
