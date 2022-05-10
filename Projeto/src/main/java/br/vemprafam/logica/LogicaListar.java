package br.vemprafam.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoAluno;

public class LogicaListar extends Logica {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("dao", new DaoAluno());
		return "/WEB-INF/jsp/alunos1.jsp";
	}

}
