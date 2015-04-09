import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

public class FrontEnd {
	// fields
	private JFrame myFrame;
	private Box myBox;
	private Box myBox2;

	// constructor
	public FrontEnd() {
		myFrame = new JFrame("FrontEnd");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setPreferredSize(new Dimension(600, 100));
		myFrame.setLocation(400, 400);

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JTextArea messagearea = new JTextArea();
		messagearea.setWrapStyleWord(true);
		myBox = Box.createHorizontalBox();
		myBox2 = Box.createHorizontalBox();
		JTextField myuser = new JTextField();
		JButton input = new JButton("Add Message");
		JButton getm = new JButton("Get Messages");
		JButton getu = new JButton("Get Users");
		getm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String user = myuser.getText();
				List<String> getmessage = BackEnd.getMessages(user);
				messagearea.setText(getmessage.toString());
			}
		});

		input.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String message = messagearea.getText();
				String user = myuser.getText();
				BackEnd.addMessage(user, message);

			}
		});
		getu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				BackEnd.getUser();
			}
		});

		JLabel myusername = new JLabel("Username");
		JLabel mymessage = new JLabel("Message");
		myBox.add(myusername);
		myBox.add(myuser);
		myBox2.add(mymessage);
		myBox2.add(messagearea);
		myBox.add(input);
		myBox.add(getu);
		myBox.add(getm);

		p.add(myBox);
		p.add(myBox2);

		myFrame.add(p);
		// myFrame.add(myBox2);
		myFrame.pack();
		myFrame.setVisible(true);
	}
}
