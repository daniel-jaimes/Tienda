package service;

import dao.Dao;
import model.Component;

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
        Component component;
        component = dao.getComponentById(id);
        return component;
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
}
