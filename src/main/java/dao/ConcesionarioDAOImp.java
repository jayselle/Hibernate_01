package dao;

import entities.Concesionario;
import manager.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class ConcesionarioDAOImp implements ConcesionarioDAO{

    @Override
    public List<Concesionario> getAllConcesionario(){
        Session sesion = SessionManager.getSession();
        List concesionarios = sesion.createQuery("FROM Concesionario").list();
        sesion.close();
        return concesionarios;
    }

    @Override
    public void insertConcesionario(){
        Concesionario c1 = new Concesionario("Taraborelli","Alvarez Thomas 5500");
        Concesionario c2 = new Concesionario("Car One","Panamericana 10000");
        Concesionario c3 = new Concesionario("San Jorge","Yrigoyen 12000");

        Session sesion = SessionManager.getSession();
        Transaction tx = sesion.beginTransaction();
        sesion.save(c1);
        sesion.save(c2);
        sesion.save(c3);
        tx.commit();
        sesion.close();
        System.out.println("Concesonarios insertados");
    }

    @Override
    public void consultarConcesionarios(){
        Iterator<Concesionario> it = getAllConcesionario().iterator();
        while(it.hasNext()){
            Concesionario c = it.next();
            System.out.println(c);
        }
    }

    @Override
    public Concesionario getConcesionarioById(Long id){
        Session sesion = SessionManager.getSession();
        Concesionario c = (Concesionario) sesion.createQuery("FROM Concesionario where id="+id).uniqueResult();
        sesion.close();
        return c;
    }

    @Override
    public void updateConcesionario(Concesionario c){
        Transaction tx=null;
        Session sesion=null;
        try{
            sesion = SessionManager.getSession();
            tx = sesion.beginTransaction();
            sesion.update(c);
            tx.commit();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
            if(tx!=null)
                tx.rollback();
        }finally{
            if (sesion!=null)
                sesion.close();
        }
    }

    @Override
    public void deleteConcesionario(Concesionario c){
        Session sesion = SessionManager.getSession();
        Transaction tx = sesion.beginTransaction();
        sesion.delete(c);
        tx.commit();
        sesion.close();
    }

}
