CC=gcc
CFLAGS=-Werror

all : hello

hello : hello.c
	$(CC) $(CFLAGS) hello.c -o hello

nm : hello
	nm hello

ldd : hello
	ldd hello

run : hello
	./hello

clean:
	rm -rf hello
