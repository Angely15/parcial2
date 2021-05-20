package co.parcial.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.parcial.modelo.Cyclist;
import co.parcial.util.Conexion;




public class cyclistDao {

	private Conexion conexion;
	
	private static final String INSERT_CYCLIST_SQL = "INSERT INTO cyclist (name,email,birthdate,country,team) VALUES (?,?,?,?,?)";
    private static final String DELETE_CYCLIST_SQL = "DELETE FROM cyclist WHERE id = ?";
    private static final String UPDATE_CYCLIST_SQL = "UPDATE cyclist SET name =?, email=?, birthdate=?,country=?,team=? WHERE id = ?";
    private static final String SELECT_CYCLIST_BY_ID = "SELECT * FROM cyclist WHERE id = ?";
    private static final String SELECT_ALL_CYCLIST = "SELECT * FROM cyclist";
    
    public cyclistDao() {
    	this.conexion = conexion.getConexion();
    }
    
    
    public void insert(Cyclist cyclist) throws SQLException{
    	try {
			PreparedStatement preparedStatement = conexion.setpreparedStatement(INSERT_CYCLIST_SQL);
			preparedStatement.setString(1, cyclist.getName());
			preparedStatement.setString(2, cyclist.getEmail());
			preparedStatement.setString(3, cyclist.getBirthdate());
			preparedStatement.setString(4, cyclist.getCountry());
			preparedStatement.setString(5, cyclist.getTeam());
			conexion.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
    }
    
    public void delete(int id) throws SQLException {
    	try {
			PreparedStatement preparedStatement = conexion.setpreparedStatement(DELETE_CYCLIST_SQL);
			preparedStatement.setInt(1, id);
			conexion.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
    }
    
    public void update(Cyclist cyclist) throws SQLException {
    	try {
			PreparedStatement preparedStatement = conexion.setpreparedStatement(UPDATE_CYCLIST_SQL);
			preparedStatement.setString(1, cyclist.getName());
			preparedStatement.setString(2, cyclist.getEmail());
			preparedStatement.setString(3, cyclist.getBirthdate());
			preparedStatement.setString(4, cyclist.getCountry());
			preparedStatement.setString(5, cyclist.getTeam());
			conexion.execute();
		} catch (SQLException e) {
			// TODO: handle exception
		}
    }
    
    public List<Cyclist> selectAll(){
    	List <Cyclist> cyclists = new ArrayList<>();
    	try {
			PreparedStatement preparedStatement = conexion.setpreparedStatement(SELECT_ALL_CYCLIST);
			ResultSet rs = conexion.query();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("nombre");
				String email = rs.getString("email");
				String country = rs.getString("country");
				String birthdate = rs.getString("birthdate");
				String team = rs.getString("team");
				cyclists.add(new Cyclist(id, name, email, birthdate, country, team));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
    	return cyclists;
    }
    
    public Cyclist select(int id){
    	Cyclist cyclist= null;
    	try {
			PreparedStatement preparedStatement = conexion.setpreparedStatement(SELECT_CYCLIST_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = conexion.query();
			while (rs.next()) {
				String name = rs.getString("nombre");
				String email = rs.getString("email");
				String country = rs.getString("country");
				String birthdate = rs.getString("birthdate");
				String team = rs.getString("team");
				cyclist = new Cyclist(id, name, email, birthdate, country, team)
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
    	return cyclist;
    }
}
