package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
//bb1
	public static void main(String[] args) {
		// this is for developer
		/** ログインID. */
		String TIME_FORMAT_YYYYMMDDHH = "yyyyMMddHH";
		String abc = null;
		Date date = null;
		//bb2		
		System.out.println(stringToDate(abc, TIME_FORMAT_YYYYMMDDHH));
		System.out.println(dateToString(date, TIME_FORMAT_YYYYMMDDHH));
	}
//bb3
	public static Date stringToDate(String strDate, String format) {
//bb4
		if (strDate.isEmpty())
			return null;

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	//bb5
	public static String dateToString(Date date,String format) {
		//bb6
		if (date.equals(null))
			return null;
		String strDate = null;
		SimpleDateFormat df = new SimpleDateFormat(format);
		strDate = df.format(date);
		return strDate;
	}
	//bb7
	public static String digest(final String manageNumber) {
		final long hash = manageNumber.hashCode();
		final int prime = getPrime(hash);
		final char[] cArray = toCharArray(hash);
		long calcedVal = prime;
		for (int i = 0; i < cArray.length; i++) {
			calcedVal += cArray[i] * (prime - i);
		}
		//bb8
		if (calcedVal < 4096) {
			calcedVal *= 50;
		}
		//bb9
		final StringBuffer buffer = new StringBuffer(
				Long.toHexString(calcedVal)).reverse();
		return buffer.substring(0, 4);
	}
	//bb10
	private static char[] toCharArray(long hex) {
		final char[] buf = new char[64];
		int charPos = 64;
		final int radix = 1 << 4;
		final long mask = radix - 1;
		do {
			buf[--charPos] = DIGITS[(int) (hex & mask)];
			hex >>>= 4;
		} while (hex != 0);

		final int len = 64 - charPos;
		final char[] result = new char[len];
		System.arraycopy(buf, charPos, result, 0, len);
		return result;
	}

	private static int getPrime(long hash) {
		if (hash < 0) {
			hash = ~hash + 1;
		}
		final int index = (int) hash % PRIMES.length;
		return PRIMES[index];
	}

	private static final int[] PRIMES = { 101, 103, 107, 109, 113, 127, 131,
			137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197,
			199, 211, 223, 227, 281, 283, 293, 307, 311, 313, 317, 331, 337,
			347, 349, 353, 359, 567, 373, 379, 383, 389, 397, 401, 409, 419,
			421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491,
			499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587,
			593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659,
			661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751,
			757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839,
			853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937,
			941, 947, 953, 967, 971, 977, 983, 991, 997 };

	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
}
