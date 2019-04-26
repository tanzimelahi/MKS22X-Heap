import java.util.Scanner;
import java.util.Arrays;
public class MyHeap{


  private static int heapHelp(int[]ary,int i,int size){
    if((i+1)*2<=size && (i+1)*2+1<=size){
      if(ary[(i+1)*2-1]>ary[(i+1)*2]){
        int dummy=ary[i];
        ary[i]=ary[(i+1)*2-1];
        ary[(i+1)*2-1]=dummy;
        return (i+1)*2-1;
      }
      else{
        int dummy=ary[i];
        ary[i]=ary[(i+1)*2];
        ary[(i+1)*2]=dummy;
        return (i+1)*2;
      }
    }
    else if((i+1)*2<=size){
      int dummy=ary[i];
      ary[i]=ary[(i+1)*2-1];
      ary[(i+1)*2-1]=dummy;
      return (i+1)*2-1;
    }
    else{
     return -1;
   }
  }

  public static void pushUp(int[]ary,int index){// thoroughly tested
    index++;
    while(index>=1){
      if(index/2-1>=0 && ary[index-1]>ary[index/2-1]){
        int dummy=ary[index-1];
        ary[index-1]=ary[index/2-1];
        ary[index/2-1]=dummy;
        index=index/2;
      }
      else{
        index=-1;
      }
    }

  }
  public static void pushDown(int[]ary,int size,int index){// thorougly tested
    while(index<size && index>=0){
       if( ((index+1)*2<=size && ary[(index+1)*2-1]>ary[index]) ||
       ( (index+1)*2+1<=size && ary[(index+1)*2]>ary[index]) ){
           index=heapHelp(ary,index,size);

     }
     else{
       index=-1; //termiates the while loop if the tree is in proper order
     }
   }
   //System.out.println(Arrays.toString(ary)+" index: "+index+ " size: "+size);
  }
  public static void heapify (int[]ary){
    for(int i=ary.length/2-1;i>=0;i--){
      pushDown(ary,ary.length,i);
    }
  }
  public static void heapsort(int[]ary){
    heapify(ary);
    int size=ary.length-1;
    for(int i=ary.length-1;i>=0;i--){
      int store=ary[size];
      ary[size]=ary[0];
      ary[0]=store;
      pushDown(ary,size,0);
      size--;
    }
  }


}
