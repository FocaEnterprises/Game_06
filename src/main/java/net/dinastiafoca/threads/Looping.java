package net.dinastiafoca.threads;

public interface Looping {

    /**
     * Starts the looping worker
     * @throws IllegalStateException if the worker is already running or has already been closed.
     */
    void start();

    /**
     * Stop the looping worker
     * @throws IllegalStateException if the worker is not running.
     */
    void stop();

    /**
     *
     * @return if worker is running
     */
    boolean isRunning();
}
