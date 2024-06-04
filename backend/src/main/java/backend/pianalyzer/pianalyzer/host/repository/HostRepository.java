package backend.pianalyzer.pianalyzer.host.repository;

import backend.pianalyzer.pianalyzer.host.model.Host;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HostRepository extends MongoRepository<Host, String> {
    @Query(value = "{'isConnected': true}", count = true)

    Optional<Integer> countAllByConnected();

    @Query(value = "{'isConnected': true}")

    Optional<List<String>> getAllByConnected();
}
