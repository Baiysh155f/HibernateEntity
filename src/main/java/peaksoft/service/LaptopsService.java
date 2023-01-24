package peaksoft.service;

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
public interface LaptopsService {
    Laptop saveLaptops(Laptop laptop);

    public List<Laptop> saveAll(List<Laptop> laptops);

    public Laptop deleteById(Long id);

    public void deleteAll();

    public List<Laptop> findAll();

    public Laptop update(Long id, Laptop laptop);

    Map<OprSystem, List<Laptop>> groupBy();

    List<Laptop> sortByDifferentColumn(String column, String ascOrDesc);
}
