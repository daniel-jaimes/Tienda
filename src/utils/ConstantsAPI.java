package utils;

public class ConstantsAPI {
    //COMPONENT
    public static final String INSERT_COMPONENTE = "INSERT INTO componente (nombre, descripcion) VALUES (?,?)";
    public static final String GET_COMPONENT_BY_ID = "SELECT * FROM componente WHERE ID = ?";
    public static final String GET_ALL_COMPONENTS = "SELECT * FROM componente";
    public static final String DELETE_COMPONENT_BY_NAME = "DELETE FROM componente WHERE nombre = ?";


    //GAME
    public static final String GET_GAME_BY_ID = "SELECT * FROM juego WHERE ID = ?";
    public static final String GET_ALL_GAMES = "SELECT * FROM juego";
    public static final String INSERT_GAME = "INSERT INTO juego (nombre, componente) VALUES (?, ?)";
    public static final String UPDATE_GAME = "UPDATE juego SET nombre = ? WHERE componente = ?";

    //CONNECTION
    public static final String CONNECTION = "jdbc:mysql://localhost:3306/dam2tm03uf6p2?useSSL=false";
    public static final String USER_CONNECTION = "root";
    public static final String PASS_CONNECTION = "DAM2T";
}
