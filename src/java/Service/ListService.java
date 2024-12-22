package Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entiy.ListContainer;
import Entiy.ListItem;
import Repo.RepoContiner;
import Repo.RepoItem;

@Service
public class ListService {
	
	@Autowired
	private  RepoContiner listContainerRepository;
	@Autowired
	private  RepoItem listItemRepository;

    public ListService(RepoContiner listContainerRepository, RepoItem listItemRepository) {
        this.listContainerRepository = listContainerRepository;
        this.listItemRepository = listItemRepository;
    }

    public ListContainer saveListContainer(ListContainer newListContainer) {
        return listContainerRepository.save(newListContainer);
    }
    
    public List<ListContainer> getAllLists() {
        return listContainerRepository.findAll();
    }

    
    public void updateLists(List<ListContainer> updatedLists) {
        listContainerRepository.saveAll(updatedLists);
    }

    
    public Optional<ListItem> getListItemById(int id) {
        return listItemRepository.findById(id);
    }

    
    public ListItem saveListItem(ListItem listItem) {
        return listItemRepository.save(listItem);
    }

    
    public void deleteListItemById(int id) {
        listItemRepository.deleteById(id);
    }
}
