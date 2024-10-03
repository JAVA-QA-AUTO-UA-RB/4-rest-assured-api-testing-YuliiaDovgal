import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class PlaceholderAPIPostsTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void testGetPost() {

        requestSpec
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("title", notNullValue());
    }

    @Test(groups = "regression")
    public void testCreatePost() {
        String newPost = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";

        requestSpec
                .body(newPost)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar"))
                .body("userId", equalTo(1));
    }

    @Test(groups = "regression")
    public void testUpdatePost() {
        String updatedPost = "{ \"id\": 1, \"title\": \"updated\", \"body\": \"updated body\", \"userId\": 1 }";

        requestSpec
                .body(updatedPost)
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("updated"))
                .body("body", equalTo("updated body"));
    }

    @Test(groups = "regression")
    public void testDeletePost() {

        requestSpec
                .when()
                .delete("/posts/1")
                .then()
                .statusCode(200); // The API returns 200, though ideally it should be 204
    }
}