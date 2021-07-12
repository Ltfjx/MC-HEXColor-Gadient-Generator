//
//    Ciallo～(∠・ω )⌒★
//


package codes.rlt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//初始化scanner

        System.out.println("输入起始颜色...");
        String InputHexColorA =scanner.next();//输入起始颜色
        while(InputHexColorA.length()!=7 | (InputHexColorA.charAt(0)!='#')){
            System.out.println("输入格式错误，应输入16进制颜色");
            System.out.println();
            System.out.println("输入起始颜色...");
            InputHexColorA =scanner.next();//输入起始颜色
        }
        System.out.println();//换行
        //System.out.println("起始颜色：" + InputHexColorA);
        int ColorA_R = Integer.valueOf(InputHexColorA.substring(1,3),16);
        //System.out.println("起始颜色R数值："+ColorA_R);
        int ColorA_G = Integer.valueOf(InputHexColorA.substring(3,5),16);
        //System.out.println("起始颜色G数值："+ColorA_G);
        int ColorA_B = Integer.valueOf(InputHexColorA.substring(5,7),16);
        //System.out.println("起始颜色B数值："+ColorA_B);


        System.out.println("输入终止颜色...");
        String InputHexColorB =scanner.next();//输入终止颜色
        while(InputHexColorB.length()!=7 | (InputHexColorB.charAt(0)!='#')){
            System.out.println("输入格式错误，应输入16进制颜色");
            System.out.println();
            System.out.println("输入终止颜色...");
            InputHexColorB =scanner.next();//输入终止颜色
        }
        System.out.println();//换行
        //System.out.println("终止颜色：" + InputHexColorB);
        int ColorB_R = Integer.valueOf(InputHexColorB.substring(1,3),16);
        //System.out.println("终止颜色R数值："+ColorB_R);
        int ColorB_G = Integer.valueOf(InputHexColorB.substring(3,5),16);
        //System.out.println("终止颜色G数值："+ColorB_G);
        int ColorB_B = Integer.valueOf(InputHexColorB.substring(5,7),16);
        //System.out.println("终止颜色B数值："+ColorB_B);


        System.out.println("输入需要应用渐变的字符串...");
        String Text = scanner.next();//输入字符串
        while(Text.length()<2){
            System.out.println("字符串至少需要2个字符");
            System.out.println();
            System.out.println("输入需要应用渐变的字符串...");
            Text =scanner.next();//输入字符串
        }
        System.out.println();//换行
        int length =Text.length();
        int[] ColorR = new int[length];
        int[] ColorG = new int[length];
        int[] ColorB = new int[length];
        int avgR = Math.round((Math.abs(ColorA_R - ColorB_R))/(length-1));
        int avgG = Math.round((Math.abs(ColorA_G - ColorB_G))/(length-1));
        int avgB = Math.round((Math.abs(ColorA_B - ColorB_B))/(length-1));

        //计算模块
        for(int i=0;i<length;i++){
            //System.out.println(i);
            if(ColorA_R < ColorB_R){
                ColorR[i]=ColorA_R+avgR*i;
            }
            else{
                ColorR[i]=ColorA_R-avgR*i;
            }


            if(ColorA_G < ColorB_G){
                ColorG[i]=ColorA_G+avgG*i;
            }
            else{
                ColorG[i]=ColorA_G-avgG*i;
            }


            if(ColorA_B < ColorB_B){
                ColorB[i]=ColorA_B+avgB*i;
            }
            else{
                ColorB[i]=ColorA_B-avgB*i;
            }
            //System.out.println(ColorR[i]);
        }



        System.out.println("---以下为渐变输出---");
        //输出模块
        for(int i=0;i<length;i++) {
            System.out.print("§#");
            if(ColorR[i]<16){
                System.out.print(0);
            }//r补位
            System.out.print(Integer.toHexString(ColorR[i]));
            if(ColorG[i]<16){
                System.out.print(0);
            }//g补位
            System.out.print(Integer.toHexString(ColorG[i]));
            if(ColorB[i]<16){
                System.out.print(0);
            }//b补位
            System.out.print(Integer.toHexString(ColorB[i]));
            System.out.print(Text.charAt(i));
        }

        System.out.println();//换行
        System.out.println();//换行
        }

    }

