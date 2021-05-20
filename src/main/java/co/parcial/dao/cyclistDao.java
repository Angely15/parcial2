package co.parcial.dao;

public class cyclistDao {
    private static final String INSERT_USUARIO_SQL = "INSERT INTO cyclist (name,email,birthdate,country,team) VALUES (?,?,?,?,?)";
    private static final String DELETE_USUARIO_SQL = "DELETE FROM cyclist WHERE id = ?";
    private static final String UPDATE_USUARIO_SQL = "UPDATE cyclist SET name =?, email=?, birthdate=?,country=?,team=? WHERE id = ?";
    private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM cyclist WHERE id = ?";
    private static final String INSERT_ALL_USUARIOS = "SELECT * FROM cyclist";
    
    
}
