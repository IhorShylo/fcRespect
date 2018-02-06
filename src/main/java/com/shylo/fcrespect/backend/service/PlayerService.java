package com.shylo.fcrespect.backend.service;

import com.shylo.fcrespect.backend.dto.req.PlayerCreateRequest;
import com.shylo.fcrespect.backend.dto.req.PlayerUpdateRequest;
import com.shylo.fcrespect.backend.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    void createPlayer(PlayerCreateRequest request);

    void updatePlayer(PlayerUpdateRequest request);

    void deletePlayerById(Integer id);

    Optional<Player> findPlayer(Integer id);

    List<Player> findAllPlayer();
}
