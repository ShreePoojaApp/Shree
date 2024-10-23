package com.shreepooja.service;

import com.shreepooja.entity.Worship;

import java.util.List;
import java.util.Optional;

public interface WorshipService {
    void createWorship(Worship worship);
    Optional<Worship> getWorship(String worshipId);
    List<Worship> getAllWorships();
    void deleteWorship(String worshipId);
}
