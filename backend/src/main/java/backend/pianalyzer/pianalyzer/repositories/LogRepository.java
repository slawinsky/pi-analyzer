package backend.pianalyzer.pianalyzer.repositories;

import backend.pianalyzer.pianalyzer.models.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<Log, String> {

}
