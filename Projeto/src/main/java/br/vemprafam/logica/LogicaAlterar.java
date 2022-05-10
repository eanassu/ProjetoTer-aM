package br.vemprafam.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoAluno;
import br.vemprafam.pojo.Aluno;

public class LogicaAlterar extends Logica {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		int ra = Integer.parseInt(request.getParameter("ra"));
		DaoAluno dao = new DaoAluno();
		Aluno aluno = dao.buscarPeloRa(ra);
		request.setAttribute("aluno", aluno);
		return "/WEB-INF/jsp/alterar.jsp";
	}

}
