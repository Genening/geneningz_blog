package geneningz.io.dao;

import geneningz.io.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Geneningz ZHANG on 9/20/2022.
 */
public interface TypeRepository extends JpaRepository<Type, Long> {

    Type findByName(String name);


    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
