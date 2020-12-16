package com.test;

public class N_queen_2 {
    //优化后的思路嘛,是穷举法,让空间变好了,因为使用了单数组,但是时间多了,多了个N,但是还是0(N^2)
    /*思路:
     * 因为绝对不可能出现同一行,所以使用单数组,那么递归每进入下一层,就是进入下一行
     */
    private static int sum=0;
    private static int qipan[] = new int[8]; //优化变成单数组
    public static void main(String[] args) {
        new N_queen_2().jisuan(0);
        System.out.println(sum);
    }
    
    private void jisuan(int n) {
        if(n==qipan.length) {
            for(int i=0;i<qipan.length;i++) {
            System.out.print(i);}
            System.out.println();
            sum++; //这说明已经放了8个棋子了
            return;
        }
        for(int i=0;i<qipan.length;i++) {//N皇后嘛,那么第一行遍历完就完事了
           qipan[n]=i;//在当前行n,当前列i放入棋子
           if(judge(n)) {
               jisuan(n+1);//进入下一行
           }
        }
    }
    
    private boolean judge(int n) {//审判棋子是否放进去了
        for(int i=0;i<n;i++) {   //棋子同一列了1  2.对角线 判断同一斜线y1-y2=k(x1-x2)
            if(qipan[i]==qipan[n]||Math.abs(n-i)==Math.abs(qipan[n]-qipan[i])) {
                return false;
            }
        }
      

        return true;
    }
}
