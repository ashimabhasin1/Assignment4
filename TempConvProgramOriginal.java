import java.util.Scanner;

public class TempConvProgram {

    public static double CtoF(double t){
        return t*9/5+32; }

    public static double f_to_c(double TEMP){
        return (TEMP-32)*5/9;
    }

    public static double CtoK(double x){
        return x+273.15;
    }

    public static void printmenu(){
        System.out.println("1 convert C to F");
        System.out.println("2 convert F to C");
        System.out.println("3 convert C to K");
        System.out.println("4 exit");
    }

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int x=0;
        System.out.println("Welcome! temp conv app");
        while(true){
            printmenu();
            x=sc.nextInt();
            if(x==1){
                System.out.println("enter t");
                double temp=sc.nextDouble();
                double r= CtoF(temp);
                System.out.println("res="+r);
            } else if(x==2){
                System.out.println("enter t");
                double t=sc.nextDouble();
                double r=f_to_c(t);
                System.out.println("res="+r);
            } else if(x==3){
                System.out.println("enter cel");
                double cel=sc.nextDouble();
                double rr=CtoK(cel);
                System.out.println(rr);
            } else if(x==4){
                System.out.println("bye");
                break;
            } else{
                System.out.println("wrong");
            }
        }
        sc.close();
    }

}
