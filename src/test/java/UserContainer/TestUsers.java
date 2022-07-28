package UserContainer;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestUsers {

    @Test
    public void checkUsers(){
        User firstUser = new User(20, "Yura", true, "QA");
        User secondUser = new User(21, "Dima", true, "Front End");
        User thirdUser = new User(24, "Yulia", false, "QA");
        User fourthUser = new User(33, "Darya", false, "Front End");
        User fifthUser = new User(40, "Nikita", true, "Back End");
        User sixthUser = new User(20, "Masha", false, "Back End");
        User seventhUser = new User(23, "Marina", false, "Back End");
        User eightsUser = new User(27, "Oleg", true, "QA");
        User ninthUser = new User(27, "Sergey", true, "Front End");
        User tenthUser = new User(35, "Misha", true, "Front End");
        User eleventhUser = new User(32, "Nikita", true, "Scrum master");
        User twelfthUser = new User(20, "Katya", false, "Product owner");
        User thirteenthUser = new User(23, "Susana", false, "Business analyst");
        User fourteenthUser = new User(34, "Alex", true, "Business analyst");
        User fifteenthUser = new User(28, "Volodya", true, "Project Coordinator");

        List<User> userList = Arrays.asList(firstUser, secondUser, thirdUser, fourthUser, fifthUser, sixthUser, seventhUser, eightsUser, ninthUser, tenthUser,
                eleventhUser, twelfthUser, thirteenthUser, fourteenthUser, fifteenthUser);


//            printCondition(userList, new UserCheck() {
//                @Override
//                public boolean checkConditions(User user) {
//                    return user.sex;
//                }
//            });

//            printCondition(userList, new UserCheck() {
//                @Override
//                public boolean checkConditions(User user) {
//                    return !user.sex;
//                }
//            });

//            printCondition(userList, new UserCheck() {
//                @Override
//                public boolean checkConditions(User user) {
//                    return user.age > 30;
//                }
//            });

//        printCondition(userList, new UserCheck() {
//            @Override
//            public boolean checkConditions(User user) {
//                return user.age < 30;
//            }
//        });

//        printCondition(userList, new UserCheck() {
//            @Override
//            public boolean checkConditions(User user) {
//                return user.speciality.equals("QA");
//            }
//        });

//        printCondition(userList, new UserCheck() {
//            @Override
//            public boolean checkConditions(User user) {
//                return user.speciality.equals("Business analyst");
//            }
//        });

//        printCondition(userList, new UserCheck() {
//            @Override
//            public boolean checkConditions(User user) {
//                return user.speciality.equals("Scrum master");
//            }
//        });

//        printCondition(userList, new UserCheck() {
//            @Override
//            public boolean checkConditions(User user) {
//                return user.age > 25 && user.speciality.equals("Front End");
//            }
//        });

//        printCondition(userList, new UserCheck() {
//            @Override
//            public boolean checkConditions(User user) {
//                return !user.sex && user.speciality.equals("Front End");
//            }
//        });

//        printCondition(userList, new UserCheck() {
//            @Override
//            public boolean checkConditions(User user) {
//                return user.sex && user.age < 30 && user.speciality.equals("Back End");
//            }
//        });

        printCondition(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return !user.sex && user.age < 30;
            }
        });

    }

    public void printCondition(List<User> userList, UserCheck userCheck) {
        for (User user : userList){
            if (userCheck.checkConditions(user)){
                System.out.println(user);
            }
        }
    }
}
