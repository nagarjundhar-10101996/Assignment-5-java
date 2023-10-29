import java.util.Scanner;

/**
 * CompetitionLog
 */
class CompetitionLog {
private int playerNumber1;
private String completeSets1;
private String incompleteSets1;
private int piecesBuilt1;
    CompetitionLog(int playerNumber, String completeSets, String incompleteSets, int piecesBuilt)
    {
        this.playerNumber1 = playerNumber;
        this.completeSets1 = completeSets;
        this.incompleteSets1 = incompleteSets;
        this.piecesBuilt1 = piecesBuilt;

    }
    public int getPlayerNumber()
    {
        return this.playerNumber1;
    }
    public String getCompleteSets(){
        return this.completeSets1;
    }   
    public String getIncompleteSets(){
        return this.incompleteSets1;
    }
    public int getPiecesBuilt()
    {
        return this.piecesBuilt1;
    }
    public void setCompleteSets(String completeSets){
        this.completeSets1 = completeSets;
    }
    public void setIncompletesets(String incompleteSets){
        this.incompleteSets1 = incompleteSets;
    }
    public void setPiecesBuilt(int piecesBuilt){
        this.piecesBuilt1 = piecesBuilt;
    }
    public String toString(){
     return "Player "+this.playerNumber1+" completed the following sets: "+this.completeSets1+"\n Player "+this.playerNumber1+" didnot completed the following sets: "+this.incompleteSets1 +"\n Player "+ this.playerNumber1 +" built total of "+ this.piecesBuilt1 +"pieces";
    }

}

class LegoSetCompetition {
    public static void main(String[] args) {
       boolean flag = true;
       int n = 3;
       int wc1 = 0;
       int wc2 = 0;
       String[] setname = new String[3];
        int[] setnosofpices = new int[3];
        String arr = "";
        String noarr = "";
        String yesarr = "";
        int sumeofpicesset = 0;
        int p1 = 0;
        int p2 = 0;
        int day = 1; 
        String arraydata = "";
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Welcome to the Lego Set Competition!");
        for (int i = 0; i < n; i++) {
            
            System.out.printf("Enter the name of Lego Set %d \n", i+1);
            setname[i] = sc.next();
            arr += setname[i];//0,1,2,3,4,5 
            wc1++;
            wc2++;
            sc.nextLine();
            System.out.printf("Enter the Number of Pieces in Lego Set %d \n", i+1);
            setnosofpices[i] = sc.nextInt();
            sc.nextLine();
            sumeofpicesset += setnosofpices[i];
            }
        int ln = -1;
        while ( flag ) { 
           
            if(ln < n)
            {
                ++ln;
            }
            System.out.println("No of pieces Player 1 use for building Day "+day);
			wc1 = sc.nextInt();
            p1 +=wc1;// sum of cost No of pieces Player 1
            noarr += minpair(sumeofpicesset, arr, wc1, setnosofpices,ln);    
			System.out.println("No of pieces Player 2 use for building Day "+day);
			wc2 = sc.nextInt();
            p2 +=wc2;// sum of cost No of pieces Player 2
            noarr += minpair(sumeofpicesset, arr, wc2, setnosofpices,ln);   
            day++;  
            //  if (p1 >= sumeofpicesset || p2 >= sumeofpicesset) {
            //     break;
            // }
        
        if(p2 == sumeofpicesset && p1 == sumeofpicesset) {
            System.out.println("Its a tie need to Start a tiebreaker round with new sets");
            for (int i = 0; i < 3; i++) {
            System.out.printf("Enter the name of Lego Set %d \n", i+1);
            setname[i] = sc.next();
            arr += setname[i];
          
            sc.nextLine();
            System.out.printf("Enter the Number of Pieces in Lego Set %d \n", i+1);
            setnosofpices[i] = sc.nextInt();
            sc.nextLine();
            sumeofpicesset += setnosofpices[i];

            }
        }else if ( p1 >= sumeofpicesset ) {
            System.out.println("Congratulation to player 1 for winning the Lego Set Competition!");
            
            
            CompetitionLog lo = new CompetitionLog(1,noarr,"None",0); 
            lo.setPiecesBuilt(p1);
            System.out.println(lo.toString());

            CompetitionLog lo1 = new CompetitionLog(2,"None",noarr,0); 
            
            lo1.setPiecesBuilt(p2);
            System.out.println(lo1.toString());
            break;
        } else if ( p2 >= sumeofpicesset ) {
            System.out.println("Congratulation to player 2 for winning the Lego Set Competition!");
            
            CompetitionLog lo = new CompetitionLog(2,noarr,"None",0); 
            lo.setPiecesBuilt(p2);
            System.out.println(lo.toString());
            CompetitionLog lo1 = new CompetitionLog(1,"None",noarr,0);
            lo1.setPiecesBuilt(p1);
            System.out.println(lo1.toString());
            break;
        }
    }  
    }
     public static String minpair( int sumofpicset, String pair, int costofpair , int[] individuallegocost , int count)
    {
        String c ="";
        int lc = 0; 
        lc += costofpair;
        if(sumofpicset <= costofpair)
        {
            
        }
        else
        {
            // if cost No of pieces of players is less then sum of pices lego 
            if(lc < costofpair)
            {
                c += (individuallegocost[count]< lc)?pair.charAt(count):pair.charAt(count); 
            } 
        }
        return c;
    }
}
