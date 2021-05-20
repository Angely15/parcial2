package co.parcial.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.parcial.modelo.Team;
import co.parcial.util.Conexion;

public class teamDao {
	private Conexion conexion;
	
    private static final String SELECT_ALL_TEAM = "SELECT * FROM team";
   
    
    public teamDao() {
    	this.conexion = conexion.getConexion();
    }
    
    public List<Team> selectAll(){
    	List <Team> teams = new ArrayList<>();
    	try {
			PreparedStatement preparedStatement = conexion.setpreparedStatement(SELECT_ALL_TEAM);
			ResultSet rs = conexion.query();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("nombre");
				String country = rs.getString("country");
				teams.add(new Team(id, name, country));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
    	return teams;
    }
}
