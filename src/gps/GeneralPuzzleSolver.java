package gps;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import gps.solver.*;
import gps.statemanager.*;
import gnu.getopt.*;

public class GeneralPuzzleSolver {
	// name of program
	final private static String progname = "GeneralPuzzleSolver";

	// puzzle enum
	private static int PUZZLE_KQ = 0;
	private static String PUZZLE_KQ_KEY = "KQ";
	private static int PUZZLE_GC = 1;
	private static String PUZZLE_GC_KEY = "GC";
	private static int PUZZLE_XX = 2;
	private static String PUZZLE_XX_KEY = "XX";

	// method enum
	private static int METHOD_MC = 0;
	private static String METHOD_MC_KEY = "MC";
	private static int METHOD_SA = 1;
	private static String METHOD_SA_KEY = "SA";

	private static int puzzle = -1;
	private static int rounds = 20;
	private static int method = METHOD_MC;
	private static String puzzleLevelS;
	private static int puzzleLevelInt;

	public static void main(String[] args) throws Exception {
		// TODO - delete - just test
		// KQueensMC kqMC = new KQueensMC(10, new Range(5, 12));
		// kqMC.solve(1000);
		// kqMC.printVariables();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(4);
		list.add(4);
		list.add(4);
		list.add(5);
		list.add(5);
		list.add(7);
		list.add(9);
		
		
		if (!parseCmdParams(args)) {
			usage(progname);
			return;
		}
		
		
		ConstraintBasedLocalSearch solver = chooseSolver();

		solve(solver, rounds);
		for (int i = 0; i < rounds; i++) {
			// GraphColorSA solver = new
			// GraphColorSA("./test/graph-color-1.txt");
			// solver.solve();
		}
	}

	public static ConstraintBasedLocalSearch chooseSolver() throws Exception {
		if (puzzle == PUZZLE_GC) {
			return (method == METHOD_SA) ? new GraphColorSA(puzzleLevelS)
					: new GraphColorMC(puzzleLevelInt, new Range(0,
							puzzleLevelInt));
		} else if (puzzle == PUZZLE_KQ) { // TODO
			// return (method == METHOD_SA) ? new KQueensSA(puzzleLevelS)
			// : new GraphColorMC(puzzleLevelInt, new Range(0,
			// puzzleLevelInt));
		} else { // PUZZLE_XX TODO

		}
		return null;

	}

	public static void solve(ConstraintBasedLocalSearch solver, int rounds) {
		ArrayList<Integer> steps = new ArrayList<Integer>();
		ArrayList<Double> qualities = new ArrayList<Double>();
		for (int i = 0; i < rounds; i++) {
			solver.reset();
			ArrayList<Integer> state = solver.solve();
			steps.add(solver.getStep());
			qualities.add(solver.evaluateState(state));
			System.out
					.println("Step = " + solver.getStep()
							+ " and solution quality is "
							+ solver.evaluateState(state));
		}
		
        DecimalFormat df = new DecimalFormat("#.##");
        
		double meanOfQualities = getMean(qualities);
		double meanOfSteps = getMean(steps);
		double stddevOfQualities = getStandardDeviation(qualities);
		double stddevOfSteps = getStandardDeviation(steps);
		System.out.println("--------------------------------------");
		System.out.println(rounds + " runs");
		System.out.println("Avarage quality of result: " + df.format(meanOfQualities) + " +-" + df.format(stddevOfQualities));
		System.out.println("Avarage number of steps: " + df.format(meanOfSteps) + " +-" + df.format(stddevOfSteps));
		System.out.println("--------------------------------------");
	}

	private static Boolean parseCmdParams(String[] argv) {
		Boolean retval = true;
		int c;
		String arg;
		String level = new String();

		Getopt g = new Getopt(progname, argv, "hp:l:r:m:");
		g.setOpterr(false); // We'll do our own error handling
		//

		while ((c = g.getopt()) != -1)
			switch (c) {
			case 'p':
				arg = g.getOptarg();
				if (arg == null) {
					retval = false;
				} else if (arg.compareTo(PUZZLE_KQ_KEY) == 0) {
					puzzle = PUZZLE_KQ;
				} else if (arg.compareTo(PUZZLE_GC_KEY) == 0) {
					puzzle = PUZZLE_GC;
				} else if (arg.compareTo(PUZZLE_XX_KEY) == 0) {
					puzzle = PUZZLE_XX;
				}
				break;
			//
			case 'l':
				arg = g.getOptarg();
				if (arg == null) {
					retval = false;
				}
				level = new String(arg);
				break;
			case 'r':
				arg = g.getOptarg();
				if (arg == null) {
					retval = false;
				}
				rounds = Integer.parseInt(arg);
				break;
			//
			case 'h':
				retval = false;
				break;
			//
			case 'm':
				arg = g.getOptarg();
				if (arg == null) {
					retval = false;
				} else if (arg.compareTo(METHOD_MC_KEY) == 0) {
					method = METHOD_MC;
				} else if (arg.compareTo(METHOD_SA_KEY) == 0) {
					method = METHOD_SA;
				} else {
					retval = false;
				}
				break;
			case '?':
				System.out.println("The option '" + (char) g.getOptopt()
						+ "' is not valid");
				break;
			//
			default:
				System.out.println("getopt() returned " + c);
				break;
			}
		//
		for (int i = g.getOptind(); i < argv.length; i++)
			System.out.println("Non option argv element: " + argv[i] + "\n");

		// check if all was set
		if (puzzle < 0) {
			retval = false;
		} else if (puzzle == PUZZLE_GC) {
			puzzleLevelS = level;
		} else if (puzzle == PUZZLE_KQ) {
			puzzleLevelInt = Integer.parseInt(level);
		} else if (puzzle == PUZZLE_XX) {
			puzzleLevelInt = Integer.parseInt(level);
		}

		return retval;

	}

	private static void usage(String progname) {
		System.out.println("USAGE: " + progname + " -p PUZZLE "
				+ "-l LEVEL [-r ROUNDS] [-m METHOD]");
		System.out.println();
		System.out.println("\tPUZZLE = [KQ|GC|XX] where");
		System.out.println("\t         \tKQ is KQueens");
		System.out.println("\t         \tGC is GraphColoring");
		System.out.println("\t         \tXX is YYY");
		System.out.println();
		System.out.println("\tLEVEL  = [INT|FILENAME] where");
		System.out
				.println("\t         \tINT is number of queens in case of KQ");
		System.out
				.println("\t         \tFILENAME is path to source file in case of GC");
		System.out.println();
		System.out
				.println("\tROUNDS  express count of how many times puzzle is being solved.");
		System.out.println("\t        is implicit 20");
		System.out.println();
		System.out.println("\tMETHOD = [SA|MC] where");
		System.out.println("\t          \tSA is Simulated Annealing");
		System.out
				.println("\t          \tMC is Minimum Conflicts, this is implicit value");

	}
	
	private static <T extends Number> double getMean(ArrayList<T> list) {
		double mean = 0;
		for (T i: list) {
			mean += i.doubleValue();
		}
		return mean/list.size();
	}
	
	private static <T extends Number> double getStandardDeviation(ArrayList<T> list) {
		double mean = getMean(list);
		double stddev = 0;
		for (T i: list) {
			stddev += Math.pow(i.doubleValue() - mean, 2);
		}
		return Math.sqrt(stddev/list.size());
	}
}
