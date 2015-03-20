package SortAndSearch;

public class Timer {

	public static final long MILLISEC = 1000000;

	private long startTime;
	private long endTime;

	public Timer() {
		startTime = System.nanoTime();
	}

	public void stop() {
		endTime = System.nanoTime();
	}

	public long getRunTime() {
		return endTime - startTime;
	}

	public String toString() {
		return "Runtime: " + (double) getRunTime() / MILLISEC + "ms";
	}
}
