package br.vemprafam.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoAluno;
import br.vemprafam.pojo.Aluno;

public class LogicaEditar extends Logica {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		int ra = Integer.parseInt(request.getParameter("ra"));
		String nome = request.getParameter("nome");
		String dataStr = request.getParameter("dataNascimento");
		double renda = Double.parseDouble(request.getParameter("renda"));
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimento = null;
		try {
			dataNascimento = format.parse(dataStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String email = request.getParameter("email");
		Aluno aluno = new Aluno(ra,nome,dataNascimento,renda,email);
		DaoAluno dao = new DaoAluno();
		dao.alterarAluno(aluno);
		return "/ServletControle?op=Listar";
	}

}
