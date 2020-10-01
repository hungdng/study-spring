package hung.tran.studyspring.service;

import hung.tran.studyspring.model.Pet;
import hung.tran.studyspring.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
