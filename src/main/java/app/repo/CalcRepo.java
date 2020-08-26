package app.repo;

import app.entity.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CalcRepo extends JpaRepository<Calculation, Integer> {

    List<Calculation> findAllByUsername(String username);

}
