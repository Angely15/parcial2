package co.parcial.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.parcial.modelo.Country;
import co.parcial.util.Conexion;

public class countryDao {
private Conexion conexion;
	
    private static final String SELECT_ALL_COUNTRY = "SELECT * FROM country";
   
    public countryDao() {
    	this.conexion = conexion.getConexion();
    }
    
    public List<Country> selectAll(){
    	List <Country> countrys = new ArrayList<>();
    	try {
			PreparedStatement preparedStatement = conexion.setpreparedStatement(SELECT_ALL_COUNTRY);
			ResultSet rs = conexion.query();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("nombre");
				countrys.add(new Country(id, name));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
    	return countrys;
    }
}
