package com.test;

public class N_queen {
    private static   int sum=0;
    public static void main(String[] args) {
        int qipan[][] = new int[8][8];
        new N_queen().jisuan(qipan, 0);
        System.out.println(sum);
    }
    
    private void jisuan(int[][] qipan,int row) {
        if(row==qipan.length) {
            sum+=1;
            return;
        }
        
        int n=qipan[0].length;//获取棋盘行的长度
        for(int col = 0;col<n;col++) {
            if(!judge(qipan,row,col)) {continue; }   
            qipan[row][col]=1;
            jisuan(qipan,row+1);
            qipan[row][col]=0;
        }
    }
    
    private boolean judge(int[][] qipan,int row,int col) {//审判棋子是否放进去了
        int n = qipan[0].length;
        for(int i=0;i<n;i++) {
            if(qipan[i][col]==1) { return false;   }//判断比他高的行同样的列是否有皇后
        }
        //这里向下判断
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--) {
            if(qipan[i][j]==1) {
                return false;
            }
        }
        //这里也向下判断 
        for(int i=row-1,j=col+1;i>=0&&j<8;i--,j++) {
            if(qipan[i][j]==1) {
                return false;
            }
        }
        return true;
    }
}
