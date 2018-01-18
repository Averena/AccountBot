package org.itstep.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import org.itstep.dao.AccountDAO;
import org.itstep.model.Account;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountUI extends JFrame {
	private JTextField tfSaveFn;
	private JTextField tfSaveSn;
	private JTextField tfSnGet;
	private JTextField tfFnGet;
	private JTextField tfOldFnUpd;
	private JTextField tfOldSnUpd;
	private JTextField tfNewFn;
	private JTextField tfNewSn;
	private JTextField tfLogin;
	private JTextField tfPass;
	private JTextField tfFnDel;
	private JTextField tfSnDel;
	private JTextField infoField;

	public AccountUI() {
		setTitle("Account manager");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 425);
		setResizable(false);
		setLocation(200, 200);
		getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 374, 332);
		getContentPane().add(tabbedPane);

		JPanel panelSave = new JPanel();
		tabbedPane.addTab("SAVE", null, panelSave, null);
		panelSave.setLayout(null);

		JLabel lblFnSave = new JLabel("First name");
		lblFnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFnSave.setBounds(10, 11, 100, 30);
		panelSave.add(lblFnSave);

		JLabel lblSnSave = new JLabel("Second name");
		lblSnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSnSave.setBounds(10, 52, 100, 30);
		panelSave.add(lblSnSave);

		tfSaveFn = new JTextField();
		tfSaveFn.setFont(new Font("Tahoma", Font.ITALIC, 13));
		tfSaveFn.setBounds(120, 11, 239, 30);
		panelSave.add(tfSaveFn);
		tfSaveFn.setColumns(10);

		tfSaveSn = new JTextField();
		tfSaveSn.setFont(new Font("Tahoma", Font.ITALIC, 13));
		tfSaveSn.setColumns(10);
		tfSaveSn.setBounds(120, 52, 239, 30);
		panelSave.add(tfSaveSn);

		JButton btnSaveAccount = new JButton("SAVE ACCOUNT");
		btnSaveAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAccount();
				getContentPane().repaint();
			}

		});
		btnSaveAccount.setForeground(Color.RED);
		btnSaveAccount.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSaveAccount.setBounds(10, 93, 349, 30);
		panelSave.add(btnSaveAccount);

		JPanel panelGet = new JPanel();
		tabbedPane.addTab("GET", null, panelGet, null);
		panelGet.setLayout(null);

		JLabel lblFnGet = new JLabel("First name");
		lblFnGet.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFnGet.setBounds(10, 11, 100, 30);
		panelGet.add(lblFnGet);

		JLabel lblSnGet = new JLabel("Second name");
		lblSnGet.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSnGet.setBounds(10, 52, 100, 30);
		panelGet.add(lblSnGet);

		JButton btnGetAccount = new JButton("GET ACCOUNT");
		btnGetAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAccount();
				getContentPane().repaint();
			}
		});
		btnGetAccount.setForeground(Color.RED);
		btnGetAccount.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGetAccount.setBounds(10, 93, 349, 30);
		panelGet.add(btnGetAccount);

		tfSnGet = new JTextField();
		tfSnGet.setFont(new Font("Tahoma", Font.ITALIC, 13));
		tfSnGet.setColumns(10);
		tfSnGet.setBounds(120, 52, 239, 30);
		panelGet.add(tfSnGet);

		tfFnGet = new JTextField();
		tfFnGet.setFont(new Font("Tahoma", Font.ITALIC, 13));
		tfFnGet.setColumns(10);
		tfFnGet.setBounds(120, 11, 239, 30);
		panelGet.add(tfFnGet);

		JPanel panelUpdate = new JPanel();
		tabbedPane.addTab("UPDATE", null, panelUpdate, null);
		panelUpdate.setLayout(null);

		JLabel lblFnUpd = new JLabel("First name");
		lblFnUpd.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFnUpd.setBounds(10, 11, 119, 30);
		panelUpdate.add(lblFnUpd);

		tfOldFnUpd = new JTextField();
		tfOldFnUpd.setFont(new Font("Tahoma", Font.ITALIC, 13));
		tfOldFnUpd.setColumns(10);
		tfOldFnUpd.setBounds(139, 11, 220, 30);
		panelUpdate.add(tfOldFnUpd);

		JLabel lblSnUpd = new JLabel("Second name");
		lblSnUpd.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSnUpd.setBounds(10, 52, 119, 30);
		panelUpdate.add(lblSnUpd);

		tfOldSnUpd = new JTextField();
		tfOldSnUpd.setFont(new Font("Tahoma", Font.ITALIC, 13));
		tfOldSnUpd.setColumns(10);
		tfOldSnUpd.setBounds(139, 52, 220, 30);
		panelUpdate.add(tfOldSnUpd);

		JButton btnUpdateAccount = new JButton("UPDATE ACCOUNT");
		btnUpdateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAccount();
				getContentPane().repaint();
			}
		});
		btnUpdateAccount.setForeground(Color.RED);
		btnUpdateAccount.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdateAccount.setBounds(10, 263, 349, 30);
		panelUpdate.add(btnUpdateAccount);

		JLabel lblNewFn = new JLabel("New first name");
		lblNewFn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewFn.setBounds(10, 93, 119, 30);
		panelUpdate.add(lblNewFn);

		JLabel lblNewSn = new JLabel("New second name");
		lblNewSn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewSn.setBounds(10, 134, 119, 30);
		panelUpdate.add(lblNewSn);

		tfNewFn = new JTextField();
		tfNewFn.setFont(new Font("Tahoma", Font.ITALIC, 13));
		tfNewFn.setColumns(10);
		tfNewFn.setBounds(139, 93, 220, 30);
		panelUpdate.add(tfNewFn);

		tfNewSn = new JTextField();
		tfNewSn.setFont(new Font("Tahoma", Font.ITALIC, 13));
		tfNewSn.setColumns(10);
		tfNewSn.setBounds(139, 134, 220, 30);
		panelUpdate.add(tfNewSn);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogin.setBounds(10, 175, 119, 30);
		panelUpdate.add(lblLogin);

		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPass.setBounds(10, 216, 119, 30);
		panelUpdate.add(lblPass);

		tfLogin = new JTextField();
		tfLogin.setFont(new Font("Tahoma", Font.ITALIC, 13));
		tfLogin.setColumns(10);
		tfLogin.setBounds(139, 175, 220, 30);
		panelUpdate.add(tfLogin);

		tfPass = new JTextField();
		tfPass.setFont(new Font("Tahoma", Font.ITALIC, 13));
		tfPass.setColumns(10);
		tfPass.setBounds(139, 216, 220, 30);
		panelUpdate.add(tfPass);

		JPanel panelDelete = new JPanel();
		tabbedPane.addTab("DELETE", null, panelDelete, null);
		panelDelete.setLayout(null);

		JLabel lblFnDel = new JLabel("First name");
		lblFnDel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFnDel.setBounds(10, 11, 100, 30);
		panelDelete.add(lblFnDel);

		tfFnDel = new JTextField();
		tfFnDel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		tfFnDel.setColumns(10);
		tfFnDel.setBounds(120, 11, 239, 30);
		panelDelete.add(tfFnDel);

		tfSnDel = new JTextField();
		tfSnDel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		tfSnDel.setColumns(10);
		tfSnDel.setBounds(120, 52, 239, 30);
		panelDelete.add(tfSnDel);

		JLabel lblSnDel = new JLabel("Second name");
		lblSnDel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSnDel.setBounds(10, 52, 100, 30);
		panelDelete.add(lblSnDel);

		JButton btnDelAccount = new JButton("DELETE ACCOUNT");
		btnDelAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAccount();
				getContentPane().repaint();
			}
		});
		btnDelAccount.setForeground(Color.RED);
		btnDelAccount.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelAccount.setBounds(10, 93, 349, 30);
		panelDelete.add(btnDelAccount);

		infoField = new JTextField();
		infoField.setForeground(Color.RED);
		infoField.setFont(new Font("Tahoma", Font.BOLD, 13));
		infoField.setEditable(false);
		infoField.setBounds(10, 354, 374, 32);
		getContentPane().add(infoField);
		infoField.setColumns(10);
		setVisible(true);

		getContentPane().repaint();
	}

	private void saveAccount() {
		String firstName = tfSaveFn.getText();
		String secondName = tfSaveSn.getText();
		
		
		AccountDAO accDAO = new AccountDAO();
		accDAO.save(new Account(firstName, secondName));
		
		infoField.setText("Account "+secondName+" was saved!");
	}

	private void getAccount() {
		String firstName = tfFnGet.getText();
		String secondName = tfSnGet.getText();
		
		
		AccountDAO accDAO = new AccountDAO();
		Account account = accDAO.get(firstName, secondName);
		
		if(account.getEmail()!=null) {
			infoField.setText("Account "+secondName+" was found!");
		}else {
			infoField.setText("Account "+secondName+" was not found!");
		}
		
	}

	private void updateAccount() {
		String oldFirstName = tfOldFnUpd.getText();
		String oldSecondName = tfOldSnUpd.getText();
		Account newAccount = new Account();
		newAccount.setFirstName(tfNewFn.getText());
		newAccount.setSecondName(tfNewSn.getText());
		newAccount.setEmail(tfLogin.getText());
		newAccount.setPassword(tfPass.getText());
		
		AccountDAO accDAO = new AccountDAO();
		
		Account accFromDB = accDAO.get(oldFirstName,oldSecondName);
		
		if(accFromDB.getEmail()!=null) {
			accDAO.update(oldFirstName, oldSecondName, newAccount);
			infoField.setText("Account "+oldSecondName+" was updated");
		}else {
			infoField.setText("Account "+oldSecondName+" was not found in DB!");
		}
	
	}

	 private void deleteAccount() {
		  String firstName = tfFnDel.getText();
		  String secondName = tfSnDel.getText();

		  AccountDAO accDao = new AccountDAO();
		  accDao.delete(firstName, secondName);

		  infoField.setText("Account " + secondName + " was deleted!");

	}
}