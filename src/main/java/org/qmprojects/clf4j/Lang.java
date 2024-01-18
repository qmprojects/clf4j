package org.qmprojects.clf4j;

public enum Lang {
    PY("python"),
    JS("node"),
    ;

    private final String command;
    private Lang(String command) {
        this.command = command;
    }
    public String getCommand() {
        return command;
    }
}
