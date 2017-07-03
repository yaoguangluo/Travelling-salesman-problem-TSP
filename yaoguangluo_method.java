package leecode;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



//Attension, this is designed by yaoguang luo and follow MIT license. for free use






public class TSP
{
   public static void main(String []argv)
   {
       int []x = new int[2];
       int []y = new int[2];
       x[0] = 0;y[0] = 10;
       x[1] = 1;y[1] = 0;
       //x[2] = 2;y[2] = 10;
       node first = new node();
       first.x=0;
       first.y=0;
       List<node>nodes = new ArrayList<node>();
       findpath(first,x,y,nodes);
       System.out.print(1);
       sort_and_printTSP_line(nodes);
   }
    public static int find(node first,int i,int[] x,int[] y)
    {
         int find=0;
         if(first.x==x[i]&& first.y==y[i])
         {
             return 1;
         }
         node temp=first;
         while(temp.prev!=null)
         {
             temp = temp.prev;
             if(temp.x == x[i]&& temp.y == y[i])
             {
                 return 1;
             }
         }
         return 0;
    }
   public static void findpath(node first, int[]x, int[]y, List<node> nodes)
   {
       for(int i=0;i<x.length;i++)
       {
           //copyfirst
           node first_copy = new node();
           first_copy.x = first.x;
           first_copy.y = first.y;
           first_copy.total_dis = first.total_dis;
           first_copy.next=first.next;
           first_copy.prev=first.prev;
           int find=find(first_copy,i,x,y);
           if(find == 0)
           {
               nodes.add(first_copy);
               node next = new node();
               next.x = x[i];
               next.y = y[i];
               int dis = Math.abs(x[i] - first.x) + Math.abs(y[i] - first.y);
               next.total_dis = first_copy.total_dis + dis;
               first_copy.next = next;
               next.prev = first_copy;
               first_copy= first_copy.next;
               findpath(first_copy, x, y,nodes);
           }//
       }
   }
}
class node{
    public int used=0;
    public int x;
    public int y;
    public int total_dis=0;
    public node prev;
    public node next;
}
