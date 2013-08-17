
public class Solver {
	 public static void main(String[] args) {
	    	if (args.length != 2 && args.length != 3) {
	    		System.out.println("invalid number of arguments");
	    		System.exit(1);
	    	}
	    	boolean optionsExist = false;
	    	int optionNumber;
	    	if (args.length == 3)
	    		optionsExist = true;
	    	if (optionsExist) {
	    		Board init=new Board(args[1]);
	    		Board goal=new Board(args[2], init.getLength(), init.getWidth());
	    		if (args[0].substring(0,2).equals("-o")) {
	    			System.out.println("invalid options parameter");
	    			System.exit(1);
	    		}
	    		if(args[0]=="-ooptions"){
	    			System.out.println("-oIsOkay: call upon isOkay whenever creating a new board(tray).");
	   
	    			System.out.println("-oVisualize: visualize the inital board and final board ");
	    			System.out.println("-oPrintSteps: visualize the steps taken towards the goal board");
	    			System.exit(1);
	    		}
	    		else if(args[0]=="-oIsOkay"){
	    		
	    		}else if(args[0]=="-oVisualize"){
	    			init.printBoard();
	    			goal.printBoard();
	    		}else if(args[0]=="-oPrintSteps");
	    			
	    		else{
	    			System.out.println("invalid option");
	    			System.exit(1);
	    		}
	    		
	    		Greedy solver= new Greedy(init,goal);
	    		if(solver.possible()){
	    			solver.printAnswer();
	    			System.exit(1);
	    		}else{
	    			System.exit(1);
	    		}
	    		
	    	}else{
	    		Board init=new Board(args[0]);
	    		Board goal=new Board(args[1], init.getLength(), init.getWidth());
	    		Greedy solver= new Greedy(init,goal);
	    		solver.printAnswer();
	    		if(solver.possible()){
		    		solver.printAnswer();
		    		System.exit(1);
		    		}else{
		    			System.exit(1);
		    		}
	    	}
	    }
}
