class helloworld
{
    public static int addTwoNumbers(int a,int b)
    {
        return a+b;
    }
    public static int subtractNumbers(int a,int b)
    {
        return a-b;
    }
    public static void main(String[] args) {
       int c=helloworld.addTwoNumbers(3,5);
       int d=helloworld.subtractNumbers(10,1);
       System.out.println("after substracting"+d);
       System.out.println("after adding " +c);
       
    }
}