package Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import Entiy.ListContainer;

public interface RepoContiner extends JpaRepository<ListContainer, Integer> {

}
