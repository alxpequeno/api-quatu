package pe.quatu.beans;

import java.io.Serializable;

public class Producto implements Serializable {

	private int codigo;
	private String nombre;
	private String descripcion;
	private double precioMin;
	private double precioMax;
	private String medida;
	private int categoria;
	private String region;
	private String resumen;
	private int proveedor;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioMin() {
		return precioMin;
	}

	public void setPrecioMin(double precioMin) {
		this.precioMin = precioMin;
	}

	public double getPrecioMax() {
		return precioMax;
	}

	public void setPrecioMax(double precioMax) {
		this.precioMax = precioMax;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public int getProveedor() {
		return proveedor;
	}

	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}

}
