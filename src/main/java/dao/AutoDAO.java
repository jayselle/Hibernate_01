package dao;

import entities.Auto;

import java.util.List;

public interface AutoDAO {

    void consultarAutos();
    void showListObjetos(List<Object> objetos);
    void showListAutos(List<Auto> listaAutos);
    void consultarAutosSegunMarca(String unaMarca);
    void consultarAutosSegunModelo(String unModelo);
    void obtenerAutosCaros(Double precio);
    void insertarAuto(Auto a);
    List<Auto> obtenerAutosConPaginacion(int registroInicial, int cantidad);
    void getAutosFechaVenta();
    void getAutosBetweenFechaVenta(String fecha1, String fecha2);
    void getAutosPorMarcaLetra(String letra);
    void getAutosPorPrecio(double p);
    void getCantAutos();
    void getCantMarcas();
    void getMaxPrice();
    void getAvgPrice();
    void getTotalVentaPorMarca();
    void getAutosYConcesionarios();

}


