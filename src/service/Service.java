package service;

import dao.Dao;
import exceptions.LogicExceptions;
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


    public Component getComponentById(int id) throws SQLException, LogicExceptions {
        Component com = dao.getComponentById(id);
        if(com ==null) throw new LogicExceptions(LogicExceptions.ISNT_EXIST_ID);
        return com;
    }

    public ArrayList<Component> getAllComponents() throws SQLException, LogicExceptions {
        ArrayList<Component> comps = dao.getAllComponents();
        if(comps.size() == 0) throw new LogicExceptions(LogicExceptions.EMPTY_COMPONENTS_DB);
        return comps;
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

    public ArrayList<Game> getAllGames() throws SQLException, LogicExceptions {
        ArrayList<Game> games =dao.getAllGames();
        if(games.size() == 0) throw new LogicExceptions(LogicExceptions.EMPTY_GAMES_DB);
        return games;
    }

    public Game getGameBy(int gameId) throws SQLException, LogicExceptions {
        Game game = dao.getGameById(gameId);
        if(game != null) throw new LogicExceptions(LogicExceptions.ISNT_EXIST_ID);
        return game;
    }

    public void updateGame(Game game) throws SQLException {
        dao.updateGame(game);
    }
}
