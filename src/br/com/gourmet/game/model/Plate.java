package br.com.gourmet.game.model;

import java.io.Serializable;

public class Plate implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String attribute;

	public Plate(String nome, String caracteristica) {
		super();
		this.setName(nome);
		this.attribute = caracteristica;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaracteristica() {
		return attribute;
	}

	public void setCaracteristica(String caracteristica) {
		this.attribute = caracteristica;
	}

	@Override
	public String toString() {
		return "Plate [name=" + name + ", attribute=" + attribute + "]";
	}
}
