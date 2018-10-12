/*
10.12
topcoder .동적계획법과 메모화-04 .킹 나이트 체스

 */

package questions;

public class ChessMetric {


    int[][] move = new int[][]{     //{x,y}
            {1,0}, {-1,0}, {0,1}, {0,-1},   //상하좌우
            {1,1}, {1,-1}, {-1,1}, {-1,-1}, //각 대각선
            {1,2}, {2,1}, {2,-1}, {1,-2},   //킹나이트 이동 범위
            {-1,2}, {-2,1}, {-2,-1}, {-1,-2}
    };

    long [][][]ways = new long[100][100][55];
    int[] dx = new int[]{1,1,1,0,-1,-1,-1,0,2,1,-1,-2,-2,-1,1,2};
    int[] dy = new int[]{1,0,-1,-1,-1,0,1,1,-1,-2,-2,-1,1,2,2,1};


    public long play(int size, int[] start, int[] end, int numMoves){

        //System.out.println("moves : " + numMoves);

        if (numMoves > 0) {

            long sum = 0;

            for (int[] m : move) {

                int x = start[0] + m[0];
                int y = start[1] + m[1];


                if ((x < 0) || (y < 0) ||
                        (x >= size) || (y >= size)) {
                    continue;
                }

                sum += play(size, new int[]{x,y}, end, numMoves - 1);
            }
            //System.out.println(sum);
            return sum;

        }

        if (start[0] == end[0] && start[1] == end[1]) {
            return 1;
        }
        return 0;

    }

    public long howMany(int size, int[] start, int[] end, int numMoves) {

        //return play(size,start,end,numMoves);

        int x,y,i,j;
        int sx = start[0],sy=start[1],ex=end[0],ey=end[1];

        ways[sy][sx][0] = 1;

        for (i=1;i<=numMoves;i++){
            for(x = 0;x<size;x++){
                for (y = 0; y<size;y++){
                    for (j=0;j<16;j++){

                        int nx = x+dx[j];
                        int ny = y+dy[j];

                        if (nx<0 || ny<0 || nx>=size ||ny>=size)
                            continue;

                        ways[ny][nx][i] += ways[y][x][i-1];
                    }
                }
            }
        }

        return ways[ey][ex][numMoves];



    }

}
