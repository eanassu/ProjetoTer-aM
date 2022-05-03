package br.vemprafam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.vemprafam.pojo.Aluno;

public class DaoAluno {
	private Connection conn;

	public DaoAluno() {
		super();
		try {
			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","SA","");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Aluno> getAlunos() {
		List<Aluno> result = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT RA, NOME, DATANASCIMENTO, RENDA, EMAIL FROM ALUNOS");
			ResultSet rs = pstmt.executeQuery();
			while ( rs.next() ) {
				result.add( new Aluno( rs.getInt("RA"),
						rs.getString("NOME"), rs.getDate("DATANASCIMENTO"),
						rs.getDouble("RENDA"), rs.getString("EMAIL")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}
	
	public void inserirAluno( Aluno aluno ) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO alunos"
					+ " VALUES(?,?,?,?,?)");
			pstmt.setInt(1, aluno.getRa());
			pstmt.setString(2, aluno.getNome());
			pstmt.setDate(3, new java.sql.Date(aluno.getDataNascimento().getTime()));
			pstmt.setDouble(4, aluno.getRenda());
			pstmt.setString(5, aluno.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public boolean excluirAluno( int ra ) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"DELETE FROM alunos WHERE ra=?");
			pstmt.setInt(1, ra);
			int count = pstmt.executeUpdate();
			return count==1;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Aluno buscarPeloRa( int ra ) {
		Aluno result = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(
				"SELECT RA, NOME, DATANASCIMENTO, RENDA, EMAIL FROM ALUNOS WHERE RA=?");
			pstmt.setInt(1, ra);
			ResultSet rs = pstmt.executeQuery();
			if ( rs.next() ) {
				result =  new Aluno( rs.getInt("RA"),
						      rs.getString("NOME"), rs.getDate("DATANASCIMENTO"),
						      rs.getDouble("RENDA"), rs.getString("EMAIL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}
	
	public void alterarAluno( Aluno aluno ) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(
				"UPDATE alunos SET nome=?,dataNascimento=?,renda=?,email=? WHERE ra=?");
			pstmt.setString(1, aluno.getNome());
			pstmt.setDate(2, new java.sql.Date(aluno.getDataNascimento().getTime()));
			pstmt.setDouble(3, aluno.getRenda());
			pstmt.setString(4, aluno.getEmail());
			pstmt.setInt(5, aluno.getRa());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
