package dao;

import entities.Auto;
import java.util.List;

public interface AutoDAO {

    public void consultarAutos();
    public void showListAutos(List<Auto> listaAutos);
    public void consultarAutosSegunMarca(String unaMarca);
    public void consultarAutosSegunModelo(String unModelo);
    public void obtenerAutosCaros(Double precio);
    public void insertarAuto(Auto a);

}


