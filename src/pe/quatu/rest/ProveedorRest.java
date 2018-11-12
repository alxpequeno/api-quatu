package pe.quatu.rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pe.quatu.beans.Proveedor;
import pe.quatu.util.MysqlDBConn;

@Path("/proveedor")
public class ProveedorRest {

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
