package br.vemprafam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.vemprafam.dao.DaoAluno;
import br.vemprafam.pojo.Aluno;

/**
 * Servlet implementation class ServletAlunos
 */
@WebServlet("/alunos")
public class ServletAlunos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlunos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoAluno dao = new DaoAluno();
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Exemplo de tabela</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<table border='1'>\r\n"
				+ "<tr>\r\n"
				+ "<th>RA</th><th>nome</th><th>Data de Nascimento</th><th>Renda</th>\r\n"
				+ "</tr>");
		List<Aluno> alunos = dao.getAlunos();
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for(Aluno aluno: alunos) {
			out.println("<tr>");
			out.format("<td>%d</td><td>"+aluno.getNome()+"</td><td>"+
			    dateFormat.format(aluno.getDataNascimento())+"</td><td>"+ 
					currencyFormat.format(aluno.getRenda())+"</td>",aluno.getRa());
			out.println("</tr>");
		}
		out.println("</table>\n"
				+ "<a href='/Projeto'>voltar ao menu</a>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
