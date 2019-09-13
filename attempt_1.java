import java.io.*;
class entry
{
    static int a[][][]=new int[9][9][10];
    public static void check()
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(a[i][j][0]==0)
                {

                    for(int p=1;p<=9;p++)
                    {
                        if(a[i][j][p]!=0)
                        {
                            for(int k=0;k<9;k++)
                            {
                                if(k!=i)
                                {
                                    if(a[k][j][0]==p)
                                    {
                                        a[i][j][p]=0;
                                    }
                                }
                            }
                        }
                    }

                    for(int p=1;p<=9;p++)
                    {
                        if(a[i][j][p]!=0)
                        {
                            for(int k=0;k<9;k++)
                            {

                                if(a[i][k][0]==p&&k!=j)
                                {
                                    a[i][j][p]=0;
                                }
                            }
                        }
                    }
                    int t=0,tv=0;
                    if(i>=0&&i<=2&&j>=0&&j<=2)
                    {t=0;tv=0;}
                    else if(i>=3&&i<=5&&j>=0&&j<=2)
                    {t=3;tv=0;}
                    else if(i>=5&&i<=8&&j>=0&&j<=2)
                    {t=6;tv=0;}
                    else if(i>=0&&i<=2&&j>=3&&j<=5)
                    {t=0;tv=3;}
                    else if(i>=3&&i<=5&&j>=3&&j<=5)
                    {t=3;tv=3;}
                    else if(i>=5&&i<=8&&j>=3&&j<=5)
                    {t=6;tv=3;}
                    else if(i>=0&&i<=2&&j>=5&&j<=8)
                    {t=0;tv=6;}
                    else if(i>=3&&i<=5&&j>=5&&j<=8)
                    {t=3;tv=6;}
                    else if(i>=5&&i<=8&&j>=5&&j<=8)
                    {t=6;tv=6;}
                    for(int p=1;p<=9;p++)
                    {
                        if(a[i][j][p]!=0)
                        {
                            for(int m=t;m<t+3;m++)
                            {
                                for(int n=tv;n<tv+3;n++)
                                {   
                                    if(a[m][n][0]==p&&n!=j&&m!=i)
                                    {
                                        a[i][j][p]=0;
                                    }
                                }
                            }
                        }
                    }
                    int count=0;int rep=0;
                    for(int p=1;p<=9;p++)
                    {
                        if(a[i][j][p]==0)
                        {++count;
                        }
                        else
                        {rep=p;}
                    }
                    if(count==8)
                    {
                        a[i][j][0]=a[i][j][rep];
                        a[i][j][rep]=0;check();
                    }
                }
            }
        }

    }
    
    
    public static void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the soduko(Enter space for blanks)");
        for(int i=0;i<9;i++)
        {
            String t=br.readLine();
            for(int j=0;j<9;j++)
            {
                char y=t.charAt(j);
                if(y==(' '))
                {
                    for(int p=0;p<=9;p++)
                    {a[i][j][p]=p;}
                }
                else
                {
                    a[i][j][0]=y-48;
                }
            }
        }
        check();

        // // for(int i=0;i<9;i++)
        // {
        // for(int j=0;j<9;j++)
        // {
        // String t=br.readLine();
        // if(t.equals(" "))
        // {
        // for(int p=0;p<=9;p++)
        // {a[i][j][p]=p;}
        // }
        // else
        // {
        // a[i][j][0]=Integer.parseInt(t);
        // }
        // }

        // }

        // for(int i=0;i<9;i++)//recheck
        // {
        // for(int j=0;j<9;j++)
        // {
        // if(a[i][j][0]==0)
        // {

        // for(int p=1;p<=9;p++)
        // {
        // if(a[i][j][p]!=0)
        // {
        // for(int k=0;k<9;k++)
        // {
        // if(k!=i)
        // {
        // if(a[k][j][0]==p)
        // {
        // a[i][j][p]=0;
        // }
        // }
        // }
        // }
        // }

        // for(int p=1;p<=9;p++)
        // {
        // if(a[i][j][p]!=0)
        // {
        // for(int k=0;k<9;k++)
        // {

        // if(a[i][k][0]==p&&k!=j)
        // {
        // a[i][j][p]=0;
        // }
        // }
        // }
        // }
        // int t=0,tv=0;
        // if(i>=0&&i<=2&&j>=0&&j<=2)
        // {t=0;tv=0;}
        // else if(i>=3&&i<=5&&j>=0&&j<=2)
        // {t=3;tv=0;}
        // else if(i>=5&&i<=8&&j>=0&&j<=2)
        // {t=6;tv=0;}
        // else if(i>=0&&i<=2&&j>=3&&j<=5)
        // {t=0;tv=3;}
        // else if(i>=3&&i<=5&&j>=3&&j<=5)
        // {t=3;tv=3;}
        // else if(i>=5&&i<=8&&j>=3&&j<=5)
        // {t=6;tv=3;}
        // else if(i>=0&&i<=2&&j>=5&&j<=8)
        // {t=0;tv=6;}
        // else if(i>=3&&i<=5&&j>=5&&j<=8)
        // {t=3;tv=6;}
        // else if(i>=5&&i<=8&&j>=5&&j<=8)
        // {t=6;tv=6;}
        // for(int p=1;p<=9;p++)
        // {
        // if(a[i][j][p]!=0)
        // {
        // for(int m=t;m<t+3;m++)
        // {
        // for(int n=tv;n<tv+3;n++)
        // {   
        // if(a[m][n][0]==p&&n!=j&&m!=i)
        // {
        // a[i][j][p]=0;
        // }
        // }
        // }
        // }
        // }
        // int count=0;int rep=0;
        // for(int p=1;p<=9;p++)
        // {
        // if(a[i][j][p]==0)
        // {++count;
        // }
        // else
        // {rep=p;}
        // }
        // if(count==8)
        // {
        // a[i][j][0]=a[i][j][rep];
        // a[i][j][rep]=0;
        // }
        // }
        // }
        // }//recheck

        // for(int j=0;j<9;j++)
        // {     
        // System.out.print(a[0][j][0]+" ");  
        // for(int y=1;y<=9;y++)
        // {
        // System.out.print(a[0][j][y]);
        // }
        // System.out.println();
        // }

        // System.out.println();
        // System.out.println();
        // for(int j=0;j<9;j++)
        // {     
        // System.out.print(a[j][0][0]+" ");  
        // for(int y=1;y<=9;y++)
        // {
        // System.out.print(a[j][0][y]);
        // }
        // System.out.println();
        // }

        // for(int i=0;i<9;i++)
        // {
            // for(int j=0;j<9;j++)
            // {

                // System.out.print(a[i][j][0]+" ");  
                // for(int y=1;y<=9;y++)
                // {
                    // System.out.print(a[i][j][y]);
                // }
                // System.out.println();
            // }
        // }

        it:for(;;)
        {
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    int val=0;
                    up:if(a[i][j][0]==0)
                    {
                        for(int y=1;y<=9;y++)
                        {
                            int a1=0,a2=0,a3=0;
                            if(a[i][j][y]!=0)
                            {

                                for(int k=0;k<9;k++)
                                {
                                    if(k!=i&&a[k][j][0]==0)
                                    {
                                        for(int o=1;o<=9;o++)
                                        {
                                            if(a[k][j][o]==a[i][j][y]&&a[k][j][o]!=0)
                                            {
                                                a1=1;
                                            }
                                        }
                                    }
                                }

                                for(int k=0;k<9;k++)
                                {
                                    if(k!=j&&a[i][k][0]==0)
                                    {
                                        for(int o=1;o<=9;o++)
                                        {
                                            if(a[i][k][o]==a[i][j][y]&&a[i][k][o]!=0)
                                            {
                                                a2=1;
                                            }
                                        }
                                    }
                                }

                                int t=0,tv=0;
                                if(i>=0&&i<=2&&j>=0&&j<=2)
                                {t=0;tv=0;}
                                else if(i>=3&&i<=5&&j>=0&&j<=2)
                                {t=3;tv=0;}
                                else if(i>=5&&i<=8&&j>=0&&j<=2)
                                {t=6;tv=0;}
                                else if(i>=0&&i<=2&&j>=3&&j<=5)
                                {t=0;tv=3;}
                                else if(i>=3&&i<=5&&j>=3&&j<=5)
                                {t=3;tv=3;}
                                else if(i>=5&&i<=8&&j>=3&&j<=5)
                                {t=6;tv=3;}
                                else if(i>=0&&i<=2&&j>=5&&j<=8)
                                {t=0;tv=6;}
                                else if(i>=3&&i<=5&&j>=5&&j<=8)
                                {t=3;tv=6;}
                                else if(i>=5&&i<=8&&j>=5&&j<=8)
                                {t=6;tv=6;}

                                for(int m=t;m<t+3;m++)
                                {
                                    for(int n=tv;n<tv+3;n++)
                                    {   

                                        if(a[m][n][0]==0)
                                        {
                                            if(!(m==i&&n==j))
                                            {
                                                for(int o=1;o<=9;o++)
                                                {
                                                    if(a[m][n][o]==a[i][j][y]&&a[m][n][o]!=0)
                                                    {
                                                        a3=1;
                                                    } 
                                                }
                                            }
                                        }
                                    }
                                }
                                if(a1==0||a2==0||a3==0)
                                {val=a[i][j][y]; break up;}
                                else
                                {val=0;}
                            }

                        }
                    }
                    if(val!=0)
                    {a[i][j][0]=val;
                        for(int u=1;u<=9;u++)
                        {a[i][j][u]=0;}
                        check();
                    }
                }
            }

            boolean c=true;
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {if(a[i][j][0]==0)
                    {c=false;}
                }
            }
            if(c)
            {break it;}
        }

        // for(int i=0;i<9;i++)
        // {
        // for(int j=0;j<9;j++)
        // {
        // System.out.print(a[i][j][0]+" ");  
        // for(int y=1;y<=9;y++)
        // {
        // System.out.print(a[i][j][y]);
        // }
        // System.out.println();
        // }
        // }

        for(int i=0;i<9;i++)
        {
        for(int j=0;j<9;j++)
        {
        System.out.print(a[i][j][0]+" ");
        }
        System.out.println();
        }

    }

    
}

