package hung.tran.studyspring.repositories;

import hung.tran.studyspring.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
