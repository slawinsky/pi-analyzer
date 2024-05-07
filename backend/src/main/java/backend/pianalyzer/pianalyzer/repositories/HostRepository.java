package backend.pianalyzer.pianalyzer.repositories;

import backend.pianalyzer.pianalyzer.models.Host;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends MongoRepository<Host, String> {

}
