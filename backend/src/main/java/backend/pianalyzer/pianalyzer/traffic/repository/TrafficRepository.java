package backend.pianalyzer.pianalyzer.traffic.repository;

import backend.pianalyzer.pianalyzer.traffic.model.Traffic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrafficRepository extends MongoRepository<Traffic, String> {
    @Query(value = "{'protocol':  ?0}", fields = "{'hits': 1, '_id': 0}")
    String findHitsByProtocol(String protocol);

    List<Traffic> findAllBy();
}
