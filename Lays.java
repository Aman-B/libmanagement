package libmangaement;


import java.awt.event.*;

import java.io.*;


import javax.swing.*;


public class Lays {
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame("Library Management application");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);

		frame.setVisible(true);
		frame.setLocationRelativeTo( null );
	}

	
	
	
	//@SuppressWarnings("deprecation")
	private static void placeComponents( JPanel panel) throws IOException {

		
	
		panel.setLayout(null);

		JLabel userLabel = new JLabel("Username : ");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);
		
		
		

		final JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);
		
		//reading user-name
		 
		
		JLabel passwordLabel = new JLabel("Password : ");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		final JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		//reading password
	     
		
		JButton loginButton = new JButton("login");
		loginButton.setBounds(80, 80, 80, 25);
		panel.add(loginButton);
		
		
		
		
		//On pressing the login button
		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Login pressed!");
				final String uname = userText.getText();
				 System.out.println("username : " + uname);
				 final String pwd = new String (passwordText.getPassword());
				 System.out.println("password : " + pwd);
				 
				try {
					
					if (verify(uname, pwd)) {
						JOptionPane.showMessageDialog(null, " You've logged in succesfully! ");

						
					}

					else {
						JOptionPane.showMessageDialog(null, " Wrong username or passowrd! ");
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		/*JButton registerButton = new JButton("register");
		registerButton.setBounds(180, 80, 80, 25);
		panel.add(registerButton);
		*/
		
	
		
		
		
	}
	
	private static boolean verify(String uname, String pwd) throws IOException {
		// TODO Auto-generated method stub
		String line = null;
		BufferedReader br = null;
		String[] data= new String [1000];
		try {
			br = new BufferedReader(new FileReader("F:\\Sem-4\\SE pro\\Data.txt"));
			while ((line = br.readLine()) != null) {
				if (line.contains(uname)) {
					  data = line.split(":");

					return pwd.equals(data[1]);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return false;
	}
}