package os;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class MyLogin {

	JFrame frame;
	JButton j,k;
	JLabel l;
	JFrame f3,f2;
	private JButton btnNewButton;
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyLogin window = new MyLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MyLogin() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		/*UIManager.put("InternalFrame.activeTitleBackground", new ColorUIResource(Color.red ));
		UIManager.put("InternalFrame.activeTitleForeground", new ColorUIResource(Color.red));
		UIManager.put("InternalFrame.titleFont", new Font("Dialog", Font.PLAIN, 11));*/
		frame.getContentPane().setIgnoreRepaint(true);
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setForeground(new Color(205, 92, 92));
		frame.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 11));
		frame.setBounds(200, 100, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		JButton btnStop = new JButton("PageFault_Algos");
		btnStop.setBounds(382, 318, 200, 37);
		btnStop.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnStop.setForeground(Color.BLACK);
		btnStop.setBackground(new Color(255, 255, 255));
		
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PageFaultGUI OBJ2=new PageFaultGUI();
				OBJ2.main();
			}
		});
		frame.getContentPane().setLayout(null);
		
		JLabel lblSRILEKHA = new JLabel("TEJKIRAN\r\n                                    SUBASH KARTHIK  \r\n                                    MONICA \r\n                                     \r\nSRILEKHA ");
		lblSRILEKHA.setBounds(10, 477, 962, 135);
		lblSRILEKHA.setFont(new Font("MV Boli", Font.PLAIN, 12));
		lblSRILEKHA.setBackground(new Color(255, 99, 71));
		lblSRILEKHA.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(lblSRILEKHA);
		frame.getContentPane().add(btnStop);
		
		
		
		JButton btnClick = new JButton("Scheduling_Algos");
		btnClick.setBounds(382, 185, 200, 37);
		btnClick.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnClick.setForeground(Color.BLACK);
		btnClick.setBackground(new Color(255, 255, 255));
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SchedulingGUI OBJ1=new SchedulingGUI();
				OBJ1.main();				
			}
		});
		frame.getContentPane().add(btnClick);

		btnNewButton = new JButton("Dining Philopher");
		btnNewButton.setBounds(382, 251, 200, 37);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DP_GUI OBJ3=new DP_GUI("Dining Philosopher");
				OBJ3.main();
				
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("SIMULATOR");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(382, 0, 200, 100);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		Font labelFont = lblNewLabel.getFont();
		String labelText = lblNewLabel.getText();
		int stringWidth = lblNewLabel.getFontMetrics(labelFont).stringWidth(labelText);
		int componentWidth = lblNewLabel.getWidth();
		double widthRatio = (double)componentWidth / (double)stringWidth;
		int newFontSize = (int)(labelFont.getSize() * widthRatio);
		int componentHeight = lblNewLabel.getHeight();
		int fontSizeToUse = Math.min(newFontSize, componentHeight);
		lblNewLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
		
		JButton btnDiskScheduling = new JButton("Disk Scheduling");
		btnDiskScheduling.setBounds(382, 384, 200, 37);
		btnDiskScheduling.setForeground(new Color(0, 0, 0));
		btnDiskScheduling.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnDiskScheduling.setBackground(new Color(255, 255, 255));
		btnDiskScheduling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DiskSched_GUI OBJ4=new DiskSched_GUI();
				OBJ4.main();
			}
		});
		frame.getContentPane().add(btnDiskScheduling);
		
		JButton btnA = new JButton("a");
		btnA.setBounds(10, 165, -1, 23);
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
			}
		});
		btnA.setBackground(new Color(210, 105, 30));
		btnA.setForeground(new Color(210, 105, 30));
		frame.getContentPane().add(btnA);
		
		JLabel label_1 = new JLabel("");
		Image images = new ImageIcon(Loginview.class.getResource("/112.jpg")).getImage();
		label_1.setIcon(new ImageIcon(images));
		label_1.setBounds(0, 0, 996, 612);
		frame.getContentPane().add(label_1);
		
		/*JButton btnBankersAlgorithm = new JButton("Banker's Algorithm");
		btnBankersAlgorithm.setForeground(new Color(255, 255, 255));
		btnBankersAlgorithm.setBounds(382, 461, 200, 37);
		frame.getContentPane().add(btnBankersAlgorithm);*/
		
		JButton btnB = new JButton("Banker's Algorithm");
		btnB.setBounds(382, 450, 200, 37);
		btnB.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnB.setForeground(Color.BLACK);
		btnB.setBackground(new Color(255, 255, 255));
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Banker OBJ5=new Banker();
				OBJ5.main();				
			}
		});
		frame.getContentPane().add(btnB);
		
		
	}
}
