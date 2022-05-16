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
        System.out.println(component);
        return component;
    }

    public ArrayList<Component> getAllComponents() throws SQLException {
        ArrayList<Component> components = new ArrayList<>();
        components = dao.getAllComponents();
        return components;
    }

    public void removeComponentByName(String name) {
        dao.removeComponentByName(name);
    }

    public void createComponent(String name, String descripcion) {

    }
}
