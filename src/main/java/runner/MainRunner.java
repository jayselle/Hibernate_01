package runner;

import dao.AutoDAO;
import dao.AutoDAOFactory;
import dao.ConcesionarioDAO;
import dao.ConcesionarioDAOFactory;
import entities.Auto;
import java.sql.Date;

public class MainRunner {

    public MainRunner() {
    }

    public static void main(String[] args){

        AutoDAO autoDao = new AutoDAOFactory().createAutoDAO();
        ConcesionarioDAO concesDao = new ConcesionarioDAOFactory().createConcesionarioDAO();

        //autoDao.consultarAutos();
        //autoDao.consultarAutosSegunMarca("vro");
        //autoDao.consultarAutosSegunModelo("2002");
        //autoDao.obtenerAutosCaros(400000d);
        //autoDao.insertarAuto(new Auto("Chevrolet Corsa", "2002", Date.valueOf("2002-01-10"), 120000d));
        //concesDao.consultarConcesionarios();
        //autoDao.getAutosFechaVenta();
        //autoDao.getAutosBetweenFechaVenta("2018-12-01","2018-12-30");
        //autoDao.getAutosPorMarcaLetra("c");
        //autoDao.getAutosPorPrecio(400000);
        //autoDao.getCantAutos();
        //autoDao.getCantMarcas();
        //autoDao.getMaxPrice();
        //autoDao.getAvgPrice();
        //autoDao.getTotalVentaPorMarca();
        //autoDao.getAutosYConcesionarios();

    }

}
