package peaksoft;

import peaksoft.enums.OprSystem;
import peaksoft.laptops.Laptop;
import peaksoft.service.LaptopsService;
import peaksoft.service.LaptopsServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        LaptopsService laptopsService = new LaptopsServiceImpl();
//        System.out.println(laptopsService.saveLaptops(new Laptop("Lenovo", OprSystem.LINUX, 256,
//                new BigDecimal(1500), LocalDate.of(2021, 1, 1))));


//        List<Laptop> laptopList = new ArrayList<>(Arrays.asList(new Laptop("Acer", OprSystem.HP, 256, new BigDecimal(1400), LocalDate.of(2029, 1, 1)),
//               new Laptop("HP", OprSystem.LINUX, 256, new BigDecimal(1399), LocalDate.of(2201, 1, 1)),
//               new Laptop( "ChromeBook", OprSystem.MACOS, 256, new BigDecimal(1509), LocalDate.of(2039, 1, 1))));
//

//        System.out.println(laptopsService.saveAll(laptopList));


//        System.out.println(laptopsService.deleteById(3L));
//        laptopsService.deleteAll();


//        System.out.println(laptopsService.findAll());
//        System.out.println(laptopsService.update(7L, new Laptop("Lenovo", OprSystem.LINUX, 256,
//                new BigDecimal(1500), LocalDate.of(2021, 1, 1))));


        System.out.println("Enter column: (id/brand/operatingSystem/memory/price/dateOfIssue)");
        String column = new Scanner(System.in).nextLine();
        System.out.println("Ascending or descending (asc/desc): ");
        String ascOrDesc = new Scanner(System.in).nextLine();
        System.out.println(laptopsService.sortByDifferentColumn(column.toLowerCase(),ascOrDesc));
    }
}
