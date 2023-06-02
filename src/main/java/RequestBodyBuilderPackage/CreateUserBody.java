package RequestBodyBuilderPackage;

import com.google.gson.JsonObject;

public interface CreateUserBody {
    /*
    CreateUserBody ინტერფეისში შევქმენი ერთგვარი შაბლონი, რომელიც აბრუნებს JsonObject ობიექტს,
    მას შემდგომში ვიყენებ რექვესთის ტანის დამუშავებისას, რაც უზრუნველყოფს კოდის მართვადობას და ცვალებადობას.
     */
    static JsonObject createUserBody(String userName, String password){
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("userName", userName);
        requestBody.addProperty("password", password);
        return requestBody;
    }
}
