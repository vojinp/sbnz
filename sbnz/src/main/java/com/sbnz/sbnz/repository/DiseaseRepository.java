package com.sbnz.sbnz.repository;

import com.sbnz.sbnz.domain.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {

    Disease findByName(String diseaseName);
}
