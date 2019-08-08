package os;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

public class DiskSched_GUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiskSched_GUI window = new DiskSched_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DiskSched_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 102));
		frame.setBounds(100, 100, 1139, 661);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(418, 104, 340, 20);
		textField.setBackground(new Color(238, 232, 170));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(418, 141, 46, 20);
		textField_1.setBackground(new Color(240, 230, 140));
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setBounds(322, 105, 66, 19);
		lblInput.setFont(new Font("Kristen ITC", Font.PLAIN, 19));
		lblInput.setForeground(new Color(0, 255, 0));
		frame.getContentPane().add(lblInput);
		
		JLabel lblHead = new JLabel("Head");
		lblHead.setBounds(322, 143, 66, 18);
		lblHead.setForeground(new Color(0, 255, 0));
		lblHead.setBackground(new Color(128, 128, 0));
		lblHead.setFont(new Font("Kristen ITC", Font.PLAIN, 19));
		frame.getContentPane().add(lblHead);
		
		JButton btnFifo = new JButton("FIFO");
		btnFifo.setBounds(24, 342, 89, 42);
		btnFifo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random ra=new Random();
				String x="";
				int n=ra.nextInt(10)+5;
				int A[]=new int[n];
				for(int i=0;i<n;i++) 
				{	A[i]=ra.nextInt(200);
					x=x+" "+A[i];
				}
				int head=ra.nextInt(200);
				DFCFS Obj1=new DFCFS();
				int ans=Obj1.main(A, n, head);
				textField.setText(x);
				textField_1.setText(head+"");
				textField_2.setText(ans+"");

			}
		});
		btnFifo.setBackground(new Color(95, 158, 160));
		frame.setLocation(200, 100);
		frame.getContentPane().add(btnFifo);
		
		JButton btnSstf = new JButton("SSTF");
		btnSstf.setBounds(220, 342, 89, 42);
		btnSstf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random ra=new Random();
				String x="";
				int n=ra.nextInt(10)+5;
				int A[]=new int[n];
				for(int i=0;i<n;i++) 
				{	A[i]=ra.nextInt(200);
					x=x+" "+A[i];
				}
				int head=ra.nextInt(200);
				SSTF Obj2= new SSTF();
				int ans=Obj2.main(A, n, head);
				textField.setText(x);
				textField_1.setText(head+"");
				textField_2.setText(ans+"");		
				
			}
		});
		btnSstf.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(btnSstf);
		
		JButton btnScan = new JButton("Scan");
		btnScan.setBounds(786, 342, 89, 42);
		btnScan.setBackground(new Color(95, 158, 160));
		btnScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random ra=new Random();
				String x="";
				int n=ra.nextInt(10)+5;
				int A[]=new int[n];
				for(int i=0;i<n;i++) 
				{	A[i]=ra.nextInt(200);
					x=x+" "+A[i];
				}
				int head=ra.nextInt(200);
				Scan Obj3 = new Scan();
				int ans=Obj3.main(A,n,head);
				textField.setText(x);
				textField_1.setText(head+"");
				textField_2.setText(ans+"");
				
			}
		});
		frame.getContentPane().add(btnScan);
		
		JButton btnCscan = new JButton("C-Scan");
		btnCscan.setBounds(967, 342, 89, 42);
		btnCscan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random ra=new Random();
				String x="";
				int n=ra.nextInt(10)+5;
				int A[]=new int[n];
				for(int i=0;i<n;i++) 
				{	A[i]=ra.nextInt(200);
					x=x+" "+A[i];
				}
				int head=ra.nextInt(200);
				CScan Obj4 = new CScan();
				int ans=Obj4.main(A,n,head);
				textField.setText(x);
				textField_1.setText(head+"");
				textField_2.setText(ans+"");
			}
		});
		btnCscan.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(btnCscan);
		
		JButton btnClook = new JButton("C-Look");
		btnClook.setBounds(604, 342, 89, 42);
		btnClook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random ra=new Random();
				String x="";
				int n=ra.nextInt(10)+5;
				int A[]=new int[n];
				for(int i=0;i<n;i++) 
				{	A[i]=ra.nextInt(200);
					x=x+" "+A[i];
				}
				int head=ra.nextInt(200);
				CLook Obj5 = new CLook();
				int ans=Obj5.main(A,n,head);
				textField.setText(x);
				textField_1.setText(head+"");
				textField_2.setText(ans+"");
				
			}
		});
		btnClook.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(btnClook);
		
		JButton btnLook = new JButton("Look");
		btnLook.setBackground(new Color(95, 158, 160));
		btnLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random ra=new Random();
				String x="";
				int n=ra.nextInt(3)+8;;
				int A[]=new int[n];
				for(int i=0;i<n;i++) 
				{	A[i]=ra.nextInt(200);
					x=x+" "+A[i];
				}
				int head=ra.nextInt(200);
				Look Obj6 = new Look();
				int ans=Obj6.main(A,n,head);
				textField.setText(x);
				textField_1.setText(head+"");
				textField_2.setText(ans+"");
			}
		});
		btnLook.setBounds(418, 342, 89, 42);
		frame.getContentPane().add(btnLook);
		
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(240, 230, 140));
		textField_2.setBounds(535, 238, 66, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNoOfCylinders = new JLabel("Total number of head movements");
		lblNoOfCylinders.setFont(new Font("Kristen ITC", Font.PLAIN, 19));
		lblNoOfCylinders.setForeground(new Color(0, 255, 0));
		lblNoOfCylinders.setBounds(160, 237, 363, 27);
		frame.getContentPane().add(lblNoOfCylinders);
		JLabel lblBestAlgoIs = new JLabel("Best Algorithm is");
		lblBestAlgoIs.setForeground(new Color(255, 255, 255));
		lblBestAlgoIs.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		lblBestAlgoIs.setBounds(432, 528, 169, 20);
		frame.getContentPane().add(lblBestAlgoIs);
		
		JLabel lblFifo = new JLabel("fifo\r\n\r\n");
		lblFifo.setForeground(new Color(255, 255, 255));
		lblFifo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblFifo.setBounds(47, 397, 66, 14);
		frame.getContentPane().add(lblFifo);

		JLabel lblSstf = new JLabel("sstf");
		lblSstf.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblSstf.setForeground(new Color(255, 255, 255));
		lblSstf.setBounds(240, 397, 58, 14);
		frame.getContentPane().add(lblSstf);
		
		JLabel lblScan = new JLabel("Scan\r\n");
		lblScan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblScan.setForeground(new Color(255, 255, 255));
		lblScan.setBounds(796, 397, 58, 14);
		frame.getContentPane().add(lblScan);
		
		JLabel lblCscan = new JLabel("C-Scan");
		lblCscan.setForeground(new Color(255, 255, 255));
		lblCscan.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblCscan.setBounds(977, 397, 58, 14);
		frame.getContentPane().add(lblCscan);
		
		JLabel lblClook = new JLabel("C-Look");
		lblClook.setForeground(new Color(255, 255, 255));
		lblClook.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblClook.setBackground(new Color(255, 255, 255));
		lblClook.setBounds(626, 397, 55, 14);
		frame.getContentPane().add(lblClook);
		
		JLabel lblLook = new JLabel("look");
		lblLook.setForeground(new Color(255, 255, 255));
		lblLook.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblLook.setBounds(428, 396, 56, 16);
		frame.getContentPane().add(lblLook);
		
		
		JButton btnCompare = new JButton("COMPARE");
		btnCompare.setBackground(new Color(205, 133, 63));
		btnCompare.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnCompare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random ra=new Random();
				String x="";
				int n=ra.nextInt(10)+5;
				int A[]=new int[n];
				int B[]=new int[n];
				int C[]=new int[n];
				int D[]=new int[n];
				int E[]=new int[n];
				int F[]=new int[n];
				for(int i=0;i<n;i++) 
				{	
					A[i]=ra.nextInt(200);
		
						//System.out.print(A[i]+"********8 ");
					x=x+" "+A[i];
					B[i]=A[i];
					C[i]=A[i];
					D[i]=A[i];
					E[i]=A[i];
					F[i]=A[i];
				}
			//	for(int i=0;i<n;i++)
					//System.out.print(A[i]+" ");
				int head=ra.nextInt(200);
				int aa[]=new int[7];
				textField.setText(x);
				textField_1.setText(head+"");
				DFCFS Obj1=new DFCFS();
				aa[1]=Obj1.main(A, n, head);
				SSTF Obj2= new SSTF();
				aa[2]=Obj2.main(B, n, head);
				Scan Obj3 = new Scan();
				aa[3]=Obj3.main(C,n,head);
				CScan Obj4 = new CScan();
				aa[4]=Obj4.main(D,n,head);
				CLook Obj5 = new CLook();
				aa[5]=Obj5.main(E,n,head);
				Look Obj6 = new Look();
				aa[6]=Obj6.main(F, n, head);	
				lblFifo.setText(aa[1]+"");
				lblSstf.setText(aa[2]+"");
				lblScan.setText(aa[3]+"");
				lblCscan.setText(aa[4]+"");
				lblClook.setText(aa[5]+"");
				lblLook.setText(aa[6]+"");
				int ans=aa[1];
				String ref[]=new String[7];
				ref[1]="FCFS"; ref[2]="SSTF"; ref[3]="SCAN"; ref[4]="C-SCAN"; ref[5]="C-LOOK" ; ref[6]="LOOK";
				String fin="";
				for(int i=2;i<=6;i++)
				{
					if(ans>aa[i])
					{
						ans=aa[i];
						fin=ref[i];
					}
				}
				lblBestAlgoIs.setText("Best Algo is: "+fin);
				}
		});
		btnCompare.setBounds(432, 452, 133, 42);
		frame.getContentPane().add(btnCompare);
		
		
		
		
		
		JLabel lblDiskScheduling = new JLabel("DISK SCHEDULING");
		lblDiskScheduling.setForeground(new Color(0, 0, 0));
		lblDiskScheduling.setFont(new Font("Gabriola", Font.BOLD, 35));
		lblDiskScheduling.setBounds(415, 13, 266, 61);
		frame.getContentPane().add(lblDiskScheduling);
		
		JLabel label = new JLabel("");
		Image images = new ImageIcon(Loginview.class.getResource("/112.jpg")).getImage();
		label.setIcon(new ImageIcon(images));
		label.setBounds(-7, 79, 1128, 535);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 140, 53);
		frame.getContentPane().add(label_1);
		
		JLabel lblPreviousState = new JLabel("PREVIOUS STATE");
		lblPreviousState.setForeground(Color.GREEN);
		lblPreviousState.setFont(new Font("Kristen ITC", Font.PLAIN, 19));
		lblPreviousState.setBackground(new Color(128, 128, 0));
		lblPreviousState.setBounds(273, 187, 98, 37);
		frame.getContentPane().add(lblPreviousState);
		
		JLabel lblPreviousState_1 = new JLabel("Previous State");
		lblPreviousState_1.setBounds(315, 187, 56, 16);
		frame.getContentPane().add(lblPreviousState_1);
		
	
		
		
		
		
	}
}
