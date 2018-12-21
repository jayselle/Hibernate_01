package runner;

import dao.AutoDAO;
import dao.AutoDAOFactory;
import entities.Auto;
import java.sql.Date;

public class Runner {

    public Runner() {
    }

    public static void main(String[] args){

        AutoDAO autoDao = new AutoDAOFactory().createAutoDAO();

        System.out.println("asd");

        autoDao.consultarAutos();
        autoDao.consultarAutosSegunMarca("vro");
        autoDao.consultarAutosSegunModelo("2002");
        autoDao.obtenerAutosCaros(400000d);
        //autoDao.insertarAuto(new Auto("Chevrolet Corsa", "2002", Date.valueOf("2002-01-10"), 120000d));

    }

}
