package soliloquy.specs.io.bootstrap;

/**
 * <b>CoreLoop</b>
 * <p>
 * This class starts up the most basic IO engine infrastructure, and runs the core graphics loop.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CoreLoop {
    /**
     * This method starts up the engine and runs the game.
     *
     * @param game The function executed by the thread which runs the rest of the game. (NB: the
     *             thread running the core graphics loop must be the main thread of the application;
     *             therefore, the rest of the application must run on a separate thread.)
     * @throws IllegalArgumentException If and only if callback is null
     */
    void startup(Runnable game) throws IllegalArgumentException;

    /**
     * @return The current window Id
     * @throws UnsupportedOperationException If and only if the core loop has not been started yet
     */
    long windowId() throws UnsupportedOperationException;

    /**
     * NB: This method exists for when a window needs to be re-generated, i.e. switching to or from
     * fullscreen
     *
     * @return The window's titlebar
     */
    String getTitlebar();

    /**
     * @param titlebar The title to assign to the Game window's titlebar
     * @throws IllegalArgumentException If and only if titlebar is null or empty
     */
    void setTitlebar(String titlebar) throws IllegalArgumentException;
}
