package com.demo.zy;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import com.demo.zy.LinkLabel;

/**
 * @author ZengYu
 */
class WannaCry extends JFrame {
	/** CONFIG **/
	private static final long serialVersionUID = 1L;
	private static int WIDTH = 1000, HEIGHT = 720;
	private static String TITLE = "Wana  DecryptOr  2.0";
	private static String PATH_ICON = "/res/icon.png";
	private static String PATH_LOCK = "/res/lock.png";
	private static String PATH_COLOR = "/res/color.png";
	
	/** COMPONENT **/
	private JLabel linkLabel_3 = null;
	

	private JFrame initJFrame() {
		ImageIcon imageIcon = new ImageIcon(WannaCry.class.getResource(PATH_ICON));
		JFrame jFrame = new JFrame(TITLE);
		jFrame.setIconImage(imageIcon.getImage());
		jFrame.setSize(WIDTH, HEIGHT);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jFrame.setResizable(false);
		jFrame.setUndecorated(true);
		jFrame.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
		jFrame.getRootPane().setBackground(Color.getColor("#0000CD"));
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
		return jFrame;
	}

	private void initView(JPanel jPanel) {
		jPanel.setLayout(null);
		jPanel.setSize(WIDTH, HEIGHT);
		jPanel.setBackground(Color.decode("#8B2323"));

		/** LOCK **/
		JLabel jLabel_lock = new JLabel();
		ImageIcon imageIcon_lock = new ImageIcon(WannaCry.class.getResource(PATH_LOCK));
		jLabel_lock.setIcon(imageIcon_lock);
		// width = 150, height = 150
		jLabel_lock.setBounds(70, 10, imageIcon_lock.getIconWidth(), imageIcon_lock.getIconHeight());
		jPanel.add(jLabel_lock);

		/** RAISE **/
		JPanel jPanel_raise = new JPanel();
		jPanel_raise.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.lightGray));
		jPanel_raise.setBounds(10, 162, 270, 170);
		jPanel_raise.setBackground(Color.decode("#8B2323"));
		jPanel_raise.setLayout(null);
		jPanel.add(jPanel_raise);
		ImageIcon imageIcon_color = new ImageIcon(WannaCry.class.getResource(PATH_COLOR));

		JLabel jLabel_raise_text1 = new JLabel("Payment will be raised on");
		jLabel_raise_text1.setFont(new Font(Font.DIALOG, 1, 17));
		jLabel_raise_text1.setForeground(Color.ORANGE);
		jLabel_raise_text1.setBounds(35, 5, 200, 30);
		jPanel_raise.add(jLabel_raise_text1);

		JLabel jLabel_raise_text2 = new JLabel("5/20/2017 16:44:00");
		jLabel_raise_text2.setFont(new Font(Font.DIALOG, 1, 17));
		jLabel_raise_text2.setForeground(Color.white);
		jLabel_raise_text2.setBounds(60, 35, 150, 30);
		jPanel_raise.add(jLabel_raise_text2);

		JLabel jLabel_raise_text3 = new JLabel("Time Left");
		jLabel_raise_text3.setFont(new Font(Font.DIALOG, 1, 17));
		jLabel_raise_text3.setForeground(Color.white);
		jLabel_raise_text3.setBounds(95, 80, 80, 30);
		jPanel_raise.add(jLabel_raise_text3);

		JLabel jLabel_raise_text4 = new JLabel("02: 22: 35: 15");
		jLabel_raise_text4.setFont(new Font(Font.SANS_SERIF, 1, 35));
		jLabel_raise_text4.setForeground(Color.white);
		jLabel_raise_text4.setBounds(15, 105, 240, 60);
		jPanel_raise.add(jLabel_raise_text4);

		JLabel jLabel_raise_color = new JLabel();
		jLabel_raise_color.setIcon(imageIcon_color);
		// width = 25, height = 114
		jLabel_raise_color.setBounds(240, 38, imageIcon_color.getIconWidth(), imageIcon_color.getIconHeight());
		jPanel_raise.add(jLabel_raise_color);

		/** LOST **/
		JPanel jPanel_lost = new JPanel();
		jPanel_lost.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.lightGray));
		jPanel_lost.setBounds(10, 345, 270, 170);
		jPanel_lost.setBackground(Color.decode("#8B2323"));
		jPanel_lost.setLayout(null);
		jPanel.add(jPanel_lost);

		JLabel jLabel_lost_text1 = new JLabel("Your files will be lost on");
		jLabel_lost_text1.setFont(new Font(Font.DIALOG, 1, 17));
		jLabel_lost_text1.setForeground(Color.ORANGE);
		jLabel_lost_text1.setBounds(35, 5, 200, 30);
		jPanel_lost.add(jLabel_lost_text1);

		JLabel jLabel_lost_text2 = new JLabel("5/20/2017 16:44:00");
		jLabel_lost_text2.setFont(new Font(Font.DIALOG, 1, 17));
		jLabel_lost_text2.setForeground(Color.white);
		jLabel_lost_text2.setBounds(60, 35, 150, 30);
		jPanel_lost.add(jLabel_lost_text2);

		JLabel jLabel_lost_text3 = new JLabel("Time Left");
		jLabel_lost_text3.setFont(new Font(Font.DIALOG, 1, 17));
		jLabel_lost_text3.setForeground(Color.white);
		jLabel_lost_text3.setBounds(95, 80, 80, 30);
		jPanel_lost.add(jLabel_lost_text3);

		JLabel jLabel_lost_text4 = new JLabel("06: 22: 35: 15");
		jLabel_lost_text4.setFont(new Font(Font.SANS_SERIF, 1, 35));
		jLabel_lost_text4.setForeground(Color.white);
		jLabel_lost_text4.setBounds(15, 105, 240, 60);
		jPanel_lost.add(jLabel_lost_text4);

		JLabel jLabel_lost_color = new JLabel();
		jLabel_lost_color.setIcon(imageIcon_color);
		// width = 25, height = 114
		jLabel_lost_color.setBounds(240, 38, imageIcon_color.getIconWidth(), imageIcon_color.getIconHeight());
		jPanel_lost.add(jLabel_lost_color);

		/** HYPERLINK **/
		LinkLabel linkLabel_1 = new LinkLabel("About bitcoin", "https://en.wikipedia.org/wiki/Bitcoin");
		linkLabel_1.setBounds(30, 550, 100, 25);
		linkLabel_1.setFont(new Font(Font.SANS_SERIF, 1, 15));
		linkLabel_1.setForeground(Color.gray);
		jPanel.add(linkLabel_1);
		
		LinkLabel linkLabel_2 = new LinkLabel("How to buy bitcoin?", "https://howtobuybitcoins.info/");
		linkLabel_2.setBounds(30, 585, 160, 25);
		linkLabel_2.setFont(new Font(Font.SANS_SERIF, 1, 15));
		linkLabel_2.setForeground(Color.gray);
		jPanel.add(linkLabel_2);
		
		linkLabel_3 = new JLabel("<html><font color=gray><u>"+"Contact Us");
		linkLabel_3.setBounds(30, 620, 120, 40);
		linkLabel_3.setFont(new Font(Font.SANS_SERIF, 1, 20));
		linkLabel_3.setForeground(Color.gray);
		jPanel.add(linkLabel_3);

		/** TITLE **/
		JLabel jLabel_title = new JLabel("Ooops, your files have been encrypted!");
		jLabel_title.setFont(new Font(Font.DIALOG, 1, 25));
		jLabel_title.setForeground(Color.white);
		jLabel_title.setBounds(335, 10, 600, 30);
		jPanel.add(jLabel_title);
		
		/** LANGUAGE **/
		
		/** TEXT **/

		/** PAY **/

		/** BUTTON **/

	}
	
	private void setListener() {
		linkLabel_3.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				linkLabel_3.setText("<html><font color=gray><u>" + "Contact Us");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				linkLabel_3.setText("<html><font color=black><u>" + "Contact Us");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO
			}
		});
	}

	private void setAction() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String string = simpleDateFormat.format(date);
		
	}

	public static void main(String[] args) {
		WannaCry wannaCry = new WannaCry();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				UIManager.put("InternalFrame.activeTitleBackground", new ColorUIResource(Color.BLUE));
				UIManager.put("InternalFrame.activeTitleForeground", new ColorUIResource(Color.RED));
				UIManager.put("InternalFrame.titleFont", new Font(Font.SERIF, 1, 15));
				JPanel jPanel = new JPanel();
				JFrame.setDefaultLookAndFeelDecorated(true);
				wannaCry.initJFrame().add(jPanel);
				wannaCry.initView(jPanel);
				wannaCry.setListener();
				wannaCry.setAction();
			}
		});
	}
}
