package biblioteca.repository;

import biblioteca.model.Carte;

import java.util.List;

public interface IRepository {
    void adaugaCarte(Carte c);
    List<Carte> getAllCarti();
}
