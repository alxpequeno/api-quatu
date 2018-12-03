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
	@Path("/categoria/{p_categoria}")
	public List<Producto> buscarxCategoria(@PathParam("p_categoria") String categoria) {

		List<Producto> listaProductos = new ArrayList<Producto>();

		try {

			Connection cn = MysqlDBConn.getConnection();
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM PRODUCTO WHERE categoria_codigo = ?");
			pst.setString(1, categoria);
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
				p.setFoto(rs.getString(11));

				listaProductos.add(p);
			}
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaProductos;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar/{p_nombre}")
	public List<Producto> buscarxNombre(@PathParam("p_nombre") String nombre) {

		List<Producto> listaProductos = new ArrayList<Producto>();

		try {

			Connection cn = MysqlDBConn.getConnection();
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM PRODUCTO WHERE nombre like concat('%',?,'%')");
			pst.setString(1, nombre);
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
				p.setFoto(rs.getString(11));

				listaProductos.add(p);
			}
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaProductos;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/eliminar")
	public void eliminarProducto(Producto producto) {

		try {
			Connection cn = MysqlDBConn.getConnection();
			PreparedStatement pst = cn.prepareStatement("DELETE FROM PRODUCTO WHERE codigo = ?;");

			pst.setInt(1, producto.getCodigo());

			pst.executeUpdate();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listado/{p_id}")
	public List<Producto> listadoProductosxProveedor(@PathParam("p_id") int id) {

		List<Producto> listaProductos = new ArrayList<Producto>();

		try {

			Connection cn = MysqlDBConn.getConnection();
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM PRODUCTO WHERE proveedor_id = ?");
			pst.setInt(1, id);
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
				p.setFoto(rs.getString(11));

				listaProductos.add(p);
			}
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaProductos;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{p_codigo}")
	public Producto obtenerProducto(@PathParam("p_codigo") int codigo) {
		Producto p = null;

		try {

			Connection cn = MysqlDBConn.getConnection();

			PreparedStatement pst = cn.prepareStatement("SELECT * FROM PRODUCTO WHERE codigo=?");

			pst.setInt(1, codigo);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				p = new Producto();
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
				p.setFoto(rs.getString(11));

			}
			cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/registrar")
	public void registrarProveedor(Producto producto) {

		try {
			Connection cn = MysqlDBConn.getConnection();
			PreparedStatement pst = cn.prepareStatement("insert into PRODUCTO values(null,?,?,?,?,?,?,?,?,?,?);");

			pst.setString(1, producto.getNombre());
			pst.setString(2, producto.getDescripcion());
			pst.setDouble(3, producto.getPrecioMin());
			pst.setDouble(4, producto.getPrecioMax());
			pst.setString(5, producto.getMedida());
			pst.setInt(6, producto.getCategoria());
			pst.setString(7, producto.getRegion());
			pst.setString(8, producto.getResumen());
			pst.setInt(9, producto.getProveedor());
			pst.setString(10, producto.getFoto());

			pst.executeUpdate();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
				p.setFoto(rs.getString(11));

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
