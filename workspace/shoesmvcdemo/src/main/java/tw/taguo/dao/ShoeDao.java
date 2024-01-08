package tw.taguo.dao;

import java.util.List;

import tw.taguo.model.Shoe;

public interface ShoeDao {
    
    Shoe getById(Long id);
    
    List<Shoe> getAllShoes();
    
    Shoe save (Shoe shoe);
    
    void update (Shoe shoe);
    
    boolean delete (Long id);
    
    List<Shoe> searchByName(String name);
}
