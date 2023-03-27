import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        UserData user1 = new UserData("kirill_23kkkkkdd_(", "dfdfdf2433", "dfdfdf2433R");
        boolean a = check(user1.getLogin(), user1.getPassword(), user1.getConfirmPassword());
        if (a) {
            System.out.println("Вход выполнен");
        } else {
            System.out.println("Вход не выполнен");

        }
    }

    public static boolean check(String login, String password, String confirmPassword) {
        UserData userData = new UserData(login, password, confirmPassword);
        try {
            checkUser(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException w) {
            System.out.println(w.getMessage());
        //} finally {
            //System.out.println("Проверка завершена");
        }
        return false;

    }

    public static void checkUser(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() >= 20) {
            throw new WrongLoginException("Длина логина не должна превышать 20 символов");
        }
        if (Objects.isNull(password) || password.length() > 20) {
            throw new WrongPasswordException("Длина пароля должна быть менее 20 символов");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать");
        }
        CheckSymbols c = new CheckSymbols();
        if (!c.checkSymbols(login)) {
            throw new WrongLoginException("Логин содержит некорректные символы");
        }
        if (!c.checkSymbols(password)) {
            throw new WrongPasswordException("Пароль содержит некорректные символы");
        }
    }

}
