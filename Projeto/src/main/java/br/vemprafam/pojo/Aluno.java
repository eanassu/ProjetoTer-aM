package br.vemprafam.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno {
	private int ra;
	private String nome;
	private Date dataNascimento;
	private double renda;
	private String email;
	public Aluno(int ra, String nome, Date dataNascimento, double renda, String email) {
		super();
		this.ra = ra;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.renda = renda;
		this.email = email;
	}
	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public String getDataNascimentoFormatada() {
		return new SimpleDateFormat("dd/MM/yyyy").format(dataNascimento);
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public double getRenda() {
		return renda;
	}
	public void setRenda(double renda) {
		this.renda = renda;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Aluno [ra=" + ra + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", renda=" + renda
				+ ", email=" + email + "]";
	}
	
}
