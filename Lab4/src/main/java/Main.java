import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        /**
         * List de strazi, List de noduri (intersectii) si HashMap pentru
         * modelarea orasului
         */
        List<Street> streetList = new ArrayList<>();
        List<Intersection> nodeList = new ArrayList<>();
        Map<Intersection, List<Street>> cityMap = new HashMap<>();


        /**
         * generare si adaugare de strazi in lista
         *
         */

        streetList.add(new Street("s0", 2));
        streetList.add(new Street("s1", 4));
        streetList.add(new Street("s2", 3));
        streetList.add(new Street("s3", 7));

        System.out.println("Not-sorted streets: ");
        for(int i = 0; i<streetList.size(); i++)
            System.out.println(streetList.get(i));

        /**
         * sortare strazi cu lambda dupa streetLenght
         */
        Collections.sort(streetList,
                ((u, v) -> u.compareTo(v)));

        System.out.println("Sorted streets: ");
        for(int i = 0; i<streetList.size(); i++)
            System.out.println(streetList.get(i));


        /**
         * generare intersectii
         */
        var intersections = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Intersection("v" + i) )
                .toArray(Intersection[]::new);


        /**
         * adaugare intersectii in lista
         */
        nodeList.addAll(Arrays.asList(intersections));

        for(int i=0; i<nodeList.size();i++)
            System.out.println(nodeList.get(i));


        /**
         * adaugare strazi la intersectie
         */

        cityMap.put(intersections[1], streetList);
        System.out.println("City Map: ");
        for(int i = 0; i<streetList.size(); i++)
            System.out.println(cityMap.get(i));

    }
}
