#include<stdio.h>
int main()
{
    int m1,n1,m2,n2;
    printf("Enter the number of rows of first matrix:");
    scanf("%d",&m1);
    printf("Enter the number of columns of first matrix:");
    scanf("%d",&n1);
    printf("Enter the number of rows of second matrix:");
    scanf("%d",&m2);
    printf("Enter the number of columns of second matrix:");
    scanf("%d",&n2);


    int a[m1][n1],b[m2][n2],c[m1][n2],i,j,k;
    for(i=0;i<m1;i++)
    {
        for(j=0;j<n1;j++)
        {
            printf("a[%d][%d]:",i,j);
            scanf("%d",&a[i][j]);
        }
    }
    for(i=0;i<m2;i++)
    {
        for(j=0;j<n2;j++)
        {
            printf("b[%d][%d]:",i,j);
            scanf("%d",&b[i][j]);
        }
    }
    for(i=0;i<m1;i++)
    {
        for(j=0;j<n2;j++)
        {
            c[i][j]=0;
        }
    }


    for(i=0;i<m1;i++)
    {
        for(j=0;j<n2;j++)
        {
            for(k=0;k<n1;k++)
            {
                c[i][j]=c[i][j]+(a[i][k]*b[k][j]);
            }
        }
    }
    for(i=0;i<m1;i++)
    {
        for(j=0;j<n2;j++)
        {
            printf("%li ",c[i][j]);
        }
        printf("\n");
    }
    return 0;
}
