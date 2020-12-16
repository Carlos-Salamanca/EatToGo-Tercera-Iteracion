package co.unicauca.eattogo.domain.command;

/**
 * Clase abstracta que representa un Comando cualquiera
 *
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public abstract class Command {

	/**
     * ¿Tiene deshacer?
     *
     */
    protected boolean hasUndo;

    /**
     * Ejecuta el comando
     */
    public abstract void execute();

    /**
     * Deshace el comando
     */
    public abstract void undo();

    /**
     * Getter y Setter
     */
    public boolean hasUndo() {
        return hasUndo;
    }

    public void setHasUndo(boolean hasUndo) {
        this.hasUndo = hasUndo;
    }
}
