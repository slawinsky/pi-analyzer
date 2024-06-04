package backend.pianalyzer.pianalyzer.log.repository;

import backend.pianalyzer.pianalyzer.log.model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<Log, String> {

}
