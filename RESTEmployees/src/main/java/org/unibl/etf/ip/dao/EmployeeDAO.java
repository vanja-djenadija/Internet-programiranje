package org.unibl.etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.unibl.etf.ip.dto.Employee;


public class EmployeeDAO {
	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	private static final String SQL_SELECT_ALL = "SELECT * FROM employees";
	// private static final String SQL_INSERT = "INSERT INTO message (text, user,
	// ip_address, create_time) VALUES (?, ?, ?, ?)";

	public static ArrayList<Employee> selectAll() {
		ArrayList<Employee> retVal = new ArrayList<Employee>();
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_ALL, false, values);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID,
				// SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID
				retVal.add(new Employee(rs.getInt("EMPLOYEE_ID"), rs.getInt("MANAGER_ID"), rs.getInt("DEPARTMENT_ID"),
						rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("EMAIL"),
						rs.getString("PHONE_NUMBER"), rs.getString("JOB_ID"), rs.getString("HIRE_DATE"),
						rs.getDouble("SALARY"), rs.getDouble("COMMISSION_PCT")));
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return retVal;
	}

	/*
	 * public static boolean insert(Message message) { boolean result = false;
	 * Connection connection = null; ResultSet generatedKeys = null; Object values[]
	 * = { message.getText(), message.getUser(), message.getIPAddress(),
	 * message.getCreateTime() }; try { connection = connectionPool.checkOut();
	 * PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_INSERT,
	 * true, values); pstmt.executeUpdate(); generatedKeys =
	 * pstmt.getGeneratedKeys(); if(pstmt.getUpdateCount()>0) { result = true; } if
	 * (generatedKeys.next()) message.setId(generatedKeys.getInt(1)); pstmt.close();
	 * } catch (SQLException e) { e.printStackTrace(); } finally {
	 * connectionPool.checkIn(connection); } return result; }
	 */

}
