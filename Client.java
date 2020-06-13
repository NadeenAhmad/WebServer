package chat;

//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Client implements Runnable {
	static Socket clientSocket;
	boolean closed;
	static ObjectOutputStream out;
	static BufferedReader inputLine;
	static ObjectInputStream in;

	public static void main(String[] args) throws IOException {

		new Client();
		// run
	}

	public Client() throws IOException {

		clientSocket = new Socket("localhost", 6789);

		inputLine = new BufferedReader(new InputStreamReader(System.in));
		in = new ObjectInputStream(clientSocket.getInputStream());

		JFrame guiFrame = new JFrame();

		// make sure the program exits when the frame closes
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("Pintrest");
		guiFrame.setSize(1000, 800);

		// This will center the JFrame in the middle of the screen
		guiFrame.setLocationRelativeTo(null);
		guiFrame.getContentPane().setBackground(Color.WHITE);

		BufferedImage myPicture = ImageIO.read(new File(
				"C:/Users/nadeen/Desktop/p.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));

		JPanel panel = (JPanel) guiFrame.getContentPane();
		panel.setLayout(null);

		panel.add(picLabel);
		Dimension size = picLabel.getPreferredSize();
		picLabel.setBounds(0, 0, size.width, size.height);

		JPanel panel1 = (JPanel) guiFrame.getContentPane();
		panel1.setLayout(null);

		ImageIcon r = new ImageIcon("C:/Users/nadeen/Desktop/close.png");

		JButton r2 = new JButton();
		r2.setIcon(r);
		JPanel panelr = (JPanel) guiFrame.getContentPane();
		panelr.setLayout(null);

		panelr.add(r2);

		r2.setBounds(850, 25, 90, 26);
boolean f = true;
		r2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// sending object to close socket
				Object a = "close";
				try {
					if (!f){
					out = new ObjectOutputStream(clientSocket.getOutputStream());
					out.flush();
					out.writeObject(a);}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				guiFrame.setVisible(false);
			}
		});

		
		
		
		
		
		
		ImageIcon q = new ImageIcon("C:/Users/nadeen/Desktop/404.png");

		JButton q2 = new JButton();
		q2.setIcon(q);
		JPanel panelq = (JPanel) guiFrame.getContentPane();
		panelq.setLayout(null);

		panelq.add(q2);

		q2.setBounds(550, 25, 190, 26);

		q2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				HTTPReq one = new HTTPReq("Get",
						"C:/Users/nadeen/Desktop/docroot/text3.txt",
						"HTTP 1.1", "localhost", "txt,jpg,png,mp4",
						"keep-alive");

					try {
						out = new ObjectOutputStream(clientSocket.getOutputStream());
						out.flush();
						out.writeObject(one);
									
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				
			
				HTTPRes response = new HTTPRes("404 Not Found", "HTTP 1.1", "txt",
						"Keep alive");
				System.out.println("Status " + response.Status + " Version "
						+ response.Version);
				System.out.println("Timestamp " + response.Timestamp);
				System.out.println("Format " + response.Format);
				System.out.println("Connection " + response.Connection + "\n");

				closed = true;
}
		});

		
		
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Font myFont = new Font("SansSerif", Font.ITALIC, 12);

		JLabel t = new JLabel("Thanks Giving Turkey Recipe");
		t.setFont(myFont);
		t.setLocation(10, 120);

		panel1.add(t);
		Dimension size1 = t.getPreferredSize();
		t.setBounds(30, 100, size1.width, size1.height);

		BufferedImage turkey = ImageIO.read(new File(
				"C:/Users/nadeen/Desktop/t.jpg"));
		JLabel picLabel2 = new JLabel(new ImageIcon(turkey));

		JPanel panel2 = (JPanel) guiFrame.getContentPane();
		panel2.setLayout(null);

		panel2.add(picLabel2);
		Dimension size2 = picLabel2.getPreferredSize();
		picLabel2.setBounds(10, 120, size2.width, size2.height);

		ImageIcon b1 = new ImageIcon("C:/Users/nadeen/Desktop/b1.png");

		JButton b2 = new JButton();
		b2.setIcon(b1);
		JPanel panel9 = (JPanel) guiFrame.getContentPane();
		panel9.setLayout(null);

		panel9.add(b2);

		b2.setBounds(30, 270, 140, 26);

		// closed = true;

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closed = false;

				// sending request to server over socket
				// request filled with data
				HTTPReq one = new HTTPReq("Get",
						"C:/Users/nadeen/Desktop/docroot/text1.txt",
						"HTTP 1.1", "localhost", "txt,jpg,png,mp4",
						"keep-alive");
				try {

					out = new ObjectOutputStream(clientSocket.getOutputStream());

					out.flush();
					out.writeObject(one);
					BufferedImage brownie = ImageIO.read(new File(
							"C:/Users/nadeen/Desktop/done.png"));
					JLabel picLabel3 = new JLabel(new ImageIcon(brownie));

					JPanel panel4 = (JPanel) guiFrame.getContentPane();
					panel4.setLayout(null);

					panel4.add(picLabel3);
					Dimension size4 = picLabel3.getPreferredSize();
					picLabel3.setBounds(600, 500, size4.width, size4.height);
					picLabel3.setVisible(true);

					Timer autoHideTimer = new Timer(1000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							picLabel3.setVisible(false);
						}

					});
					autoHideTimer.start();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				HTTPRes response = new HTTPRes("200 OK", "HTTP 1.1", "txt",
						"Keep alive");
				System.out.println("Status " + response.Status + " Version "
						+ response.Version);
				System.out.println("Timestamp " + response.Timestamp);
				System.out.println("Format " + response.Format);
				System.out.println("Connection " + response.Connection + "\n");

				closed = true;

			}

		});

		JPanel panel3 = (JPanel) guiFrame.getContentPane();
		panel3.setLayout(null);

		JLabel b = new JLabel("Chocolate Brownies Recipe");
		b.setFont(myFont);
		b.setLocation(10, 120);

		panel3.add(b);
		Dimension size3 = b.getPreferredSize();
		b.setBounds(270, 100, size3.width, size3.height);

		BufferedImage brownie = ImageIO.read(new File(
				"C:/Users/nadeen/Desktop/b.jpg"));
		JLabel picLabel3 = new JLabel(new ImageIcon(brownie));

		JPanel panel4 = (JPanel) guiFrame.getContentPane();
		panel4.setLayout(null);

		panel4.add(picLabel3);
		Dimension size4 = picLabel3.getPreferredSize();
		picLabel3.setBounds(250, 120, size4.width, size4.height);

		ImageIcon b3 = new ImageIcon("C:/Users/nadeen/Desktop/b1.png");

		JButton b4 = new JButton();
		b4.setIcon(b3);
		JPanel panel10 = (JPanel) guiFrame.getContentPane();
		panel10.setLayout(null);

		panel10.add(b4);

		b4.setBounds(270, 270, 140, 26);

		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closed = false;

				HTTPReq one = new HTTPReq("Get",
						"C:/Users/nadeen/Desktop/docroot/text2.txt",
						"HTTP 1.1", "localhost", "txt,jpg,png,mp4",
						"keep-alive");
				try {
					out = new ObjectOutputStream(clientSocket.getOutputStream());

					out.flush();
					out.writeObject(one);
					BufferedImage brownie = ImageIO.read(new File(
							"C:/Users/nadeen/Desktop/done.png"));
					JLabel picLabel3 = new JLabel(new ImageIcon(brownie));

					JPanel panel4 = (JPanel) guiFrame.getContentPane();
					panel4.setLayout(null);

					panel4.add(picLabel3);
					Dimension size4 = picLabel3.getPreferredSize();
					picLabel3.setBounds(600, 500, size4.width, size4.height);
					picLabel3.setVisible(true);

					Timer autoHideTimer = new Timer(1000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							picLabel3.setVisible(false);
						}

					});
					autoHideTimer.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				HTTPRes response = new HTTPRes("200 OK", "HTTP 1.1", "txt",
						"Keep alive");

				System.out.println("Status " + response.Status + " Version "
						+ response.Version);
				System.out.println("Timestamp " + response.Timestamp);
				System.out.println("Format " + response.Format);
				System.out.println("Connection " + response.Connection + "\n");

				closed = true;

			}
		});

		JPanel panel5 = (JPanel) guiFrame.getContentPane();
		panel5.setLayout(null);

		JLabel p2 = new JLabel("Pasta Recipe");
		p2.setFont(myFont);
		p2.setLocation(10, 120);

		panel5.add(p2);
		Dimension size5 = p2.getPreferredSize();
		p2.setBounds(550, 100, size5.width, size5.height);

		BufferedImage pasta = ImageIO.read(new File(
				"C:/Users/nadeen/Desktop/p2.jpg"));
		JLabel picLabel4 = new JLabel(new ImageIcon(pasta));

		JPanel panel6 = (JPanel) guiFrame.getContentPane();
		panel6.setLayout(null);

		panel6.add(picLabel4);
		Dimension size6 = picLabel4.getPreferredSize();
		picLabel4.setBounds(490, 120, size6.width, size6.height);

		ImageIcon b5 = new ImageIcon("C:/Users/nadeen/Desktop/b1.png");

		JButton b6 = new JButton();
		b6.setIcon(b5);
		JPanel panel11 = (JPanel) guiFrame.getContentPane();
		panel11.setLayout(null);

		panel11.add(b6);

		b6.setBounds(510, 270, 140, 26);

		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closed = false;

				HTTPReq one = new HTTPReq("Get",
						"C:/Users/nadeen/Desktop/docroot/text3.txt",
						"HTTP 1.1", "localhost", "txt,jpg,png,mp4",
						"keep-alive");
				try {
					out = new ObjectOutputStream(clientSocket.getOutputStream());

					out.flush();
					out.writeObject(one);
					BufferedImage brownie = ImageIO.read(new File(
							"C:/Users/nadeen/Desktop/done.png"));
					JLabel picLabel3 = new JLabel(new ImageIcon(brownie));

					JPanel panel4 = (JPanel) guiFrame.getContentPane();
					panel4.setLayout(null);

					panel4.add(picLabel3);
					Dimension size4 = picLabel3.getPreferredSize();
					picLabel3.setBounds(600, 500, size4.width, size4.height);
					picLabel3.setVisible(true);

					Timer autoHideTimer = new Timer(1000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							picLabel3.setVisible(false);
						}

					});
					autoHideTimer.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				HTTPRes response = new HTTPRes("200 OK", "HTTP 1.1", "txt",
						"Keep alive");

				System.out.println("Status " + response.Status + " Version "
						+ response.Version);
				System.out.println("Timestamp " + response.Timestamp);
				System.out.println("Format " + response.Format);
				System.out.println("Connection " + response.Connection + "\n");

				closed = true;

			}
		});
		JPanel panel7 = (JPanel) guiFrame.getContentPane();
		panel7.setLayout(null);

		JLabel c = new JLabel("CheeseCake Recipe");
		c.setFont(myFont);
		c.setLocation(10, 120);

		panel7.add(c);
		Dimension size7 = c.getPreferredSize();
		c.setBounds(750, 100, size7.width, size7.height);

		BufferedImage cheeseCake = ImageIO.read(new File(
				"C:/Users/nadeen/Desktop/c.jpg"));
		JLabel picLabel5 = new JLabel(new ImageIcon(cheeseCake));

		JPanel panel8 = (JPanel) guiFrame.getContentPane();
		panel8.setLayout(null);

		panel8.add(picLabel5);
		Dimension size8 = picLabel5.getPreferredSize();
		picLabel5.setBounds(730, 120, size8.width, size8.height);

		ImageIcon b7 = new ImageIcon("C:/Users/nadeen/Desktop/b1.png");

		JButton b8 = new JButton();
		b8.setIcon(b7);

		JPanel panel12 = (JPanel) guiFrame.getContentPane();
		panel12.setLayout(null);

		panel12.add(b8);

		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closed = false;

				HTTPReq one = new HTTPReq("Get",
						"C:/Users/nadeen/Desktop/docroot/text4.txt",
						"HTTP 1.1", "localhost", "txt,jpg,png,mp4",
						"keep-alive");
				try {
					out = new ObjectOutputStream(clientSocket.getOutputStream());

					out.flush();
					out.writeObject(one);
					BufferedImage brownie = ImageIO.read(new File(
							"C:/Users/nadeen/Desktop/done.png"));
					JLabel picLabel3 = new JLabel(new ImageIcon(brownie));

					JPanel panel4 = (JPanel) guiFrame.getContentPane();
					panel4.setLayout(null);

					panel4.add(picLabel3);
					Dimension size4 = picLabel3.getPreferredSize();
					picLabel3.setBounds(600, 500, size4.width, size4.height);
					picLabel3.setVisible(true);

					Timer autoHideTimer = new Timer(1000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							picLabel3.setVisible(false);
						}

					});
					autoHideTimer.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				HTTPRes response = new HTTPRes("200 OK", "HTTP 1.1", "txt",
						"Keep alive");

				System.out.println("Status " + response.Status + " Version "
						+ response.Version);
				System.out.println("Timestamp " + response.Timestamp);
				System.out.println("Format " + response.Format);
				System.out.println("Connection " + response.Connection + "\n");

				closed = true;

			}
		});

		b8.setBounds(730, 270, 140, 26);

		JPanel panel13 = (JPanel) guiFrame.getContentPane();
		panel13.setLayout(null);

		JLabel p1 = new JLabel("Monsters inc Sticker");
		p1.setFont(myFont);
		p1.setLocation(10, 120);

		panel13.add(p1);
		Dimension size9 = p1.getPreferredSize();
		p1.setBounds(40, 310, 200, size9.height);

		BufferedImage m1 = ImageIO.read(new File(
				"C:/Users/nadeen/Desktop/png1.png"));
		JLabel picLabel6 = new JLabel(new ImageIcon(m1));

		JPanel panel14 = (JPanel) guiFrame.getContentPane();
		panel14.setLayout(null);

		panel14.add(picLabel6);
		Dimension size10 = picLabel6.getPreferredSize();
		picLabel6.setBounds(20, 320, size10.width, size10.height);

		ImageIcon b9 = new ImageIcon("C:/Users/nadeen/Desktop/b2.png");

		JButton b10 = new JButton();
		b10.setIcon(b9);
		JPanel panel15 = (JPanel) guiFrame.getContentPane();
		panel15.setLayout(null);

		panel15.add(b10);
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closed = false;

				HTTPReq one = new HTTPReq("Get",
						"C:/Users/nadeen/Desktop/docroot/png1.png",
						"HTTP 1.1", "localhost", "txt,jpg,png,mp4",
						"keep-alive");
				try {
					out = new ObjectOutputStream(clientSocket.getOutputStream());

					out.flush();
					out.writeObject(one);
					BufferedImage brownie = ImageIO.read(new File(
							"C:/Users/nadeen/Desktop/done.png"));
					JLabel picLabel3 = new JLabel(new ImageIcon(brownie));

					JPanel panel4 = (JPanel) guiFrame.getContentPane();
					panel4.setLayout(null);

					panel4.add(picLabel3);
					Dimension size4 = picLabel3.getPreferredSize();
					picLabel3.setBounds(600, 500, size4.width, size4.height);
					picLabel3.setVisible(true);

					Timer autoHideTimer = new Timer(1000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							picLabel3.setVisible(false);
						}

					});
					autoHideTimer.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				HTTPRes response = new HTTPRes("200 OK", "HTTP 1.1", "png",
						"Keep alive");

				System.out.println("Status " + response.Status + " Version "
						+ response.Version);
				System.out.println("Timestamp " + response.Timestamp);
				System.out.println("Format " + response.Format);
				System.out.println("Connection " + response.Connection + "\n");

				closed = true;

			}
		});
		b10.setBounds(20, 490, 180, 26);

		JPanel panel16 = (JPanel) guiFrame.getContentPane();
		panel16.setLayout(null);

		JLabel p3 = new JLabel("Monsters inc Sticker");
		p3.setFont(myFont);
		p3.setLocation(10, 120);

		panel16.add(p3);
		Dimension size11 = p3.getPreferredSize();
		p3.setBounds(270, 310, 220, size11.height);

		BufferedImage m2 = ImageIO.read(new File(
				"C:/Users/nadeen/Desktop/png2.png"));
		JLabel picLabel7 = new JLabel(new ImageIcon(m2));

		JPanel panel17 = (JPanel) guiFrame.getContentPane();
		panel17.setLayout(null);

		panel17.add(picLabel7);
		Dimension size12 = picLabel7.getPreferredSize();
		picLabel7.setBounds(250, 320, size12.width, size12.height);

		ImageIcon b11 = new ImageIcon("C:/Users/nadeen/Desktop/b2.png");

		JButton b12 = new JButton();
		b12.setIcon(b11);
		JPanel panel18 = (JPanel) guiFrame.getContentPane();
		panel18.setLayout(null);

		panel18.add(b12);

		b12.setBounds(250, 490, 180, 26);
		b12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closed = false;

				HTTPReq one = new HTTPReq("Get",
						"C:/Users/nadeen/Desktop/docroot/png2.png",
						"HTTP 1.1", "localhost", "txt,jpg,png,mp4",
						"keep-alive");
				try {
					out = new ObjectOutputStream(clientSocket.getOutputStream());

					out.flush();
					out.writeObject(one);
					BufferedImage brownie = ImageIO.read(new File(
							"C:/Users/nadeen/Desktop/done.png"));
					JLabel picLabel3 = new JLabel(new ImageIcon(brownie));

					JPanel panel4 = (JPanel) guiFrame.getContentPane();
					panel4.setLayout(null);

					panel4.add(picLabel3);
					Dimension size4 = picLabel3.getPreferredSize();
					picLabel3.setBounds(600, 500, size4.width, size4.height);
					picLabel3.setVisible(true);

					Timer autoHideTimer = new Timer(1000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							picLabel3.setVisible(false);
						}

					});
					autoHideTimer.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				HTTPRes response = new HTTPRes("200 OK", "HTTP 1.1", "png",
						"Keep alive");
				System.out.println("Status " + response.Status + " Version "
						+ response.Version);
				System.out.println("Timestamp " + response.Timestamp);
				System.out.println("Format " + response.Format);
				System.out.println("Connection " + response.Connection + "\n");

				closed = true;

			}
		});
		JPanel panel19 = (JPanel) guiFrame.getContentPane();
		panel19.setLayout(null);

		JLabel p4 = new JLabel("Desktop Wallpaper");
		p4.setFont(myFont);
		p4.setLocation(10, 120);

		panel19.add(p4);
		Dimension size13 = p4.getPreferredSize();
		p4.setBounds(530, 310, 220, size13.height);

		BufferedImage w1 = ImageIO.read(new File(
				"C:/Users/nadeen/Desktop/wall1.jpg"));
		JLabel picLabel8 = new JLabel(new ImageIcon(w1));

		JPanel panel20 = (JPanel) guiFrame.getContentPane();
		panel20.setLayout(null);

		panel20.add(picLabel8);
		Dimension size14 = picLabel8.getPreferredSize();
		picLabel8.setBounds(470, 340, size14.width, size14.height);

		ImageIcon b13 = new ImageIcon("C:/Users/nadeen/Desktop/b3.png");

		JButton b14 = new JButton();
		b14.setIcon(b13);
		JPanel panel21 = (JPanel) guiFrame.getContentPane();
		panel21.setLayout(null);

		panel21.add(b14);

		b14.setBounds(500, 490, 180, 26);
		b14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closed = false;

				HTTPReq one = new HTTPReq("Get",
						"C:/Users/nadeen/Desktop/docroot/wall1.jpg",
						"HTTP 1.1", "localhost", "txt,jpg,png,mp4",
						"keep-alive");
				try {
					out = new ObjectOutputStream(clientSocket.getOutputStream());

					out.flush();
					out.writeObject(one);
					BufferedImage brownie = ImageIO.read(new File(
							"C:/Users/nadeen/Desktop/done.png"));
					JLabel picLabel3 = new JLabel(new ImageIcon(brownie));

					JPanel panel4 = (JPanel) guiFrame.getContentPane();
					panel4.setLayout(null);

					panel4.add(picLabel3);
					Dimension size4 = picLabel3.getPreferredSize();
					picLabel3.setBounds(600, 500, size4.width, size4.height);
					picLabel3.setVisible(true);

					Timer autoHideTimer = new Timer(1000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							picLabel3.setVisible(false);
						}

					});
					autoHideTimer.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				HTTPRes response = new HTTPRes("200 OK", "HTTP 1.1", "png",
						"Keep alive");
				System.out.println("Status " + response.Status + " Version "
						+ response.Version);
				System.out.println("Timestamp " + response.Timestamp);
				System.out.println("Format " + response.Format);
				System.out.println("Connection " + response.Connection + "\n");

				closed = true;

			}
		});

		JPanel panel22 = (JPanel) guiFrame.getContentPane();
		panel22.setLayout(null);

		JLabel p5 = new JLabel("Desktop Wallpaper");
		p5.setFont(myFont);
		p5.setLocation(10, 120);

		panel22.add(p5);
		Dimension size15 = p5.getPreferredSize();
		p5.setBounds(790, 310, 220, size15.height);

		BufferedImage w2 = ImageIO.read(new File(
				"C:/Users/nadeen/Desktop/wall2.jpg"));
		JLabel picLabel9 = new JLabel(new ImageIcon(w2));

		JPanel panel23 = (JPanel) guiFrame.getContentPane();
		panel23.setLayout(null);

		panel23.add(picLabel9);
		Dimension size16 = picLabel9.getPreferredSize();
		picLabel9.setBounds(760, 340, size16.width, size16.height);

		ImageIcon b15 = new ImageIcon("C:/Users/nadeen/Desktop/b3.png");

		JButton b16 = new JButton();
		b16.setIcon(b15);
		JPanel panel24 = (JPanel) guiFrame.getContentPane();
		panel24.setLayout(null);

		panel24.add(b16);

		b16.setBounds(770, 490, 180, 26);
		b16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closed = false;

				HTTPReq one = new HTTPReq("Get",
						"C:/Users/nadeen/Desktop/docroot/wall2.jpg",
						"HTTP 1.1", "localhost", "txt,jpg,png,mp4",
						"keep-alive");
				try {
					out = new ObjectOutputStream(clientSocket.getOutputStream());

					out.flush();
					out.writeObject(one);
					BufferedImage brownie = ImageIO.read(new File(
							"C:/Users/nadeen/Desktop/done.png"));
					JLabel picLabel3 = new JLabel(new ImageIcon(brownie));

					JPanel panel4 = (JPanel) guiFrame.getContentPane();
					panel4.setLayout(null);

					panel4.add(picLabel3);
					Dimension size4 = picLabel3.getPreferredSize();
					picLabel3.setBounds(600, 500, size4.width, size4.height);
					picLabel3.setVisible(true);

					Timer autoHideTimer = new Timer(1000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							picLabel3.setVisible(false);
						}

					});
					autoHideTimer.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				HTTPRes response = new HTTPRes("200 OK", "HTTP 1.1", "png",
						"Keep alive");
				System.out.println("Status " + response.Status + " Version "
						+ response.Version);
				System.out.println("Timestamp " + response.Timestamp);
				System.out.println("Format " + response.Format);
				System.out.println("Connection " + response.Connection + "\n");

				closed = true;

			}
		});
		JPanel panel25 = (JPanel) guiFrame.getContentPane();
		panel25.setLayout(null);

		JLabel p6 = new JLabel("Butterfly Origami Tutorial");
		p6.setFont(myFont);
		p6.setLocation(10, 120);

		panel25.add(p6);
		Dimension size17 = p6.getPreferredSize();
		p6.setBounds(40, 520, 200, size17.height);

		BufferedImage mp4 = ImageIO.read(new File(
				"C:/Users/nadeen/Desktop/mp4.png"));
		JLabel picLabel10 = new JLabel(new ImageIcon(mp4));

		JPanel panel26 = (JPanel) guiFrame.getContentPane();
		panel26.setLayout(null);

		panel26.add(picLabel10);
		Dimension size18 = picLabel10.getPreferredSize();
		picLabel10.setBounds(20, 540, size18.width, size18.height);

		ImageIcon b17 = new ImageIcon("C:/Users/nadeen/Desktop/b4.png");

		JButton b18 = new JButton();
		b18.setIcon(b17);
		JPanel panel27 = (JPanel) guiFrame.getContentPane();
		panel27.setLayout(null);

		panel27.add(b18);

		b18.setBounds(30, 665, 180, 26);
		b18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closed = false;

				HTTPReq one = new HTTPReq("Get",
						"C:/Users/nadeen/Desktop/docroot/mp4One.mp4",
						"HTTP 1.1", "localhost", "txt,jpg,png,mp4",
						"keep-alive");
				try {
					out = new ObjectOutputStream(clientSocket.getOutputStream());

					out.flush();
					out.writeObject(one);
					BufferedImage brownie = ImageIO.read(new File(
							"C:/Users/nadeen/Desktop/done.png"));
					JLabel picLabel3 = new JLabel(new ImageIcon(brownie));

					JPanel panel4 = (JPanel) guiFrame.getContentPane();
					panel4.setLayout(null);

					panel4.add(picLabel3);
					Dimension size4 = picLabel3.getPreferredSize();
					picLabel3.setBounds(600, 500, size4.width, size4.height);
					picLabel3.setVisible(true);

					Timer autoHideTimer = new Timer(1000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							picLabel3.setVisible(false);
						}

					});
					autoHideTimer.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				HTTPRes response = new HTTPRes("200 OK", "HTTP 1.1", "png",
						"Keep alive");

				System.out.println("Status " + response.Status + " Version "
						+ response.Version);
				System.out.println("Timestamp " + response.Timestamp);
				System.out.println("Format " + response.Format);
				System.out.println("Connection " + response.Connection + "\n");

				closed = true;

			}
		});
		JPanel panel30 = (JPanel) guiFrame.getContentPane();
		panel30.setLayout(null);

		JLabel p7 = new JLabel("DIY Pop-up greeting Card");
		p7.setFont(myFont);
		p7.setLocation(10, 120);

		panel30.add(p7);
		Dimension size20 = p7.getPreferredSize();
		p7.setBounds(275, 520, 200, size20.height);

		BufferedImage mp42 = ImageIO.read(new File(
				"C:/Users/nadeen/Desktop/mp42.png"));
		JLabel picLabel11 = new JLabel(new ImageIcon(mp42));

		JPanel panel28 = (JPanel) guiFrame.getContentPane();
		panel28.setLayout(null);

		panel28.add(picLabel11);
		Dimension size19 = picLabel11.getPreferredSize();
		picLabel11.setBounds(270, 550, size19.width, size19.height);

		ImageIcon b19 = new ImageIcon("C:/Users/nadeen/Desktop/b4.png");

		JButton b20 = new JButton();
		b20.setIcon(b19);
		JPanel panel29 = (JPanel) guiFrame.getContentPane();
		panel29.setLayout(null);

		panel29.add(b20);

		b20.setBounds(260, 665, 180, 26);
		b20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closed = false;

				HTTPReq one = new HTTPReq("Get",
						"C:/Users/nadeen/Desktop/docroot/mp4Two.mp4",
						"HTTP 1.1", "localhost", "txt,jpg,png,mp4",
						"keep-alive");
				try {
					out = new ObjectOutputStream(clientSocket.getOutputStream());

					out.flush();
					out.writeObject(one);
					BufferedImage brownie = ImageIO.read(new File(
							"C:/Users/nadeen/Desktop/done.png"));
					JLabel picLabel3 = new JLabel(new ImageIcon(brownie));

					JPanel panel4 = (JPanel) guiFrame.getContentPane();
					panel4.setLayout(null);

					panel4.add(picLabel3);
					Dimension size4 = picLabel3.getPreferredSize();
					picLabel3.setBounds(600, 500, size4.width, size4.height);
					picLabel3.setVisible(true);

					Timer autoHideTimer = new Timer(1000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							picLabel3.setVisible(false);
						}

					});
					autoHideTimer.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				HTTPRes response = new HTTPRes("200 OK", "HTTP 1.1", "png",
						"Keep alive");

				System.out.println("Status " + response.Status + " Version "
						+ response.Version);
				System.out.println("Timestamp " + response.Timestamp);
				System.out.println("Format " + response.Format);
				System.out.println("Connection " + response.Connection + "\n");

				closed = true;

			}
		});
		// make sure the JFrame is visible
		guiFrame.setVisible(true);

	}

	@Override
	public void run() {
		try {
			Object r = in.readObject();
			String reply = r.toString();

			while (reply != null) {
				System.out.println(reply);

			}
			// closed = true;
		} catch (IOException | ClassNotFoundException e) {
		}
	}
}
