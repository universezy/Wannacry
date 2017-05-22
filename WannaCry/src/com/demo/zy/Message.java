package com.demo.zy;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 * @author ZengYu
 */

public class Message extends JFrame {
	/** CONFIG **/
	private static Message instance;
	private static final long serialVersionUID = 1L;
	private static int WIDTH = 460, HEIGHT = 290;
	private static String TOPIC_COLOR = "#8B2323";
	private static String PATH_ICON = "/resource/icon.png";

	/** COMPONENT **/
	private JFrame jFrame;
	private ImageIcon imageIcon;
	private JTextArea jTextArea;
	private JScrollPane jScrollPane;
	private JButton jButton_send,jButton_cancel;

	private Message() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				UIManager.put("InternalFrame.activeTitleBackground", new ColorUIResource(Color.BLUE));
				UIManager.put("InternalFrame.activeTitleForeground", new ColorUIResource(Color.RED));
				UIManager.put("InternalFrame.titleFont", new Font(Font.SERIF, 1, 15));
				JPanel jPanel = new JPanel();
				JFrame.setDefaultLookAndFeelDecorated(true);
				initJFrame().add(jPanel);
				initView(jPanel);
				setListener();
			}
		});
	}

	public static synchronized Message getInstance() {
		if (instance == null)
			instance = new Message();
		return instance;
	}

	private JFrame initJFrame() {
		imageIcon = new ImageIcon(getClass().getResource(PATH_ICON));
		jFrame = new JFrame("Message");
		jFrame.setIconImage(imageIcon.getImage());
		jFrame.setSize(WIDTH, HEIGHT);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jFrame.setResizable(false);
		jFrame.setUndecorated(true);
		jFrame.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
		jFrame.getRootPane().setBackground(Color.getColor("#0000CD"));
		jFrame.setLocationRelativeTo(null);
		jFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				instance = null;
			}
		});
		jFrame.setVisible(true);
		return jFrame;
	}

	private void initView(JPanel jPanel) {
		jPanel.setLayout(null);
		jPanel.setSize(WIDTH, HEIGHT);
		jPanel.setBackground(Color.decode(TOPIC_COLOR));

		jTextArea = new JTextArea();
		jTextArea.setFont(new Font(Font.SERIF, 1, 15));
		jTextArea.setBackground(Color.white);
		jTextArea.setEditable(true);
		jTextArea.setLineWrap(true);
		jTextArea.setWrapStyleWord(true);

		jScrollPane = new JScrollPane(jTextArea);
		jScrollPane.setBounds(10, 10, WIDTH - 30, HEIGHT - 120);
		jScrollPane.setLayout(new ScrollPaneLayout());
		jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jPanel.add(jScrollPane);
		
		jButton_send = new JButton("Send");
		jButton_send.setFont(new Font(Font.SERIF, 1, 15));
		jButton_send.setBounds(230, 210, 95, 30);
		jPanel.add(jButton_send);
		
		jButton_cancel = new JButton("Cancel");
		jButton_cancel.setFont(new Font(Font.SERIF, 1, 15));
		jButton_cancel.setBounds(345, 210, 95, 30);
		jPanel.add(jButton_cancel);
	}
	
	private void setListener(){
		jButton_send.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

			}
		});
		
		jButton_cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jFrame.dispatchEvent(new WindowEvent(jFrame, WindowEvent.WINDOW_CLOSING));

			}
		});
	}
}
