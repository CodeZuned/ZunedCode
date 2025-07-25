

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Client extends JFrame 
{

        Socket socket;
         BufferedReader br;
    PrintWriter out;
    //Declare componets
    private JLabel heading=new JLabel("Client Area");
    private JTextArea msgArea=new JTextArea();
    private JTextField msgInput=new JTextField();
    private Font font=new Font("Roboto",Font.PLAIN,20);

    public Client()
    {
        try {
            System.out.println("Sending request to Server");
            socket=new Socket( "127.0.0.1",7777);
            System.out.println("Connection Done.");
              br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream());
            createGUI();
            handleEvents();
            startReading();
            //  startWriting();

            
        } catch (Exception e) {
            e.printStackTrace();
        
        }
    }
  
    private void handleEvents()
    {
        msgInput.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
              
                
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
               
                
              
                
            }

            @Override
            public void keyReleased(KeyEvent e)
             {
               
                
                if(e.getKeyCode()==10)
                {
                   System.out.println("you perssed"+e.getKeyCode());
                    String contentoSend=msgInput.getText();
                    msgArea.append("Me :"+contentoSend+"\n");
                    out.println(contentoSend);
                    out.flush();
                    msgInput.setText("");
                    msgInput.requestFocus();

                }
                
            }
            
        });

    }

    
    private void createGUI()
    {
        //GUI Code
        this.setTitle("Client Messager[END]");
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //coding for components

            heading.setFont(font);
            msgArea.setFont(font);
            // heading.setIcon(new ImageIcon("clogo.png"));

            msgInput.setFont(font);
            heading.setHorizontalAlignment(SwingConstants.CENTER);
            heading.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
            msgInput.setHorizontalAlignment(SwingConstants.CENTER);
            this.setLayout(new BorderLayout());
            //adding the compoents to frame

                this.add(heading,BorderLayout.NORTH);
                this.add(msgArea,BorderLayout.CENTER);
                this.add(msgInput,BorderLayout.SOUTH);

        this.setVisible(true);

    }
    public void startReading()
    {
        Runnable r1=()->{
            try{

            
            System.out.println("reader started");
            while (true&& !socket.isClosed()) {
                String msg=br.readLine();
                if(msg.equals("exit"))
                {
                        System.out.println("Server terminated the chat");
                        JOptionPane.showMessageDialog(this,"Server Terminated the chat");
                        msgInput.setEnabled(false);

                        socket.close();
                    break;
                }
                System.out.println("Server :"+msg);
                msgArea.append("Server :"+msg+"\n");

            }
        
        } catch (Exception e) {
           
           // e.printStackTrace();
           System.out.println("Conncetion is closed");
          
        }
    };
    new Thread(r1).start();

    }
    public void startWriting()
    {
        Runnable r2=()->{
                System.out.println("Writer Started..");
                try{

                
            while ((true)) {
                
              


                    BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
                    String content=br1.readLine();
                    out.println(content);
                    out.flush();
                    if(content.equals("exit"))
                    {
                        
                        socket.close();
                        break;
                    }
                   
                    

                } 
                System.out.println("Conncetion is closed");
            }catch (Exception e) {
                   
                    e.printStackTrace();
                   
                    
                }
            
            
        };
        new Thread(r2).start();

    }
    public static void main(String[] args) {
        System.out.println("this is Client");
        new Client();

    }
}
