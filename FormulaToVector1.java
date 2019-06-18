/**
 * 用來排序方程式
 * C和H同時出現 就會被拉到最前面排序
 * 如果沒同時出現 照原本英文字排序
 * 先切割文字 再用list排序
 * 切割文字的方式 主要原理: 大寫開頭的一組 寫入builderFormula暫存 等遇到下一個大寫開頭才會丟入list並清空
 * 如果是遇到倒數第二個字元 也會成為最後一組
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Denny-PC
 */
class FormulaCutting
{
    private String Formula;
    private int FormulaNumber;
    
    public FormulaCutting()
    {
        Formula="";
        FormulaNumber = 0;
    }
    String Cutting(String F)
    {
        Formula="";
        FormulaNumber = 0;
        ArrayList<Double> Periodictable = new ArrayList<>();
        String[] list = {"Fr", "Ra", "Cs", "Ba", "Hf", "Ta", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Rb", "Sr", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "ln", "Sn", "Sb", "Te", "Xe", "Ca", "Sc", "Ti", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Na", "Mg", "Al", "Si", "Cl", "Ar", "Li", "Be", "Ne", "He", "H", "B", "C", "N", "O", "F", "P", "S", "K", "V", "Y", "I", "W"};
        for (int i = 0; i < list.length; i++) {
            Periodictable.add(0.0);
        }
        System.out.println("list長度: "+list.length);
        System.out.println("第60格的元素: "+list[60]);
        System.out.println("第60格的元素個數為: "+Periodictable.get(60));
        System.out.println("測試indexOf找list中H是第幾格: "+Arrays.asList(list).indexOf("Hg"));//這個會用到 用來找出切出來的元素的個數要放的位置
        
        Formula = F + " ";
        System.out.println("開始排序："+ F);
        StringBuilder builderFormula = new StringBuilder();
        StringBuilder builderC = new StringBuilder();
        StringBuilder builderH = new StringBuilder();
        ArrayList<String> FormulaList = new ArrayList<String>();
            
            for(int i=0;i<Formula.length();i++)
            {
                
//                Formula.charAt(i);
                System.out.println(Formula.charAt(i) + " 第"+i+"個字元");
                    //Character.isUpperCase(char ch) 字元是大寫就=true
                    //Character.isLowerCase(char ch) 字元是小寫就=true
                    //Character.isDigit(char ch) 字元是數字就=true
                    
                if(Character.isUpperCase(Formula.charAt(i)))//如果第i個字元是大寫就
                {
                    if(i>0)//跳過第一個字母
                    {
                            for(int j=FormulaNumber;j<i;j++)
                            {
                                builderFormula.append(Formula.charAt(j));
                            }
                            FormulaNumber =i;
//                            builder.append(",");
                            System.out.println(builderFormula.toString()+" 切一個");
                            FormulaList.add(builderFormula.toString());
                            builderFormula.delete(0, builderFormula.toString().length());
                    }
                }
                else if(i==Formula.length()-1)
                {
                    for(int k=FormulaNumber;k<Formula.length();k++)
                    {
                        builderFormula.append(Formula.charAt(k));
                    }
                    System.out.println(builderFormula.toString());
                    FormulaList.add(builderFormula.toString());
                    builderFormula.delete(0, builderFormula.toString().length());
                }
//                FormulaList.add(String.valueOf(Formula.charAt(i)));
                //前面設定是"字串"的arraylist 但charAt()出來是字元 要轉成字串
                
            }
        System.out.println(builderFormula.toString());
        System.out.println(FormulaList);
        Collections.sort(FormulaList);//內建arraylist排序
        System.out.println(FormulaList);
        for(int i=0;i<FormulaList.size();i++)
        {
            builderFormula.append(FormulaList.get(i));
        }
        
        Formula = builderFormula.toString().replaceFirst(" ", "");
        //以上全部照字母順序排序 還不考慮C和H同時有的狀況

        return Formula;
    }
    
    
ArrayList<Double>CutToList(String F){
        Formula="";
        FormulaNumber = 0;
        ArrayList<Double> Periodictable = new ArrayList<>();
        String[] list = {"Fr", "Ra", "Cs", "Ba", "Hf", "Ta", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Rb", "Sr", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "ln", "Sn", "Sb", "Te", "Xe", "Ca", "Sc", "Ti", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Na", "Mg", "Al", "Si", "Cl", "Ar", "Li", "Be", "Ne", "He", "H", "B", "C", "N", "O", "F", "P", "S", "K", "V", "Y", "I", "W"};
        for (int i = 0; i < list.length; i++) {
            Periodictable.add(0.0);
        }
        System.out.println("list長度: "+list.length);
        System.out.println("第60格的元素: "+list[60]);
        System.out.println("第60格的元素個數為: "+Periodictable.get(60));
        System.out.println("測試indexOf找list中H是第幾格: "+Arrays.asList(list).indexOf("Hg"));//這個會用到 用來找出切出來的元素的個數要放的位置
        
        Formula = F + " ";
        System.out.println("開始排序："+ F);
        StringBuilder builderFormula = new StringBuilder();
        ArrayList<String> FormulaList = new ArrayList<String>();
            
            for(int i=0;i<Formula.length();i++)
            {
                
//                Formula.charAt(i);
                System.out.println(Formula.charAt(i) + " 第"+i+"個字元");
                    //Character.isUpperCase(char ch) 字元是大寫就=true
                    //Character.isLowerCase(char ch) 字元是小寫就=true
                    //Character.isDigit(char ch) 字元是數字就=true
                    
                if(Character.isUpperCase(Formula.charAt(i)))//如果第i個字元是大寫就
                {
                    if(i>0)//跳過第一個字母
                    {
                            for(int j=FormulaNumber;j<i;j++)
                            {
                                builderFormula.append(Formula.charAt(j));
                            }
                            
                            String FormulaStr = builderFormula.toString().trim();
                            String str2=""; 
                            String str3="";
                            for(int k=0;k<FormulaStr.length();k++)
                            {
                                if(FormulaStr.charAt(k)>=48 && FormulaStr.charAt(k)<=57)
                                {
                                    str2+=FormulaStr.charAt(k);
                                }
                                else if((FormulaStr.charAt(k)>=65 && FormulaStr.charAt(k)<=90)||(FormulaStr.charAt(k)>=97 && FormulaStr.charAt(k)<=122))
                                {
                                    str3+=FormulaStr.charAt(k);
                                }                                
                            }
                            if(str2==""){str2="1";}
                            FormulaNumber =i;
//                            builder.append(",");
                            System.out.println(builderFormula.toString()+" 切一個");
                            System.out.println("切完的文字部分是: "+str3);
                            System.out.println("切完的數字部分是: "+str2);
                            Periodictable.remove(Arrays.asList(list).indexOf(str3));
                            Periodictable.add(Arrays.asList(list).indexOf(str3), Double.parseDouble(str2));
                            FormulaList.add(builderFormula.toString());
                            builderFormula.delete(0, builderFormula.toString().length());
                    }
                }
                else if(i==Formula.length()-1)
                {
                    for(int k=FormulaNumber;k<Formula.length();k++)
                    {
                        builderFormula.append(Formula.charAt(k));
                    }
                    builderFormula.append("\b");//把最後一項的空白消除
                    
                            String FormulaStr = builderFormula.toString().trim();
                            String str2="";
                            String str3="";
                            for(int k=0;k<FormulaStr.length();k++)
                            {
                                if(FormulaStr.charAt(k)>=48 && FormulaStr.charAt(k)<=57)
                                {
                                    str2+=FormulaStr.charAt(k);
                                }
                                
                                else if((FormulaStr.charAt(k)>=65 && FormulaStr.charAt(k)<=90)||(FormulaStr.charAt(k)>=97 && FormulaStr.charAt(k)<=122))
                                {
                                    str3+=FormulaStr.charAt(k);
                                }
                                
                            }
                            if(str2==""){str2="1";}                    
                    
                    System.out.println(builderFormula.toString()+" 這是經過else if的");
                    System.out.println("這是經過else if的文字部分是: "+str3);
                    System.out.println("這是經過else if的數字部分是: "+str2);
                    Periodictable.remove(Arrays.asList(list).indexOf(str3));
                    Periodictable.add(Arrays.asList(list).indexOf(str3), Double.parseDouble(str2));
                    FormulaList.add(builderFormula.toString());
                    builderFormula.delete(0, builderFormula.toString().length());
                }
//                FormulaList.add(String.valueOf(Formula.charAt(i)));
                //前面設定是"字串"的arraylist 但charAt()出來是字元 要轉成字串
                
            }
        System.out.println(builderFormula.toString());
        System.out.println(FormulaList);
        Collections.sort(FormulaList);//內建arraylist排序
        System.out.println(FormulaList);
        for(int i=0;i<FormulaList.size();i++)
        {
            builderFormula.append(FormulaList.get(i));
        }
        
        Formula = builderFormula.toString().replaceFirst(" ", "");
        //以上全部照字母順序排序 還不考慮C和H同時有的狀況

        return Periodictable;    
    }
    

}

public class FormulaToVector1 {

    public static void main(String[] args){
        FormulaCutting FC = new FormulaCutting();

        System.out.println("最後結果："+FC.Cutting("C800H13O4NS"));
        //System.out.println("最後結果："+FC.Cutting("C8H13O4NS"));
        System.out.println("測試輸出list: "+FC.CutToList("C800H13O4NS12"));

    }    
}
