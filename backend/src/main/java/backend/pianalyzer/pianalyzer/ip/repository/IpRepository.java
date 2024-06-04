package backend.pianalyzer.pianalyzer.ip.repository;

import backend.pianalyzer.pianalyzer.ip.model.Ip;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IpRepository extends MongoRepository<Ip, String> {
    String countAllByIsDangerIsTrue();

    @Query(value = "{'isDanger': true}", fields = "{'ip': 1,'_id':  0}")
    Optional<List<String>> findIpByIsDanger();

    List<Ip> findAllBy(Sort hits);
}
