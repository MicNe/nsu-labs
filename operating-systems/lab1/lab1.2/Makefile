CC=gcc
CFLAGS=-Werror

all : hello

hello : hello.c libhello-static.a
	$(CC) $(CFLAGS) hello.c -lhello-static -L. -o hello

libhello-static.a : hello-static.o
	ar rc libhello-static.a hello-static.o

hello-static.o : hello-static.h hello-static.c
	$(CC) $(CFLAGS) -c hello-static.c -o hello-static.o

run : hello
	./hello

clean : hello-static.o libhello-static.a hello
	rm -rf hello-static.o libhello-static.a hello
