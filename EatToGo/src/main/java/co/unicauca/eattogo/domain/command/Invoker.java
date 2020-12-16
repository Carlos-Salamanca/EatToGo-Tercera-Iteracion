package co.unicauca.eattogo.domain.command;

import java.util.Stack;

/**
 * Invocador de comandos. Ejecuta y deshace los comandos
 *
 * @author Juliana Mora López, Yeferson Benavides Marín
 */
public class Invoker {

	 /**
     * Comando a ser invocado
     */
    private Command cmd;
    /**
     * Pila de operaciones deshacer
     */
    private final Stack<Command> undoStack;

    /**
     * Constructor
     */
    public Invoker() {
        undoStack = new Stack<>();
    }

    /**
     * Getter y Setter
     */
    public void setCommand(Command cmd) {
        this.cmd = cmd;
    }

    public Command getCommand() {
        return cmd;
    }

    /**
     * Ejecuta el comando
     */
    public void execute() {
        if (cmd.hasUndo) {
            undoStack.push(cmd);
        }
        cmd.execute();
    }

    /**
     * Ejecuta la operación de deshacer
     */
    public void undo() {
        if (!undoStack.isEmpty()) {
            Command cmdAux = undoStack.pop();
            cmdAux.undo();
        }
    }

    /**
     * Tiene comandos en la pila?
     *
     * @return true si lo tiene, false si no
     */
    public boolean hasCommandUndo() {
        return !undoStack.isEmpty();
    }
}
