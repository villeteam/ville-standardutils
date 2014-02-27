package fi.utu.ville.standardutils;

import java.util.Random;

/**
 * <p>
 * Provides an easy and efficient way for fetching {@link Random}-objects. This
 * class does approximately the same as ThreadLocalRandom in Java 7.
 * </p>
 * <p>
 * <b> Do not call {@link Random #setSeed(long)} on {@link Random}-objects
 * fetched through this method.</b> This is because the {@link Random}-object is
 * anyway shared between all the requests serviced by the same thread meaning
 * that you would not get predictable randomness anyway (at least between
 * different server-client cycles) and setting seed could reduce the quality of
 * randomness received by other users. If you need predictable "randomness",
 * instantiate a normal {@link Random}-object.
 * </p>
 * 
 * @author Riku Haavisto
 * 
 */
public final class RandomProvider {

	private RandomProvider() {

	}

	private static ThreadLocal<Random> randoms = new ThreadLocal<Random>() {

		@Override
		protected Random initialValue() {
			return new Random();
		}

	};

	/**
	 * @return the {@link Random}-instance local to current {@link Thread}
	 */
	public static Random getRandom() {
		return randoms.get();
	}

}
