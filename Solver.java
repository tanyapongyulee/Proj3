
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
	    		if (args[0].substring(0,2).equals("-o")) {
	    			System.out.println("invalid options parameter");
	    			System.exit(1);
	    		}
	    		switch (args[0]) {
	    		case "-ooptions":
	    			System.out.println("WRITE OF OPTIONS STUFF");
	    			System.out.println("");
	    			System.exit(0); //don't run any code
	    		case "-ooption1":
	    			optionNumber = 1;
	    		case "-ooption2":
	    			optionNumber = 2;
	    		default: 
	    			System.out.println("invalid option");
	    			System.exit(1);
	    		}
	    		Board init=new Board(args[1]);
	    		Board goal=new Board(args[2], init.getLength(), init.getWidth());
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
