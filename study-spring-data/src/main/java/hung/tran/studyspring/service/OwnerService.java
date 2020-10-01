package hung.tran.studyspring.service;

import hung.tran.studyspring.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
