import java.util.Stack;
////////////////////////////////////////////////////////////////
class Square {
	private static final int SIZ = 11; // matrix size
	private static final int POZ = 25; // number of positions
	private static int move(int x, int y) {
		return x + y*SIZ;
	}
	// N NE E SE S SW W NW
	//      N 
	//      |  
	//  W - x - E >
	//      |
	//      S
	//      v
	private static final int[] DIR = {
		move( 0, -3), // North
		move( 2, -2), // North-East
		move( 3,  0), // East
		move( 2,  2), // South-East
		move( 0,  3), // South
		move(-2,  2), // South-West
		move(-3,  0), // West
		move(-2, -2), // North-West
	};
	private static Stack<int[]> stk = new Stack<>();
////////////////////////////////////////////////////////////////
	// <m/> - matrix                                      //
	// <p/> - position                                    //
	// <c/> - counter                                     //
	public static void Gamma(int[] m, int p, int c) {     //
		// Here we go ..                                  //
		// Beforehand we must be sure that m[p] is dzero  //
		// 0. Set m[p]                                    //
		m[p] = ++c; ////////////////////////////////////////
		// 1. Now that we have just incremented <c/> ck   //
		// whether we are done.                           //
		if (c == POZ) {                                   //
			stk.push(m);                                  //
			return;                                       //
		}                                                 //
		// 2. Loof over directions                        //
		for (int j = 0; j < DIR.length; j++) {            //
			int target = p + DIR[j];                      //
			// 3. Go if target is not set                 //
			if (m[target] == 0) {                         //
				Gamma(m.clone(), target, c);              //
			}                                             //
		}                                                 //
	} //////////////////////////////////////////////////////////
	public static void dump(final int[] m) {
	// <m/> - matrix
	}	
	public static void main(String[] args) {
		int[] m = {
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1,
			1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1,
			1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1,
			1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1,
			1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		};
		int[] q = {
			36, 37, 38, 39, 40,
			47, 48, 49, 50, 51,
			58, 59, 60, 61, 62,
			69, 70, 71, 71, 73,
			80, 81, 82, 83, 87,			
		};
		for (int j = 0; j < DIR.length; j++) {
			int p = q[4] + DIR[j];
			System.out.println(p);
		}
	};
};
