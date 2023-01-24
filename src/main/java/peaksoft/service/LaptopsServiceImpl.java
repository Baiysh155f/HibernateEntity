package peaksoft.service;

import peaksoft.dao.LaptopsDao;
import peaksoft.dao.LaptopsDaoImpl;
import peaksoft.enums.OprSystem;
import peaksoft.laptops.Laptop;

import java.util.List;
import java.util.Map;

/**
 * @Baiysh155f. ttask
 * 24.01.2023
 * admin
 * вт
 **/
public class LaptopsServiceImpl implements LaptopsService{
    LaptopsDao laptopsDao = new LaptopsDaoImpl();
    @Override
    public Laptop saveLaptops(Laptop laptop) {
        return laptopsDao.saveLaptops(laptop);
    }

    @Override
    public List<Laptop> saveAll(List<Laptop> laptops) {
        return laptopsDao.saveAll(laptops);
    }

    @Override
    public Laptop deleteById(Long id) {
        return laptopsDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        laptopsDao.deleteAll();
    }

    @Override
    public List<Laptop> findAll() {
        return laptopsDao.findAll();
    }

    @Override
    public Laptop update(Long id, Laptop laptop) {
        return laptopsDao.update(id,laptop);
    }

    @Override
    public Map<OprSystem, List<Laptop>> groupBy() {
        return laptopsDao.groupBy();
    }

    @Override
    public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc) {
        return laptopsDao.sortByDifferentColumn(column,ascOrDesc);
    }
}
