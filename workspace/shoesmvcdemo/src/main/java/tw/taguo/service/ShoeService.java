package tw.taguo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.taguo.dao.ShoeDao;
import tw.taguo.model.Shoe;

@Service
@Transactional
public class ShoeService {

    @Autowired
    private ShoeDao shoeDao;

    public Shoe getShoeById(Long id) {
        return shoeDao.getById(id);
    }

    public List<Shoe> getAllShoes() {
        return shoeDao.getAllShoes();
    }

    public Shoe saveShoe(Shoe shoe) {
        return shoeDao.save(shoe);
    }


    public void updateShoe(Shoe shoe) {
        shoeDao.update(shoe);
    }

    public void deleteShoe(Long id) {
        shoeDao.delete(id);
    }

    public List<Shoe> searchShoesByName(String name) {
        return shoeDao.searchByName(name);
    }
}
