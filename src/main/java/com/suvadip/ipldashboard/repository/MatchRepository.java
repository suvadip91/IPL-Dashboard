package com.suvadip.ipldashboard.repository;

import java.util.List;

import com.suvadip.ipldashboard.model.Match;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long> {
    
    public List<Match> getByTeam1OrTeam2OrderByDate(String team1, String team2, Pageable pageable);

    default List<Match> getLatestMatchesByTeam(String teamName, int size){
        return getByTeam1OrTeam2OrderByDate(teamName, teamName, PageRequest.of(0, size));
    }
}
