package br.vemprafam.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract public class Logica {
	abstract public String executar(HttpServletRequest request, HttpServletResponse response);
}
