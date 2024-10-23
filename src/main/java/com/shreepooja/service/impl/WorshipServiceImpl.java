package com.shreepooja.service.impl;

import com.shreepooja.entity.Worship;
import com.shreepooja.repository.WorshipRepository;
import com.shreepooja.service.WorshipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class WorshipServiceImpl implements WorshipService {
    @Autowired
    WorshipRepository worshipRepository;

    @Override
    public void createWorship(Worship worship) {
        worshipRepository.save(worship);
    }

    @Override
    public Optional<Worship> getWorship(String worshipId) {
        return worshipRepository.findById(worshipId);
    }

    @Override
    public List<Worship> getAllWorships() {
        return worshipRepository.findAll();
    }

    @Override
    public void deleteWorship(String worshipId) {
        worshipRepository.deleteById(worshipId);
    }
}
