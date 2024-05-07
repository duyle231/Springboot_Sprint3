package vn.unigap.api.repository;

import vn.unigap.api.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, String> {
    boolean existsByEmail(String email);
}
