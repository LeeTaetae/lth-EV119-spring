package com.app.ev119.repository;

import com.app.ev119.domain.entity.FirstAid;
import com.app.ev119.domain.entity.Procedures;
import com.app.ev119.domain.type.UrgencyType;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Slf4j @Commit
@Transactional
public class FirstAidRepositoryTest {

    @PersistenceContext
    private FirstAidRepository firstAidRepository;

    private void insertFirstAidData(){
        FirstAid firstAd = new FirstAid();

        firstAd.setUrgency(UrgencyType.CRITICAL);

        firstAidRepository.save(firstAd);


        Procedures procedures = new Procedures();
        procedures.setFirstAid(firstAd);
    }
}
