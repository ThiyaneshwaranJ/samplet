package newmaven.maven1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class pirates extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pirates frame = new pirates();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public pirates() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKalyaniFurnitures = new JLabel("Kalyani  Furnitures");
		lblKalyaniFurnitures.setBounds(197, 11, 146, 14);
		lblKalyaniFurnitures.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblKalyaniFurnitures);
		
		JLabel lblNewLabel = new JLabel("Product id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(28, 71, 100, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProductName.setBounds(28, 143, 100, 14);
		contentPane.add(lblProductName);
		
		JLabel lblProductPrice = new JLabel("Product Price");
		lblProductPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProductPrice.setBounds(28, 207, 97, 14);
		contentPane.add(lblProductPrice);
		
		JLabel label = new JLabel("");
		label.setBounds(193, 72, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(193, 72, 46, 14);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(197, 69, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(197, 141, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(197, 205, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		final JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0, String Productprice) {
				String Productid  = textField.getText();
				String Productname=textField_1.getText();
				String productprice =textField_2.getText();
				
				

				
				
				String str1="insert into pirates values('"+Productid+"','"+Productname+"','"+Productprice+"')";
						
			
				 try {
					Class.forName("org.h2.Driver");
				
					
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/sjava","sa","");
					
					Statement stmt=conn.createStatement();
					
					stmt.executeUpdate(str1);
				 
				 }catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					JOptionPane.showMessageDialog(btnAddProduct,"Added...");
			}

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		btnAddProduct.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddProduct.setBounds(364, 139, 133, 23);
		contentPane.add(btnAddProduct);
		
		JButton btnDeleteProduct = new JButton("Delete Product");
		btnDeleteProduct.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeleteProduct.setBounds(364, 68, 133, 23);
		contentPane.add(btnDeleteProduct);
		
		final JButton btnUpdateProduct = new JButton("Update Product");
		btnUpdateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String Productid  = textField.getText();
					String Productname=textField_1.getText();
					String productprice =textField_2.getText();

					String str1="update pirates set productid='"+Productid+"',productname='"+Productname+"',productprice='"+productprice+"'  where productid='"+Productid+"'";
					
					Class.forName("org.h2.Driver");
					
	                Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/sjava","sa","");
					
					Statement stmt=conn.createStatement();
					
					stmt.executeUpdate(str1);
					
					JOptionPane.showMessageDialog(btnUpdateProduct,"Updated...");
				}                   
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				
				
			}
		});
		btnUpdateProduct.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdateProduct.setBounds(364, 204, 133, 23);
		contentPane.add(btnUpdateProduct);
	}
}
