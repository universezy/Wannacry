package com.demo.zy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
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
	private static int WIDTH = 1000, HEIGHT = 710;
	private static String NAME = "Wana  DecryptOr  2.0";
	private static String TITLE = "Ooops, your files have been encrypted!";
	private static String TEXT = "我的电脑出了什么问题？\n您的一些重要文件被我加密保存了。";
	private static String PAY = "Send $300 worth of bitcoin to this address:";
	private static String ADDRESS = "13AM4VM2dhxYgXeQepoHkHSQuy6NgaEb94";
	private static String PATH_ICON = "/resource/icon.png";
	private static String PATH_LOCK = "/resource/lock.png";
	private static String PATH_COLOR = "/resource/color.png";
	private static String PATH_BITCOIN = "/resource/bitcoin.png";
	private static String LINK1 = "https://en.wikipedia.org/wiki/Bitcoin";
	private static String LINK2 = "https://howtobuybitcoins.info/";
	private static String[] LANGUAGE = { "Chinese (simple)", "English" };

	/** COMPONENT **/
	private ImageIcon imageIcon, imageIcon_lock, imageIcon_color, imageIcon_bitcoin;
	private JFrame jFrame;
	private JLabel jLabel_raise_text1, jLabel_raise_text2, jLabel_raise_text3, jLabel_raise_text4, jLabel_raise_color;
	private JLabel jLabel_lost_text1, jLabel_lost_text2, jLabel_lost_text3, jLabel_lost_text4, jLabel_lost_color;
	private JLabel jLabel_lock, jLabel_contact, jLabel_title, jLabel_bitcoin, jLabel_pay_text,jLabel_address;
	private JPanel jPanel_raise, jPanel_lost, jPanel_pay, jPanel_address;
	private LinkLabel linkLabel_1, linkLabel_2;
	private JComboBox<String> jComboBox;
	private JTextArea jTextArea_text;
	private JScrollPane scrollPane;
	private JButton jButton_copy,jButton_check,jButton_decrypt;

	private JFrame initJFrame() {
		imageIcon = new ImageIcon(PATH_ICON);
		jFrame = new JFrame(NAME);
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
		jLabel_lock = new JLabel();
		imageIcon_lock = new ImageIcon(getClass().getResource(PATH_LOCK));
		jLabel_lock.setIcon(imageIcon_lock);
		// width = 150, height = 150
		jLabel_lock.setBounds(70, 10, imageIcon_lock.getIconWidth(), imageIcon_lock.getIconHeight());
		jPanel.add(jLabel_lock);

		/** RAISE **/
		jPanel_raise = new JPanel();
		jPanel_raise.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.lightGray));
		jPanel_raise.setBounds(10, 162, 270, 170);
		jPanel_raise.setBackground(Color.decode("#8B2323"));
		jPanel_raise.setLayout(null);
		jPanel.add(jPanel_raise);
		imageIcon_color = new ImageIcon(getClass().getResource(PATH_COLOR));

		jLabel_raise_text1 = new JLabel("Payment will be raised on");
		jLabel_raise_text1.setFont(new Font(Font.DIALOG, 1, 17));
		jLabel_raise_text1.setForeground(Color.ORANGE);
		jLabel_raise_text1.setBounds(35, 5, 200, 30);
		jPanel_raise.add(jLabel_raise_text1);

		jLabel_raise_text2 = new JLabel("5/24/2017 20:21:15");
		jLabel_raise_text2.setFont(new Font(Font.DIALOG, 1, 17));
		jLabel_raise_text2.setForeground(Color.white);
		jLabel_raise_text2.setBounds(60, 35, 150, 30);
		jPanel_raise.add(jLabel_raise_text2);

		jLabel_raise_text3 = new JLabel("Time Left");
		jLabel_raise_text3.setFont(new Font(Font.DIALOG, 1, 17));
		jLabel_raise_text3.setForeground(Color.white);
		jLabel_raise_text3.setBounds(95, 80, 80, 30);
		jPanel_raise.add(jLabel_raise_text3);

		jLabel_raise_text4 = new JLabel("02: 23: 59: 22");
		jLabel_raise_text4.setFont(new Font(Font.SANS_SERIF, 1, 35));
		jLabel_raise_text4.setForeground(Color.white);
		jLabel_raise_text4.setBounds(15, 105, 240, 60);
		jPanel_raise.add(jLabel_raise_text4);

		jLabel_raise_color = new JLabel();
		jLabel_raise_color.setIcon(imageIcon_color);
		// width = 25, height = 114
		jLabel_raise_color.setBounds(240, 38, imageIcon_color.getIconWidth(), imageIcon_color.getIconHeight());
		jPanel_raise.add(jLabel_raise_color);

		/** LOST **/
		jPanel_lost = new JPanel();
		jPanel_lost.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.lightGray));
		jPanel_lost.setBounds(10, 345, 270, 170);
		jPanel_lost.setBackground(Color.decode("#8B2323"));
		jPanel_lost.setLayout(null);
		jPanel.add(jPanel_lost);

		jLabel_lost_text1 = new JLabel("Your files will be lost on");
		jLabel_lost_text1.setFont(new Font(Font.DIALOG, 1, 17));
		jLabel_lost_text1.setForeground(Color.ORANGE);
		jLabel_lost_text1.setBounds(35, 5, 200, 30);
		jPanel_lost.add(jLabel_lost_text1);

		jLabel_lost_text2 = new JLabel("5/28/2017 20:21:15");
		jLabel_lost_text2.setFont(new Font(Font.DIALOG, 1, 17));
		jLabel_lost_text2.setForeground(Color.white);
		jLabel_lost_text2.setBounds(60, 35, 150, 30);
		jPanel_lost.add(jLabel_lost_text2);

		jLabel_lost_text3 = new JLabel("Time Left");
		jLabel_lost_text3.setFont(new Font(Font.DIALOG, 1, 17));
		jLabel_lost_text3.setForeground(Color.white);
		jLabel_lost_text3.setBounds(95, 80, 80, 30);
		jPanel_lost.add(jLabel_lost_text3);

		jLabel_lost_text4 = new JLabel("06: 23: 59: 22");
		jLabel_lost_text4.setFont(new Font(Font.SANS_SERIF, 1, 35));
		jLabel_lost_text4.setForeground(Color.white);
		jLabel_lost_text4.setBounds(15, 105, 240, 60);
		jPanel_lost.add(jLabel_lost_text4);

		jLabel_lost_color = new JLabel();
		jLabel_lost_color.setIcon(imageIcon_color);
		// width = 25, height = 114
		jLabel_lost_color.setBounds(240, 38, imageIcon_color.getIconWidth(), imageIcon_color.getIconHeight());
		jPanel_lost.add(jLabel_lost_color);

		/** HYPERLINK **/
		linkLabel_1 = new LinkLabel("About bitcoin", LINK1);
		linkLabel_1.setBounds(30, 550, 100, 25);
		linkLabel_1.setFont(new Font(Font.SANS_SERIF, 0, 15));
		linkLabel_1.setForeground(Color.gray);
		jPanel.add(linkLabel_1);

		linkLabel_2 = new LinkLabel("How to buy bitcoins?", LINK2);
		linkLabel_2.setBounds(30, 585, 160, 25);
		linkLabel_2.setFont(new Font(Font.SANS_SERIF, 0, 15));
		linkLabel_2.setForeground(Color.gray);
		jPanel.add(linkLabel_2);

		jLabel_contact = new JLabel("<html><u>" + "Contact Us");
		jLabel_contact.setBounds(30, 620, 120, 40);
		jLabel_contact.setFont(new Font(Font.SANS_SERIF, 0, 20));
		jLabel_contact.setForeground(Color.decode("#96CDCD"));
		jPanel.add(jLabel_contact);

		/** TITLE **/
		jLabel_title = new JLabel(TITLE);
		jLabel_title.setBounds(335, 10, 500, 30);
		jLabel_title.setFont(new Font(Font.DIALOG, 1, 25));
		jLabel_title.setForeground(Color.white);
		jPanel.add(jLabel_title);

		/** LANGUAGE **/
		jComboBox = new JComboBox<>(LANGUAGE);
		jComboBox.setFont(new Font(Font.SANS_SERIF, 0, 15));
		jComboBox.setBounds(850, 15, 135, 25);
		jComboBox.setBackground(Color.decode("#8B2323"));
		jComboBox.setForeground(Color.white);
		jPanel.add(jComboBox);

		/** TEXT **/
		jTextArea_text = new JTextArea();
		jTextArea_text.setText(TEXT);
		jTextArea_text.setFont(new Font(Font.SERIF, 1, 15));
		jTextArea_text.setBackground(Color.white);
		jTextArea_text.setEditable(false);
		jTextArea_text.setLineWrap(true);
		jTextArea_text.setWrapStyleWord(true);

		scrollPane = new JScrollPane(jTextArea_text);
		scrollPane.setPreferredSize(new Dimension(700, 465));
		scrollPane.setBounds(290, 50, 700, 465);
		scrollPane.setLayout(new ScrollPaneLayout());
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jPanel.add(scrollPane);

		/** PAY **/
		jPanel_pay = new JPanel();
		jPanel_pay.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.lightGray));
		jPanel_pay.setBounds(290, 525, 700, 90);
		jPanel_pay.setBackground(Color.decode("#8B2323"));
		jPanel_pay.setLayout(null);
		jPanel.add(jPanel_pay);

		jLabel_bitcoin = new JLabel();
		imageIcon_bitcoin = new ImageIcon(getClass().getResource(PATH_BITCOIN));
		jLabel_bitcoin.setIcon(imageIcon_bitcoin);
		// width = 168, height = 68
		jLabel_bitcoin.setBounds(0, 11, imageIcon_bitcoin.getIconWidth(), imageIcon_bitcoin.getIconHeight());
		jPanel_pay.add(jLabel_bitcoin);

		jLabel_pay_text = new JLabel(PAY);
		jLabel_pay_text.setBounds(175, 7, 520, 25);
		jLabel_pay_text.setFont(new Font(Font.DIALOG, 1, 18));
		jLabel_pay_text.setForeground(Color.ORANGE);
		jPanel_pay.add(jLabel_pay_text);

		jPanel_address = new JPanel();
		jPanel_address.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.lightGray));
		jPanel_address.setBounds(175, 45, 475, 35);
		jPanel_address.setBackground(Color.decode("#8B2323"));
		jPanel_address.setLayout(null);
		jPanel_pay.add(jPanel_address);

		jLabel_address = new JLabel();
		jLabel_address.setText(ADDRESS);
		jLabel_address.setFont(new Font(Font.SANS_SERIF, 0, 18));
		jLabel_address.setBounds(2, 2, 471, 31);
		jLabel_address.setForeground(Color.white);
		jLabel_address.setBackground(Color.decode("#8B2323"));
		jPanel_address.add(jLabel_address);

		jButton_copy = new JButton("Copy");
		jButton_copy.setFont(new Font(Font.DIALOG, 0, 13));
		jButton_copy.setBounds(655, 40, 40, 40);
		jButton_copy.setMargin(new Insets(1, 1, 1, 1));
		jButton_copy.setBackground(Color.decode("#EEE9E9"));
		jPanel_pay.add(jButton_copy);
		
		/** BUTTON **/
		jButton_check = new JButton("Check Payment");
		jButton_check.setFont(new Font(Font.DIALOG, 1, 18));
		jButton_check.setBounds(290, 630, 330, 35);
		jButton_check.setBackground(Color.decode("#EEE9E9"));
		jPanel.add(jButton_check);
		
		jButton_decrypt = new JButton("Decrypt");
		jButton_decrypt.setFont(new Font(Font.DIALOG, 1, 18));
		jButton_decrypt.setBounds(660, 630, 330, 35);
		jButton_decrypt.setBackground(Color.decode("#EEE9E9"));
		jPanel.add(jButton_decrypt);
	}

	private void setListener() {
		jLabel_contact.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				jLabel_contact.setText("<html><u>" + "Contact Us");
				jLabel_contact.setForeground(Color.decode("#96CDCD"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jLabel_contact.setText("<html><u>" + "Contact Us");
				jLabel_contact.setForeground(Color.decode("000000"));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO
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
