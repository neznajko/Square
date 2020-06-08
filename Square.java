import java.util.Stack;
////////////////////////////////////////..///////////**///////////////^^////////
class Square {                                       //               //
    private static final int BSIZ  = 3;              // border size   //
    private static final int SQSIZ = 5;              // square size   //
    private static final int MSIZ  = 2*BSIZ + SQSIZ; // matrix size   //
    private static final int NPOZ  = SQSIZ*SQSIZ;    // nof positions //
/////////////////////////////////////////////////////``/,,////////////\\////////
    private static int dr(final int dx, final int dy) { // delta r    //
        return dx + dy*MSIZ;                            //            //
    } //////////////////////////////////##//////////////``////^^//////||////////
    // N NE E SE S SW W NW              //                    //
    //      N                           //                    //
    //      |                           //                    //
    //  W - x - E >                     //                    //
    //      |                           //                    //
    //      S                           //                    //
    //      v                           //                    //
    private static final int[] DSPL = { // displacement //////\\////////////////
        dr( 0, -3),                     // North              //
        dr( 2, -2),                     // North-East         //
        dr( 3,  0),                     // East               //
        dr( 2,  2),                     // South-East         //
        dr( 0,  3),                     // South              //
        dr(-2,  2),                     // South-West         //
        dr(-3,  0),                     // West               //
        dr(-2, -2),                     // North-West         //
    };                                  //                    //
////////////////////////////////////////;;////////////__//////||////////////////
    private static Stack<int[]> stk = new Stack<>();  //
//////////////////////////////////////////////////////||//^^////////////////////
    public static void T(int[] m, int p, int c) {         //
        // <m/> - matrix                                  //
        // <p/> - position                                //
        // <c/> - counter                                 //
        // Here we go ..                                  //
        // Beforehand we must be sure that m[p] is dzero _//
        // [0. Set m[p]]                                  //
        m[p] = ++c; ////////////////////////////////////////
        // [1. are ve done?]                              //
        if (c == NPOZ) {                                  //
            stk.push(m);                                  //
            return;                                       //
        }                                                 //
        // [2. DSPL Loof]                                 //
        for (int j = 0; j < DSPL.length; j++) {           //
            int t = p + DSPL[j]; // target position       //
            // [3. Ck]                                    //
            if (m[t] == 0) {                              //
                T(m.clone(), t, c);                       //
            }                                             //
        }                                                 //
    } ////////////////////////////////////////**//////////||////////////////////
    private static final int[] M = {          //
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,      //
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,      //
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,      //
        1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1,      //
        1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1,      //
        1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1,      //
        1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1,      //
        1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1,      //
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,      //
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,      //
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,      //
    };                                        //
//////////////////////////////////////////////||//////////////^^////////////////
    private static final int[] S = { // square <m/> positions //
        36, 37, 38, 39, 40,                                   //
        47, 48, 49, 50, 51,                                   //
        58, 59, 60, 61, 62,                                   //
        69, 70, 71, 72, 73,                                   //
        80, 81, 82, 83, 84,                                   //
    };                                                        //
//////////////////////////////////////////////////////////////\\////////////////
    // Dump <m/>'s square                                     //
    public static void dump(final int[] m) {                  //
        String s = "";                                        //
        for (int j = 0; j < NPOZ; j++) {                      //
            s += String.format("%1$2d", m[S[j]]) + ", ";      //
            if ((j + 1)%SQSIZ == 0) s += "\n";                //
        }                                                     //
        System.out.printf("%s", s);                           //
    } ////////////////////////////////////////////////////////||////////////////
    public static void main(String[] args) {
        // initial square position
        final int i = (args.length > 0) ? Integer.parseInt(args[0]) : 4;
        int p = S[i]; // initial square <m/> position
        // ..
        T(M.clone(), p, 0);
        System.out.println(stk.size());
        final int[] f = stk.firstElement();
        final int[] l = stk.lastElement();
        System.out.println("first:");
        dump(f);
        System.out.println("last:");
        dump(l);
    }
};
////////////////_///////////////////////_//////////_///////////////////_/// log:
