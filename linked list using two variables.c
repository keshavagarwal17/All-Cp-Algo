#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
    int id;
    int data;
    struct node* next;
}a;

int main()
{
    int i=1;
    a *first=NULL,*t=NULL,*last=NULL,*temp=NULL;
    for(;;)
    {
        int r;
        printf("Do you want to enter data:(1-yes/0-no):");
        scanf("%d",&r);
        if(r==1)
        {
            t=(a*)malloc(sizeof(a));
            t->id=i;
            i++;
            scanf("%d",&t->data);

            t->next= NULL;

            if(first==NULL)
            {
             first=t;
             last=t;
            }
            else
            {
                last->next=t;
                last=t;
            }
        }
        else
        break;
    }
        int p;
        printf("Enter the id of data you want to delete:");
        scanf("%d",&p);
        t=first;
        if(t->id==p)
        {
            temp=t;
            first=t->next;
        }
        else
        {
            while(t->next->id!=p)
            {
                t=t->next;
            }
            temp=t->next;
            t->next=temp->next;
            free(temp);
        }

        t=first;
        while(t!=NULL)
        {
            printf("%d\n",t->data);
            t=t->next;
        }
    return 0;

}
