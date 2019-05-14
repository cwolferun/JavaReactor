package com.reaction.JavaReactor.repoTests;

import com.reaction.JavaReactor.model.TaxPayer;
import com.reaction.JavaReactor.repositories.PostRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostTest {

    @Autowired
    PostRepo postRepo;

    @Test
    public void pageSomething() {
        Page<TaxPayer> someguys;
        for(int i=0;i<5;i++)
        {
            someguys = postRepo.findTaxPayerByCostCenter("G5240", PageRequest.of(i,5));
            System.out.println("Aqi page "+i);
            someguys.forEach(System.out::println);

        }
    }
}
