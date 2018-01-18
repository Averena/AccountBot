package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.itstep.model.Account;

public class AccountDAO {

	public void save(Account account) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "INSERT INTO account(first_name, second_name, password, login) VALUES(?,?,?,?)";

		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, account.getFirstName());
			statement.setString(2, account.getSecondName());
			statement.setString(3, account.getPassword());
			statement.setString(4, account.getEmail());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public Account get(String firstName, String secondName) {
		Account account = new Account();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM account WHERE first_name=? AND second_name=?";

		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			
		
			statement.setString(1, firstName);
			statement.setString(2, secondName);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				account.setFirstName(resultSet.getString("first_name"));
				account.setSecondName(resultSet.getString("second_name"));
				account.setEmail(resultSet.getString("login"));
				account.setPassword(resultSet.getString("password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return account;

	}

	public void update(String firstName, String secondName, Account newAccount) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE account SET first_name=?, second_name=?, login=?, password=? WHERE first_name=? AND second_name=?";
		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, newAccount.getFirstName());
			statement.setString(4, newAccount.getPassword());
			statement.setString(2, newAccount.getSecondName());
			statement.setString(3, newAccount.getEmail());
			statement.setString(5, firstName);
			statement.setString(6, secondName);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void delete(String firstName, String secondName) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "DELETE FROM account WHERE first_name=? AND second_name=?";
		try {
			connection = DBConnection.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, secondName);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}