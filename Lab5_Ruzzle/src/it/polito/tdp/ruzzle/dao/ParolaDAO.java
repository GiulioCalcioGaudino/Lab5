package it.polito.tdp.ruzzle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ParolaDAO {
	private String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root";

	public boolean cerca(String s){
		try {
			
			Connection conn = DriverManager.getConnection(jdbcURL);
			String sql = "select nome from parola where nome = ?";
			PreparedStatement st;
			st = conn.prepareStatement(sql);
			st.setString(1, s);			
			ResultSet res = st.executeQuery();

			if (res.next()) {
				// found
				res.close();
				conn.close();
				return true;
			} else {
				// not found
				res.close();
				conn.close();
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean cercaSequenza(String sequenza) {
		
		try {
		Connection conn = DriverManager.getConnection(jdbcURL);
		String sql = "SELECT nome FROM parola WHERE nome LIKE ?;";

		PreparedStatement st;

			st = conn.prepareStatement(sql);
			st.setString(1, sequenza + "%");
			ResultSet res = st.executeQuery();

			if (res.next()) {
				res.close();
				conn.close();
				return true;
			} else {
				res.close();
				conn.close();
				return false;
			}

		} catch (SQLException e) {
//			System.out.println("Errore connessione al database");
//			throw new RuntimeException("Error Connection Database AA");
			e.printStackTrace();
		}
		return false;
	}

	
}
