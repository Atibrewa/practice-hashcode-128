package hashCodeActivity;

import java.util.*;



public class hashCodeDemo {


    public static void main(String[] args) {

        List<Student> students = new ArrayList<Student>();
        students.add(new Student("Slavica Teke", 160610));
        students.add(new Student("Alexandra Reis", 901211));
        students.add(new Student("Draven Reyer", 235054));
        students.add(new Student("Draven Reyer", 235054));
        students.add(new Student("Pallav Ahearn", 319131));
        students.add(new Student("Pallav McQueen", 531242));
        students.add(new Student("Victorius Wortham", 902373));
        students.add(new Student("Alexandra Reis", 234628));
        students.add(new Student("Gaios Best", 131537));
        students.add(new Student("Wigbrand Spalding", 704970));
        students.add(new Student("James McQueen", 902373));


        Map<Integer, List<Student>> collisionMap = new HashMap<>();
        Map<Integer, List<Student>> allEntriesMap = new HashMap<>();

// Insert all elements into buckets based on their hash value
        students.forEach(value -> {
            int index = value.hashCode();
            if (allEntriesMap.get(index) == null) {
                List<Student> newList = new ArrayList<>();
                newList.add(value);
                allEntriesMap.put(index,newList);
            } else {
                List<Student> curList = allEntriesMap.get(index);
                curList.add(value);
                allEntriesMap.put(index, curList);
                if (collisionMap.get(index) == null) {
                    List<Student> collisionList = new ArrayList<>();
                    collisionList.add(value);
                    collisionMap.put(index, collisionList);
                } else {
                    List<Student> cList = collisionMap.get(index);
                    cList.add(value);
                    collisionMap.put(index, cList);
                }
            }

        });

        // Sum up the number of values in each bucket
        int collisions = collisionMap.values().stream().map(List::size).reduce(0, Integer::sum);
        System.out.printf("Number of collisions: %d\n", collisions);

        System.out.println("Collided entries: " + collisionMap.toString());        
        
        System.out.println("\nAll Entries: " + allEntriesMap.toString());             

    }
}
