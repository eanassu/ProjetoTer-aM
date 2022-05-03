package br.vemprafam.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoAluno;
import br.vemprafam.pojo.Aluno;

/**
 * Servlet implementation class ServletEditar
 */
@WebServlet("/editar")
public class ServletEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		RequestDispatcher rd = request.getRequestDispatcher("/alunos1.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
