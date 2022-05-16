package dao;

import model.Component;
import model.Game;
import utils.ConstantsAPI;

import java.sql.*;
import java.util.ArrayList;

public class Dao {
    private static Dao instance;
    private Connection connection;

    private Dao() {
    }

    public static Dao getInstance() {
        if (instance == null) {
            instance = new Dao();
        }
        return instance;
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = ConstantsAPI.CONNECTION;
            String user = ConstantsAPI.USER_CONNECTION;
            String password = ConstantsAPI.PASS_CONNECTION;
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Component getComponentById(int id) throws SQLException {
        Component component;
        try (PreparedStatement ps = this.connection.prepareStatement(ConstantsAPI.GET_COMPONENT_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                else {
                    component = new Component(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("descripcion")
                    );
                }
            }
        }
        return component;
    }

    public ArrayList<Component> getAllComponents() throws SQLException {
        ArrayList<Component> components = new ArrayList<>();
        try (Statement st = this.connection.createStatement()) {
            try (ResultSet rs = st.executeQuery(ConstantsAPI.GET_ALL_COMPONENTS)) {
                while (rs.next()) {
                    components.add(new Component(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("descripcion")
                    ));
                }
            }
        }
        return components;
    }

    public void removeComponentByName(String name) throws SQLException {
        System.out.println(name);
        try(PreparedStatement ps = this.connection.prepareStatement(ConstantsAPI.DELETE_COMPONENT_BY_NAME)){
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }

    public void insertComponent(Component component) throws SQLException {
        try (PreparedStatement ps = this.connection.prepareStatement(ConstantsAPI.INSERT_COMPONENTE)){
            ps.setString(1, component.getName());
            ps.setString(2, component.getDescription());
            ps.executeUpdate();
        }
    }

    public void saveGame(Game game) throws SQLException {
        try (PreparedStatement ps = this.connection.prepareStatement(ConstantsAPI.INSERT_GAME)){
            ps.setString(1, game.getName());
            ps.setInt(2, game.getComponentId());
            ps.executeUpdate();
        }
    }

    public ArrayList<Game> getAllGames() throws SQLException {
        ArrayList<Game> games = new ArrayList<>();
        try (Statement st = this.connection.createStatement()) {
            try (ResultSet rs = st.executeQuery(ConstantsAPI.GET_ALL_GAMES)) {
                while (rs.next()) {
                    games.add(new Game(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getInt("componente")
                    ));
                }
            }
        }
        return games;
    }

    public Game getGameById(int gameId) throws SQLException {
        Game game;
        try (PreparedStatement ps = this.connection.prepareStatement(ConstantsAPI.GET_GAME_BY_ID)) {
            ps.setInt(1, gameId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                else {
                    game = new Game(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getInt("componente")
                    );
                }
            }
        }
        return game;
    }

    public void updateGame(Game game) throws SQLException {
        try (PreparedStatement ps = this.connection.prepareStatement(ConstantsAPI.UPDATE_GAME)){
            ps.setString(1, game.getName());
            ps.setInt(2, game.getComponentId());
            ps.executeUpdate();
        }
    }
}
