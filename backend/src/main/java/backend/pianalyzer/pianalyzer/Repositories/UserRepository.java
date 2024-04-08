package backend.pianalyzer.pianalyzer.Repositories;

import backend.pianalyzer.pianalyzer.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {

}
