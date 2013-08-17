Division of Labor
First we met together as a group to brainstorm several possible implementations of the program. After establishing a roadmap for the tray, we set deadlines for each of us to work on different methods in tray class (Board.java). We thought it would be much more efficient to work on separate things individually, and sharing what we’ve changed on Github and through emails. We also discovered that the most efficient way to work from home is simply to utilize Github as much as possible. However, this was still not enough to facilitate communication between the members. Thus for some time in the progress of the project, one member did most of the work on the solving algorithm while others were lost. It also was the case where it wasn’t intended, but the distributed workload was uneven. Better distribution of workload may have sped up the project progress. 
Later on in the project, however, the algorithm to solve the puzzle needed a lot of attention because it simply was not working. After consulting our TA, we decided to redo it and use a different structure implementation. This required careful programming and planning, thus all of us worked on it together contributing ideas and finding various bugs. In the final stages of the project, one member focused on the readme as we realized it is a big portion of this project. The other members focused on debugging the program and building the actual driver.




Design part 1: The Tray Class
The tray class in our program is the Board.java file. The Board class is where the Board is initialized as a two-by-two array of Block objects that we will elaborate on later. It takes in the input text file through InputSource object in the constructor. It has several important instance variables that will be used later on in the algorithm. One is a Hashset of available moves a Block object can have, represented by Point objects indicating the x and y coordinates of the 2 by 2 array. Second is an array list of Block Objects that indicate the goal configuration. Third is an array list of Block Objects that indicate the Block objects that could be moved. The Board class also has very important methods to be used in the algorithm. One is a method that checks what are the legal moves a block can have, and returns a string array list of legal moves: “up, down, left, right”. Other methods are move methods that update the invariant of Board class object, as well as that of Block Object.

Design Part 2: The Block class
The Block class describes the object created by input source of 4 integers. There are specified widths and lengths to keep track of Block sizes. Also, there are Point objects to keep track of top and bottom coordinates of a Block. There are methods that could change the coordinates, and is used by move methods in Board.java. Finally, there is a equals method that compares if two blocks are equal by comparing the top and bottom coordinates, as well as the size.


Design Part 3: The algorithm
In our project, the algorithm we used is called greedy search in Greedy.java. The basic idea behind the greedy search is, we take all the possible moves a Block object can take, and we iterate through all the Blocks in the board object and do all the possible moves until we eventually get to the goal configuration. This algorithm does not find the solution in least amount of moves, but it still gets the job done. 
The algorithm takes in an unsolved board object and a goal configuration board object. The current board is then pushed to a stack, used to store the board that will be searched. From this board, all the possible blocks that can be utilized will be obtained by calling a method in Board. Every time the program calls upon the method to do the search, the current board object is stored in a hashset of already seen boards, and it is also added to a stack. While the board is not in its goal configuration, the program will iterate through all the Block objects, and take their possible moves. If there is a possible move, we check if the board configuration has already been by checking the hashset of already seen boards, then we make the move, and push the board in the stack. We also store the string object of the direction that the Block moved in a Hashmap, where the key is the Board object and the value is the string Object. This will be useful for printing the solution at the end of the program.
	To check if the board is in its goal configuration, the program simply checks the goal file, get the location of the goal Block objects, checks the current Board object for the same location, and if the blocks exist in those locations then we have a match.
	Finally, we have a heuristics method where it calculates the distance between the goal block and the block object that we want to move to the goal configuration. If every time we call search and heuristics is lowered, then it’s a smart move the make that makes the code more efficient. If the heuristics are raised, then the program simply does that make that move.

Evaluating data structure for the tray
To store the information in Board.java, we decided to use a two by two array because theoretically adding and changing entries should take constant time. Indeed, the operation did take constant time as we tried to make the board bigger and bigger. However, to find the possible moves all the blocks can make was a slower process, because the program has to iterate through all the blocks and check for possible moves. This operation theoretically would take theta(b*k) where b is the number of blocks and k is the width or length of the block depending on the move. However, our tests showed that no matter if we increase the number of blocks, there weren’t too much of a difference. Perhaps the impact in efficiency on a faster computer does not make too much difference.
Method
We put various sizes of board ranging from 1*1 to 10000*10000. We also put differing number of blocks in 1000*1000 board. We then timed the operation to initialize the board by tic and toc built in java methods. Then we graphed it.
Results
 
 
Conclusions
Since from the tests the times were pretty much constant for both operations despite theoretical complexity, we just decided to use our existing algorithm.

Evaluating one move at a time or multiple
To find out if our algorithm works better with multiple moves for a block at once or with one move at a time, we simply tried them with a medium level puzzle and measured the time it took to solve the puzzle. The test was done the same way as the last test, where it used tic and toc to time the program.
Result

		Multiple moves	Single moves
Time to finish program	95 seconds	63 seconds

Conclusion
To our surprise, the single move worked better! This was probably because doing multiple moves at once may overlook many possible combinations of moves that may give the shorter route to solution.
(I couldn't do the test on hashcodes because we just didn't have anything on it. Also couldn't od the bfs and dfs because we didn't use a tree. )
Disclaimers
Our program may not run under the time limit in a slower computer like ones in Soda. It ran well in a Macbook Pro, however. Also, our algorithm may face some bugs if run on the harder puzzles.

Program development
As mentioned in our division of work, we always got together first to brainstorm ideas on how to tackle the project. We first tried to initialize the tray because without the tray we’ve literally got nothing to work with, and writing an algorithm out of nothing would be extremely hard to imagine. Within the tray implementation we first worked on board because we had to know what kind of environment our block objects would be placed in. After we’ve got the tray completed, we went on to working on the algorithm. The algorithm was very tricky so we consulted our TA for advice. His advice really helped us initially to get going on the project. As we were developing different classes and methods, we always followed it up with JUnit testing to find as many bugs as possible. We postponed the coding of the actual driver to the very last because it only makes sense to write it when we have everything ready. It was just easy plugging everything in.

(Tanya would you please help me elaborate on Junit testing?)



