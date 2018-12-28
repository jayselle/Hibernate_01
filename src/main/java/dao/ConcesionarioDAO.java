package dao;

import entities.Concesionario;
import java.util.List;

public interface ConcesionarioDAO {

    public void insertConcesionario();
    public List<Concesionario> getAllConcesionario();
    public void consultarConcesionarios();
    public Concesionario getConcesionarioById(Long id);
    public void updateConcesionario(Concesionario c);
    public void deleteConcesionario(Concesionario c);

}
