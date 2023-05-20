#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
//Part I Begins
struct LL_struct{
    char name[30];
    struct LL_struct *next;
};

void add(char name[30]) {
   //create a link
   struct LL_struct *add = (struct LL_struct*) malloc(sizeof(struct LL_struct));
	
   add->name = name;
	
   //point it to old first node
   add->next = head;
	
   //point first to new first node
   head = add;
}
void remove(struct LL_struct** head_ref, char key[30]){
    // Store head node
    struct LL_struct *temp = *head_ref, *prev;
    if (temp != NULL && temp->name != key) {
        prev = temp;
        temp = temp->next;
    }
 
    // If key was not present in linked list
    if (temp == NULL)
        return;
 
    // Unlink the node from linked list
    prev->next = temp->next;
 
    free(temp); // Free memory
}
//Part 2 Begins
struct StorageUnit{
  struct LL_struct *path;
struct LL_struct *root;

};
void DisplayPath(struct StorageUnit strunt){
 struct LL_struct *pathh = strunt.root;
   printf("Path: ");
 if(pathh != NULL){

    printf("%s\\", pathh->name);

      pathh = pathh->next;
   }
     printf("\n");
   }
void MakeDirectory(struct StorageUnit *strunt, char name[30]){

struct LL_struct *LL = (struct LL_struct*)malloc(sizeof(struct LL_struct));

  strcpy(LL->name, name);
if(strunt->root == NULL){
     strunt->root = LL;

strunt->path = LL;

      LL->next = NULL;
}
else{
  strunt->path->next = LL;

LL->next = NULL;

  strunt->path = LL;
}
}
void RemoveDirectory(char name[30], struct StorageUnit *strunt){
    struct LL_struct *qqq = NULL;
     struct LL_struct *rrr = strunt->root;

     if(rrr != NULL && rrr->name == name){

        if(qqq == NULL){
            strunt->root = rrr->next;
        }
        else{
        qqq->next = rrr->next;
     }
     if(strunt->path == rrr){
         strunt->path = qqq;
       }
}
  qqq = rrr;
   rrr = rrr->next;
}
}
void SwapDirectory(struct StorageUnit *strunt, char fnode[30], char snode[30]){

  if(strunt->root == NULL){

    printf("Path Is Empty Or Incomplete!\n");
     return;
  }
  struct LL_struct *fbefore;
  struct LL_sruct, *sbefore; 
  struct LL_struct *next1;
  struct LL_struct *next2;
  struct LL_struct *fsdrct;
  struct LL_struct *ssdrct;

  fsdrct = strunt->root;
  fbefore = NULL;

   while(fsdrct != NULL){
     if(fsdrct->name == fnode){
           break;
      }
       else if(fsdrct->name, snode){
        strcpy(snode, fnode);
                 break;
               }
   fbefore = fsdrct;
  fsdrct = fsdrct->next;
   }
        ssdrct = fsdrct->next;
         sbefore = ssdrct;
  
    while(ssdrct != NULL && ssdrct->name != snode){
          sbefore = ssdrct;
          ssdrct = ssdrct->next;
      }
       next1 = fsdrct->next;
      next2 = ssdrct->next;
  
         while(next1 == ssdrct){
        if(fbefore == NULL){
           strunt->root = ssdrct;
           ssdrct->next = fsdrct;
            fsdrct->next = next2;
         }
          else{
           fbefore->next = ssdrct;
          ssdrct->next = fsdrct;
          fsdrct->next = next2;
          }
}
 else{
   if(fbefore == NULL){
      strunt->root = ssdrct;
      ssdrct->next = next1;
      sbefore->next = fsdrct;
        fsdrct->next = next2;
     }
      else{
      fbefore->next = ssdrct;
       ssdrct->next = next1;
        sbefore->next = fsdrct;
        fsdrct->next = next2;
    }
   }
  
    if(strunt->path == fsdrct){
        strunt->path = ssdrct;
     }
       else if(strunt->path == ssdrct){
     strunt->path = fsdrct;
     }
}
int main()
{
    /* Start with the empty list */
    struct LL_struct *head = NULL;
}