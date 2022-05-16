import java.util.Scanner;

public class Scrabble
{
    public static void main (String[] args)
    {
        int totalp=0;
        int dword=0;
        int tword=0;
        Scanner keyboard = new Scanner(System.in);
        String list[]= new String[6] ;
        System.out.println("Please enter your word, separating each letter by a comma.");
        list[0]= keyboard.nextLine();
        System.out.println();
        System.out.println("Please enter 5 possible placements of your word with the starting location");
        System.out.println("and a H or V denoting if it will be placed vertical or horizontal separated by a comma");
        list[1]= keyboard.nextLine();
        list[2]= keyboard.nextLine();
        list[3]= keyboard.nextLine();
        list[4]= keyboard.nextLine();
        list[5]= keyboard.nextLine();
        for(int x = 1; x<6; x++)
        {
            if(list[x].indexOf("H")!= -1)
            {
                int z=0; 
                String value = list[x];
                String intValue = value.replaceAll("[^0-9]", ""); 
                int valuex= Integer.parseInt(intValue);
                for (int y= valuex; y<= valuex+3;y++)
                {
                    //System.out.println("Tile: "+y+ " Z Value:"+z);
                    if(y%3==0)
                    {
                        if(list[0].charAt(z)== 'A' || list[0].charAt(z)== 'E')
                        {
                            totalp=totalp+2;
                            //System.out.println("Two added");
                        }
                        if(list[0].charAt(z)== 'D' || list[0].charAt(z)== 'R')
                        {
                            totalp=totalp+4; 
                            //System.out.println("Four added");
                        }
                        if(list[0].charAt(z)== 'B' || list[0].charAt(z)== 'M')
                        {
                            totalp=totalp+6;
                            //System.out.println("Six added");
                        }
                        if(list[0].charAt(z)== 'V' || list[0].charAt(z)== 'Y')
                        {
                            totalp=totalp+8;
                            //System.out.println("Eight added");
                        }
                        if(list[0].charAt(z)== 'J' || list[0].charAt(z)== 'X')
                        {
                            totalp=totalp+16;
                            //System.out.println("16 added");
                        }
                    }
                    else if(y%5==0)
                    {
                        if(list[0].charAt(z)== 'A' || list[0].charAt(z)== 'E')
                        {
                            totalp=totalp+3;
                            //System.out.println("3 added");
                        }
                        if(list[0].charAt(z)== 'D' || list[0].charAt(z)== 'R')
                        {
                            totalp=totalp+6;
                            //System.out.println("6 added");
                        }
                        if(list[0].charAt(z)== 'B' || list[0].charAt(z)== 'M')
                        {
                            totalp=totalp+9;
                            //System.out.println("9 added");
                        }
                        if(list[0].charAt(z)== 'V' || list[0].charAt(z)== 'Y')
                        {
                            totalp=totalp+12;
                            //System.out.println("12 added");
                        }
                        if(list[0].charAt(z)== 'J' || list[0].charAt(z)== 'X')
                        {
                            totalp=totalp+24;
                            //System.out.println("24 added");
                        }
                    }
                    else
                    {
                        if(list[0].charAt(z)== 'A' || list[0].charAt(z)== 'E')
                        {
                            totalp=totalp+1;
                            //System.out.println("1 added");
                        }
                        if(list[0].charAt(z)== 'D' || list[0].charAt(z)== 'R')
                        {
                            totalp=totalp+2;
                            //System.out.println("2 added");
                        }
                        if(list[0].charAt(z)== 'B' || list[0].charAt(z)== 'M')
                        {
                            totalp=totalp+3;
                            //System.out.println("3 added");
                        }
                        if(list[0].charAt(z)== 'V' || list[0].charAt(z)== 'Y')
                        {
                            totalp=totalp+4;
                            //System.out.println("4 added");
                        }
                        if(list[0].charAt(z)== 'J' || list[0].charAt(z)== 'X')
                        {
                            totalp=totalp+8;
                           // System.out.println("8 added");
                        }
                    }
                    if(y%7==0 && y%5!=0 && y%3!=0)
                    {
                        dword=1;
                        //System.out.println("dword");
                    }
                    if(y%8==0&& y%7!=0 && y%5!=0 && y%3!=0)
                    {
                        tword=1;
                        //System.out.println("tword added");
                    }
                    z=z+2;
                }
            }
            if(list[x].indexOf("V")!= -1)
            {
                int z=0; 
                String value = list[x];
                String intValue = value.replaceAll("[^0-9]", ""); 
                int valuex= Integer.parseInt(intValue);
                for (int y= valuex; y<= valuex+30;y=y+10)
                {
                    //System.out.println("Tile: "+y+ " Z Value:"+z);
                    if(y%3==0)
                    {
                        if(list[0].charAt(z)== 'A' || list[0].charAt(z)== 'E')
                        {
                            totalp=totalp+2;
                            //System.out.println("Two added");
                        }
                        if(list[0].charAt(z)== 'D' || list[0].charAt(z)== 'R')
                        {
                            totalp=totalp+4; 
                            //System.out.println("Four added");
                        }
                        if(list[0].charAt(z)== 'B' || list[0].charAt(z)== 'M')
                        {
                            totalp=totalp+6;
                            //System.out.println("Six added");
                        }
                        if(list[0].charAt(z)== 'V' || list[0].charAt(z)== 'Y')
                        {
                            totalp=totalp+8;
                            //System.out.println("Eight added");
                        }
                        if(list[0].charAt(z)== 'J' || list[0].charAt(z)== 'X')
                        {
                            totalp=totalp+16;
                            //System.out.println("16 added");
                        }
                    }
                    else if(y%5==0)
                    {
                        if(list[0].charAt(z)== 'A' || list[0].charAt(z)== 'E')
                        {
                            totalp=totalp+3;
                            //System.out.println("3 added");
                        }
                        if(list[0].charAt(z)== 'D' || list[0].charAt(z)== 'R')
                        {
                            totalp=totalp+6;
                            //System.out.println("6 added");
                        }
                        if(list[0].charAt(z)== 'B' || list[0].charAt(z)== 'M')
                        {
                            totalp=totalp+9;
                            //System.out.println("9 added");
                        }
                        if(list[0].charAt(z)== 'V' || list[0].charAt(z)== 'Y')
                        {
                            totalp=totalp+12;
                            //System.out.println("12 added");
                        }
                        if(list[0].charAt(z)== 'J' || list[0].charAt(z)== 'X')
                        {
                            totalp=totalp+24;
                            //System.out.println("24 added");
                        }
                    }
                    else
                    {
                        if(list[0].charAt(z)== 'A' || list[0].charAt(z)== 'E')
                        {
                            totalp=totalp+1;
                            //System.out.println("1 added");
                        }
                        if(list[0].charAt(z)== 'D' || list[0].charAt(z)== 'R')
                        {
                            totalp=totalp+2;
                            //System.out.println("2 added");
                        }
                        if(list[0].charAt(z)== 'B' || list[0].charAt(z)== 'M')
                        {
                            totalp=totalp+3;
                            //System.out.println("3 added");
                        }
                        if(list[0].charAt(z)== 'V' || list[0].charAt(z)== 'Y')
                        {
                            totalp=totalp+4;
                            //System.out.println("4 added");
                        }
                        if(list[0].charAt(z)== 'J' || list[0].charAt(z)== 'X')
                        {
                            totalp=totalp+8;
                            //System.out.println("8 added");
                        }
                    }
                    if(y%7==0 && y%5!=0 && y%3!=0)
                    {
                        dword=1;
                        //System.out.println("dword");
                    }
                    if(y%8==0&& y%7!=0 && y%5!=0 && y%3!=0)
                    {
                        tword=1;
                        //System.out.println("tword added");
                    }
                    z=z+2;
                }
            }
            if(tword==1){totalp= 3*totalp; tword=0; dword=0;}
            if(dword==1){totalp= 2*totalp; dword=0;} 
            System.out.println("Your point total is "+totalp);
            totalp=0;
        }

    }
}
