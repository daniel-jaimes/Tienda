package service;

public class Service {
    private Service instance;

    private Service(){}

    public Service getInstance() {
        if(instance == null){
            instance = new Service();
        }
        return instance;
    }
}
