package com.reaction.JavaReactor.rx;

import com.reaction.JavaReactor.model.TaxPayer;
import com.reaction.JavaReactor.repositories.PostRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@Slf4j
public class TaxRx {

    @Autowired
    PostRepo postRepo;

    private Page<TaxPayer> taxPayers;

    public Flux<List<TaxPayer>> getPayers() {

        taxPayers = postRepo.findTaxPayerByCostCenter("G5240", PageRequest.of(0, 5));
        taxPayers.nextPageable();
        return (Flux<List<TaxPayer>>) taxPayers;
    }

    Flux<List<TaxPayer>> increment() {
        return (Flux<List<TaxPayer>>) taxPayers.nextPageable();
    }


}
