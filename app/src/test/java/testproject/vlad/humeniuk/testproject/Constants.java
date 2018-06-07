package testproject.vlad.humeniuk.testproject;

public class Constants {

    public interface Response {

        String TEST_RESPONSE = "{\n" +
                "  \"data\": [{\n" +
                "    \"type\": \"tabconfig\",\n" +
                "    \"id\": \"1\",\n" +
                "    \"attributes\": {\n" +
                "      \"title\": \"Tab 1 title\",\n" +
                "      \"body\": \"Tab 1 body\"\n" +
                "    }\n" +
                "  }]\n" +
                "}";

        String BAD_RESPONSE = "{\n" +
                "  \"config\": [{\n" +
                "      \"title\": \"Tab 1 title\",\n" +
                "      \"body\": \"Tab 1 body\"\n" +
                "  }]\n" +
                "}";
    }
}
