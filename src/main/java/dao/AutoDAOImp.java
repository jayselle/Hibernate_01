package dao;

import entities.Auto;
import manager.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class AutoDAOImp implements AutoDAO{

    @Override
    public void showListObjetos(List<Object> objetos) {
        Iterator<Object> listaObjetos = objetos.iterator();
        while(listaObjetos.hasNext()){
            Object[] o = (Object[]) listaObjetos.next();
            System.out.println(o[0]+" - "+o[1]);
        }
    }

    @Override
    public void showListAutos(List<Auto> listaAutos) {
        Iterator<Auto> autos = listaAutos.iterator();
        while (autos.hasNext()){
            System.out.println(autos.next().toString());
        }
    }

    @Override
    public void consultarAutos() {

        Session sesion = null;

        try{
            sesion = SessionManager.getSession();
            List<Auto> autos = sesion.createQuery("FROM Auto").list();
            showListAutos(autos);
        } catch(Exception e){
            System.out.println("Error"+e.getMessage());
        } finally{
            if (sesion!=null){
                sesion.close();
            }
        }
    }

    @Override
    public void consultarAutosSegunMarca(String unaMarca) {
        Session sesion = SessionManager.getSession();
        Query query = sesion.getNamedQuery("obtenerAutosSegunMarca");
        query.setParameter("marca","%"+unaMarca+"%");
        List<Auto> autos = query.list();
        showListAutos(autos);
        sesion.close();
    }

    @Override
    public void consultarAutosSegunModelo(String unModelo) {
        Session sesion = SessionManager.getSession();
        Query query = sesion.getNamedQuery("obtenerAutosSegunModelo");
        query.setParameter("modelo",unModelo);
        List<Auto> autos = query.list();
        showListAutos(autos);
        sesion.close();
    }

    @Override
    public void obtenerAutosCaros(Double precio) {
        Session sesion = SessionManager.getSession();
        Query query = sesion.getNamedQuery("obtenerAutosCaros");
        query.setParameter("precio2",precio);
        List<Auto> autos = query.list();
        showListAutos(autos);
        sesion.close();
    }

    @Override
    public void insertarAuto(Auto a) {
        Session sesion = null;
        Transaction transaction = null;

        try{
            // Obtiene la sesion del trabajo
            sesion = SessionManager.getSession();

            // Genera una transaccion
            transaction = sesion.beginTransaction();

            // Inserta el auto
            sesion.save(a);

            // Compromete los cambios
            transaction.commit();

        } catch (Exception e){
            System.out.println("Error"+e.getMessage());
            if(transaction!=null){
                transaction.rollback();
            }

        } finally {
            if (sesion!=null){
                sesion.close();
            }
        }

    }

    public List<Auto> obtenerAutosConPaginacion(int registroInicial, int cantidad){
        Session sesion = SessionManager.getSession();
        Query query = sesion.createQuery("FROM Auto");
        query.setMaxResults(cantidad);
        query.setFirstResult(registroInicial);
        List<Auto> autos = query.list();
        sesion.close();
        return autos;
    }

    //Todos los autos ordenados en forma descendente por fecha de venta.
    public void getAutosFechaVenta(){
        Session sesion = SessionManager.getSession();
        Query query = sesion.createQuery("FROM Auto ORDER BY fecha_venta DESC");
        List<Auto> autos = query.list();
        showListAutos(autos);
        sesion.close();
    }

    //Los autos con fecha de venta entre 2 fechas.
    public void getAutosBetweenFechaVenta(String fecha1, String fecha2){
        Session sesion = SessionManager.getSession();
        Query query = sesion.createQuery("FROM Auto WHERE fecha_venta BETWEEN :fechaInicio AND :fechaFin");
        query.setString("fechaInicio",fecha1);
        query.setString("fechaFin",fecha2);
        List<Auto> autos = query.list();
        showListAutos(autos);
        sesion.close();
    }

    //Los autos cuya marca comienza con la letra C.
    public void getAutosPorMarcaLetra(String letra){
        Session sesion = SessionManager.getSession();
        Query query = sesion.createQuery("FROM Auto WHERE marca LIKE :letra");
        query.setParameter("letra",letra+"%");
        List<Auto> autos = query.list();
        showListAutos(autos);
        sesion.close();
    }

    //Los autos con precio mayor a 15000.
    @Override
    public void getAutosPorPrecio(double p) {
        Session sesion = SessionManager.getSession();
        Query query = sesion.createQuery("FROM Auto WHERE precio > :p");
        query.setParameter("p",p);
        List<Auto> autos = query.list();
        showListAutos(autos);
        sesion.close();
    }

    //La cantidad total de autos.
    @Override
    public void getCantAutos() {
        Session sesion = SessionManager.getSession();
        Long cantAutos = (Long) sesion.createQuery("SELECT count(1) FROM Auto").uniqueResult();
        System.out.println("La cantidad de autos es "+cantAutos);
        sesion.close();
    }

    //La cantidad de marcas diferentes.
    @Override
    public void getCantMarcas() {
        Session sesion = SessionManager.getSession();
        Long cantMarcas = (Long) sesion.createQuery("SELECT count(DISTINCT marca) FROM Auto").uniqueResult();
        System.out.println("La cantidad de marcas diferentes es "+cantMarcas);
        sesion.close();
    }

    //El precio mas alto.
    @Override
    public void getMaxPrice() {
        Session sesion = SessionManager.getSession();
        Double maxPrecio = (Double) sesion.createQuery("SELECT max(precio) FROM Auto").uniqueResult();
        System.out.println("El precio maximo es "+maxPrecio);
        sesion.close();
    }

    //El promedio de precios.
    @Override
    public void getAvgPrice() {
        Session sesion = SessionManager.getSession();
        Double avgPrecio = (Double) sesion.createQuery("Select avg(precio) FROM Auto").uniqueResult();
        System.out.println("El promedio de precios es "+avgPrecio);
        sesion.close();
    }

    //El monto total de venta agrupado por marca.
    @Override
    public void getTotalVentaPorMarca() {
        Session sesion = SessionManager.getSession();
        List total = sesion.createQuery("Select marca, sum(precio) FROM Auto GROUP BY marca").list();
        showListObjetos(total);
        sesion.close();
    }

    //Producto cartesiano entre autos y concesionarios.
    @Override
    public void getAutosYConcesionarios() {
        Session sesion = SessionManager.getSession();
        List total = sesion.createQuery("FROM Auto, Concesionario").list();
        showListObjetos(total);
        sesion.close();
    }

}
