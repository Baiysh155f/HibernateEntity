package peaksoft.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.DatabaseConnection;
import peaksoft.enums.OprSystem;
import peaksoft.laptops.Laptop;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Baiysh155f. ttask
 * 24.01.2023
 * admin
 * вт
 **/
public class LaptopsDaoImpl implements LaptopsDao {
    private EntityManagerFactory entityManagerFactory = DatabaseConnection.createEntityManagerFactory();

    @Override
    public Laptop saveLaptops(Laptop laptop) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(laptop);
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptop;
    }

    @Override
    public List<Laptop> saveAll(List<Laptop> laptops) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Laptop laptop : laptops) {
            entityManager.persist(laptop);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptops;
    }

    @Override
    public Laptop deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Laptop id1 = entityManager.createQuery("select p from  Laptop p where p.id = :id", Laptop.class).setParameter("id", id).getSingleResult();
        entityManager.remove(id1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }

    @Override
    public void deleteAll() {
       try  {
           EntityManager entityManager = entityManagerFactory.createEntityManager();
           entityManager.getTransaction().begin();
           List<Laptop> selectLFromLaptopL = entityManager.createQuery("select l from Laptop l", Laptop.class).getResultList();
           for (Laptop laptop : selectLFromLaptopL) {
               entityManager.remove(laptop);
           }
           entityManager.getTransaction().commit();
           entityManager.close();
           System.out.println("deleted all...");
       }catch (RuntimeException e){
           System.out.println(e.getMessage());
       }
    }

    @Override
    public List<Laptop> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Laptop> selectLFromLaptopL = entityManager.createQuery("select l from Laptop l", Laptop.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return selectLFromLaptopL;
    }

    @Override
    public Laptop update(Long id, Laptop newLaptop) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Laptop singleResult = entityManager.createQuery("select l from Laptop l where l.id = :id", Laptop.class)
                .setParameter("id", id)
                .getSingleResult();
        singleResult.setBrand(newLaptop.getBrand());
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public Map<OprSystem, List<Laptop>> groupBy() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Map<OprSystem, List<Laptop>> selectLFromLaptopL = entityManager.createQuery("select l from Laptop l", Laptop.class)
                .getResultStream().collect(Collectors.groupingBy(Laptop::getOperationSystem));
        entityManager.getTransaction().commit();
        entityManager.close();
        return selectLFromLaptopL;
    }
    @Override
    public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc) {
        switch (column) {
            case "id" -> System.out.println(id(ascOrDesc));
            case "brand" -> System.out.println(brand(ascOrDesc));
            case "operatingsystem" -> System.out.println(operatingSystem(ascOrDesc));
            case "memory" -> System.out.println(memory(ascOrDesc));
            case "price" -> System.out.println(price(ascOrDesc));
            case "dateofissue" -> System.out.println(dateOfIssue(ascOrDesc));
        }
        return null;
    }

    private List<Laptop> brand(String ascOrDesc) {
        String sql1 = "select l from Laptop l order by brand";
        String sql2 = "select l from Laptop l order by brand desc";
        String sql = "";
        if (ascOrDesc.toLowerCase().equals("asc")) sql = sql1;
        else if (ascOrDesc.toLowerCase().equals("desc")) sql = sql2;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Laptop> list = entityManager.createQuery(sql).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return list;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private List<Laptop> id(String ascOrDesc) {
        String sql1 = "select l from Laptop l order by id";
        String sql2 = "select l from Laptop l order by id desc";
        String sql = "";
        if (ascOrDesc.toLowerCase().equals("asc")) sql = sql1;
        else if (ascOrDesc.toLowerCase().equals("desc")) sql = sql2;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Laptop> list = entityManager.createQuery(sql).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return list;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private List<Laptop> operatingSystem(String ascOrDesc) {
        String sql1 = "select l from Laptop l order by operationSystem";
        String sql2 = "select l from Laptop l order by operationSystem desc";
        String sql = "";
        if (ascOrDesc.toLowerCase().equals("asc")) sql = sql1;
        else if (ascOrDesc.toLowerCase().equals("desc")) sql = sql2;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Laptop> list = entityManager.createQuery(sql).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return list;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private List<Laptop> memory(String ascOrDesc) {
        String sql1 = "select l from Laptop l order by memory";
        String sql2 = "select l from Laptop l order by memory desc";
        String sql = "";
        if (ascOrDesc.toLowerCase().equals("asc")) sql = sql1;
        else if (ascOrDesc.toLowerCase().equals("desc")) sql = sql2;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Laptop> list = entityManager.createQuery(sql).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return list;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private List<Laptop> price(String ascOrDesc) {
        String sql1 = "select l from Laptop l order by price";
        String sql2 = "select l from Laptop l order by price desc";
        String sql = "";
        if (ascOrDesc.toLowerCase().equals("asc")) sql = sql1;
        else if (ascOrDesc.toLowerCase().equals("desc")) sql = sql2;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Laptop> list = entityManager.createQuery(sql).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return list;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    private List<Laptop> dateOfIssue(String ascOrDesc) {
        String sql1 = "select l from Laptop l order by dateOfBirth";
        String sql2 = "select l from Laptop l order by dateOfBirth desc";
        String sql = "";
        if (ascOrDesc.toLowerCase().equals("asc")) sql = sql1;
        else if (ascOrDesc.toLowerCase().equals("desc")) sql = sql2;
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Laptop> list = entityManager.createQuery(sql).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return list;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
