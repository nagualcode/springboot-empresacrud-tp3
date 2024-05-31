package br.infnet.empresacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.infnet.empresacrud.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
