package UserContainer;

import java.util.ArrayList;
import java.util.List;

public interface UserCheck {
    boolean checkConditions(User user);

    static List <User> userConditions (List<User> users, UserCheck userCheck) {
        List<User> conditionResult = new ArrayList<>();
        for (User user : users){
            if (userCheck.checkConditions(user)) {
                conditionResult.add(user);
                System.out.println(conditionResult);
            }
        }
        return conditionResult;
    }
}
