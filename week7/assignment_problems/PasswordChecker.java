
public class PasswordChecker {

    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {

        int length = password.length();

        if (length < 6) {
            return "Weak";
        } else if (length < 10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {

        PasswordChecker pc1 =
                new PasswordChecker("abcd");

        PasswordChecker pc2 =
                new PasswordChecker("abcdefgh");

        PasswordChecker pc3 =
                new PasswordChecker("abcdefghijkl");

        System.out.println("Password 1: "
                + pc1.getStrength());

        System.out.println("Password 2: "
                + pc2.getStrength());

        System.out.println("Password 3: "
                + pc3.getStrength());
    }
}

