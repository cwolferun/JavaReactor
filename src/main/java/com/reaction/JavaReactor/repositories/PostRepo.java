package com.reaction.JavaReactor.repositories;

import com.reaction.JavaReactor.model.TaxPayer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<TaxPayer,Long> {

    Page<TaxPayer> findTaxPayerByCostCenter(String costCenter, Pageable pageable);
//    Flux<TaxPayer> findTaxPayerByCostCenterAndVote(String costCenter, String vote, Pageable pageable);


}
