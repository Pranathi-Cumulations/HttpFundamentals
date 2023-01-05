import com.google.gson.Gson;
import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class HttpFundamental{
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        Gson gson = new Gson();
        HttpClient client = HttpClient.newHttpClient();


        try {
            String objectToAdd= gson.toJson(new Posts(101,2,"hi","hello"));
            HttpRequest postRequest = HttpRequest.newBuilder().
            header("content-type","application/json").
                    POST(HttpRequest.BodyPublishers.ofString(objectToAdd)).
                    uri(new URI("https://jsonplaceholder.typicode.com/posts")).build();
            HttpResponse httpResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(httpResponse);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try{
            HttpRequest getRequest = HttpRequest.newBuilder().
                    GET().
                    uri(new URI("https://jsonplaceholder.typicode.com/posts")).build();

            HttpResponse httpResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString());


            JSONArray json = (JSONArray) parser.parse(httpResponse.body().toString());
            ArrayList<Posts> postsList = new ArrayList<>();
            for (int i=0;i< json.size();i++){
                JSONObject obj = (JSONObject) json.get(i);
                postsList.add(gson.fromJson(obj.toJSONString(),Posts.class));
            }
            System.out.println(postsList);
        }
        catch(Exception e){
            System.out.println(e);
        }

        try {
            String objectToUpdate= gson.toJson(new Posts(101,2,"hola","hello"));
            HttpRequest putRequest = HttpRequest.newBuilder().
                    header("content-type","application/json").
                    PUT(HttpRequest.BodyPublishers.ofString(objectToUpdate)).
                    uri(new URI("https://jsonplaceholder.typicode.com/posts/2")).build();
            HttpResponse httpResponse = client.send(putRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(httpResponse);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try{
            HttpRequest getRequest = HttpRequest.newBuilder().
                    DELETE().
                    uri(new URI("https://jsonplaceholder.typicode.com/posts/1")).build();

            HttpResponse httpResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(httpResponse);
        }
        catch(Exception e){
            System.out.println(e);
        }


    }
}
