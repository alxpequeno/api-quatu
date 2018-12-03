package pe.quatu.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pe.quatu.beans.Categoria;
import pe.quatu.util.MysqlDBConn;

@Path("/categoria")
public class CategoriaRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{p_codigo}")
	public Categoria obtenerCategoria(@PathParam("p_codigo") int codigo) {

		Categoria categoria = null;
		try {

			Connection cn = MysqlDBConn.getConnection();
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM CATEGORIA WHERE codigo = ?");
			pst.setInt(1, codigo);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				categoria = new Categoria();
				categoria.setCodigo(rs.getInt(1));
				categoria.setDescripcion(rs.getString(2));

			}
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return categoria;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listado")
	public List<Categoria> listadoDepartamentos() {

		List<Categoria> listaCategorias = new ArrayList<Categoria>();

		try {

			Connection cn = MysqlDBConn.getConnection();
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM CATEGORIA");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Categoria c = new Categoria();
				c.setCodigo(rs.getInt(1));
				c.setDescripcion(rs.getString(2));

				listaCategorias.add(c);
			}
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaCategorias;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String categoriaInit() {
		return "Categoria REST";
	}
}
