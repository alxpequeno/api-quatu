package pe.quatu.beans;

import java.io.Serializable;

public class Categoria implements Serializable {

	private int codigo;
	private String descripcion;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
