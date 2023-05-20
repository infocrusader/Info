#include<stdio.h>                 
#include<unistd.h>
#include<stdlib.h>
#include<time.h>
#include<pthread.h>
#include<semaphore.h>

sem_t customer;
sem_t barber;
sem_t mutex;
void get_haircut();
void * make_customer_function();
int available_seats = 6;
int numcust = 0;

void *CustomerT(void *num) {
	int n=*(int *)num; 
	sem_wait(&mutex);
	numcust++;
	if (available_seats > 0) {
	    available_seats--;
	printf("%d.",n);                                               //adding sserial no. to each entry of customer
	printf("\t Customer %d arrived at the shop.\n",n);             //entering shop
	sem_wait(&customer);                                       //waiting for space to open up
	printf("\t Customer %d sits in one of the chairs.\n",n);       //sitting on the chair
	usleep(1000);                                                       //waiting for 1 second, we can increase the time also
	printf("\t After waiting for some time.\n");
	printf("\t Customer %d entering the barber room.\n",n);        //entering barber room
	sem_wait(&barber);                                       //waiting for barber chair to become free
	sem_post(&customer);
	printf("\t Customer %d waking up the barber.\n",n);
	sem_post(&mutex);
	sem_post(&barber);                                       //giving up the chair
	available_seats++;
	printf("\t Customer %d leaving the shop after haircut.\n",n);
	} else {
		sem_post(&mutex);
		printf("A customer found no available seats and left.\n");
}
pthread_exit(NULL);
}
void *BarberT(void *arg) {
        while(numcust == 0){
            printf("No customers, Barber goes to sleep\n");
            sem_wait(&customer);
            printf("Customer activated, and wakes barber.\n");
        }
        get_haircut();
        numcust--;
        printf("Customer has left.\n");
        printf("Number of available customers is: %d\n", numcust);
        sem_wait(&customer);
}



void *make_customer_function() {

	while (1) {
		if (rand() % 3 != 1) {
			pthread_t customer;
			int start = 0;
			start = pthread_create(&customer, NULL, (void *) CustomerT,NULL);
			pthread_join(customer, NULL);
			if (start != 0)
				perror("No Customers Yet!!!\n");
		}
		        usleep(100000);

	}
}
void get_haircut(){

    int cuttime = rand() % 401; /* Random number between 0 and 400 (miliseconds)*/

    cuttime = cuttime * 1000; /* Convert miliseconds to microseconds*/
    usleep(cuttime);
}

int main(){

	pthread_t barberc;
	sem_init(&customer, 0, 0);
	sem_init(&barber, 0, 0);
	sem_init(&mutex, 0, 1);
	int start = 0;

	start = pthread_create(&barberc, NULL, (void *)BarberT, NULL);  
    if(start)
        printf("Failed to create thread."); 
    
	make_customer_function();
	pthread_join(barberc, NULL);
}