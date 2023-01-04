import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class HttpFundamental {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        HttpClient client = HttpClient.newHttpClient();

        try{
            HttpRequest getRequest = HttpRequest.newBuilder().
                    GET().
                    uri(new URI("https://jsonplaceholder.typicode.com/posts")).build();

            HttpResponse httpResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString());

            JSONArray json = (JSONArray) parser.parse(httpResponse.body().toString());
            ArrayList<Posts> postsList = new ArrayList<>();
            for (int i=0;i< json.size();i++){
                JSONObject obj = (JSONObject) json.get(i);
                Posts post = new Posts();
                post.setUserId((long)obj.get("userId"));
                post.setBody((String) obj.get("body"));
                post.setTitle((String) obj.get("title"));
                post.setId((long) obj.get("id"));
                postsList.add(post);
            }
            System.out.println(postsList);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
