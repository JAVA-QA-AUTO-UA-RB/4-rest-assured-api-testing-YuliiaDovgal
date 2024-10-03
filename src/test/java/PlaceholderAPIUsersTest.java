import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class PlaceholderAPIUsersTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void testGetUserById() {

        requestSpec
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("username", notNullValue());
    }

    @Test(groups = "regression")
    public void testGetUserByUsername() {

        requestSpec
                .when()
                .get("/users?username=Bret")
                .then()
                .statusCode(200)
                .body("[0].username", equalTo("Bret"))
                .body("[0].email", notNullValue());
    }
}


