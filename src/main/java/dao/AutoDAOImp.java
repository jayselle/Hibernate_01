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

}
