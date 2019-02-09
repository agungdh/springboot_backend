package agungdh.embohopoiki.repository;

import agungdh.embohopoiki.model.Orang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrangRepository extends JpaRepository<Orang, Long> {

}