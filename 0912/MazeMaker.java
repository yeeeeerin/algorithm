/*

9.10
topcoder .08 .미로 만드는 사람

 */
import java.util.LinkedList;
import java.util.Queue;

public class MazeMaker {
    public static void main(String[] args){

        String[] maze = {

               //"..X.X.X.X.X.X."

                ".......",
                "X.X.X..",
                "XXX...X",
                "....X..",
                "X....X.",
                "......."
        };

        int[] moveRow = {1,0,-1,0,-2,1};
        int[] moveCol = {0,-1,0,1,3,0};
        System.out.println(longestPath(maze,5,0,moveRow,moveCol));
    }

    //row가 가로
    //col가 세로

    public static int longestPath(String[] maze,int startRow, int startCol,int[] moveRow,int[] moveCol){

        int mazeRow = maze[0].length();
        int mazeCol = maze.length;

        int[][] mazePathCount = new int[mazeCol][mazeRow];
        Queue<Integer[]> queue = new LinkedList();

        mazePathCount[startCol][startRow] = -1;
        queue.add(new Integer[]{startRow, startCol});

        //System.out.println(((LinkedList<Integer[]>) queue).poll()[0]);

        int j=1;

        while(!queue.isEmpty()){

            int queueRow = ((LinkedList<Integer[]>) queue).getFirst()[0];
            int queueCol = ((LinkedList<Integer[]>) queue).getFirst()[1];
            //System.out.println("queue.getFirst()[0] = " + queueRow);
            //System.out.println("queue.getFirst()[1] = " + queueCol);

            //내가 움직인 위치에서 +1
            j = mazePathCount[queueCol][queueRow] + 1;

            for(int i=0;i<moveRow.length;i++){

                int row = queueRow + moveRow[i];
                int col = queueCol + moveCol[i];

                //배열의 범위를 넘지 않는 선에서 움직인 값이 .일 경우 최소 이동 단위를 추가해 준다.
                if (!(row == startRow && col == startCol)) {
                    if ((row < mazeRow) && (row >= 0) && (col < mazeCol) && (col >= 0) && maze[col].charAt(row) == '.') {
                        //이미 값이 있을 경우(최소의 숫자가 들어있음) pass
                        if (mazePathCount[col][row] > 0 && mazePathCount[col][row] <= j) continue;
                        mazePathCount[col][row] = j;
                        ((LinkedList<Integer[]>) queue).add(new Integer[]{row, col});
                    }
                }
            }

            queue.poll();


        }

        int max = 0;

        for (int i=0;i<mazeCol;i++){
            for (int k=0;k<mazeRow;k++){

                //움직이지 않은 길(.)이 있다면 그건 미로를 탈출하지 못하게 하는 출구가 있다는 것
                if(maze[i].charAt(k) == '.' && mazePathCount[i][k] == 0){
                    return -1;
                }else{
                    if(mazePathCount[i][k] > max) max = mazePathCount[i][mazeRow-1];
                }

                System.out.print(mazePathCount[i][k] + ",");
            }
            System.out.println();
        }

        System.out.println();



        return max+1;
    }
}
