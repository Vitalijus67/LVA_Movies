package Command;
/**
 *
 * @author Lorenas Orleckas
 */
public class CommandFactory {

    public Command createCommand(String commandStr) {
        Command command = null;
        //Instantiate the required Command object...
        if (commandStr.equals("login")) {
            command = new LoginCommand();
        } else if (commandStr.equals("register")) {
            command = new RegisterCommand();
        } else if (commandStr.equals("forgotPass")) {
            command = new ForgotPasswordCommand();
        } else if (commandStr.equals("changePassword")) {
            command = new ChangePasswordCommand();
        }else {
            command = new ErrorCommand();
        }
        //Return the instantiated Command object to the calling code...
        return command;
    }
}
