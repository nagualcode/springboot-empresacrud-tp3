package br.infnet.empresacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.infnet.empresacrud.model.Armazem;

@Repository
public interface ArmazemRepository extends JpaRepository<Armazem, Long> {
}
