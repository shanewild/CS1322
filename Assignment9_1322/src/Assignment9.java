import java.util.Random;

class Maze {
    public final int dimension = 15;
    public int start_x = dimension/2;
    public int start_y = dimension/2;

    char[][] theMaze = new char[dimension][dimension];

    public Maze() {
        for(int i=0;i<dimension;i++) {
            for(int j=0;j<dimension;j++) {
                theMaze[i][j]=' ';
            }
        }

        initializeMaze();

    }

    private void initializeMaze() {
        Random myRand=new Random();

        //Put in random walls
        for(int i=0;i<dimension;i++) {
            for(int j=0; j<dimension;j++) {
                if(myRand.nextInt(10)>=7) {
                    theMaze[i][j]='X';
                }
            }
        }

        //Pick a random goal
        int goal_x=myRand.nextInt(dimension-1);
        int goal_y=myRand.nextInt(dimension-1);
        theMaze[goal_x][goal_y]='C';

        //Place the starting position
        theMaze[start_x][start_y]='M';
    }

    @Override
    public String toString() {
        String final_return_string="";

        for(int i=0;i<dimension;i++) {
            for(int k=0;k<dimension;k++) {
                final_return_string+="----";
            }
            final_return_string+="\n| ";
            for(int j=0;j<dimension;j++) {
                final_return_string+=theMaze[i][j]+" | ";
            }
            final_return_string+="\n";
        }
        for(int k=0;k<dimension;k++) {
            final_return_string+="----";
        }
        final_return_string+="\n\n";
        return final_return_string;
    }
}
public class Assignment9 {
    public static boolean find_path(Maze my_maze,int x, int y) {

        //Ensure that you are looking at valid values for x.  x represents the row of the 2 dimensional array, it should go from 0 to my_maze.dimension-1.  Check that x is between these values, if it's not return false.  Note, don't return true if it is between those values, because that would end the recursion.
if(x<0||x>my_maze.dimension-1){
return false;
}
        //Next, ensure y is also valid.  y represents the column in the 2 dimension array, it likewise should be between 0 and my_maze.dimension-1.  If it is not, return false.  Again, don't return true otherwise.
        if(y<0||y>my_maze.dimension-1){
            return false;
        }
        //Next, check if you found the cheese.  You were passed an object called my_maze.  It has a public 2 dimensional array called theMaze in it.  Check to see if that 2D array in cell x,y is the cheese (i.e. the character in that cell is a C).  If so, return true, this would be the end of the recursion.
if (my_maze.theMaze[x][y]=='C'){
    return true;
}
        //Next, check if you hit a wall.  You'll know you are at a wall if cell x, y of theMaze has the character X in it.  If it does, return false.  Again, do not return true, if it doesn't.
        if (my_maze.theMaze[x][y]=='X'){
            return false;
        }
        //Check if we have already been to this cell via other recursive calls.  You'll know we've been here if the cell has a + in it.  If cell x,y of theMaze is x, return false.  Don't return true otherwise.
        if (my_maze.theMaze[x][y]=='+'){
            return false;
        }
        //If you are not in the starting position (cell with M in it), and you have not found the cheese (cell with C in it), then change the value of the current cell to a + to mark where you have been.
        if (my_maze.theMaze[x][y]!='M' && my_maze.theMaze[x][y]!='C'){
            my_maze.theMaze[x][y]='+';
        }
        //Don't change these lines, they clear the screen in repl.it and print out the current state of the maze.
        System.out.println("\033[0;0H");
        System.out.flush();
        System.out.println(my_maze);

        //Next we are going to make the recursive calls.  It's possible in the maze to move up, down, left and right.  So we'll have 4 recursive calls.
        //Remember that x=0 y=0 is the top left corner of the 2 dimensional array.  If you wish to move down a row, you'd increase x.  If you wish to move up a row, you decrease x.  To move right, you increase y, to move left, you decrease y.
        //Make a recursive call to check the cell above where you are, passing yourself my_maze, and appropriate values for x and y.  Note that find_path returns a boolean.  If the recursive call returns true, you should return true.  Otherwise do nothing.
        if (find_path(my_maze, x-1, y)){
            return true;
        }
        //Make a recursive call to check the cell to your right, passing yourself my_maze, and appropriate values for x and y.  Note that find_path returns a boolean.  If the recursive call returns true, you should return true.  Otherwise do nothing.
        if (find_path(my_maze, x, y+1)){
            return true;
        }
        //Make a recursive call to check the cell below you, passing yourself my_maze, and appropriate values for x and y.  Note that find_path returns a boolean.  If the recursive call returns true, you should return true.  Otherwise do nothing.
        if (find_path(my_maze, x+1, y)){
            return true;
        }
        //Make a recursive call to check the cell to your left, passing yourself my_maze, and appropriate values for x and y.  Note that find_path returns a boolean.  If the recursive call returns true, you should return true.  Otherwise do nothing.
        if (find_path(my_maze, x, y-1)){
            return true;
        }
        //If you have gotten here, none of those calls found the cheese yet, so you should clear this cell as it's not part of the path.  i.e.  if the current cell you are looking at does not contain the starting position (M) and it doesn't contain the cheese (C) change the value of the cell to a space ' '
        if (my_maze.theMaze[x][y]!='M'&&my_maze.theMaze[x][y]!='C'){
            my_maze.theMaze[x][y]=' ';
        }
        //Leave this here, if you didn't find it above, there is no valid path, and the method will return false.
        return false;
    }


    public static void main(String[] args) {
        Maze myMaze=new Maze();

        boolean foundit=find_path(myMaze,myMaze.start_x,myMaze.start_y);

        if(foundit) {
            System.out.println("\n\nFound the cheese!");
        }
        else {
            System.out.println("\n\nNo Cheese for me!");
        }
    }
}
