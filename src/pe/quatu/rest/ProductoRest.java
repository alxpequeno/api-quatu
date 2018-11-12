package pe.quatu.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pe.quatu.beans.Producto;
import pe.quatu.beans.Proveedor;
import pe.quatu.util.MysqlDBConn;

@Path("/producto")
public class ProductoRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listado")
	public List<Producto> listadoProductos() {

		List<Producto> listaProductos = new ArrayList<Producto>();

		try {

			Connection cn = MysqlDBConn.getConnection();
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM PRODUCTO");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Producto p = new Producto();
				p.setCodigo(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				p.setPrecioMin(rs.getDouble(4));
				p.setPrecioMax(rs.getDouble(5));
				p.setMedida(rs.getString(6));
				p.setCategoria(rs.getInt(7));
				p.setRegion(rs.getString(8));
				p.setResumen(rs.getString(9));
				p.setProveedor(rs.getInt(10));

				listaProductos.add(p);
			}
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaProductos;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String productoInit() {
		return "Producto REST";
	}
}
