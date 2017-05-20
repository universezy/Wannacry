package com.demo.zy;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

class LinkLabel extends JLabel {
	private static final long serialVersionUID = 1L;
	private String text, url;
	private boolean isSupported;

	public LinkLabel(String text, String url) {
		super();
		setText(text);
		this.text = text;
		this.url = url;
		try {
			this.isSupported = Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE);
		} catch (Exception e) {
			this.isSupported = false;
		}
		setText(false);
		addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setText(isSupported);
				if (isSupported)
					setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				setText(false);
			}

			public void mouseClicked(MouseEvent e) {
				try {
					if (!LinkLabel.this.url.equals(""))
						Desktop.getDesktop().browse(new java.net.URI(LinkLabel.this.url));
				} catch (Exception ex) {
				}
			}
		});
	}

	private void setText(boolean b) {
		if (!b) {
			setText("<html><font color=gray><u>" + text);
		} else {
			setText("<html><font color=black><u>" + text);
		}
	}
}
