package backend.pianalyzer.pianalyzer.repositories;

import backend.pianalyzer.pianalyzer.models.Traffic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrafficRepository extends MongoRepository<Traffic, String> {
    @Query(value = "{'protocol':  ?0}", fields = "{'hits': 1, '_id': 0}")
    String findHitsByProtocol(String protocol);
}
