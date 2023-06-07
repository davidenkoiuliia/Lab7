package server.commands.list;

import server.commands.Command;
import server.commands.Invoker;
import server.exceptions.ArgumentException;
import server.exceptions.FileException;
import server.services.ScriptManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static server.utils.Parser.tildaResolver;


/**
 * The type Execute script command.
 */
public class ExecuteScriptCommand implements Command {
    private final Invoker invoker;
    private final ScriptManager scriptManager;

    /**
     * Instantiates a new Execute script command.
     *
     * @param invoker       the invoker
     * @param scriptManager the script manager
     */
    public ExecuteScriptCommand(Invoker invoker, ScriptManager scriptManager) {
        this.invoker = invoker;
        this.scriptManager = scriptManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            throw new ArgumentException("Команда требует минимум один аргумент");
        }
        String command;
        String scriptName;
        String currentScript = tildaResolver(args[1]);
        scriptManager.addToScripts(currentScript);
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(currentScript));

            while (fileReader.ready()) {
                command = fileReader.readLine();
                if (command.split(" ")[0].equals("execute_script")) {

                    scriptName = tildaResolver(command.split(" ")[1]);

                    if (scriptManager.getScripts().contains(scriptName)) {
                        throw new FileException("Встречена рекурсия. Скрипт не выполняется.");
                    }
                    scriptManager.addToScripts(scriptName);
                }
                invoker.execute(command);
            }

            scriptManager.clearScripts();
            fileReader.close();

            System.out.println("Скрипт выполнен.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String description() {
        return "выполнить скрипт.";
    }
}
