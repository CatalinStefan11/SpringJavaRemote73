package ro.sda.spring._1_;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

// CTR + D -> copy the current line
// ALT + SHIFT + ARROW UP/DOWN -> move current line up/down
// CTR + ALT + ARROW LEFT/RIGHT -> move backward or forward in the history of navigation
// SHIFT + F6 -> refactor class name (file name) / refactor method name or variable etc
public class JsonProcessor {
    public static void main(String[] args) {

        User u = new User("Catalin", "Manaila", 26);

        // transformation between POJO (plain-old java object) to JSON object
        System.out.println(userToJson(u));

        System.out.println("--------------------------");

        List<User> userList = List.of(
                new User("Leo", "Messi", 37),
                new User("Cristiano", "Ronaldo", 39));

        System.out.println(userArrayToJson(userList));
    }

    private static JSONObject userToJson(User u) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("firstName", u.getFirstName());
        jsonObject.put("lastName", u.getLastName());
        jsonObject.put("age", u.getAge());

        return jsonObject;
    }

    private static JSONArray userArrayToJson(List<User> list) {
        JSONArray jsonArray = new JSONArray();

        for(User u : list) {
            jsonArray.put(userToJson(u));
        }

        return jsonArray;
    }
}