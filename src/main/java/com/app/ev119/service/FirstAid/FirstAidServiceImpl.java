package com.app.ev119.service.FirstAid;

import com.app.ev119.domain.entity.FirstAid;
import com.app.ev119.repository.FirstAidRepository;
import com.app.ev119.repository.ProceduresRepository;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class FirstAidServiceImpl implements FirstAidService {

    private FirstAidRepository firstAidRepository;
    private ProceduresRepository proceduresRepository;

    @Override
    public Long firstAidSave(FirstAid firstAid) {
        firstAidRepository.save(firstAid);
        return firstAid.getId();
    }

    @Override
    public FirstAid firstAidFindById(Long id) {
        return null;
    }
}
