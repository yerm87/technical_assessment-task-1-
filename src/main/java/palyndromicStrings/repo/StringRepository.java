package palyndromicStrings.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import palyndromicStrings.entity.StringEntity;

@Repository
public interface StringRepository extends CrudRepository<StringEntity, Integer> {
}
