package com.demo.zy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private int RANSOM = 1;
	private static String NAME = "Wana  DecryptOr  2.1 plus";
	private static String TITLE = "Ooops, your files have been encrypted!";
	private static String TEXT = "我的电脑出了什么问题？\n" + "您的一些重要文件被我加密保存了。\n"
			+ "照片、图片、文档、压缩包、音频、视频文件、exe文件等，几乎所有类型的文件都被加密了，因此不能正常打开。\n"
			+ "这和一般文件损坏有本质上的区别。您大可在网上找找恢复文件的方法，我敢保证，没有我们的解密服务，就算老天爷来了也不能恢复这些文档。\n\n" + "有没有恢复这些文档的方法？\n"
			+ "我写不下去了，打字好他妈累。。。\n";
	private String PAY = "Send " + RANSOM + " yuan worth of QB to this QQ number:";
	private static String ADDRESS = "1148871229";
	private static String TOPIC_COLOR = "#8B2323";// 红
	// private static String TOPIC_COLOR = "#228B22";//绿
	private static String PATH_ICON = "/resource/icon.png";
	private static String PATH_LOCK = "/resource/lock.png";
	private static String PATH_COLOR = "/resource/color.png";
	private static String PATH_QB = "/resource/qb.jpg";
	private static String LINK1 = "http://baike.baidu.com/link?url=DqTnozzY3b5dBFctNXJXf2qUEANhu-TnWkQgIif94nMAB8BF2MK1aPifxafUomxTsf6x2pI17kv6Gc2UnNHmnMHqC9ke7FLnzW_Nb7kpXGecolCn9lZZ-6p_nvule86g";
	private static String LINK2 = "https://pay.qq.com/ipay/index.shtml";
	private static String[] LANGUAGE = { "Chinese (simple)", "English" };

	/** COMPONENT **/
	private ImageIcon imageIcon, imageIcon_lock, imageIcon_color, imageIcon_qb;
	private JFrame jFrame;
	private JLabel jLabel_raise_text1, jLabel_raise_text2, jLabel_raise_text3, jLabel_raise_text4, jLabel_raise_color;
	private JLabel jLabel_lost_text1, jLabel_lost_text2, jLabel_lost_text3, jLabel_lost_text4, jLabel_lost_color;
	private JLabel jLabel_lock, jLabel_contact, jLabel_title, jLabel_qb, jLabel_pay_text, jLabel_address;
	private JPanel jPanel_raise, jPanel_lost, jPanel_pay, jPanel_address;
	private LinkLabel linkLabel_1, linkLabel_2;
	private JComboBox<String> jComboBox;
	private JTextArea jTextArea_text;
	private JScrollPane jScrollPane;
	private JButton jButton_copy, jButton_check, jButton_decrypt;

	private JFrame initJFrame() {
		imageIcon = new ImageIcon(getClass().getResource(PATH_ICON));
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
		jFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.out.println("closing");
			}
		});
		jFrame.setVisible(true);
		return jFrame;
	}

	private void initView(JPanel jPanel) {
		jPanel.setLayout(null);
		jPanel.setSize(WIDTH, HEIGHT);
		jPanel.setBackground(Color.decode(TOPIC_COLOR));

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
		jPanel_raise.setBackground(Color.decode(TOPIC_COLOR));
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
		jPanel_lost.setBackground(Color.decode(TOPIC_COLOR));
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
		linkLabel_1 = new LinkLabel("About QB", LINK1);
		linkLabel_1.setBounds(30, 550, 100, 25);
		linkLabel_1.setFont(new Font(Font.SANS_SERIF, 0, 15));
		linkLabel_1.setForeground(Color.gray);
		jPanel.add(linkLabel_1);

		linkLabel_2 = new LinkLabel("How to buy QBs?", LINK2);
		linkLabel_2.setBounds(30, 585, 160, 25);
		linkLabel_2.setFont(new Font(Font.SANS_SERIF, 0, 15));
		linkLabel_2.setForeground(Color.gray);
		jPanel.add(linkLabel_2);

		jLabel_contact = new JLabel("<html><u>" + "Contact me");
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
		jComboBox.setBackground(Color.decode(TOPIC_COLOR));
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

		jScrollPane = new JScrollPane(jTextArea_text);
		jScrollPane.setBounds(290, 50, 700, 465);
		jScrollPane.setLayout(new ScrollPaneLayout());
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jPanel.add(jScrollPane);

		/** PAY **/
		jPanel_pay = new JPanel();
		jPanel_pay.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.lightGray));
		jPanel_pay.setBounds(290, 525, 700, 90);
		jPanel_pay.setBackground(Color.decode(TOPIC_COLOR));
		jPanel_pay.setLayout(null);
		jPanel.add(jPanel_pay);

		jLabel_qb = new JLabel();
		imageIcon_qb = new ImageIcon(getClass().getResource(PATH_QB));
		jLabel_qb.setIcon(imageIcon_qb);
		// width = 80, height = 80
		jLabel_qb.setBounds(0, 5, imageIcon_qb.getIconWidth(), imageIcon_qb.getIconHeight());
		jPanel_pay.add(jLabel_qb);

		jLabel_pay_text = new JLabel(PAY);
		jLabel_pay_text.setBounds(105, 7, 590, 25);
		jLabel_pay_text.setFont(new Font(Font.DIALOG, 1, 18));
		jLabel_pay_text.setForeground(Color.ORANGE);
		jPanel_pay.add(jLabel_pay_text);

		jPanel_address = new JPanel();
		jPanel_address.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.lightGray));
		jPanel_address.setBounds(105, 45, 545, 35);
		jPanel_address.setBackground(Color.decode(TOPIC_COLOR));
		jPanel_address.setLayout(null);
		jPanel_pay.add(jPanel_address);

		jLabel_address = new JLabel();
		jLabel_address.setText(ADDRESS);
		jLabel_address.setFont(new Font(Font.SANS_SERIF, 0, 18));
		jLabel_address.setBounds(2, 2, 471, 31);
		jLabel_address.setForeground(Color.white);
		jLabel_address.setBackground(Color.decode(TOPIC_COLOR));
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
		jLabel_contact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				jLabel_contact.setText("<html><u>" + "Contact me");
				jLabel_contact.setForeground(Color.decode("#96CDCD"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				jLabel_contact.setText("<html><u>" + "Contact me");
				jLabel_contact.setForeground(Color.decode("000000"));
			}
		});

		jLabel_contact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Message.getInstance();
			}
		});

		jButton_copy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(ADDRESS), null);
				JOptionPane.showMessageDialog(null, "Having pasted into your clipboard:\n" + ADDRESS, "Confirm",
						JOptionPane.CLOSED_OPTION);
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
