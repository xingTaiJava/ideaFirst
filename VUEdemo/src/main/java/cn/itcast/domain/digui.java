package cn.itcast.domain;

import javax.print.attribute.IntegerSyntax;


//1  1  2  3  5  8  11  19  30  49
public class digui {
    public  Integer fun(int n){
        if(n==1||n==2){ return 1; }
   //     n=n-1;
        return fun(n-1)+fun(n-2);
        // fun(7-1)  6  =fun(6-1)+fun(6-2)    fun(7-2)   5  = fun(5-1)+fun(5-2)  =5
        // fun(6-1)  5  =fun(5-1)+fun(5-2)  = 3+2=5 ;                 fun(6-2)   4  = fun(4-1)+fun(4-2)  =3
        // fun(5-1)  4  =fun(4-1)+fun(4-2)/1  =  fun(3)+1  =3                     fun(5-2)   3  = fun(3-1)/1 +fun(3-2)/1  =  1+1

        // fun(4-1)  3  =fun(3-1)/1   + fun(3-2)/1    =2


    }

    public static void main(String[] args) {
        digui di =new digui();
    //    Integer  in =di.fun();
          System.out.println(di.fun(7));
  //      di.fun(25);
    }
}
