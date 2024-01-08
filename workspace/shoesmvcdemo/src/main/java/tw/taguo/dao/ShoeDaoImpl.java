package tw.taguo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tw.taguo.model.Shoe;

@Repository
@Transactional
public class ShoeDaoImpl implements ShoeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Shoe getById(Long id) {
        return sessionFactory.getCurrentSession().get(Shoe.class, id);
    }

    @Override
    public List<Shoe> getAllShoes() {
        return sessionFactory.getCurrentSession().createQuery("FROM Shoe", Shoe.class).getResultList();
    }

    @Override
    public Shoe save(Shoe shoe) {
        sessionFactory.getCurrentSession().save(shoe);
        return shoe;
    }
    @Override
    public void update(Shoe shoe) {
        sessionFactory.getCurrentSession().saveOrUpdate(shoe);
    }

    @Override
    public boolean delete(Long id) {
        Shoe shoe = getById(id);
        if (shoe != null) {
            sessionFactory.getCurrentSession().delete(shoe);
            return true; // 刪除成功
        } else {
            return false; // 找不到要刪除的鞋子
        }
    }

    @Override
    public List<Shoe> searchByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Shoe WHERE brand LIKE :name";
        return session.createQuery(hql, Shoe.class).setParameter("name", "%" + name + "%").getResultList();
    }
}
