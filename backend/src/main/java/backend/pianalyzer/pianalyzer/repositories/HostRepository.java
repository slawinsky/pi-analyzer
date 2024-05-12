package backend.pianalyzer.pianalyzer.repositories;

import backend.pianalyzer.pianalyzer.models.Host;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HostRepository extends MongoRepository<Host, String> {
    Optional<Integer> countAllByIsConnectedTrue();
    Optional<List<String>> getAllByIsConnectedTrue();
}
