package edu.vserver.exercises.math.essentials.generator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import fi.utu.ville.standardutils.PreciseDecimal;

public enum Operator implements Serializable, Operatable, EquationElement {
	SUM() {

		@Override
		public String getSymbol() {
			return "+";
		}

		@Override
		public Term operate(Term term1, Term term2) {
			return term1.add(term2);
		}

		@Override
		public double operate(double firstOperand, double secondOperand) {
			return firstOperand + secondOperand;
		}

		@Override
		public int getPriority() {
			return 4;
		}

		@Override
		public double[] getTermRange(double[] otherTermRange,
				double[] solutionRange) {
			double first = solutionRange[0] - otherTermRange[0];
			double second = solutionRange[1] - otherTermRange[0];

			double[] result = new double[] { Math.min(first, second),
					Math.max(first, second) };
			return result;
		}

		@Override
		public double[] getSolutionRange(double[] firstTermRange,
				double[] secondTermRange) {
			return new double[] { firstTermRange[0] + secondTermRange[0],
					firstTermRange[1] + secondTermRange[1] };
		}

		@Override
		public boolean validateBounds(double[] firstTermRange,
				double[] secondTermRange, double[] solutionRange) {
			double[] temp = getSolutionRange(firstTermRange, secondTermRange);

			return isIntersectionNonEmpty(temp, solutionRange);

			/*return (solutionRange[0] >= firstTermRange[0]+secondTermRange[0]) && 
					(solutionRange[1] <= firstTermRange[1]+secondTermRange[1]);*/
		}

		public PreciseDecimal[] obscure(PreciseDecimal number, PreciseDecimal[] firstRange, PreciseDecimal[] secondRange){
			PreciseDecimal possibilities = PreciseDecimal.subtract(number, firstRange[0]);
			possibilities = PreciseDecimal.add(possibilities, PreciseDecimal.ONE);
			if(possibilities.doubleValue() < 1)
				return null;
						
			for(int i=0; i< MAX_ATTEMPTS; i++){
				PreciseDecimal first = PreciseDecimal.getRandomDecimal(firstRange[0], firstRange[1], 0);
				PreciseDecimal second = PreciseDecimal.subtract(number, first);
				if(withinRange(second, secondRange)){
//					System.out.println("Obscured "+number+" into "+first+"+"+second);
					return new PreciseDecimal[]{first,second};
				}
			}
			return null;
		}

		@Override
		@Deprecated
		public int[] obscure(int number, int[] firstRange, int[] secondRange) {
			if (!canObscure(number, firstRange, secondRange))
				return null;

			int firstTerm;
			int secondTerm;

			long possibilities = (long) firstRange[1] - (long) firstRange[0]
					+ 1;
			// if(possibilities < 0)
			// System.out.println("Range was "+firstRange[0]+" "+firstRange[1]);
			int attempts = 0;
			do {
				firstTerm = firstRange[0]
						+ gen.nextInt(possibilities > Integer.MAX_VALUE ? Integer.MAX_VALUE
								: (int) possibilities);
				secondTerm = number - firstTerm;
				attempts++;
				if(attempts >= MAX_ATTEMPTS)
					return null;				
			} while (!withinRange(secondTerm, secondRange));
		
			return new int[] { firstTerm, secondTerm };
		}

		private boolean canObscure(int number, int[] firstRange,
				int[] secondRange) {
			double[] first = new double[] { firstRange[0], firstRange[1] };
			double[] second = new double[] { secondRange[0], secondRange[1] };
			return withinRange(number, getSolutionRange(first, second));
		}
	},

	SUBTRACT() {

		@Override
		public String getSymbol() {
			return "-";
		}

		@Override
		public Term operate(Term term1, Term term2) {
			return term1.subtract(term2);
		}

		@Override
		public double operate(double firstOperand, double secondOperand) {
			return firstOperand - secondOperand;
		}

		@Override
		public int getPriority() {
			return 3;
		}

		@Override
		public double[] getTermRange(double[] otherTermRange,
				double[] solutionRange) {
			return new double[] { otherTermRange[0] - solutionRange[1],
					otherTermRange[1] - solutionRange[0] };
		}

		@Override
		public double[] getSolutionRange(double[] firstTermRange,
				double[] secondTermRange) {

			double first = firstTermRange[0] - secondTermRange[0];
			double second = firstTermRange[1] - secondTermRange[0];

			double[] result = new double[] { Math.min(first, second),
					Math.max(first, second) };
			return result;
		}

		@Override
		public boolean validateBounds(double[] firstTermRange,
				double[] secondTermRange, double[] solutionRange) {
			double[] temp = getSolutionRange(firstTermRange, secondTermRange);

			return isIntersectionNonEmpty(temp, solutionRange);
		}

		@Override
		public PreciseDecimal[] obscure(PreciseDecimal number, PreciseDecimal[] firstRange, PreciseDecimal[] secondRange){

			PreciseDecimal firstTerm;
			PreciseDecimal secondTerm;

			long possibilities = PreciseDecimal.add(PreciseDecimal.subtract(firstRange[1], number), PreciseDecimal.ONE).longValue();
			if (possibilities <= 0)
				return null;
			
			int attempts = 0;
			do {
				firstTerm = PreciseDecimal.getRandomDecimal(firstRange[0], firstRange[1], 0);
				secondTerm = PreciseDecimal.subtract(firstTerm, number);
				attempts++;
								
				if(attempts >= MAX_ATTEMPTS){
//					System.out.println("MAX ATTEMPTS IN SUB");
					return null;			
				}
			} while (!withinRange(secondTerm, secondRange));
			
//			System.out.println("Obscured "+number+" into "+firstTerm+" - "+secondTerm);
			
			return new PreciseDecimal[] { firstTerm, secondTerm };
		}
		
		@Override
		@Deprecated
		public int[] obscure(int number, int[] firstRange, int[] secondRange) {
			if (!canObscure(number, firstRange, secondRange)) {
				return null;
			}

			int firstTerm;
			int secondTerm;

			long possibilities = Math.abs((long) firstRange[1] - (long) number) + 1;
			// if (possibilities < 0)
			// System.out.println("Range was " + firstRange[0] + " "
			// + firstRange[1]);
			int attempts = 0;
			do {
				firstTerm = number
						+ gen.nextInt(possibilities > Integer.MAX_VALUE ? Integer.MAX_VALUE
								- number
								: (int) possibilities);
				secondTerm = firstTerm - number;
				attempts++;
				
				if(attempts >= MAX_ATTEMPTS)
					return null;				
			} while (!withinRange(secondTerm, secondRange));
			
			return new int[] { firstTerm, secondTerm };
		}

		private boolean canObscure(int number, int[] firstRange,
				int[] secondRange) {
			double[] first = new double[] { firstRange[0], firstRange[1] };
			double[] second = new double[] { secondRange[0], secondRange[1] };
			return withinRange(number, getSolutionRange(first, second));
		}
	},

	MULTIPLICATION {

		@Override
		public String getSymbol() {
			return "*";
		}

		@Override
		public Term operate(Term term1, Term term2) {
			return term1.multiply(term2);
		}

		@Override
		public double operate(double firstOperand, double secondOperand) {
			return firstOperand * secondOperand;
		}

		@Override
		public int getPriority() {
			return 2;
		}

		@Override
		public double[] getTermRange(double[] otherTermRange,
				double[] solutionRange) {
			double minValue = 0;
			double maxValue = 0;

			if (otherTermRange[0] != 0.0)
				minValue = solutionRange[0] / otherTermRange[0];
			if (otherTermRange[1] != 0.0)
				maxValue = solutionRange[1] / otherTermRange[1];

			// System.out.println("created range " + otherTermRange[0] + " "
			// + otherTermRange[1] + " in division");
			// to prevent situations like [-1, 10] [-10, -1] = [10, -10]
			double[] result = new double[] { Math.min(minValue, maxValue),
					Math.max(minValue, maxValue) };
			return result;
		}

		@Override
		public double[] getSolutionRange(double[] firstTermRange,
				double[] secondTermRange) {
			double first = firstTermRange[0] * secondTermRange[0];
			double second = firstTermRange[1] * secondTermRange[1];

			// to prevent situations like [-1, 10] [-10, -1] = [10, -10]
			double[] result = new double[] { Math.min(first, second),
					Math.max(first, second) };
			return result;

		}

		@Override
		public boolean validateBounds(double[] firstTermRange,
				double[] secondTermRange, double[] solutionRange) {
			return withinRange(firstTermRange[0] * secondTermRange[0],
					solutionRange)
					|| withinRange(firstTermRange[1] * secondTermRange[1],
							solutionRange);
		}

		@Override
		@Deprecated
		public int[] obscure(int number, int[] firstRange, int[] secondRange) {
			ArrayList<Integer> factors = Factorize(number);

			if (number == 0) {
				if (withinRange(0, firstRange)) {
					return new int[] { 0,
							gen.nextInt(secondRange[1] - secondRange[0] + 1) };
				}
				if (withinRange(0, secondRange)) {
					return new int[] {
							gen.nextInt(firstRange[1] - firstRange[0] + 1), 0 };
				}
				return null;
			}

			ArrayList<Integer> factorList = new ArrayList<>();

			for (Integer i : factors) {
				int secondTempFactor = number / i;
				if (withinRange(i, firstRange)
						&& withinRange(secondTempFactor, secondRange)) {
					factorList.add(i);
					factorList.add(secondTempFactor);
				}
				if (withinRange(i, secondRange)
						&& withinRange(secondTempFactor, firstRange)) {
					factorList.add(i);
					factorList.add(secondTempFactor);
				}
			}

			if (factorList.isEmpty()) {
				return null;
			}

			int randomIndex = gen.nextInt(factorList.size() / 2) * 2;

			return new int[] { factorList.get(randomIndex),
					factorList.get(randomIndex + 1) };
		}
		
		@Override
		public PreciseDecimal[] obscure(PreciseDecimal number, PreciseDecimal[] firstRange, PreciseDecimal[] secondRange) {
			ArrayList<Integer> factors = Factorize(Math.abs(number.intValue()));

			if (number.equals(PreciseDecimal.ZERO)) {
				if (withinRange(number, firstRange)) {
					return new PreciseDecimal[] { number,
							new PreciseDecimal(gen.nextInt(secondRange[1].intValue() - secondRange[0].intValue() + 1)) };
				}
				if (withinRange(number, secondRange)) {
					return new PreciseDecimal[] {
							new PreciseDecimal(gen.nextInt(firstRange[1].intValue() - firstRange[0].intValue() + 1)), number };
				}
				return null;
			}

			ArrayList<Integer> factorList = new ArrayList<>();

			for (Integer i : factors) {
				int secondTempFactor = number.intValue() / i;
				if (withinRange(new PreciseDecimal(i), firstRange)
						&& withinRange(new PreciseDecimal(secondTempFactor), secondRange)) {
					factorList.add(i);
					factorList.add(secondTempFactor);
				}
				if (withinRange(new PreciseDecimal(i), secondRange)
						&& withinRange(new PreciseDecimal(secondTempFactor), firstRange)) {
					factorList.add(i);
					factorList.add(secondTempFactor);
				}
				
				//some copy-paste for the negative multiplicand
				secondTempFactor = number.intValue() / -i;
				if (withinRange(new PreciseDecimal(-i), firstRange)
						&& withinRange(new PreciseDecimal(secondTempFactor), secondRange)) {
					factorList.add(-i);
					factorList.add(secondTempFactor);
				}
				if (withinRange(new PreciseDecimal(-i), secondRange)
						&& withinRange(new PreciseDecimal(secondTempFactor), firstRange)) {
					factorList.add(-i);
					factorList.add(secondTempFactor);
				}
			}

			if (factorList.isEmpty()) {
				return null;
			}
			
			int randomIndex = gen.nextInt(factorList.size() / 2) * 2;

			return new PreciseDecimal[] { new PreciseDecimal(factorList.get(randomIndex)),
					new PreciseDecimal(factorList.get(randomIndex + 1)) };
		}
	},

	DIVISION() {

		@Override
		public String getSymbol() {
			return "/";
		}

		@Override
		public Term operate(Term term1, Term term2) {
			return term1.divide(term2);
		}

		@Override
		public double operate(double firstOperand, double secondOperand) {
			return firstOperand / secondOperand;
		}

		@Override
		public int getPriority() {
			return 1;
		}

		@Override
		public double[] getTermRange(double[] otherTermRange,
				double[] solutionRange) {
			double first = otherTermRange[0] * solutionRange[0];
			double second = otherTermRange[1] * solutionRange[1];

			// to prevent situations like [-1, 10] [-10, -1] = [10, -10]
			double[] result = new double[] { Math.min(first, second),
					Math.max(first, second) };
			return result;
		}

		@Override
		public double[] getSolutionRange(double[] firstTermRange,
				double[] secondTermRange) {
			double minValue = Integer.MIN_VALUE;
			double maxValue = firstTermRange[1];

			if (secondTermRange[1] != 0.0)
				minValue = firstTermRange[0] / secondTermRange[1];
			if (secondTermRange[0] != 0.0)
				maxValue = firstTermRange[1] / secondTermRange[0];

			// to prevent situations like [-1, 10] [-10, -1] = [10, -10]
			double[] result = new double[] { Math.min(minValue, maxValue),
					Math.max(minValue, maxValue) };
			return result;
		}

		@Override
		public boolean validateBounds(double[] firstTermRange,
				double[] secondTermRange, double[] solutionRange) {

			return true;
		}

		@Override
		@Deprecated
		public int[] obscure(int number, int[] firstRange, int[] secondRange) {
			if (number == 0) {
				return null;
			}

			if (!canObscure(new PreciseDecimal(number), new PreciseDecimal[]{new PreciseDecimal(firstRange[0]), new PreciseDecimal(firstRange[1])}, new PreciseDecimal[]{new PreciseDecimal(secondRange[0]),new PreciseDecimal(secondRange[1])})) {
				return null;
			}

			int denominator = 0;
			long possibilities = (long) secondRange[1] - (long) secondRange[0]
					+ 1;
			int attempts = 0;
			do {
				denominator = secondRange[0]
						+ gen.nextInt(possibilities >= Integer.MAX_VALUE ? Integer.MAX_VALUE
								- secondRange[0]
								: (int) possibilities);
				attempts++;
				if(attempts > MAX_ATTEMPTS)
					return null;
			} while (denominator == 0
					|| !withinRange((long) number * (long) denominator,
							firstRange));
			
			return new int[] { number * denominator, denominator };
		}

		@Override
		public PreciseDecimal[] obscure(PreciseDecimal number, PreciseDecimal[] firstRange, PreciseDecimal[] secondRange) {
			if (number.toString().equals(PreciseDecimal.ZERO.toString())) {
				return new PreciseDecimal[]{PreciseDecimal.ZERO, PreciseDecimal.getRandomDecimal(secondRange[0], secondRange[1], 0)};
			}
			
			PreciseDecimal denominator = PreciseDecimal.ZERO;
			PreciseDecimal possibilities = PreciseDecimal.divide(firstRange[1], number);
			
			if (!canObscure(possibilities, firstRange, secondRange)) {
				return null;
			}

			int attempts = 0;
			do{
				PreciseDecimal randomNum = new PreciseDecimal(
						gen.nextInt(possibilities.longValue() >= Integer.MAX_VALUE-2 ? 
								Integer.MAX_VALUE - secondRange[0].intValue()
								: Math.abs(possibilities.intValue())));
				
				denominator = PreciseDecimal.add(randomNum ,PreciseDecimal.ONE);
				
				attempts++;
				if(attempts > MAX_ATTEMPTS){
//					System.out.println("MAX ATTEMPSTS DIV");
					break;
				}
			}while(denominator.equals(PreciseDecimal.ZERO)
					|| denominator.equals(PreciseDecimal.ONE)
					|| !withinRange(PreciseDecimal.multiply(number, denominator), firstRange));
			
			if(attempts >= MAX_ATTEMPTS)
				denominator = PreciseDecimal.ONE;
			
			return new PreciseDecimal[] { PreciseDecimal.multiply(number, denominator), denominator };

		}
		
		private boolean canObscure(PreciseDecimal number, PreciseDecimal[] firstRange,
				PreciseDecimal[] secondRange) {
			if(number.intValue() == 0 || number.compareTo(firstRange[0]) < 0)
				return false;
			return true;
		}
	}, 
	
	NOOP(){
		@Override
		public String getSymbol() {
			return "";
		}

		@Override
		public Term operate(Term term1, Term term2) {
			return term1;
		}
	};

	
	protected boolean withinRange(PreciseDecimal second,
			PreciseDecimal[] range) {
		double value = second.doubleValue();
		return value >= range[0].doubleValue() && value <= range[1].doubleValue();
	}
	
	protected boolean withinRange(long i, int[] range) {
		return range[0] <= i && range[1] >= i;
	}

	protected boolean withinRange(int i, int[] range) {
		return withinRange((long) i, range);
	}

	protected static boolean withinRange(double i, double[] range) {
		return range[0] <= i && range[1] >= i;
	}

	private static Random gen = new Random();

	private static ArrayList<Integer> Factorize(int target) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		int sqrt = (int) Math.sqrt(target);

		for (int i = 1; i <= sqrt; i++) {
			if (target % i == 0) {
				result.add(i);
			}
		}

		Collections.reverse(result);

		return result;
	}

	@Override
	public int getPriority() {
		return 0;
	}

	private static final int MAX_ATTEMPTS = 500;
	
	/**
	 * Calculates the range that is appropriate for the other term for this
	 * operator given the ranges for the solution and the other term.
	 * 
	 * @param otherTermRange
	 *            The allowed range for the other term in this operation
	 * @param solutionRange
	 *            The allowed range for the solution in this operation
	 * @return A double array that has the minimum allowed value is in index 0
	 *         and the maximum value in index 1
	 */
	public double[] getTermRange(double[] otherTermRange, double[] solutionRange) {
		return null;
	}

	/**
	 * Calculates the range that, given the two ranges for the terms, the
	 * solution is possible to achieve. For example, if the ranges for the terms
	 * are [0,5] and [2,6] with the sum operator, the possible solutions consist
	 * of the range [2,8]
	 * 
	 * @param firstTermRange
	 *            The range for the first term
	 * @param secondTermRange
	 *            The range for the second term
	 * @return The range for the solution
	 */
	public double[] getSolutionRange(double[] firstTermRange,
			double[] secondTermRange) {
		return null;
	}

	/**
	 * Validates the given bounds. E.g. [1,5] + [3,6] = [10,20] will return
	 * true, because 4+6=10, 5+5=10 and 5+6=11. [1,5] + [3,6] = [12,20] on the
	 * other hand will return false.
	 * 
	 * @param firstTermRange
	 *            The range for the first term.
	 * @param secondTermRange
	 *            The range for the second term.
	 * @param solutionRange
	 *            The range for the solution.
	 * @return True, if there exists a solution with the given ranges. False
	 *         otherwise.
	 */
	public boolean validateBounds(double[] firstTermRange,
			double[] secondTermRange, double[] solutionRange) {
		return false;
	}

	/**
	 * Checks if there is any overlap in the two gives ranges.
	 * 
	 * @param firstBound
	 * @param secondBound
	 * @return False if the intersection of these sets is empty, true otherwise.
	 */
	private static boolean isIntersectionNonEmpty(double[] firstBound,
			double[] secondBound) {

		return (withinRange(firstBound[0], secondBound)
				|| withinRange(firstBound[1], secondBound)
				|| withinRange(secondBound[0], firstBound) || withinRange(
					secondBound[1], firstBound));
	}

	/**
	 * Performs the correct arithmetic operation on the given parameters.
	 * 
	 * @param firstTerm
	 * @param secondTerm
	 * @return the result of the operation
	 */
	@Deprecated
	public double operate(double firstTerm, double secondTerm) {
		return 0;
	}
	
	/**
	 * Performs the correct arithmetic operation on the given parameters.
	 * 
	 * @param firstTerm
	 * @param secondTerm
	 * @return the result of the operation
	 */
	public PreciseDecimal operate(PreciseDecimal firstTerm, PreciseDecimal secondTerm) {
		return PreciseDecimal.ZERO;
	}

	/**
	 * Rewrites the given number as an operation. E.g. Multiplication.obscure(6)
	 * could return an array [3,2]. To simplify implementation, only integers
	 * are obscured; if doubles or floats need to be obscured, it is the
	 * caller's responsibility multiply the ranges with the correct power of
	 * ten. The same applies for the provided number and result.
	 * 
	 * @param number
	 *            The number to rewrite
	 * @param firstRange
	 *            The range for the first term.
	 * @param secondRange
	 *            The range for the second term
	 * @return An array containing the terms that, when operated on with the
	 *         same operator, will give back the starting number. Null if
	 *         obscuring was not possible.
	 */
	@Deprecated
	public int[] obscure(int number, int[] firstRange, int[] secondRange) {
		return null;
	}
	
	public PreciseDecimal[] obscure(PreciseDecimal number, PreciseDecimal[] firstRange, PreciseDecimal[] secondRange){
		return null;
	}
}
