package Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import Entiy.ListItem;

public interface RepoItem extends JpaRepository<ListItem, Integer> {

}
