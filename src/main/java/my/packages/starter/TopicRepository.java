package my.packages.starter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface TopicRepository extends CrudRepository<Topic,String> {


}
