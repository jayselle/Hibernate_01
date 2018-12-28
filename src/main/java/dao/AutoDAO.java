package dao;

import entities.Auto;
import java.util.List;

public interface AutoDAO {

    void consultarAutos();
    void showListAutos(List<Auto> listaAutos);
    void consultarAutosSegunMarca(String unaMarca);
    void consultarAutosSegunModelo(String unModelo);
    void obtenerAutosCaros(Double precio);
    void insertarAuto(Auto a);
    List<Auto> obtenerAutosConPaginacion(int registroInicial, int cantidad);

}


