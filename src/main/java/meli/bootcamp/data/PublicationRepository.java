package meli.bootcamp.data;

import meli.bootcamp.entity.Publication;
import org.springframework.data.repository.CrudRepository;

public interface PublicationRepository extends CrudRepository<Publication, Integer> {
}
