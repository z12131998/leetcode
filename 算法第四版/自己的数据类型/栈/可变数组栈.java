package four;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[5];//初始值为存储5个数
    private int N = 0;
    public boolean isEmpty() {return N==0;}//是否为空
    public int size() {return N;}
    
    private void Resize(int max) {//重新弄数组诺
        Item[] tmp = (Item[]) new Object[max];
        for(int i =0;i<max;i++) {
            tmp[i]=a[i];
        }
        a=tmp;
    }
    
    public void push(Item item) {
        if(N==a.length) {//扩充数组
            Resize(2*a.length);
        }
        a[N++]=item;
    }
    
    public Item pop() {
        if(N==0) {return null;}
        Item tmp = a[--N];
        a[N]=null;
        if(N>0&&N==a.length/4) {
            Resize(a.length/2);
        }
        return tmp;
    }
        
    @Override
    public Iterator<Item> iterator() {
        // TODO 自动生成的方法存根
        return new ReverseArrayItertor();
    }
    
    private class ReverseArrayItertor implements Iterator<Item>{
            int i=N;
        @Override
        public boolean hasNext() {
            // TODO 自动生成的方法存根
            return i>0;
        }

        @Override
        public Item next() {
            // TODO 自动生成的方法存根
            return a[--i];
        }
        
    }
}
