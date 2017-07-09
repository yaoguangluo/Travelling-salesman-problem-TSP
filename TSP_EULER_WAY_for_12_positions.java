public class TSP
{
    public static int small=1000000000;
   public static int te=0;
   public static void main(String []argv)
   {
       int []x = new int[12];
       int []y = new int[12];
       x[0] = 0;y[0] = 0;
       x[1] = 1;y[1] = 0;
       x[2] = 2;y[2] = 10;
       x[3] = 12;y[3] = 16;
       x[4] = 6;y[4] = 6;
       x[5] = 8;y[5] = 22;
       x[6] = 16;y[6] = 30;
       x[7] = 22;y[7] = 18;
       x[8] = 18;y[8] = 20;
       x[9] = 10;y[9] = 10;
       x[10] = 11;y[10] = 21;
       x[11] = 1;y[11] = 1;
       node first = new node();
       first.x=0;
       first.y=0;
       first.used=0;
       List<node>nodes = new ArrayList<node>();
       findpath(first,x,y,nodes);
       System.out.print(1);
       sort(nodes,first.x,first.y,x.length);
       System.out.print(2);
   }
    public static void sort( List<node> nodes,int x, int y,int N)
    {
                  node temp=nodes.get(nodes.size()-1);
                  node temp1=nodes.get(nodes.size()-1);
                  System.out.println("the short one");
                  node []out =new node[N];
                  while(temp!=null)
                  {
                      out[temp.used]=temp;
                      temp=temp.prev;
                  }
                  while(temp1!=null)
                  {
                      out[temp1.used]=temp1;
                      temp1=temp1.next;
                  }
                  for(int i1=0;i1<out.length;i1++)
                  {
                         if(out[i1]!=null)
                         {
                             System.out.println("x:"+out[i1].x+"y:"+out[i1].y);
                         }
                  }
        System.out.println("the shortest distance:"+out[out.length-1].total_dis);
    }
    public static int find(node first,int i,int[] x,int[] y)
    {
         if(first.x == x[i] && first.y == y[i])
         {
             return 1;
         }
         node temp = first;
         node temp1 = first;
         while(temp.prev != null)
         {
             temp = temp.prev;
             if(temp.x == x[i]&& temp.y == y[i])
             {
                 return 1;
             }
             if(temp.x==x[x.length-1]&& temp.y==y[y.length-1])
             {
                 if(temp.used!=x.length)
                 {
                     return 1;
                 }
             }
         }
        while(temp1.next!=null)
        {
            temp1 = temp1.next;
            if (temp1.x == x[i] && temp1.y == y[i]) {
              return 1;
            }
            if(temp1.x==x[x.length-1]&& temp1.y==y[y.length-1])
            {
                if(temp1.used!=x.length)
                {
                    return 1;
                }
            }
        }

        if(temp.used!=0)
        {
            return 1;
        }

        if(temp.x!=x[0] || temp.y!=y[0])
        {
           return 1;
        }
        return 0;
    }
    public static int find1(node first,int []x,int []y)
    {
        while(first.next!=null) {
            first = first.next;
        }
            if(first.x==x[x.length-1]&& first.y==y[y.length-1])
            {
                if(first.used==x.length-1)
                {
                    if(first.total_dis<small)
                    {
                        small=first.total_dis;
                        return 1;
                    }
                    //System.out.println(first.u
                }
            }
        return 0;
    }
   public static void findpath(node first, int[]x, int[]y, List<node> nodes)
   {
       for(int i=0;i<x.length;i++)
       {
           node first_copy = new node();
           first_copy.x = first.x;
           first_copy.y = first.y;
           first_copy.used = first.used;
           first_copy.total_dis = first.total_dis;
           first_copy.next = first.next;
           first_copy.prev = first.prev;
           int find = find(first_copy,i,x,y);
          // int find1 = find1(first_copy,i,x,y);
           if(find == 0)
           {
               te++;
               node next = new node();
               next.x = x[i];
               next.y = y[i];
               int dis = Math.abs(x[i] - first.x) + Math.abs(y[i] - first.y);
               next.total_dis = first_copy.total_dis + dis;
               next.used=first_copy.used+1;
               first_copy.next = next;
               next.prev = first_copy;
               first_copy= first_copy.next;
               int find1 = find1(first_copy,x,y);
               if(find1==1)
               {
                   //     small = temp.total_dis;
                   // nodes.clear();
                   nodes.add(first_copy);

               }
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
