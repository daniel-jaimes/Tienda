package service;

import dao.Dao;
import model.Component;
import model.Game;

import java.sql.SQLException;
import java.util.ArrayList;

public class Service {
    private static Service instance;
    private final Dao dao;

    private Service() {
        dao = Dao.getInstance();
        dao.connect();
    }

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }


    public Component getComponentById(int id) throws SQLException {
        return dao.getComponentById(id);
    }

    public ArrayList<Component> getAllComponents() throws SQLException {
        return dao.getAllComponents();
    }

    public void removeComponentByName(String name) throws SQLException {
        dao.removeComponentByName(name);
    }


    public void createComponent(Component component) throws SQLException {
        dao.insertComponent(component);
    }

    public void createGame(Game game) throws SQLException {
        dao.saveGame(game);
    }

    public ArrayList<Game> getAllGames() throws SQLException {
        return dao.getAllGames();
    }

    public Game getGameBy(int gameId) throws SQLException {

        return dao.getGameById(gameId);
    }

    public void updateGame(Game game) throws SQLException {
        dao.updateGame(game);
    }
}
