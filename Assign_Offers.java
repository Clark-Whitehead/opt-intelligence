import java.io.*;
import java.util.*;

class Assign_Offers {
    public static void main(String[] args) {
        
        //Path to input file
        String path = "./profiles.csv";

        //Read input file into array
        String line = "";
        List<Object[]> values = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine()) != null) {
                values.add(line.split(","));
            }

            //Close bufferedreader
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Run local defined logic method
        assign_offers(values);

    }

    //Method for assigning offers and outputting to csv file
    public static void assign_offers(List<Object[]> values) {
        
        try {

            //Prep files for wrtting output to csv
            File file = new File("./resultsJava.csv");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            //Loop through profiles file and assign offers to array
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


                //Write current array to line in csv
                for(int j=0; j<individual_array.size(); j++) {
                    bw.write(individual_array.get(j) + ",");
                }

                //Write new line in prep for next current array
                bw.newLine();
                
                

            }

            //Close the files
            bw.close();
            fw.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
     

    }

}

