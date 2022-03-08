package com.rvmagrini.springboot.repositories;

import com.rvmagrini.springboot.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
