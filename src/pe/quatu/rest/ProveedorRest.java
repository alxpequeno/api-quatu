package pe.quatu.rest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.MediaType;

import pe.quatu.beans.Proveedor;
import pe.quatu.util.MysqlDBConn;

@Path("/proveedor")
public class ProveedorRest {
	
	@POST
	@Path("/login")
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces(MediaType.APPLICATION_JSON)
	public Proveedor login(@FormParam("p_correo") String correo, @FormParam("p_contrasena") String clave) {
		
		Proveedor proveedor = null;
		
		try {

			Connection cn = MysqlDBConn.getConnection();

			PreparedStatement pst = cn.prepareStatement("SELECT * FROM PROVEEDOR WHERE correo=? and contrasena=?");

			pst.setString(1, correo);
			pst.setString(2, clave);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				proveedor = new Proveedor();
				proveedor.setId(rs.getInt(1));
				proveedor.setEmpresa(rs.getString(2));
				proveedor.setRuc(rs.getString(3));
				proveedor.setContacto(rs.getString(4));
				proveedor.setDni(rs.getString(5));
				proveedor.setCorreo(rs.getString(6));
				proveedor.setDireccion(rs.getString(7));
				proveedor.setDepartamento(rs.getInt(8));
				proveedor.setContrasena(rs.getString(9));
			}
			cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return proveedor;
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/actualizar")
	public void actualizarProveedor(@FormParam("p_id") int id, @FormParam("p_empresa") String empresa,
			@FormParam("p_ruc") String ruc, @FormParam("p_contacto") String contacto, @FormParam("p_dni") String dni,
			@FormParam("p_correo") String correo, @FormParam("p_direccion") String direccion,
			@FormParam("p_departamento") int departamento, @FormParam("p_contrasena") String contrasena) {

		Proveedor proveedor = new Proveedor();
		proveedor.setId(id);
		proveedor.setEmpresa(empresa);
		proveedor.setRuc(ruc);
		proveedor.setContacto(contacto);
		proveedor.setDni(dni);
		proveedor.setCorreo(correo);
		proveedor.setDireccion(direccion);
		proveedor.setDepartamento(departamento);
		proveedor.setContrasena(contrasena);

		try {
			Connection cn = MysqlDBConn.getConnection();
			PreparedStatement pst = cn.prepareStatement(
					"UPDATE PROVEEDOR SET empresa=?,ruc=?,contacto=?,dni=?,correo=?,direccion=?,departamento_id=?,contrasena=? WHERE id=?");

			pst.setString(1, proveedor.getEmpresa());
			pst.setString(2, proveedor.getRuc());
			pst.setString(3, proveedor.getContacto());
			pst.setString(4, proveedor.getDni());
			pst.setString(5, proveedor.getCorreo());
			pst.setString(6, proveedor.getDireccion());
			pst.setInt(7, proveedor.getDepartamento());
			pst.setString(8, proveedor.getContrasena());
			pst.setInt(9, proveedor.getId());

			pst.executeUpdate();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/registrar")
	public void registrarProveedor(@FormParam("p_empresa") String empresa, @FormParam("p_ruc") String ruc,
			@FormParam("p_contacto") String contacto, @FormParam("p_dni") String dni,
			@FormParam("p_correo") String correo, @FormParam("p_direccion") String direccion,
			@FormParam("p_departamento") int departamento, @FormParam("p_contrasena") String contrasena) {

		Proveedor proveedor = new Proveedor();
		proveedor.setEmpresa(empresa);
		proveedor.setRuc(ruc);
		proveedor.setContacto(contacto);
		proveedor.setDni(dni);
		proveedor.setCorreo(correo);
		proveedor.setDireccion(direccion);
		proveedor.setDepartamento(departamento);
		proveedor.setContrasena(contrasena);

		try {
			Connection cn = MysqlDBConn.getConnection();
			PreparedStatement pst = cn.prepareStatement("insert into PROVEEDOR values (null,?,?,?,?,?,?,?,?)");

			pst.setString(1, proveedor.getEmpresa());
			pst.setString(2, proveedor.getRuc());
			pst.setString(3, proveedor.getContacto());
			pst.setString(4, proveedor.getDni());
			pst.setString(5, proveedor.getCorreo());
			pst.setString(6, proveedor.getDireccion());
			pst.setInt(7, proveedor.getDepartamento());
			pst.setString(8, proveedor.getContrasena());

			pst.executeUpdate();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{p_id}")
	public Proveedor obtenerProveedor(@PathParam("p_id") int id) {
		Proveedor proveedor = null;

		try {

			Connection cn = MysqlDBConn.getConnection();

			PreparedStatement pst = cn.prepareStatement("SELECT * FROM PROVEEDOR WHERE id=?");

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				proveedor = new Proveedor();
				proveedor.setId(rs.getInt(1));
				proveedor.setEmpresa(rs.getString(2));
				proveedor.setRuc(rs.getString(3));
				proveedor.setContacto(rs.getString(4));
				proveedor.setDni(rs.getString(5));
				proveedor.setCorreo(rs.getString(6));
				proveedor.setDireccion(rs.getString(7));
				proveedor.setDepartamento(rs.getInt(8));
				proveedor.setContrasena(rs.getString(9));
			}
			cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return proveedor;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listado")
	public List<Proveedor> listadoProveedores() {

		List<Proveedor> listaProveedores = new ArrayList<Proveedor>();

		try {

			Connection cn = MysqlDBConn.getConnection();
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM PROVEEDOR");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Proveedor p = new Proveedor();
				p.setId(rs.getInt(1));
				p.setEmpresa(rs.getString(2));
				p.setRuc(rs.getString(3));
				p.setContacto(rs.getString(4));
				p.setDni(rs.getString(5));
				p.setCorreo(rs.getString(6));
				p.setDireccion(rs.getString(7));
				p.setDepartamento(rs.getInt(8));
				p.setContrasena(rs.getString(9));

				listaProveedores.add(p);
			}
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaProveedores;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String proveedorInit() {
		return "Proveedor REST";
	}


}
