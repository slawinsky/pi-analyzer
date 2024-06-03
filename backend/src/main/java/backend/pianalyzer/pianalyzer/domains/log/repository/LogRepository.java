package backend.pianalyzer.pianalyzer.domains.log.repository;

import backend.pianalyzer.pianalyzer.model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<Log, String> {

}
