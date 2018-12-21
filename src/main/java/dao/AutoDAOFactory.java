package dao;

public class AutoDAOFactory {

    public AutoDAO createAutoDAO(){

        return new AutoDAOImp();
    }

}
