package tests.portal.api;

import base.BaseApi;
import io.restassured.response.ResponseBodyData;
import static io.restassured.path.json.JsonPath.from;

public class TodoApi extends BaseApi {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static final String GET_TODO_URL = combineUrl(BASE_URL, "/todos");

    public String getTodoTitle(String id){
        String response = getTodo(id).asString();
        String title = from(response).get("title");
        return title;
    }

    private ResponseBodyData getTodo(String id){
        ResponseBodyData response = getRequestSpecification().param("id", id).get(GET_TODO_URL);
        return response;
    }

}
