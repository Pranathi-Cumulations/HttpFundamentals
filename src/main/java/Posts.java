import java.util.ArrayList;

public class Posts {
    private long userId;
    private long id;
    private String title;
    private String body;

    public Posts(){

    }
    public Posts(long userId, long id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

class PostsList{
    ArrayList<Posts> allPosts = new ArrayList<>();

    public ArrayList<Posts> getAllPosts() {
        return allPosts;
    }

    public void setAllPosts(ArrayList<Posts> allPosts) {
        this.allPosts = allPosts;
    }
}
