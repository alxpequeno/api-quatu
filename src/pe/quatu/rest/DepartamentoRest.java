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

import pe.quatu.beans.Departamento;
import pe.quatu.util.MysqlDBConn;

@Path("/departamento")
public class DepartamentoRest {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listado")
	public List<Departamento> listadoDepartamentos() {

		List<Departamento> listaDepartamentos = new ArrayList<Departamento>();

		try {

			Connection cn = MysqlDBConn.getConnection();
			PreparedStatement pst = cn.prepareStatement("SELECT * FROM DEPARTAMENTO");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Departamento d = new Departamento();
				d.setId(rs.getInt(1));
				d.setNombre(rs.getString(2));

				listaDepartamentos.add(d);
			}
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaDepartamentos;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String departamentoInit() {
		return "Departamento REST";
	}
}
