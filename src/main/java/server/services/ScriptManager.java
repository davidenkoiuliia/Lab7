package server.services;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Script manager.
 */
public class ScriptManager {
    private final List<String> scripts;


    /**
     * Instantiates a new Script manager.
     *
     * @param scripts the scripts
     */
    public ScriptManager(List<String> scripts) {
        this.scripts = scripts == null ? new ArrayList<>() : scripts;
    }

    /**
     * Add to scripts.
     *
     * @param script the script
     */
    public void addToScripts(String script) {
        scripts.add(script);
    }

    /**
     * Clear scripts.
     */
    public void clearScripts() {
        scripts.clear();
    }

    /**
     * Gets scripts.
     *
     * @return the scripts
     */
    public List<String> getScripts() {
        return scripts;
    }

}
