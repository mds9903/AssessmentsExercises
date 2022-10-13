import java.io.*;

import com.fasterxml.jackson.databind.*;

public class JSONProcessing {
    //"Read a Json file from the disk and convert it into POJO
    //Serialize the POJO to a json file on the disk.
    //List all the fields/properties in the json."

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("file.encoding"));
        // get the json file
//        String path = "test.json";
//        String path = "/home/sujan/IdeaProjects/AssessmentExercises/src/test.txt";
        String path = "/home/sujan/IdeaProjects/AssessmentExercises/src/test.json";
        StringBuilder jsonText = new StringBuilder(); // to store the read content from file
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            while ((line = br.readLine()) != null) {
                jsonText.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON Text Retrieved:\n"+jsonText);
        String json = jsonText.toString();
        ObjectMapper objectMapper = new ObjectMapper();
        User user1 = null;
        try {
            user1 = objectMapper.readValue(json, User.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(user1.toString());
    }
}
