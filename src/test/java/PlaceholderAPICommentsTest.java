import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class PlaceholderAPICommentsTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void testGetCommentById() {

        requestSpec
                .when()
                .get("/comments/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("email", notNullValue());
    }

    @Test(groups = "regression")
    public void testGetCommentsByPostId() {

        requestSpec
                .when()
                .get("/comments?postId=1")
                .then()
                .statusCode(200)
                .body("postId[0]", equalTo(1));
    }
}


