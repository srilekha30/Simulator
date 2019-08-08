package os;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bargraph extends JPanel {
  private double[] values;
  private String[] names;
  private String title;

  public Bargraph(double[] v, String[] n, String t) {
  	setForeground(new Color(0, 204, 51));
  	setBackground(Color.DARK_GRAY);
  	
  	JLabel label = new JLabel("");
  	add(label);
    names = n;
    values = v;
    title = t;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (values == null || values.length == 0)
      return;
    double minValue = 0;
    double maxValue = 0;
    for (int i = 0; i < values.length; i++) {
      if (minValue > values[i])
        minValue = values[i];
      if (maxValue < values[i])
        maxValue = values[i];
    }

    Dimension d = getSize();
    int clientWidth = d.width;
    int clientHeight = d.height;
    int barWidth = clientWidth / values.length;

    Font titleFont = new Font("Gabriola", Font.BOLD, 30);
    FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
    Font labelFont = new Font("Gabriola", Font.BOLD, 20);
    FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

    int titleWidth = titleFontMetrics.stringWidth(title);
    int y = titleFontMetrics.getAscent();
    int x = (clientWidth - titleWidth) / 2;
    g.setFont(titleFont);
    g.drawString(title, x, y);

    int top = titleFontMetrics.getHeight();
    int bottom = labelFontMetrics.getHeight();
    if (maxValue == minValue)
      return;
    double scale = (clientHeight - top - bottom) / (maxValue - minValue);
    y = clientHeight - labelFontMetrics.getDescent();
    g.setFont(labelFont);

    for (int i = 0; i < values.length; i++) {
      int valueX = i * barWidth + 1;
      int valueY = top;
      int height = (int) (values[i] * scale);
      if (values[i] >= 0)
        valueY += (int) ((maxValue - values[i]) * scale);
      else {
        valueY += (int) (maxValue * scale);
        height = -height;
      }

      g.setColor(Color.CYAN);
      g.fillRect(valueX, valueY, barWidth - 4, height);
      g.setColor(Color.white);
      g.drawRect(valueX, valueY, barWidth - 4, height);
      int labelWidth = labelFontMetrics.stringWidth(names[i]);
      x = i * barWidth + (barWidth - labelWidth) / 2;
      g.drawString(names[i], x, y);
    }
  }

  public static void test(double val[] ,String[] n) {
    JFrame f = new JFrame();
    f.setSize(650, 550);
    f.setLocation(200, 100);
    double[] values = new double[6];
    String[] names = new String[6];
    for(int i=0;i<6;i++)
    {
    	values[i]=val[i];
    	names[i]=n[i];
    }

    f.getContentPane().add(new Bargraph(values, names, "Scheduling Algorithms"));

   /* WindowListener wndCloser = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };
    f.addWindowListener(wndCloser);*/
    
    /*JLabel label_1 = new JLabel("");
	Image images = new ImageIcon(Loginview.class.getResource("/112.jpg")).getImage();
	label_1.setIcon(new ImageIcon(images));
	//label_1.setOpaque(false);
	//label_1.setContentAreaFilled(false);
	//label.setBorderPainted(false);
	//label_1.setBounds(67, -43, 833, 690);
	//panel_1.add(label);
	label_1.setBounds(-19, 73, 1140, 758);
	f.getContentPane().add(label_1);*/
	
    f.setVisible(true);
  }
}

