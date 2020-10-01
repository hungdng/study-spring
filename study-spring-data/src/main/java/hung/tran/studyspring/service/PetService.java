package hung.tran.studyspring.service;

import hung.tran.studyspring.model.Owner;
import hung.tran.studyspring.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
