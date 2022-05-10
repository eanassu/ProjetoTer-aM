package br.vemprafam.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoAluno;

public class LogicaExcluir extends Logica {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		int ra = Integer.parseInt(request.getParameter("ra"));
		DaoAluno dao = new DaoAluno();
		dao.excluirAluno(ra);
		return "/alunos1.jsp";
	}

}
