#include<stdio.h>
#include<stdlib.h>

struct Node{
int data;
struct Node *next;
};

struct Node *head = NULL;
struct Node *tail = NULL;

void addFirst(int info){
struct Node *newNode = malloc(sizeof(struct Node));
newNode->data = info;
newNode->next = NULL;
if(head == NULL){
head = tail = newNode;
return;
}
newNode->next = head;
head = newNode;
}

void addLast(int info){
struct Node *newNode = malloc(sizeof(struct Node));
newNode->data = info;
newNode->next = NULL;
if(head == NULL){
head = tail = newNode;
return;
}

struct Node *temp = head;
while(temp->next != NULL){
temp = temp->next;
}

temp->next = newNode;
newNode->next = NULL;

}
int listSize(){
struct Node *temp = head;
int sz=0;
while(temp != NULL){
temp = temp->next;
sz++;
}

return sz;
}

void addAt(int indx, int info){

struct Node *newNode = malloc(sizeof(struct Node));

if(indx == 0){
    addFirst(info);
    return;
}
if(indx == listSize()){
    addLast(info);
    return;
}

newNode->data = info;
newNode->next = NULL;

int i=0;
struct Node *temp = head;
while(i != indx-1){
temp = temp->next;
i++;
}

newNode->next = temp->next;
temp->next = newNode;

}

void removeFirst(){
    struct Node *temp = head;
    head = head->next;

}

void printList(){
struct Node *temp = head;
while(temp != NULL){
printf("%d -> ",temp->data);
temp = temp->next;
}
printf("NULL\n");
}

void main(){

addFirst(1);
addLast(2);
addLast(3);
addLast(4);
addAt(4,2);
printList();

}