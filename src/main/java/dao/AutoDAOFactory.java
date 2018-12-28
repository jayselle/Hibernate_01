package dao;

public class AutoDAOFactory {

    public static AutoDAO createAutoDAO(){
        return new AutoDAOImp();
    }

}
