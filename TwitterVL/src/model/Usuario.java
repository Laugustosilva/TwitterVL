package model;

import java.util.ArrayList;

import controller.Mensagens;

public class Usuario {
	private String login;
	private String senha;
	private ArrayList<String> mensagens;

	public Usuario() {
		setMensagens(new ArrayList<String>());
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void addMensagens(String m){
		mensagens.add(m);
	}

	public ArrayList<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens(ArrayList<String> mensagens) {
		this.mensagens = mensagens;
	}

}