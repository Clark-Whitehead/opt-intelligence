import java.io.*;
import java.util.*;

class Assign_Offers {
    public static void main(String[] args) {
        
        String path = "./profiles.csv";
        String line = "";
        List<Object[]> values = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine()) != null) {
                values.add(line.split(","));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        test(values);

    }

    public static void test(List<Object[]> values) {
        
        try {

            File file = new File("./resultsJava.csv");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);


            for (int i=0; i<values.size(); i++){

                List<String> individual_array = new ArrayList<String>();

                String sex = values.get(i)[0].toString();
                int age = Integer.parseInt(values.get(i)[1].toString());


                individual_array.add(sex);
                individual_array.add(Integer.toString(age));

                //Sex = Males
                if (sex.equals("M")) {
                    
                    if(age >= 18 && age <= 25) {
                        individual_array.add("E");
                        individual_array.add("B");
                        individual_array.add("I");
                        individual_array.add("A");
                    }

                    if(age >= 26 && age <= 35) {
                        individual_array.add("B");
                        individual_array.add("I");
                        individual_array.add("F");
                        individual_array.add("H");
                        individual_array.add("D");
                    }

                    if(age >= 36 && age <= 45) {
                        individual_array.add("J");
                        individual_array.add("D");
                    }

                    if(age >= 46) {
                        individual_array.add("B");
                    }

                } 
                
                //Sex = Females
                else {

                    if(age >= 18 && age <= 25) {
                        individual_array.add("G");
                        individual_array.add("C");
                    }

                    if(age >= 26 && age <= 35) {
                        individual_array.add("F");
                        individual_array.add("H");
                        individual_array.add("D");
                    }

                    if(age >= 36 && age <= 45) {
                        individual_array.add("J");
                        individual_array.add("D");
                    }

                    if(age >= 46) {
                        individual_array.add("G");
                    }

                }


                // System.out.println(individual_array.get(j));
                for(int j=0; j<individual_array.size(); j++) {
                    bw.write(individual_array.get(j) + ",");
                }

                // bw.write(combined_array[i].get(combined_array[i].size()-1));
                bw.newLine();
                // System.out.println(individual_array.get(j));
                

            }


            bw.close();
            fw.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
     

    }

}

