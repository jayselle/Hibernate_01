import dao.AutoDAO;
import dao.AutoDAOFactory;
import entities.Auto;

import java.util.List;

public class TestPaginacion {

    public static void main(String[] args){

        int registroInicial = 0;
        int cantidadRegistros = 2;
        AutoDAO autoDao = AutoDAOFactory.createAutoDAO();
        List<Auto> autos;

        do{

            autos = autoDao.obtenerAutosConPaginacion(registroInicial,cantidadRegistros);
            autoDao.showListAutos(autos);
            registroInicial+=cantidadRegistros;

        } while(autos.size() == cantidadRegistros);

    }

}
