package UserContainer;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TestUsers {
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
    @Test
    public void checkUserSex() {
        List<User> lu = UserCheck.userConditions(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.sex;
            }
        });
        for (User user : lu){
            Assert.assertTrue(user.sex);
        }
    }

        @Test
        public void checkUserRSex() {
            List<User> lu = UserCheck.userConditions(userList, new UserCheck() {
                @Override
                public boolean checkConditions(User user) {
                    return !user.sex;
                }
            });
            for (User user : lu){
                Assert.assertTrue(!user.sex);
            }
        }

        @Test
        public void checkUserAgeMore30() {
            List<User> lu = UserCheck.userConditions(userList, new UserCheck() {
                @Override
                public boolean checkConditions(User user) {
                    return user.getAge() > 30;
                }
            });
            for (User user : lu){
                Assert.assertTrue(user.getAge() > 30);
            }
        }

        @Test
        public void userCheckAgeLess30() {
            List<User> lu = UserCheck.userConditions(userList, new UserCheck() {
                @Override
                public boolean checkConditions(User user) {
                    return user.getAge() < 30;
                }
            });
            for (User user : lu){
                Assert.assertTrue(user.getAge() < 30);
            }
        }

        @Test
        public void checkUserQA() {
            List<User> lu = UserCheck.userConditions(userList, new UserCheck() {
                @Override
                public boolean checkConditions(User user) {
                    return Objects.equals(user.getSpeciality(), "QA");
                }
            });
            for (User user : lu){
                Assert.assertEquals(user.getSpeciality(), "QA");
            }
        }

    @Test
    public void checkUserBA() {
        List<User> lu = UserCheck.userConditions(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return Objects.equals(user.getSpeciality(), "BA");
            }
        });
        for (User user : lu){
            Assert.assertEquals(user.getSpeciality(), "BA");
        }
    }

    @Test
    public void checkUserSM() {
        List<User> lu = UserCheck.userConditions(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return Objects.equals(user.getSpeciality(), "Scrum master");
            }
        });
        for (User user : lu){
            Assert.assertEquals(user.getSpeciality(), "Scrum master");
        }
    }

    @Test
    public void checkUserAgeMore25AndFrontEnd() {
        List<User> lu = UserCheck.userConditions(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return Objects.equals(user.getSpeciality(), "Front End") && user.getAge() > 25;
            }
        });
        for (User user : lu){
            Assert.assertTrue(user.age > 25 && Objects.equals(user.getSpeciality(), "Front End"));
        }
    }

    @Test
    public void checkUserFemaleAndFrontEnd() {
        List<User> lu = UserCheck.userConditions(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return Objects.equals(user.getSpeciality(), "Front End") && !user.sex;
            }
        });
        for (User user : lu){
            Assert.assertTrue(!user.sex && Objects.equals(user.getSpeciality(), "Front End"));
        }
    }

    @Test
    public void checkUserMaleAgeMore30SpecBackEnd() {
        List<User> lu = UserCheck.userConditions(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return Objects.equals(user.getSpeciality(), "Back End") && user.sex && user.age > 30;
            }
        });
        for (User user : lu){
            Assert.assertTrue(user.sex && user.age > 30 && Objects.equals(user.getSpeciality(), "Back End"));
        }
    }

    @Test
    public void molodiyeDevochki() {
        List<User> lu = UserCheck.userConditions(userList, new UserCheck() {
            @Override
            public boolean checkConditions(User user) {
                return user.getAge() < 30 && !user.sex;
            }
        });
        for (User user : lu){
            Assert.assertTrue(!user.sex && user.getAge() < 30);
        }
    }


    public void printCondition(List<User> userList, UserCheck userCheck) {
        for (User user : userList){
            if (userCheck.checkConditions(user)){
                System.out.println(user);
            }
        }
    }
}
